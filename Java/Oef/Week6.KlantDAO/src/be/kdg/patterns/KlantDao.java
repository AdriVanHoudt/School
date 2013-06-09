package be.kdg.patterns;
 
import be.kdg.patterns.Klant;
 
import java.sql.*;
import java.util.Collections;
import java.util.Set;

 
/**
 * Deze klasse kan gebruikt worden om Klant-objecten in een database op te slaan en op te vragen.
 * De gegevens worden bijgehouden in een hsql database.
 * <p/>
 *
 * Vul in deze klasse aan waar nodig.
 */
public class KlantDao {
    private String databasePath;
    private final String driverName = "org.hsqldb.jdbcDriver";
    private Connection connection;
    private Statement statement;
 
    /**
     * Maakt een nieuwe KlantDao aan die werkt met het opgegeven database-bestand.
     *
     * @param databasePath het pad van de database die gebruikt moet worden.
     *                     Indien dit nog niet bestaat, zal het aangemaakt worden.
     */
    public KlantDao(String databasePath) {
        this.databasePath = databasePath;
        laadDriver();
        connection = maakConnectie(this.databasePath);
        statement = maakStatement(connection);
        maakTabel(statement);
        sluitStatementEnConnectie(statement, connection);
    }
 
    /**
     * Laad de driver voor hsqldb.
     * Indien de driver niet gevonden wordt, wordt het systeem afgesloten.
     */
    private void laadDriver() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver niet gevonden");
            System.exit(1);
        }
    }
 
    /**
     * Maakt een nieuwe connectie met de database.
     * Indien het maken van de connectie faalt, wordt het programma afgesloten.
     *
     * @param databasePath het pad van de database die gebruikt moet worden.
     * @return een open connectie naar de database.
     */
    private Connection maakConnectie(String databasePath) {
        try {
            connection = DriverManager.getConnection(databasePath);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState = " + e.getSQLState());
            System.out.println("Error code = " + e.getErrorCode());
            System.out.println("Connectie");
            System.exit(1);
        }
        return connection;
    }
 
    /**
     * Maakt een nieuw statement op basis van een open connectie.
     * Indien de connectie gesloten is, of een andere fout optreedt, dan wordt het programma afgesloten.
     *
     * @param connection een connectie die reeds geopend moet zijn.
     * @return een statement-object dat gebruikt kan worden om SQL-statements uit te voeren.
     */
    private Statement maakStatement(Connection connection) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState = " + e.getSQLState());
            System.out.println("Error code = " + e.getErrorCode());
            System.exit(1);
        }
        return statement;
    }
 
    /**
     * Maakt een tabel met naam 'klanten' in de database.  Indien de tabel al bestaat,
     * wordt deze niet verwijderd.  Indien er iets mis loopt met de database, wordt
     * het programma afgesloten.
     *
     * @param statement een open stattement.
     */
    private void maakTabel(Statement statement) {
        try {
            statement.execute("DROP TABLE klanten IF EXISTS");
            statement.execute("CREATE TABLE klanten (id INTEGER IDENTITY, naam CHAR(40), email CHAR(30))");
        } catch (SQLException e) {
            String message = e.getMessage();
            if (message.contains("Table already exists")) return;
            System.err.println("Unexpected error during creation of table KLANTEN");
            System.exit(1);
        }
    }
 
    /**
     * Zendt een 'CHECKPOINT' statement naar de database en sluit daarna het gegeven statement en connectie.
     * Dit zorgt ervoor dat hsqldb de cache naar schijf schrijft.
     *
     * @param statement  Het SQL statement
     * @param connection De database connection
     */
    private void sluitStatementEnConnectie(Statement statement, Connection connection) {
        try {
            statement.execute("CHECKPOINT");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Cannot execute CHECKPOINT or close statement or close connection");
        }
    }
 
    /**
     * Wist de tabel 'klanten' in de database.
     * indien er iets fout gebeurt, wordt false teruggegeven.
     *
     * @return true als de tabel succesvol gewist werd.
     *         Anders wordt false teruggegeven (ook indien er iets mis liep met de connectie).
     */
    public boolean clear() {
 
        return false;
    }
 
    /**
     * Creëert een nieuw record in de database op basis van het gegeven klant-object.
     * Het gegeven klant-object moet een id hebben die gelijk is aan -1.  Dit wijst erop
     * dat het object nog niet in de database werd toegevoegd.  Na uitvoering van deze
     * methode bevat het klant-object het juiste id waarmee het object in de database
     * geregistreerd werd.
     *
     * @param klant een klant-object waarvan het id nog niet werd ingevuld (gelijk aan -1).
     * @return true als de klant succesvol werd gecreëerd.  Er wordt false teruggegeven wanneer
     *         de klant-id niet -1 was of als er iets mis liep met het uitvoeren van het statement.
     */
    public boolean create(Klant klant) {
        Connection connection = null;
        Statement statement = null;
        try {
            if (klant.getId() >= 0) return false;
            connection = maakConnectie(databasePath);
            statement = maakStatement(connection);
            String naam = klant.getNaam();
            String email = klant.getEmail();
            int rowsAffected = statement.executeUpdate("INSERT INTO klanten VALUES (NULL, '" + naam + "', '" + email + "')");
            if (rowsAffected != 1) {
                sluitStatementEnConnectie(statement, connection);
                return false;
            }
            ResultSet resultSet = statement.executeQuery("CALL IDENTITY()");
            if (!resultSet.next()) {
                sluitStatementEnConnectie(statement, connection);
                return false;
            }
            int id = resultSet.getInt(1);
            klant.setId(id);
            sluitStatementEnConnectie(statement, connection);
            return true;
        } catch (SQLException e) {
            sluitStatementEnConnectie(statement, connection);
            return false;
        }
    }
 
    /**
     * Past de gegevens van een klant-object aan in de database.
     * De klant-id wordt gebruikt om de gegevens terug te vinden in de database.
     *
     * @param klant de nieuwe gegevens van de klant
     * @return true als de gegevens aangepast werden.  Er wordt false teruggegeven wanneer
     *         de klant-id niet gevonden werd of als er iets mis liep met het uitvoeren van het statement.
     */
    public boolean update(Klant klant) {
 
        return false;
    }
 
    /**
     * Haalt klant-gegevens uit de database a.d.h. van een klant-id.
     *
     * @param id een nummer dat deze klant identificeert in de database.
     * @return een ingevuld klant-object indien de klant gevonden werd.  Anders wordt null teruggegeven.  Indien er
     *         iets mis liep met de database-connectie, wordt ook null teruggegeven.
     */
    public Klant retrieve(int id) {
    	try {
            PreparedStatement prestatement = connection.prepareStatement("SELECT naam, email FROM klant WHERE id=?");
            prestatement.setInt(1, id);
            ResultSet result = prestatement.executeQuery();
            prestatement.close();
            Klant klant = new Klant(result.getString("naam"), result.getString("email"));
            return klant;
        }
        catch (SQLException e) {
            System.out.println("retrieve fail");
        }
        return null;
    }
 
    /**
     * Haalt alle klanten op bij wie de naam gelijk is aan de opgegeven naam.
     *
     * @param naam de naam van alle klanten die opgevraagd worden.
     * @return een lijst met ingevulde klant-objecten wiens naam gelijk is aan de opgegeven naam.
     */
    public Set<Klant> retrieveByName(String naam) {
 
        return null;
    }
 
    /**
     * Verwijdert alle gegevens van een klant a.d.h. van een klant-id.
     *
     * @param id de klant-id van de klant die verwijderd moet worden.
     * @return true als de gegevens werden verwijderd.  Er wordt false teruggegeven indien de klant-id
     *         niet werd gevonden of indien er iets mis liep met de database.
     */
    public boolean delete(int id) {
 
        return false;
    }
 
    /**
     * Verwijdert alle gegevens van een klant a.d.h. van een klant-object.
     * Enkel de klant-id van dit object wordt gebruikt.
     *
     * @param klant de klantgegevens die verwijderd moeten worden (enkel de id wordt gebruikt).
     * @return true als de gegevens werden verwijderd.  Er wordt false teruggegeven indien de klant-id
     *         niet werd gevonden of indien er iets mis liep met de database.
     */
    public boolean delete(Klant klant) {
        return delete(klant.getId());
    }
 
    /**
     * Haalt alle klantenrecords op in de vorm van een TreeSet, gesorteerd op naam.
     *
     * @return een TreeSet met alle klantenrecords
     */
    public Set<Klant> retrieveAll() {
        return Collections.emptySet();
    }
 
    /**
     * Sluit de database connectie af.
     * Er wordt ook een 'shutdown' statement uitgevoerd dat alle data naar de schijf wegschrijft.
     */
    public void close() {
        try {
            Connection connection = maakConnectie(databasePath);
            Statement statement = maakStatement(connection);
            statement.execute("SHUTDOWN COMPACT");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            // do nothing, database is not needed anymore
        }
    }
}