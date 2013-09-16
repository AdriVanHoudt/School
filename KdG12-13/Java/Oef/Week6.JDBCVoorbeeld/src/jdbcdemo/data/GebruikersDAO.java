package jdbcdemo.data;

import jdbcdemo.exception.MySQLException;
import jdbcdemo.model.Gebruiker;
import jdbcdemo.model.Gebruikers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GebruikersDAO {
    private static final String driver = "org.hsqldb.jdbcDriver";
    private static final String url = "jdbc:hsqldb:dbData/demo";
    private static final String user = "sa";
    private static final String password = "";
    private static GebruikersDAO dao;
    private static Connection dataBaseConnection;

    private GebruikersDAO() {
        // leeg
    }

    public static GebruikersDAO getInstance() {
        if (dao == null) {
            dataBaseConnection = DatabaseConnection.openConnection(
                    url, user, password, driver);
            dao = new GebruikersDAO();
        }
        return dao;
    }

    public static void flushDAO() {
        DatabaseConnection.closeConnection();
        dao = null;
    }

    public void maakGebruikersDatabaseTabel() {
        Statement statement;
        try {
            statement = dataBaseConnection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS gebruikers");
            String create = "CREATE TABLE gebruikers " +
                    "(sleutel INT NOT NULL PRIMARY KEY," +
                    "voornaam VARCHAR(20) NOT NULL," +
                    "familienaam VARCHAR(30) NOT NULL," +
                    "gebruikersnaam VARCHAR(20) NOT NULL," +
                    "wachtwoord VARCHAR(20) NOT NULL)";
            statement.executeUpdate(create);
            statement.close();
        }
        catch (SQLException e) {
            throw new MySQLException(e);
        }
    }

    public List<Gebruiker> getGebruikers() {
        List<Gebruiker> gebruikers = new ArrayList<Gebruiker>();
        Statement statement;
        try {
            statement = dataBaseConnection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM gebruikers");
            while (result.next()) {
                Gebruiker gebruiker = new Gebruiker(
                        result.getInt("sleutel"),
                        result.getString("voornaam"),
                        result.getString("familieNaam"),
                        result.getString("gebruikersnaam"),
                        result.getString("wachtwoord"));
                gebruikers.add(gebruiker);
            }
            statement.close();
        }
        catch (SQLException e) {
            throw new MySQLException(e);
        }
        return Collections.unmodifiableList(gebruikers);
    }

    public void clearGebruikers() {
        Statement statement;
        try {
            statement = dataBaseConnection.createStatement();
            String delete = "DELETE FROM gebruikers";  // maakt de tabel helemaal leeg
            statement.execute(delete);
            statement.close();
        }
        catch (SQLException e) {
            throw new MySQLException(e);
        }
    }

    public void updateGebruikers() {
        clearGebruikers();

        Gebruikers gebruikers = new Gebruikers();
        List<Gebruiker> lijst = gebruikers.getGebruikers();
        PreparedStatement statement;
        try {
            statement = dataBaseConnection.prepareStatement(
                    "INSERT INTO gebruikers (" +
                            "sleutel, voornaam, familienaam, gebruikersnaam, wachtwoord)" +
                            "VALUES(?,?,?,?,?)");
            dataBaseConnection.setAutoCommit(false);
            for (Gebruiker gebruiker : lijst) {
                statement.setInt(1, gebruiker.getSleutel());
                statement.setString(2, gebruiker.getVoornaam());
                statement.setString(3, gebruiker.getFamilienaam());
                statement.setString(4, gebruiker.getGebruikersnaam());
                statement.setString(5, gebruiker.getWachtwoord());
                statement.executeUpdate();
            }
            dataBaseConnection.commit();
            dataBaseConnection.setAutoCommit(true);
            statement.close();
        }
        catch (SQLException e) {
            throw new MySQLException(e);
        }
    }

    public boolean isGeldigeGebruiker(String gebruikersnaam, char[] wachtwoord) {
        PreparedStatement statement;
        try {
            statement = dataBaseConnection.prepareStatement(
                    "SELECT voornaam FROM gebruikers WHERE gebruikersnaam = ? " +
                            "AND wachtwoord = ?");
            statement.setString(1, gebruikersnaam);
            statement.setString(2, new String(wachtwoord));
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                statement.close();
                return true;
            }
            statement.close();
        }
        catch (SQLException e) {
            throw new MySQLException(e);
        }
        return false;
    }
}
