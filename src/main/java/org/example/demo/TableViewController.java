package org.example.demo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class TableViewController {

    @FXML
    private DatabaseConnector dbConnector = new DatabaseConnector(); // Connector to interact with the database

    @FXML
    private TableView<Characters> containerTable; // TableView to display character data

    @FXML
    private TableColumn<Characters, Integer> idColumn; // Column for character IDs

    @FXML
    private TableColumn<Characters, String> nameColumn; // Column for character names

    @FXML
    private TableColumn<Characters, String> speciesColumn; // Column for character species

    @FXML
    private TableColumn<Characters, String> genderColumn; // Column for character genders

    @FXML
    private TableColumn<Characters, String> affiliationColumn; // Column for character affiliations

    @FXML
    private TableColumn<Characters, String> planet_of_originColumn; // Column for characters' planets of origin

    // Initialize method to set up the table columns and load character data
    @FXML
    private void initialize() {
        // Set up each column to display data based on character properties
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        speciesColumn.setCellValueFactory(new PropertyValueFactory<>("species"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        affiliationColumn.setCellValueFactory(new PropertyValueFactory<>("affiliation"));
        planet_of_originColumn.setCellValueFactory(new PropertyValueFactory<>("planet_of_origin"));

        // Retrieve and set character data from database to table
        Characters characters = new Characters();
        ObservableList<Characters> items = characters.getCharactersFromDatabase();
        this.containerTable.setItems(items);
    }

    // Handler to reload the tableView
    @FXML
    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tableView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Handler to switch to the barChartView
    @FXML
    public void barChartViewButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("barChartView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Handler to switch to the pieChartView
    @FXML
    public void pieChartViewButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pieChartView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
