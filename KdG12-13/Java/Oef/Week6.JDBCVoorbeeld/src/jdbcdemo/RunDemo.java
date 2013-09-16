package jdbcdemo;

import jdbcdemo.data.GebruikersDAO;
import jdbcdemo.view.LoginFrame;

public class RunDemo {
    public static void main(String[] args) {
        GebruikersDAO dao = GebruikersDAO.getInstance();
        dao.maakGebruikersDatabaseTabel();
        dao.updateGebruikers();
        GebruikersDAO.flushDAO();
        new LoginFrame();
    }
}
