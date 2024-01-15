/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarshallingUnMarshalling;

/**
 *
 * @author IXL1KOR
 */

import FXML1DataController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private DeviceController deviceController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/DeviceFxml.fxml"));

            primaryStage.setScene(new Scene(loader.load()));

           
            

            primaryStage.setTitle("Person List App");
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

   

