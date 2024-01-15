/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peng.PropertyDescriptor;

/**
 *
 * @author IXL1KOR
 */
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class Person {
    private String name;
    private int age;

    public Person() {
    }
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Constructors, getters, and setters...

    public String readValue(String title) {
        try {
            PropertyDescriptor pd = new PropertyDescriptor(title, this.getClass());
            if (null != pd.getReadMethod()) {
                Object value = pd.getReadMethod().invoke(this);
                return (value != null) ? value.toString() : null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person();
        person.setName("John");
        person.setAge(25);
        person.setCity("New York");

        // Use readValue to dynamically read properties
        System.out.println("Name: " + person.readValue("name"));
        System.out.println("Age: " + person.readValue("age"));
        System.out.println("City: " + person.readValue("city"));
        System.out.println("NonexistentProperty: " + person.readValue("NonexistentProperty"));
    }
}

