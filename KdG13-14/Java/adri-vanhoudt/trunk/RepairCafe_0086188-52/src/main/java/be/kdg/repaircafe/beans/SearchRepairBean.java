package be.kdg.repaircafe.beans;

import be.kdg.repaircafemodel.dom.repairs.Repair;
import be.kdg.repaircafemodel.dom.users.Repairer;
import be.kdg.repaircafemodel.dom.users.User;
import be.kdg.repaircafemodel.service.api.RepairService;
import be.kdg.repaircafemodel.service.api.UserService;
import be.kdg.repaircafemodel.service.exceptions.UserServiceException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adri
 */
@Component("searchRepairBean")
@Scope("session")
public class SearchRepairBean implements Serializable{
    
    @Autowired
    RepairService repairService;
    
    @Autowired
    UserService userService;
    
    private String query;
    private List<Repair> repairs;
    private List<Repair> savedRepairs;
    private List<Repair> tempSavedRepairs;
    private Repair selectedRepair;
    private Double price;
    private User user;
    
    // the results panel will be rendered if queried == true
    private boolean queried;

    @PostConstruct
    public void init() {
        this.repairs = new ArrayList<> ();
        this.savedRepairs = new ArrayList<>();
        this.queried = false;
        
        if(!savedRepairs.isEmpty()) {
            this.queried = true;
        }
    }
    
    
    public String searchRepairs() {
        repairs = repairService.findRepairsByKeyword(query);
        this.queried = true;
        return "searchrepairs";
    }
    
    public String saveRepairs() {
        this.savedRepairs.addAll(this.tempSavedRepairs);
        this.queried = false;
        return "searchrepairs";
    }
    
    public String bidOnRepair() {
        System.out.println("Bidding");
        HttpSession session = UtilBean.getSession();
        String usernameTemp = (String) session.getAttribute("username");
        
        try {
            this.user = userService.getUser(usernameTemp);
        } catch (UserServiceException ex) {
            System.out.println("FAIL @searchRepairBean bid " + ex.getMessage());
        }
        
        repairService.placeBid((Repairer)this.user, this.selectedRepair, price);
        System.out.println("Bid of " + this.price + " done");
        return "searchrepairs";
    }
    
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    public List<Repair> getSavedRepairs() {
        return savedRepairs;
    }

    public void setSavedRepairs(List<Repair> savedRepairs) {
        this.savedRepairs = savedRepairs;
    }

    public boolean isQueried() {
        return queried;
    }

    public void setQueried(boolean queried) {
        this.queried = queried;
    }

    public List<Repair> getTempSavedRepairs() {
        return tempSavedRepairs;
    }

    public void setTempSavedRepairs(List<Repair> tempSavedRepairs) {
        this.tempSavedRepairs = tempSavedRepairs;
    }

    public Repair getSelectedRepair() {
        return selectedRepair;
    }

    public void setSelectedRepair(Repair selectedRepair) {
        this.selectedRepair = selectedRepair;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    
}