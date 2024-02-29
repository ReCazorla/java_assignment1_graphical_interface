package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.*;

public class Characters {

    // Declare the properties of a character
    private Integer id;
    private String name;
    private String species;
    private String gender;
    private String affiliation;
    private String planet_of_origin;

    // Default constructor
    public Characters() {
    }

    // Constructor with parameters to initialize a character object
    public Characters(Integer id, String name, String species, String gender, String affiliation,
                      String planet_of_origin) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.affiliation = affiliation;
        this.planet_of_origin = planet_of_origin;
    }

    // Getters and setters for each property
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getPlanet_of_origin() {
        return planet_of_origin;
    }

    public void setPlanet_of_origin(String planet_of_origin) {
        this.planet_of_origin = planet_of_origin;
    }

    // Database connector instance for establishing connection
    DatabaseConnector dbConnector = new DatabaseConnector();

    // Fetches characters from the database and returns them as an observable list
    public ObservableList<Characters> getCharactersFromDatabase() {
        ObservableList<Characters> personaList = FXCollections.observableArrayList();

        try {
            // Establish connection to the database
            Connection connection = dbConnector.connect();
            // SQL query to select all characters
            String SQL = "SELECT * FROM characters";
            Statement stmt = connection.createStatement();
            ResultSet resul = stmt.executeQuery(SQL);

            // Iterate through the result set and add each character to the list
            while (resul.next()) {
                Integer id = resul.getInt("id");
                String name = resul.getString("name");
                String species = resul.getString("species");
                String gender = resul.getString("gender");
                String affiliation = resul.getString("affiliation");
                String planet_of_origin = resul.getString("planet_of_origin");

                Characters character = new Characters(id, name, species, gender, affiliation, planet_of_origin);
                personaList.add(character);
            }

        } catch (SQLException e) {
            // In case of an SQL exception, show a confirmation alert with the error message
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("WARNING");
            alerta.setContentText(e + "");
            alerta.showAndWait();
        }

        return personaList;
    }

}
