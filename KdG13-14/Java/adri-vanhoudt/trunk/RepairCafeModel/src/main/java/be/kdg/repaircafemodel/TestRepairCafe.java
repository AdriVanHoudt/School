/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.kdg.repaircafemodel;

import be.kdg.repaircafemodel.dom.repairs.Item;
import be.kdg.repaircafemodel.dom.repairs.Repair;
import be.kdg.repaircafemodel.dom.repairs.RepairDetails;
import be.kdg.repaircafemodel.dom.users.Address;
import be.kdg.repaircafemodel.dom.users.Client;
import be.kdg.repaircafemodel.dom.users.Person;
import be.kdg.repaircafemodel.dom.users.Repairer;
import be.kdg.repaircafemodel.service.api.RepairService;
import be.kdg.repaircafemodel.service.exceptions.UserServiceException;
import be.kdg.repaircafemodel.service.api.UserService;
import be.kdg.repaircafemodel.service.exceptions.RepairServiceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author wouter
 */
public class TestRepairCafe
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("be/kdg/repaircafemodel/spring/root-context.xml");
        
        // Get userService from Spring Context
        UserService userService = (UserService) context.getBean("userService");
        
        // Get repairService from Spring Context
        RepairService repairService = (RepairService) context.getBean("repairService");
        
        
        // Create a client
        Address address1 = new Address("Nationalestraat", "5", "2000", "Antwerpen");
        Person person1 = new Person("Jan", "Peeters", address1);
        Client client = new Client(person1, "jan.peeters@student.kdg.be", "jan");

        // Create a repairer
        Address address2 = new Address("Nationalestraat", "5", "2000", "Antwerpen");
        Person person2 = new Person("Wouter", "Deketelaere", address2);
        Repairer repairGuy = new Repairer(person2, "wouter.deketelaere@kdg.be", "jef","Master");
        try
        {
            userService.addUser(client);
            userService.addUser(repairGuy);
        }
        catch (UserServiceException ex)
        {
            Logger.getLogger(TestRepairCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        // update een gebruiker met een nieuw wachtwoord                
        try
        {
            userService.updatePassword(repairGuy, "jef", "wouter");
            userService.checkLogin(repairGuy.getUsername(), "wouter");
        }
        catch (UserServiceException ex)
        {
            Logger.getLogger(TestRepairCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try
        {
            userService.checkLogin("wouter.deketelaere@kdg.be", "wouter");
        }
        catch (UserServiceException ex)
        {
            Logger.getLogger(TestRepairCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Repair repair = new Repair(new Item("G 4210 i","Miele","Vaatwasser"), new RepairDetails(
                "Elektrisch", 
                "Toestel stopt niet meer", 
                RepairDetails.PriceModel.FIXED,
                new DateTime().plusWeeks(2)));
        
        repairService.submitRepair(client, repair);
        System.out.println(repairService.getAllCategories());
        repairService.placeBid(repairGuy, repair, 200.0);
        
        System.out.println(repairService.findAllRepairsByClient(client));
        repairService.placeBid(repairGuy, repair, 150);     
        
        try
        {
            System.out.println(repairService.findRepairsByCategory("Vaatwasser"));
            System.out.println(repairService.findRepairsByDefect("Elektrisch"));
            System.out.println(repairService.getBids(repairGuy));
        }
        catch (RepairServiceException ex)
        {
            Logger.getLogger(TestRepairCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
