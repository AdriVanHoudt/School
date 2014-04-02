package be.kdg.repaircafe.beans;

import be.kdg.repaircafemodel.dom.repairs.Bid;
import be.kdg.repaircafemodel.dom.repairs.Repair;
import be.kdg.repaircafemodel.dom.users.Client;
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
@Component("clientdashBean")
@Scope("session")
public class ClientDashBean implements Serializable {

    @Autowired
    RepairService repairService;

    @Autowired
    UserService userService;

    private List<Repair> openRepairs;
    private List<Repair> closedRepairs;

    private Repair selectedOpenRepair;
    private Bid selectedBid;

    private int daysLeft;
    private User user;
    private Bid acceptedBid;
    private Repair acceptedRepair;

    private Boolean renderBids;
    private Boolean renderSummary;

    @PostConstruct
    public void init() {
        this.openRepairs = new ArrayList<>();
        this.closedRepairs = new ArrayList<>();
        
        this.renderBids = false;
        this.renderSummary = false;
        
        getUser();

        if (!this.user.toString().isEmpty()) {
            this.openRepairs = repairService.findOpenRepairsByClient((Client) this.user);
            this.closedRepairs = repairService.findClosedRepairsByClient((Client) this.user);
        }

    }

    private void getUser() {
        HttpSession session = UtilBean.getSession();
        String usernameTemp = (String) session.getAttribute("username");

        try {
            this.user = userService.getUser(usernameTemp);
        } catch (UserServiceException ex) {
            System.out.println("FAIL @clientDashBean getUser " + ex.getMessage());
        }
    }

    public String acceptBid() {
        System.out.println("accepting bid");
        repairService.acceptBid(selectedBid);
        this.acceptedBid = selectedBid;
        this.acceptedRepair = selectedBid.getRepair();
        this.renderBids = false;
        this.renderSummary = true;
        System.out.println("accepted bid");
        return "clientdash";
    }

    public String showBids() {
        if (this.selectedOpenRepair.getRepairer() == null) {
            this.setRenderBids(true);
        } else {
            this.setRenderBids(false);
        }
        return "clientdash";
    }

    public List<Repair> getOpenRepairs() {
        return openRepairs;
    }

    public void setOpenRepairs(List<Repair> openRepairs) {
        this.openRepairs = openRepairs;
    }

    public List<Repair> getClosedRepairs() {
        return closedRepairs;
    }

    public void setClosedRepairs(List<Repair> closedRepairs) {
        this.closedRepairs = closedRepairs;
    }

    public Repair getSelectedOpenRepair() {
        return selectedOpenRepair;
    }

    public void setSelectedOpenRepair(Repair selectedOpenRepair) {
        this.selectedOpenRepair = selectedOpenRepair;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public Bid getSelectedBid() {
        return selectedBid;
    }

    public void setSelectedBid(Bid selectedBid) {
        System.out.println(selectedBid);
        this.selectedBid = selectedBid;
    }

    public Bid getAcceptedBid() {
        return acceptedBid;
    }

    public void setAcceptedBid(Bid acceptedBid) {
        this.acceptedBid = acceptedBid;
    }

    public Repair getAcceptedRepair() {
        return acceptedRepair;
    }

    public void setAcceptedRepair(Repair acceptedRepair) {
        this.acceptedRepair = acceptedRepair;
    }

    public Boolean isRenderBids() {
        return renderBids;
    }

    public void setRenderBids(Boolean renderBids) {
        this.renderBids = renderBids;
    }

    public Boolean isRenderSummary() {
        return renderSummary;
    }

    public void setRenderSummary(Boolean renderSummary) {
        this.renderSummary = renderSummary;
    }

}
