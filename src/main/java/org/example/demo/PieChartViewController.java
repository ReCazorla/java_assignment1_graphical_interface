package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PieChartViewController implements Initializable {

    @FXML
    private PieChart pieChart; // FXML annotation to inject the pie chart component

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Method called to initialize the controller after the FXML fields have been populated
        loadChartDataFromDatabase(); // Call method to load the chart data from database
    }

    private void loadChartDataFromDatabase() {
        // Connect to the database and retrieve data for the pie chart
        try (Connection connection = new DatabaseConnector().connect()) {
            // Prepare SQL query to count characters by their affiliation
            String query = "SELECT affiliation, COUNT(*) AS count FROM characters GROUP BY affiliation ORDER BY count DESC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Iterate through the result set and add data to the pie chart
            while (resultSet.next()) {
                String affiliation = resultSet.getString("affiliation");
                int count = resultSet.getInt("count");
                pieChart.getData().add(new PieChart.Data(affiliation, count)); // Add data to pie chart
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace in case of an SQL exception
        }
    }

    @FXML
    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        // Handler for tableView button: loads the table view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tableView.fxml"));
        Scene scene = new Scene(loader.load()); // Load the scene from FXML
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow(); // Get the current stage
        stage.setScene(scene); // Set the scene to the stage
        stage.show(); // Show the stage
    }

    @FXML
    public void barChartViewButton(ActionEvent actionEvent) throws IOException {
        // Handler for barChartView button: loads the bar chart view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("barChartView.fxml"));
        Scene scene = new Scene(loader.load()); // Load the scene from FXML
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow(); // Get the current stage
        stage.setScene(scene); // Set the scene to the stage
        stage.show(); // Show the stage
    }

    @FXML
    public void pieChartViewButton(ActionEvent actionEvent) throws IOException {
        // Handler for pieChartView button: reloads the pie chart view, effectively refreshing it
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pieChartView.fxml"));
        Scene scene = new Scene(loader.load()); // Load the scene from FXML
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow(); // Get the current stage
        stage.setScene(scene); // Set the scene to the stage
        stage.show(); // Show the stage
    }
}
