/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FXML1DataController;

/**
 *
 * @author IXL1KOR
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private PersonListController personListController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/PersonList_1.fxml"));

            primaryStage.setScene(new Scene(loader.load()));

            personListController = loader.getController();
            personListController.setMainApp(this);

            primaryStage.setTitle("Person List App");
            primaryStage.show();

            // Load data from XML file on application start
            personListController.loadDataFromXML();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        // Save data to FXML file when closing application
        personListController.saveDataToFXML();
    }
}

