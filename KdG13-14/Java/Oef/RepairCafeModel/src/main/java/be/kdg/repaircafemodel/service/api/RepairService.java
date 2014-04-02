/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.repaircafemodel.service.api;

import be.kdg.repaircafemodel.dom.repairs.Bid;
import be.kdg.repaircafemodel.dom.repairs.Repair;
import be.kdg.repaircafemodel.dom.repairs.RepairDetails.Status;
import be.kdg.repaircafemodel.dom.users.Client;
import be.kdg.repaircafemodel.dom.users.Repairer;
import be.kdg.repaircafemodel.dom.users.User;
import be.kdg.repaircafemodel.service.exceptions.RepairServiceException;
import java.util.List;

/**
 *
 * @author wouter
 */
public interface RepairService
{
    public void submitRepair(Client user, Repair repair);
    public void removeRepair(User user, Repair repair);
    public void updateRepairStatus(Repair repair, Status newStatus);
    public void removeAllRepairs();

    public boolean placeBid(Repairer repairer, Repair repair, double price);
    public void acceptBid(Bid bid);
    public void clearBid(Bid bid);
    public void removeBid(Bid bid);
    public List<Bid> getBids(Repair repair);
    public List<Bid> getBids(Repairer repairer);
    
    public List<String> getAllCategories();
    public List<String> getAllBrands();
    public List<String> getAllDefects();
    public Repair findRepairByID(int id);
    public List<Repair> findAllRepairsByClient(Client client);
    public List<Repair> findClosedRepairsByClient(Client client);
    public List<Repair> findOpenRepairsByClient(Client client);
    public List<Repair> findRepairsByRepairer(Repairer repairer);
    public List<Repair> findRepairsByKeyword(String keyword) throws RepairServiceException;
    public List<Repair> findAllRepairs() throws RepairServiceException;
    public List<Repair> findAllOpenRepairs() throws RepairServiceException;
    public List<Repair> findAllClosedRepairs() throws RepairServiceException;
    public List<Repair> findRepairsByBrand(String brand) throws RepairServiceException;
    public List<Repair> findRepairsByCategory(String category) throws RepairServiceException;
    public List<Repair> findRepairsByDefect(String defect) throws RepairServiceException;

}
