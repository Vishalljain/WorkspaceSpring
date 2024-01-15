public class ComplexExample1 {

    public static void main(String[] args) {
        Employee1 employee = new Employee1();
        employee.setName("John Doe");
        employee.setAge(30);

        // Creating a copy of the Employee instance
        Employee1 employeeCopy = new Employee1();
        employeeCopy.setName(employee.getName());
        employeeCopy.setAge(employee.getAge());

        // Creating an ObjectWrapper and passing the copied Employee instance
        ObjectWrapper1 objectWrapper = new ObjectWrapper1(employeeCopy);

        // Modifying the original Employee instance
        employee.setDepartment("IT");

        // Accessing the Employee instance from ObjectWrapper
        Employee1 retrievedEmployee = objectWrapper.getEmployee();

        // Printing details
        System.out.println("Original Employee: " + employee);
        System.out.println("Retrieved Employee from ObjectWrapper: " + retrievedEmployee);
    }
}

class Employee1 {
    private String name;
    private int age;
    private String department;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee1() {
    }

    

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}

class ObjectWrapper1 {
    private Employee1 wrappedEmployee;

    public ObjectWrapper1(Employee1 wrappedEmployee) {
        this.wrappedEmployee = wrappedEmployee;
    }

    public Employee1 getEmployee() {
        return wrappedEmployee;
    }
}
