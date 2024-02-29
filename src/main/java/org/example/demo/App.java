package org.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the TableView
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("tableView.fxml"));
        // Create a new scene with the loaded FXML
        Scene scene = new Scene(fxmlLoader);
        // Load and set the application icon
        Image image = new Image(getClass().getResourceAsStream("images/icon.png"));
        stage.getIcons().add(image);
        // Set the title of the application window
        stage.setTitle("Star Wars Characters");
        // Set the scene for the stage
        stage.setScene(scene);
        // Display the stage
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the application
        launch();
    }

}
