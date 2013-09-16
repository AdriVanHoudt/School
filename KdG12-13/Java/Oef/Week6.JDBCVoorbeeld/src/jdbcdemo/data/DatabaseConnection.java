package jdbcdemo.data;

import jdbcdemo.exception.MySQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connection;

    private DatabaseConnection() {
        // leeg
    }

    public static Connection openConnection(String sourceUrl, String username,
                                            String password, String driverName) {
        if (connection == null) {
            try {
                Class.forName(driverName);
                connection = DriverManager.getConnection(sourceUrl, username, password);
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC Driver niet gevonden: " + e.getMessage());
                System.exit(1);
            } catch (SQLException e) {
                throw new MySQLException(e);
            }
        }
        return connection;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new MySQLException(e);
        }
        finally {
            connection = null;
        }
    }
}
