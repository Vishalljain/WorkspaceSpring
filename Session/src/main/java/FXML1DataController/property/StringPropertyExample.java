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

public class StringPropertyExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Person person = new Person("Honey", "Italy");

        VBox root = new VBox(10);

        // Using StringProperty for name
        TextField nameTextFieldProperty = new TextField();
        nameTextFieldProperty.setEditable(true);
        nameTextFieldProperty.textProperty().bind(person.nameProperty());
        root.getChildren().add(new Label("Name (StringProperty):"));
        root.getChildren().add(nameTextFieldProperty);

        // Using simple String variable for city
        TextField cityTextFieldVariable = new TextField();
        cityTextFieldVariable.setEditable(true);
        cityTextFieldVariable.setText(person.getCity());
        root.getChildren().add(new Label("City (String variable):"));
        root.getChildren().add(cityTextFieldVariable);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("StringProperty Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set values in real-time
        new Thread(() -> {
            try {
                Thread.sleep(3000); // Wait for 3 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Change values in the model
            person.setName("A");
            person.setCity("B");
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Person {
    private final StringProperty name = new SimpleStringProperty();
    private String city;

    public Person(String name, String city) {
        this.name.set(name);
        this.city = city;
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
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

