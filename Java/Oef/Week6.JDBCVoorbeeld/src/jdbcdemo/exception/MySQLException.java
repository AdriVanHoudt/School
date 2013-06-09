package jdbcdemo.exception;

import java.sql.SQLException;

public class MySQLException extends RuntimeException {
    public MySQLException(SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState = " + e.getSQLState());
        System.out.println("Error code = " + e.getErrorCode());
    }
}
