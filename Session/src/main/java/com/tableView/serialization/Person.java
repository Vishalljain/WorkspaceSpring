/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tableView.serialization;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IXL1KOR
 */
@XmlRootElement(name = "person")
public class Person implements DataEntity {
    private String name;
    private String city;
    private int id;
    private int age;
    private String parentsName;

    public Person(String name, String city, int id, int age, String parentsName) {
        this.name = name;
        this.city = city;
        this.id = id;
        this.age = age;
        this.parentsName = parentsName;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getParentsName() {
        return parentsName;
    }

    public void setParentsName(String parentsName) {
        this.parentsName = parentsName;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", city=" + city + ", id=" + id + ", age=" + age + ", parentsName=" + parentsName + '}';
    }

}
