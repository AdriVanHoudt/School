/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.repaircafemodel.dom.repairs;

import be.kdg.repaircafemodel.dom.users.Repairer;
import org.joda.time.DateTime;

/**
 * A repairer can bid on a repair. Depending on the choice of the customer the
 * bid wil take the form of fixed bid or an per hour bid. Only one bid can be
 * submitted on a particular repair.
 *
 * Once a bid is accepted by the Client no more bid can be submitted.
 *
 * @see be.kdg.repaircafemodel.dom.users.Client
 * @see be.kdg.repaircafemodel.dom.users.Repairer
 * @see be.kdg.repaircafemodel.dom.repairs.Repair
 * @author wouter
 */
public abstract class Bid implements Comparable<Bid>
{
    private static int bidCounter = 0;
    private final int bidId;
    private final DateTime timestamp;
    protected final double price;
    private String comment;
    private Repairer repairer;
    private Repair repair;
    private boolean accepted = false;
    private boolean eligible = true;

    public Bid(double price)
    {
        bidId = bidCounter++;
        this.price = price;
        timestamp = new DateTime();
    }

    public int getBidId()
    {
        return bidId;
    }

    /**
     * Retrieve bidding time
     *
     * @return Timestamp
     */
    public DateTime getTimestamp()
    {
        return timestamp;
    }

    /**
     * Set repairer that placed this bid.
     *
     * @param repairer
     */
    public void setRepairer(Repairer repairer)
    {
        this.repairer = repairer;
    }

    /**
     * Associate with repair
     *
     * @param repair
     */
    public void setRepair(Repair repair)
    {
        this.repair = repair;
    }

    /**
     * Mark bid as accepted
     * @param value
     */
    public void setAccepted(boolean value)
    {
        this.accepted = value;
    }

    /**
     * Return bid price. 
     * 
     * This is either a fixed price or per hour price.
     *
     * @return bid price
     */
    public double getPrice()
    {
        return price;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public Repairer getRepairer()
    {
        return repairer;
    }

    public boolean isAccepted()
    {
        return accepted;
    }

    /**
     * Is this bid still in the running
     * @return bid eligibility
     */
    public boolean isEligible()
    {
        return eligible;
    }

    /**
     * Set eligibility of bid
     * @param eligible 
     */
    public void setEligible(boolean eligible)
    {
        this.eligible = eligible;
    }

    public Repair getRepair()
    {
        return repair;
    }

    @Override
    public int compareTo(Bid o)
    {
        return (int) ((int) price - o.price);
    }

    @Override
    public String toString()
    {
        return "Bid{" + timestamp.toString("dd/MM/yyyy") + ", accepted=" + accepted + ", by user=" + repairer + ", for price=" + price + '}';
    }

    /**
     * Returns bid type: Fixed or Per Hour
     * @return bid type
     */
    public abstract String getType();
}
