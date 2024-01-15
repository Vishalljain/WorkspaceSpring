/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FXML1DataController.property;

/**
 *
 * @author IXL1KOR
 */
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Example {
    public static void main(String[] args) {
        StringProperty propertyA = new SimpleStringProperty("Initial Value");
        StringProperty propertyB = new SimpleStringProperty();

        // Bidirectional binding
        propertyA.bindBidirectional(propertyB);

        System.out.println("Before: A=" + propertyA.get() + ", B=" + propertyB.get());

        // Changing propertyA
        propertyA.set("New Value");

        System.out.println("After A set: A=" + propertyA.get() + ", B=" + propertyB.get());

        // Changing propertyB
        propertyB.set("Another Value");

        System.out.println("After B set: A=" + propertyA.get() + ", B=" + propertyB.get());
    }
}
