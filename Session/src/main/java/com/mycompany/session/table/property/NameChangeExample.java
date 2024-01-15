/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.session.table.property;

/**
 *
 * @author IXL1KOR
 */
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NameChangeExample {

    public static void main(String[] args) {
        // Example with plain String property
        Person person = new Person("John");
        person.setName("Doe");

        // Example with StringProperty
        PersonWithProperty personWithProperty = new PersonWithProperty("Alice");
        personWithProperty.nameProperty().addListener((observable, oldValue, newValue) ->
                System.out.println("StringProperty - Name changed for " + personWithProperty + ": " + oldValue + " -> " + newValue));

        personWithProperty.setName("Eve");
    }

    interface NameChangeObservable {
        void onNameChange(String oldName, String newName);
    }

    public static class Person implements NameChangeObservable {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            String oldName = this.name;//John
            this.name = name;
            System.out.println("String - Name changed for " + this + ": " + oldName + " -> " + name);
            onNameChange(oldName, name);
        }

        @Override
        public void onNameChange(String oldName, String newName) {
            System.out.println("String - Handling name change for " + this + ": Custom logic for plain String");
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "'}";
        }
    }

    public static class PersonWithProperty implements NameChangeObservable {
        private StringProperty name;

        public PersonWithProperty(String name) {
            this.name = new SimpleStringProperty(name);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            String oldName = this.name.get();
            this.name.set(name);
            System.out.println("StringProperty - Name changed for " + this + ": " + oldName + " -> " + name);
            onNameChange(oldName, name);
        }

        public StringProperty nameProperty() {
            return name;
        }

        @Override
        public void onNameChange(String oldName, String newName) {
            System.out.println("StringProperty - Handling name change for " + this + ": Custom logic for StringProperty");
        }

        @Override
        public String toString() {
            return "PersonWithProperty{name='" + name.get() + "'}";
        }
    }
}

