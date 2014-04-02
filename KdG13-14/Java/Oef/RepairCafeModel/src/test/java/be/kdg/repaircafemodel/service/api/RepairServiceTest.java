/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.repaircafemodel.service.api;

import be.kdg.repaircafemodel.dom.repairs.Bid;
import be.kdg.repaircafemodel.dom.repairs.FixedBid;
import be.kdg.repaircafemodel.dom.repairs.Item;
import be.kdg.repaircafemodel.dom.repairs.Repair;
import be.kdg.repaircafemodel.dom.repairs.RepairDetails;
import be.kdg.repaircafemodel.dom.users.Address;
import be.kdg.repaircafemodel.dom.users.Client;
import be.kdg.repaircafemodel.dom.users.Person;
import be.kdg.repaircafemodel.dom.users.Repairer;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author wouter
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/be/kdg/repaircafemodel/spring/root-context.xml")
public class RepairServiceTest
{
    @Autowired
    private RepairService repairService;
    private Client client;
    private Repairer repairer;
    private Repair repair;

    @Before
    public void setUp()
    {
        // Create a client
        Address address1 = new Address("Nationalestraat", "5", "2000", "Antwerpen");
        Person person1 = new Person("Jan", "Peeters", address1);
        client = new Client(person1, "jan.peeters@student.kdg.be", "jan");

        // Create a repairer
        Address address2 = new Address("Nationalestraat", "5", "2000", "Antwerpen");
        Person person2 = new Person("Wouter", "Deketelaere", address2);
        repairer = new Repairer(person2, "wouter.deketelaere@kdg.be", "jef", "Master");

        repair = new Repair(new Item("G 4210 i", "Miele", "Vaatwasser"), new RepairDetails(
                "Elektrisch",
                "Toestel stopt niet meer",
                RepairDetails.PriceModel.FIXED,
                new DateTime().plusWeeks(2)));        
    }

    @Test
    public void testCreateRepair()
    {
        repairService.submitRepair(client, repair);
        TestCase.assertTrue(client.getRepairs().contains(repair));
        TestCase.assertEquals(repair.getClient(),client);
    }
    
    @Test
    public void testPlaceBid()
    {
        repairService.placeBid(repairer, repair, 200);
        TestCase.assertTrue(!repairer.getBids().isEmpty());
        TestCase.assertTrue(!repair.getBids().isEmpty());        
    }
    
    @Test
    public void testAcceptBid()
    {
        // place bid on repair by repairer
        repairService.placeBid(repairer, repair, 200);
        // get that bid
        Bid bid = repair.getBids().get(0);

        // accept that bid
        repairService.acceptBid(bid);
        
        // assert that repair is now assigned
        TestCase.assertTrue(repair.getDetails().isAssigned());
        // assert that no bid are eligible anymore.
        for(Bid b: repair.getBids())
        {
            TestCase.assertTrue(!b.isEligible());
        }
        // assert that the placed bid is accepted
        TestCase.assertTrue(bid.isAccepted());
        // assert that the repair is associated with the repairer that placed
        // the bid.
        TestCase.assertEquals(repair.getRepairer(), repairer);
    }
    
    @Test
    public void testRemoveRepair()
    {
        // submit a repair to system 
        repairService.submitRepair(client, repair);
        
        // place bid on repair for a repairer
        repairService.placeBid(repairer, repair, 200);
        
        // get that bid
        Bid bid = repair.getBids().get(0);
        
        // accept that bid
        repairService.acceptBid(bid);        
        
        // remove repair for this repairer
        repairService.removeRepair(repairer, repair);
        
        TestCase.assertTrue(!repairer.getRepairs().contains(repair));
        TestCase.assertTrue(!repairer.getBids().contains(bid));
    }
    
    @Test
    public void testRemoveBid()
    {
        // submit a repair to system 
        repairService.submitRepair(client, repair);
        
        // place bid on repair for a repairer
        repairService.placeBid(repairer, repair, 200);
        
        // get that bid
        Bid bid = repair.getBids().get(0);
        
        // place another bid on repair by the same repairer
        repairService.placeBid(repairer, repair, 100);
        
        // accept that bid
        repairService.acceptBid(bid);
        
        // remove first bid
        repairService.removeBid(bid);        
        
        TestCase.assertTrue(!repair.getBids().contains(bid));
        TestCase.assertTrue(!repairer.getBids().contains(bid));
        TestCase.assertTrue(!repair.getBids().isEmpty());
        TestCase.assertTrue(!repairer.getBids().isEmpty());
        TestCase.assertTrue(repairer.getRepairs().isEmpty());
    }
    
}
