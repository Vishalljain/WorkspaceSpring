/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author IXL1KOR
 */
public class ThisUnderstanding {

    public ThisUnderstanding() {
    }
    public static void main(String[] args) {
        Employee2 e = new Employee2();
        e.setCity("H");
        e.setCompany("K");
        Test t = new Test(e);
        e.setName("Yurf");
        t.displayInfo(e);
    }

    }
    

    class Test{

    public Test(Employee2 e) {
        displayInfo(e);
    }

    public void displayInfo(Employee2 e) {
        System.out.println(e.getCity()+e.getCompany()+e.getName());
    }
        
    }
    

    class Employee2 {

        String name;
        String city;
        String company;

        public Employee2() {

        }

        public Employee2(String name, String city, String company) {
            this.name = name;
            this.city = city;
            this.company = company;
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

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

    }