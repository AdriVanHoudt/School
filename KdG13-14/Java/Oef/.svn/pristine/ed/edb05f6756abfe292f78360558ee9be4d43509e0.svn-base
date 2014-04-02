/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.repaircafemodel.dom.users;

import be.kdg.repaircafemodel.dom.repairs.Bid;
import be.kdg.repaircafemodel.dom.repairs.FixedBid;
import be.kdg.repaircafemodel.dom.repairs.Item;
import be.kdg.repaircafemodel.dom.repairs.PerhourBid;
import be.kdg.repaircafemodel.dom.repairs.Repair;
import be.kdg.repaircafemodel.dom.repairs.RepairDetails;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.joda.time.DateTime;

/**
 *
 * @author wouter
 */
public class RepairerTest extends TestCase
{
    private Repairer repairer;

    public RepairerTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        Address address2 = new Address("Nationalestraat", "5", "2000", "Antwerpen");
        Person person2 = new Person("Wouter", "Deketelaere", address2);
        repairer = new Repairer(person2, "wouter.deketelaere@kdg.be", "jef", "Master");
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    /**
     * Test of addBid method, of class Repairer.
     */
    public void testAddBid()
    {
        System.out.println("addBid");
        Bid bid = new FixedBid(100);
        Repairer instance = repairer;
        instance.addBid(bid);
        bid.setRepairer(repairer);
        assertEquals(bid.getRepairer(), repairer);
    }

    /**
     * Test of getBids method, of class Repairer.
     */
    public void testGetBids()
    {
        System.out.println("getBids");
        Repairer instance = repairer;
        Bid fixedBid = new FixedBid(300);
        Bid priceBid = new PerhourBid(20);
        instance.addBid(fixedBid);
        instance.addBid(priceBid);
        List<Bid> expResult = new ArrayList<>();
        expResult.add(fixedBid);
        expResult.add(priceBid);
        List<Bid> result = instance.getBids();
        assertEquals(expResult, result);
    }

    /**
     * Test of rate method, of class Repairer.
     */
    public void testRate()
    {
        System.out.println("rate");
        int rating = 5;
        Repairer instance = repairer;
        instance.rate(rating);
        instance.rate(rating - 1);
        instance.rate(rating - 2);
        // overal rating is in feite 3.75 -> afronden en casten geeft 4
        assertEquals(instance.getOveralRating(), 4);
    }

    /**
     * Test of getOveralRating method, of class Repairer.
     */
    public void testGetOveralRating()
    {
        System.out.println("getOveralRating");
        Repairer instance = repairer;
        int expResult = 0;
        int rating = 0;
        instance.rate(rating);
        instance.rate(rating - 1);
        instance.rate(rating - 2);
        int result = instance.getOveralRating();
        assertEquals(expResult, result);
    }

    /**
     * Test of Repairers removePair method
     */
    public void testRemoveRepair()
    {
        System.out.println("testRemoveRepair");
        Repair repair = new Repair(new Item("G 4210 i", "Miele", "Vaatwasser"), new RepairDetails(
                "Elektrisch",
                "Toestel stopt niet meer",
                RepairDetails.PriceModel.FIXED,
                new DateTime().plusWeeks(2)));
        
        // create bid
        Bid bid = new FixedBid(200);
        // bid is owned by repairer
        repairer.addBid(bid);
        // bid is placed on repair
        repair.addBid(bid);
        // another bid is placed on the repair
        repair.addBid(new FixedBid((100)));
        // "assign" repairer
        repairer.addRepair(repair);
        
        // now remove this repair from the repair -> should also remove bid from his list
        repairer.removeRepair(repair);
        
        assertTrue(!repairer.getBids().contains(bid));
    }

}
