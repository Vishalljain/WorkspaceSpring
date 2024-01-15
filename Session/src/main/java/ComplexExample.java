public class ComplexExample {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setAge(30);

        // Creating an ObjectWrapper and passing the Employee instance
        ObjectWrapper objectWrapper = new ObjectWrapper(employee);

        // Modifying the Employee instance after passing it to ObjectWrapper
        employee.setDepartment("IT");

        // Accessing the Employee instance from ObjectWrapper
        Employee retrievedEmployee = objectWrapper.getEmployee();

        // Printing details
        System.out.println("Original Employee: " + employee);
        System.out.println("Retrieved Employee from ObjectWrapper: " + retrievedEmployee);
    }
}

class Employee {
    private String name;
    private int age;
    private String department;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}

class ObjectWrapper {
    private Employee wrappedEmployee;

    public ObjectWrapper(Employee wrappedEmployee) {
        this.wrappedEmployee = wrappedEmployee;
    }

    public Employee getEmployee() {
        return wrappedEmployee;
    }
}
