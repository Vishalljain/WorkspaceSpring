/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FXML1DataController.property;

/**
 *
 * @author IXL1KOR
 */
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ModelUpdateExample extends Application {
     BusinessLogicModel businessModel = new BusinessLogicModel("Vishal","Bhadravathi");
      UIModel uiModel = new UIModel(businessModel);

    @Override
    public void start(Stage primaryStage) {
       
        VBox root = new VBox(10);

        // Using StringProperty for name
        TextField nameTextFieldProperty = new TextField();
        nameTextFieldProperty.setEditable(true);
        nameTextFieldProperty.textProperty().bind(uiModel.nameProperty());
        root.getChildren().add(new Label("Name (StringProperty):"));
        root.getChildren().add(nameTextFieldProperty);

        // Using simple String for city
        TextField cityTextFieldVariable = new TextField();
        cityTextFieldVariable.setEditable(true);
        cityTextFieldVariable.textProperty().bindBidirectional(uiModel.cityProperty());
        root.getChildren().add(new Label("City (String variable):"));
        root.getChildren().add(cityTextFieldVariable);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Model Update Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Add listener to detect changes in the UI model's name property
        uiModel.nameProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("UI Model - Name changed: " + newValue);
            // Update the business logic model
            businessModel.setName(newValue);
        });

        // Add listener to detect changes in the UI model's city property
        uiModel.cityProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("UI Model - City changed: " + newValue);
            // Update the business logic model
            businessModel.setCity(newValue);
        });
        
      
    }

    @Override
    public void stop() throws Exception {
        System.out.println(businessModel);
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }
}

class BusinessLogicModel {
    private String name;
    private String city;

    public BusinessLogicModel(String name, String city) {
        this.name=name;
        this.city=city;
    }

    @Override
    public String toString() {
        return "BusinessLogicModel{" + "name=" + name + ", city=" + city + '}';
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

class UIModel {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty city = new SimpleStringProperty();
    private final BusinessLogicModel businessModel;

    public UIModel(BusinessLogicModel businessModel) {
        this.businessModel = businessModel;

        // Initialize UI model with data from business model
        name.set(businessModel.getName());
        city.set(businessModel.getCity());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }
}

