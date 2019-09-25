package main.java.com.excilys.dao.impl;

public class DBConnectionException extends RuntimeException {
    /**
     * Constructs a DBConnectionException with the given detail message.
     *
     * @param message The detail message of the DAOException.
     */
    public DBConnectionException(String message) {
        super(message);
    }
 
    /**
     * Constructs a DBConnectionException with the given root cause.
     *
     * @param cause The root cause of the DAOException.
     */
    public DBConnectionException(Throwable cause) {
        super(cause);
    }
 
    /**
     * Constructs a DBConnectionException with the given detail message and root
     * cause.
     *
     * @param message The detail message of the DAOException.
     * @param cause The root cause of the DAOException.
     */
    public DBConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
	


