package org.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    // Database URL, username, and password constants
    //private static final String URL = "jdbc:sqlserver://javaassignment.database.windows.net:1433;database=starwars;user=javaassignmentadm@javaassignment;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    
    private static final String URL = "jdbc:sqlserver://javaassignment.database.windows.net:1433;database=starwars";

    private static final String USER = "javaassignmentadm@javaassignment";
    private static final String PASS = "Regina12345!";

    // Method to establish a connection to the database
    public Connection connect() {
        try {
            // Attempt to establish a connection to the specified database
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            // If connection fails, throw a runtime exception with the error message
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
