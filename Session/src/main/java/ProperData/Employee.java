/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProperData;

import com.mycompany.session.table.*;

/**
 *
 * @author IXL1KOR
 */
public class Employee implements DataEntity {
    private String name;
    private String city;
    private int id;

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

    public int getId() {
        return id;
    }

    // Constructors, getters, and setters
    public void setId(int id) {
        this.id = id;
    }

    public Employee() {
    }

    public Employee(String name, String city, int id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", id=" + id +
                '}';
    }
    
    
}
