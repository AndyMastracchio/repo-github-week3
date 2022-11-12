package com.dh.consultingroom.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Represents a Data base connection using H2 Driver
 * @author Aponte
 */
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:h2:tcp://localhost/~/test";
    private String userName = "sa";
    private String password = "";

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("org.h2.Driver");
            this.connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    /**
     * Obtain a connection reference to make transactions with
     * @return connection on H2 DB
     * @author Aponte
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Using singleton patter it returns only one instance of this object
     * @return DataBaseConnection instance
     * @throws SQLException if sth went wrong with the connection
     * @author Aponte
     */
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}

