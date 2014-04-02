/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.repaircafemodel.dom.repairs;

import be.kdg.repaircafemodel.dom.users.Client;
import be.kdg.repaircafemodel.dom.users.Repairer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Displays all information about a repair.  A repair has a unique number and is
 * associated with an Item and a Client who has filed it in the system. It also
 * includes a list of bids. These bids are offered by different Repairers A
 * repair can have a status Fixed, Broken or irreparable.
 * 
 * It can be associated with a repairer too if a repairers bid was accepted.
 *
 * @see(be.kdg.repaircafemodel.dom.repairs.Repair.Status) A Repairer can write a
 * rebuttal if he is not satisfied with the evaluation by a Client
 *
 * @author wouter
 */
public class Repair implements Comparable<Repair>, Serializable
{
    private static int repairCounter = 0;
    private final int repairId;
    private Client client;    
    private Repairer repairer;    
    private RepairDetails details;
    private Item item;        
    private final List<Bid> bids;        

    private Repair()
    {
        this.repairId = repairCounter++;
        this.bids = new ArrayList<>();                
    }

    public Repair(Item item, RepairDetails repDetails)
    {
        this();
        this.item = item;
        this.details = repDetails;
    }

    public void addBid(Bid bid)
    {
        this.bids.add(bid);
    }

    public void addClient(Client client)
    {
        this.client = client;
    }

    public void setRepairer(Repairer repairer)
    {
        this.repairer = repairer;
    }

    public int getRepairId()
    {
        return repairId;
    }

    public List<Bid> getBids()
    {
        return bids;
    }

    public RepairDetails getDetails()
    {
        return details;
    }
    
    public Client getClient()
    {
        return client;
    }

    public Repairer getRepairer()
    {
        return repairer;
    }

    public Item getItem()
    {
        return item;
    }

    public void setDetails(RepairDetails details)
    {
        this.details = details;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }

    @Override
    public int compareTo(Repair o)
    {
        return this.details.getSubmitDate().compareTo(o.getDetails().getSubmitDate());
    }

    @Override
    public String toString()
    {
        return String.format("%s -%s", this.getDetails().getDescription(), item.getProductName());
    }

}
