package org.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    // Database URL, username, and password constants
    private static final String URL = "jdbc:mysql://localhost:3306/star_wars";
    private static final String USER = "root";
    private static final String PASS = "";

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
