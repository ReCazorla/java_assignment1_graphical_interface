package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BarChartViewController implements Initializable {
    // Inject the BarChart component from the FXML
    @FXML
    private BarChart<String, Number> barChart;

    // Inject the CategoryAxis component from the FXML
    @FXML
    private CategoryAxis xAxis;

    // Method called to initialize the controller after its root element has been completely processed
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Load chart data from the database upon initialization
        loadChartDataFromDatabase();
    }

    // Fetches data from the database and populates the bar chart
    private void loadChartDataFromDatabase() {
        // Attempt to connect to the database and query for chart data
        try (Connection connection = new DatabaseConnector().connect()) {
            // SQL query to count characters by affiliation
            String query = "SELECT affiliation, COUNT(*) AS count FROM characters GROUP BY affiliation ORDER BY count DESC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Create a new series for the bar chart
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Prevalence of affiliation");

            // Iterate through the result set and add data to the series
            while (resultSet.next()) {
                String affiliation = resultSet.getString("affiliation");
                int count = resultSet.getInt("count");
                series.getData().add(new XYChart.Data<>(affiliation, count));
            }

            // Add the series to the bar chart
            barChart.getData().add(series);

        } catch (SQLException e) {
            // Print the stack trace in case of an SQL exception
            e.printStackTrace();
        }
    }

    // Handles the action event for switching to the table view
    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        // Load the FXML for the table view and switch the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tableView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Handles the action event for refreshing the bar chart view
    public void barChartViewButton(ActionEvent actionEvent) throws IOException {
        // Reload the FXML for the bar chart view and refresh the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("barChartView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Handles the action event for switching to the pie chart view
    public void pieChartViewButton(ActionEvent actionEvent) throws IOException {
        // Load the FXML for the pie chart view and switch the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pieChartView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
