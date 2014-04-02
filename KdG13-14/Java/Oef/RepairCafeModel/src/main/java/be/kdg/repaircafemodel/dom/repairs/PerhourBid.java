/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.kdg.repaircafemodel.dom.repairs;

/**
 *
 * @author wouter
 */
public class PerhourBid extends Bid
{
    /**
     * Bid with per hour  price.    
     * If the customer creates a per hour priced repair
     * only this type of offer can be made.
     *
     * @param price
     */
    public PerhourBid(double price)
    {
        super(price);
    }

    @Override
    public String getType()
    {
        return "Per Hour";
    }
    
}
