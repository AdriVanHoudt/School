package be.kdg.repaircafe.beans;

import be.kdg.repaircafemodel.dom.repairs.Item;
import be.kdg.repaircafemodel.dom.repairs.Repair;
import be.kdg.repaircafemodel.dom.repairs.RepairDetails;
import be.kdg.repaircafemodel.dom.repairs.RepairDetails.PriceModel;
import be.kdg.repaircafemodel.dom.users.Client;
import be.kdg.repaircafemodel.service.api.RepairService;
import be.kdg.repaircafemodel.service.api.UserService;
import be.kdg.repaircafemodel.service.exceptions.UserServiceException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adri
 */
@Component("newRepairBean")
@Scope("session")
public class NewRepairBean implements Serializable {

    @Autowired
    private RepairService repairService;
    
    @Autowired
    private UserService userService;

    // Repair details
    private String defect;
    private String description;
    private PriceModel priceModel;
    private List<PriceModel> priceModels;
    private DateTime dueDate;

    // Item
    private String productName;
    private String brand;
    private String category;

    @PostConstruct
    public void init() {
        this.priceModels = new ArrayList();
        this.priceModels.addAll(Arrays.asList(PriceModel.values()));
    }

    public String addNewRepair() {
        System.out.println("Trying to add new repair");
        // make repair
        Item itemTemp = new Item(productName, brand, category);
        RepairDetails repairDetailsTemp = new RepairDetails(defect, description, priceModel, dueDate);
        Repair repairTemp = new Repair(itemTemp, repairDetailsTemp);
        System.out.println("Made the repair now trying to get user as client");

        // get the client which is the current user
        HttpSession session = UtilBean.getSession();
        String usernameTemp = (String) session.getAttribute("username");
        
        try {
            Client c = (Client) userService.getUser(usernameTemp);
            repairService.submitRepair(c, repairTemp);
        } catch (UserServiceException ex) {
            System.out.println("FAIL @newRepairBean add new Repair " + ex.getMessage());
        }

        System.out.println("Added new repair " + this.productName);
        
        return "newrepair";
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriceModel getPriceModel() {
        return priceModel;
    }

    public void setPriceModel(PriceModel priceModel) {
        this.priceModel = priceModel;
    }

    public DateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(DateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<PriceModel> getPriceModels() {
        return priceModels;
    }

    public void setPriceModels(List<PriceModel> priceModels) {
        this.priceModels = priceModels;
    }

    
}
