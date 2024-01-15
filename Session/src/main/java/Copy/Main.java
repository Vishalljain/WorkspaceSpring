/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Copy;

/**
 *
 * @author IXL1KOR
 */
// DataEntity.java
 abstract class DataEntity {
    private String name;
    private String city;
    private int id;

    public DataEntity(String name, String city, int id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    public abstract DataEntity copy();
}

// Person.java
 class Person extends DataEntity {
    private int age;
    private String parentsName;

    public void setAge(int age) {
        this.age = age;
    }

    public void setParentsName(String parentsName) {
        this.parentsName = parentsName;
    }

    public Person(String name, String city, int id, int age, String parentsName) {
        super(name, city, id);
        this.age = age;
        this.parentsName = parentsName;
    }

    public int getAge() {
        return age;
    }

    public String getParentsName() {
        return parentsName;
    }

    // Copy constructor for Person
    public Person(Person original) {
        super(original.getName(), original.getCity(), original.getId());
        this.age = original.getAge();
        this.parentsName = original.getParentsName();
    }

    @Override
    public DataEntity copy() {
        //return this;
        return new Person(this);
    }
}

// Employee.java
 class Employee extends DataEntity {
    public Employee(String name, String city, int id) {
        super(name, city, id);
    }

    // Copy constructor for Employee
    public Employee(Employee original) {
        super(original.getName(), original.getCity(), original.getId());
    }

    @Override
    public DataEntity copy() {
        return new Employee(this);
        
    }
}

// DataEntityFactory.java
 class DataEntityFactory {
    public static DataEntity copyDataEntity(DataEntity original) {
        return original.copy();
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Person originalPerson = new Person("John", "City1", 1, 25, "John's Parents");
        Employee originalEmployee = new Employee("Alice", "City2", 2);

        // Copy entities
        DataEntity copiedPerson = DataEntityFactory.copyDataEntity(originalPerson);
        DataEntity copiedEmployee = DataEntityFactory.copyDataEntity(originalEmployee);
        originalPerson.setAge(100);

        // Print original and copied data
        System.out.println("Original Person: " + originalPerson.getName() + ", " + originalPerson.getAge());
        System.out.println("Copied Person: " + copiedPerson.getName() + ", " + ((Person) copiedPerson).getAge());

        System.out.println("Original Employee: " + originalEmployee.getName());
        System.out.println("Copied Employee: " + copiedEmployee.getName());
    }
}

