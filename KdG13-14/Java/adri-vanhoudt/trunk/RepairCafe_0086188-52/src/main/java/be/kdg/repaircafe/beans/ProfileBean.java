package be.kdg.repaircafe.beans;

import be.kdg.repaircafemodel.dom.users.Address;
import be.kdg.repaircafemodel.dom.users.Person;
import be.kdg.repaircafemodel.dom.users.User;
import be.kdg.repaircafemodel.service.api.UserService;
import be.kdg.repaircafemodel.service.exceptions.UserServiceException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adri
 */
@Component("profileBean")
@Scope("session")
public class ProfileBean implements Serializable {

    @Autowired
    private UserService userService;

    private User user;

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String street;
    private String zip;
    private String nr;
    private String city;

    private String old_password;
    private String new_password;

    @PostConstruct
    public void init() {
        HttpSession session = UtilBean.getSession();
        String usernameTemp = (String) session.getAttribute("username");
        
        try {
            this.user = userService.getUser(usernameTemp);
        } catch (UserServiceException ex) {
            System.out.println("FAIL @profileBean init " + ex.getMessage());
        }
        
        this.username = user.getUsername();
        this.firstname = user.getPerson().getFirstname();
        this.lastname = user.getPerson().getLastname();
        this.street = user.getPerson().getAddress().getStreet();
        this.zip = user.getPerson().getAddress().getZip();
        this.nr = user.getPerson().getAddress().getNr();
        this.city = user.getPerson().getAddress().getCity();
        System.out.println("init username " + this.user.getUsername());
    }

    public String updateUser() {
        System.out.println("in update method");
        try {
            System.out.println(username);
            Address address = new Address(street, nr, zip, city);
            Person person = new Person(firstname, lastname, address);
            userService.updateUser(userService.getUser(username), person);
            System.out.println("updated person");
        } catch (UserServiceException ex) {
            System.out.println("FAIL @profileBean updateUser" + ex.getMessage());
        }
        return "profile";
    }

    public String updatePassword() {
        System.out.println("in update password");
        if (!new_password.isEmpty() && new_password.length() >= 3) {
            try {
                user.changePassword(old_password, new_password);
            } catch (UserServiceException ex) {
                System.out.println("FAIL @profileBean udatePassword " + ex.getMessage());
            }
        }
        return "profile";
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
}