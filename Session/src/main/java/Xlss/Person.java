/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Xlss;

/**
 *
 * @author IXL1KOR
 */
public class Person {
    private String personName;
    private String personCompany;
    private String personCity;
    private int personId;

     public Person() {
     
     }
    
    public Person(String personName, String personCompany, String personCity, int personId) {
        this.personName = personName;
        this.personCompany = personCompany;
        this.personCity = personCity;
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonCompany() {
        return personCompany;
    }

    public void setPersonCompany(String personCompany) {
        this.personCompany = personCompany;
    }

    public String getPersonCity() {
        return personCity;
    }

    public void setPersonCity(String personCity) {
        this.personCity = personCity;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
    
    @Override
    public String toString() {
        return "Person{" + "personName=" + personName + ", personCompany=" + personCompany + ", personCity=" + personCity + ", personId=" + personId + '}';
    }
    
}
