package be.kdg.repaircafe.beans;

import be.kdg.repaircafemodel.service.api.UserService;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adri
 */
@Component("utilBean")
public class UtilBean implements Serializable {

    @Autowired
    private UserService userService;

    public static HttpSession getSession() {
        System.out.println("Getting session");
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
        System.out.println("Got session in utilbean");
        return req.getSession(false);
    }

    public static String boomSession() {       
            getSession().invalidate();
            System.out.println("Session went BOOM!");
        return "/index";
    }
}