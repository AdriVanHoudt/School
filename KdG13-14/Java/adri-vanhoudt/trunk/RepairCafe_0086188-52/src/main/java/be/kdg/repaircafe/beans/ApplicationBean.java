package be.kdg.repaircafe.beans;

import be.kdg.repaircafemodel.TestRepairCafe;
import be.kdg.repaircafemodel.dom.repairs.Item;
import be.kdg.repaircafemodel.dom.repairs.Repair;
import be.kdg.repaircafemodel.dom.repairs.RepairDetails;
import be.kdg.repaircafemodel.dom.users.Address;
import be.kdg.repaircafemodel.dom.users.Client;
import be.kdg.repaircafemodel.dom.users.Person;
import be.kdg.repaircafemodel.dom.users.Repairer;
import be.kdg.repaircafemodel.service.api.RepairService;
import be.kdg.repaircafemodel.service.api.UserService;
import be.kdg.repaircafemodel.service.exceptions.UserServiceException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adri
 */
@Component("applicationBean")
@Scope("application")
public class ApplicationBean implements Serializable, ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserService userService;

    @Autowired
    private RepairService repairService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        userService.removeAllUsers();
        repairService.removeAllRepairs();

        // Maak een gewone gebruiker
        Address address1 = new Address("Bruul", "5", "2800", "Mechelen");
        Person person1 = new Person("Jan", "Peeters", address1);
        Client client1 = new Client(person1, "jan.peeters@student.kdg.be", "jan");

        // Maak een gewone gebruiker
        Address address2 = new Address("Zandstraat", "23", "3000", "Leuven");
        Person person2 = new Person("Michel", "Van den Bergh", address2);
        Client client2 = new Client(person2, "michel.vandenbergh@gmail.com", "michel");

        // Maak een repairer
        Address address3 = new Address("Nationalestraat", "5", "2000", "Antwerpen");
        Person person3 = new Person("Wouter", "Deketelaere", address3);
        Repairer repairGuy1 = new Repairer(person3, "wouter.deketelaere@kdg.be", "jef", "Master");
        repairGuy1.rate(4);

        // Maak een repairer
        Address address4 = new Address("Kleuterstraat", "1", "2500", "Lier");
        Person person4 = new Person("Handy", "Man", address4);
        Repairer repairGuy2 = new Repairer(person4, "handy.man@handyman.com", "moeilijk", "Bachelor");
        repairGuy2.rate(3);
        
        try {
            userService.addUser(client1);
            userService.addUser(client2);
            userService.addUser(repairGuy1);
            userService.addUser(repairGuy2);

        // update een gebruiker met een nieuw wachtwoord                
            userService.updatePassword(repairGuy1, "jef", "wouter");
            userService.checkLogin(repairGuy1.getUsername(), "wouter");
        } catch (UserServiceException ex) {
            Logger.getLogger(TestRepairCafe.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            userService.checkLogin("wouter.deketelaere@kdg.be", "wouter");
        } catch (UserServiceException ex) {
            Logger.getLogger(TestRepairCafe.class.getName()).log(Level.SEVERE, null, ex);
        }

        Repair repair1 = new Repair(new Item("G 4210 i", "Miele", "Vaatwasser"), new RepairDetails(
                "Elektrisch",
                "Toestel stopt niet meer",
                RepairDetails.PriceModel.FIXED,
                new DateTime().plusWeeks(2)));

        repairService.submitRepair(client1, repair1);

        Repair repair2 = new Repair(new Item("ALOA 150", "Logicom", "Telefoon"), new RepairDetails(
                "Elektrisch",
                "Laadt niet meer op",
                RepairDetails.PriceModel.PER_HOUR,
                new DateTime().plusWeeks(2)));
        repairService.submitRepair(client2, repair2);

        System.out.println(repairService.getAllCategories());
        repairService.placeBid(repairGuy1, repair1, 200.0);
        repairService.placeBid(repairGuy2, repair1, 150.0);

        System.out.println(repairService.findAllRepairsByClient(client1));
        repairService.placeBid(repairGuy1, repair2, 15);
        repairService.placeBid(repairGuy2, repair2, 12);
    }

}