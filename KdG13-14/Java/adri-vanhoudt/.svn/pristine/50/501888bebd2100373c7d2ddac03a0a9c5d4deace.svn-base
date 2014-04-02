package be.kdg.repaircafe.beans;

import be.kdg.repaircafemodel.dom.users.Address;
import be.kdg.repaircafemodel.dom.users.Client;
import be.kdg.repaircafemodel.dom.users.Person;
import be.kdg.repaircafemodel.dom.users.Repairer;
import be.kdg.repaircafemodel.service.api.UserService;
import be.kdg.repaircafemodel.service.exceptions.UserServiceException;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("registerUserBean")
public class RegisterUserBean implements Serializable {

    @Autowired
    private UserService userService;

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String street;
    private String zip;
    private String nr;
    private String city;
    private String degree;

    public String registerUser() {
        try {
            if (degree.isEmpty()) {
                Address address = new Address(street, nr, zip, city);
                Person person = new Person(firstname, lastname, address);
                Client client = new Client(person, username, password);
                userService.addUser(client);
            } else {
                Address address = new Address(street, nr, zip, city);
                Person person = new Person(firstname, lastname, address);
                Repairer repairer = new Repairer(person, username, password, degree);
                userService.addUser(repairer);
            }           
        } catch (UserServiceException ex) {
            System.out.println("FAIL " + ex.getMessage());
        }
        return "index";
    }

public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

}
