/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

/**
 *
 * @author IXL1KOR
 */
// Shape.java - Base abstract class
 abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    // Common method for all shapes
    public void displayColor() {
        System.out.println("Shape color: " + color);
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateArea();
}

// Resizable.java - Interface
 interface Resizable {
    void resize(double factor);
}

// Circle.java - Subclass implementing Resizable
 class Circle extends Shape implements Resizable {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // Implementation of abstract method from Shape
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Implementation of the resize method from Resizable
    @Override
    public void resize(double factor) {
        radius *= factor;
    }
}

// Main.java - Testing the classes
public class Main {
    public static void main(String[] args) {
        // Creating a Circle object
        Circle circle = new Circle("Red", 5.0);

        // Displaying color and area before resizing
        circle.displayColor();
        System.out.println("Circle area: " + circle.calculateArea());

        // Resizing the circle
        circle.resize(2.0);

        // Displaying color and area after resizing
        circle.displayColor();
        System.out.println("Resized circle area: " + circle.calculateArea());
    }
}

