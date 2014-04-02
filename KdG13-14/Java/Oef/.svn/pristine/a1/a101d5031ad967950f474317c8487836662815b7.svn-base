/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.repaircafemodel.service.impl;

import be.kdg.repaircafemodel.dom.repairs.Bid;
import be.kdg.repaircafemodel.dom.repairs.FixedBid;
import be.kdg.repaircafemodel.dom.repairs.PerhourBid;
import be.kdg.repaircafemodel.dom.repairs.Repair;
import be.kdg.repaircafemodel.dom.repairs.RepairDetails.Status;
import be.kdg.repaircafemodel.dom.users.Client;
import be.kdg.repaircafemodel.dom.users.Repairer;
import be.kdg.repaircafemodel.dom.users.User;
import be.kdg.repaircafemodel.persistence.api.RepairDAO;
import be.kdg.repaircafemodel.service.api.RepairService;
import be.kdg.repaircafemodel.service.exceptions.RepairServiceException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of RepairService.
 *
 * @author wouter
 */
@Service("repairService")
public class RepairServiceImpl implements RepairService
{
    @Autowired
    private RepairDAO repairDAO;

    /**
     * Sets up and saves a new Repair to the system. Sets up a bidirectional
     * association between a repair and a client.
     *
     * @see(be.kdg.repaircafemodel.dom.repairs.Repair)
     *
     * @param client The client that submits the repair
     * @param repair The repair that needs to be filed.
     */
    @Override
    public void submitRepair(Client client, Repair repair)
    {
        client.addRepair(repair);
        repair.addClient(client);
        repairDAO.saveRepair(repair);
    }

    /**
     * Changes status of a repair to new status
     *
     * This method also checks whether the new status is legal status for this
     * repair.
     *
     * A repair can't have status Fixed when the repair was not previously
     * assigned to a repairer.
     *
     * @param repair
     * @param newStatus
     *
     * @throws RepairServiceException if illegal repair state is detected
     */
    @Override
    public void updateRepairStatus(Repair repair, Status newStatus)
    {
        try
        {
            if ((newStatus.equals(Status.Fixed) || newStatus.equals(Status.Irreparable)) && !repair.getDetails().isAssigned())
            {
                throw new IllegalStateException("Repair is not assigned");
            }

            repair.getDetails().setStatus(newStatus);
        }
        catch (IllegalStateException e)
        {
            throw new RepairServiceException("Repair must be assigned to Repairer first", e);
        }
    }

    /**
     * Removes a repair from the repository if no one is referencing the repair.
     *
     * Repairs can be referenced by clients or repairers. If no one references a
     * repair any longer it will be removed from the repository as well.
     *
     * @param user
     * @param repair
     */
    @Override
    public void removeRepair(User user, Repair repair)
    {
        boolean onlyClientReference = repair.getRepairer() == null && user instanceof Client;
        boolean onlyRepairerReference = repair.getClient() == null && user instanceof Repairer;

        if (user != null)
        // call Client or Repairers removePair method
        {
            user.removeRepair(repair);
        }

        if (onlyClientReference || onlyRepairerReference)
        {
            repairDAO.deleteRepair(repair);
        }
    }

    /**
     * Retrieve all repairs submitted by a particular client. This includes open
     * and closed repairs.
     *
     * @param client
     * @return
     */
    @Override
    public List<Repair> findAllRepairsByClient(Client client)
    {
        return client.getRepairs();
    }

    /**
     * Retrieve all repairs assigned to this repairer.
     *
     * This includes open and closed repairs. Can be used to write rebuttals for
     * past repairs in case of unfair review by Client
     *
     * @param repairer a repairer
     * @return List of all repairs associated with a repairer
     * @see(be.kdg.repaircafemodel.dom.repairs.Repair#setRebuttal)
     */
    @Override
    public List<Repair> findRepairsByRepairer(Repairer repairer)
    {
        return repairDAO.getRepairsByRepairer(repairer);
    }

    /**
     * A repairer can place a bid on a repair.
     *
     * The type of bid is determined based on the repair and an according Bid is
     * created. All bidirectional associations between Bid-Repairer-Repair are
     * being taken care of.
     *
     * @param repairer Repairer that places the bid
     * @param repair Repair for which a bid is submitted
     * @param price Bid price
     *
     * @return true if bid is successfully placed on repair
     */
    @Override
    public synchronized boolean placeBid(Repairer repairer, Repair repair, double price)
    {
        Bid bid;
        // check if repair hasn't got assigned between showing repair and placing bid
        if (!repair.getDetails().isAssigned())
        {
            switch (repair.getDetails().getPriceModel())
            {
                case FIXED:
                    bid = new FixedBid(price);
                    break;
                default:
                    bid = new PerhourBid(price);
                    break;
            }
            bid.setRepairer(repairer);
            repairer.addBid(bid);
            repair.addBid(bid);
            bid.setRepair(repair);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Client can accept a certain bid. If a bid is accepted. All other bids for
     * this repair are no longer eligible for acceptance. The bid will be marked
     * accepted.
     *
     * The repair will be set as "assigned to" the Repairer. The repair will be
     * added to the repairers assigned repair list.
     *
     * @param acceptedBid The bid that is accepted.
     */
    @Override
    public void acceptBid(Bid acceptedBid)
    {
        Repair repair = acceptedBid.getRepair();
        for (Bid bid : repair.getBids())
        {
            // not really necessary
            bid.setAccepted(false);
            bid.setEligible(false);
        }
        // mark repair as "assigned to"
        repair.getDetails().setAssigned(true);
        // set repair's repairer
        repair.setRepairer(acceptedBid.getRepairer());
        // add assigned repair to repairer's assigned repair list
        acceptedBid.getRepairer().addRepair(repair);
        // mark bid as accepted
        acceptedBid.setAccepted(true);
    }

    /**
     * Clear accepted bid.
     *
     * This method reverse all the effects of accepting a bid.
     *
     * @param acceptedBid
     */
    @Override
    public void clearBid(Bid acceptedBid)
    {
        // get associated repair
        Repair repair = acceptedBid.getRepair();

        // reset all other bids in repair to eligible and not accepted
        // including this bid
        for (Bid bid : repair.getBids())
        {
            bid.setAccepted(false);
            bid.setEligible(true);
        }
        // remove repair from repairers assigned repair list
        this.removeRepair(acceptedBid.getRepairer(), repair);
        // reset repairer assocation
        repair.setRepairer(null);
        // reset "assigned to"
        repair.getDetails().setAssigned(false);
    }

    /**
     * Remove bid from the system.
     *
     * This will remove the bid from system and from all associated objects.
     * If the bid to be removed was already accepted. All other bids will be
     * reset to eligible and the repair will be removed from the repairers
     * assigned repair list.
     *
     * @param removeBid
     */
    @Override
    public void removeBid(Bid removeBid)
    {
        Repair repair = removeBid.getRepair();
        Repairer repairer = removeBid.getRepairer();
        
        // if this bid was already accepted
        // reset all other bids so the become eligible again                
        if (removeBid.isAccepted())
        {
            // since this bid was accepted the associated repair
            // was on the repairers assigned list and thus
            // we need to remove it.
            repairer.getRepairs().remove(repair);
            // reset all other bids in repair to eligible and not accepted
            // including this bid
            for (Bid bid : repair.getBids())
            {
                bid.setAccepted(false);
                bid.setEligible(true);
            }
        }
        // finally remove from the respective bid list 
        repairer.getBids().remove(removeBid);
        repair.getBids().remove(removeBid);        
    }

    /**
     * Return all known item categories
     *
     * @return List of categories
     */
    @Override
    public List<String> getAllCategories()
    {
        return repairDAO.getAllCategories();
    }

    /**
     * Return all known item brands
     *
     * @return List of brands
     */
    @Override
    public List<String> getAllBrands()
    {
        return repairDAO.getAllBrands();
    }

    /**
     * Return all known defects
     *
     * @return List of all known defects to the system
     */
    @Override
    public List<String> getAllDefects()
    {
        return repairDAO.getAllDefects();
    }

    /**
     * Return all bids for a certain repair. Utility function that can be used
     * by clients to get bids for a particular repair.
     *
     * @param repair for which bids are requested
     * @return List of bids
     */
    @Override
    public List<Bid> getBids(Repair repair)
    {
        return repair.getBids();
    }

    /**
     * Get all bids for this repairer
     *
     * @param repairer All bids
     * @return
     */
    @Override
    public List<Bid> getBids(Repairer repairer)
    {
        return repairer.getBids();
    }

    /**
     * Retrieve all repairs open and closed.
     *
     * @param keyword can match productname, repair description, brand, category
     * or defect
     * @return list of matching repairs
     * @throws RepairServiceException
     */
    @Override
    public List<Repair> findRepairsByKeyword(String keyword) throws RepairServiceException
    {
        return repairDAO.getRepairsByKeyword(keyword);
    }

    /**
     * Retrieve all repairs open and closed.
     *
     * @return
     * @throws RepairServiceException
     */
    @Override
    public List<Repair> findAllRepairs() throws RepairServiceException
    {
        return repairDAO.getAllRepairs();
    }

    /**
     * Retrieve all broken repairs
     *
     * @return List of repairs
     * @throws RepairServiceException
     */
    @Override
    public List<Repair> findAllOpenRepairs() throws RepairServiceException
    {
        return repairDAO.getAllOpenRepairs();
    }

    /**
     * Retrieve all fixed or Unrepairable repairs
     *
     * @return List of repairs
     * @throws RepairServiceException
     */
    @Override
    public List<Repair> findAllClosedRepairs() throws RepairServiceException
    {
        return repairDAO.getAllClosedRepairs();
    }

    @Override
    public List<Repair> findRepairsByBrand(String brand) throws RepairServiceException
    {
        return repairDAO.getRepairsByBrand(brand);
    }

    /**
     * Find repairs for this category. Utility method that repairers can use to
     * find suitable repairs.
     *
     * @param category
     * @return
     * @throws RepairServiceException
     */
    @Override
    public List<Repair> findRepairsByCategory(String category) throws RepairServiceException
    {
        return repairDAO.getRepairsByCategory(category);
    }

    /**
     * Find repairs per defect. Utility method that repairers can use to find
     * suitable repairs.
     *
     * @param defect
     * @return
     * @throws RepairServiceException
     */
    @Override
    public List<Repair> findRepairsByDefect(String defect) throws RepairServiceException
    {
        return repairDAO.getRepairsByDefect(defect);
    }

    @Override
    public Repair findRepairByID(int id)
    {
        return repairDAO.getRepairByID(id);
    }

    @Override
    public List<Repair> findClosedRepairsByClient(Client client)
    {
        return repairDAO.getClosedRepairsByUser(client);
    }

    @Override
    public List<Repair> findOpenRepairsByClient(Client client)
    {
        return repairDAO.getOpenRepairsByUser(client);
    }

    @Override
    public void removeAllRepairs()
    {
        this.repairDAO.removeAllRepairs();
    }

}
