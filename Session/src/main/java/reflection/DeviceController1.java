/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reflection;

/**
 *
 * @author IXL1KOR
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DeviceController1 {
    public int loop(int a, int b) {
        return a + b;
    }

    public void main1() {
        System.out.println("Main method");
    }
    
     public void main2() {
        System.out.println("Main2 method");
    }

    public static void main(String[] args) {
        // Create an instance of DeviceController
        DeviceController1 controller = new DeviceController1();

        // Get the Class object for DeviceController
        Class<DeviceController1> aClass = DeviceController1.class;

        // Get all methods declared in DeviceController class
        Method[] declaredMethods = aClass.getDeclaredMethods();

        // Iterate over each method and invoke it
        for (Method method : declaredMethods) {
            try {
                // Check if the method has parameters
                if (method.getParameterCount() == 0 && method.getName()=="main") {
                    // Invoke the method if it has no parameters
                    method.invoke(controller);
                } else if (method.getParameterCount() == 2
                        && method.getParameterTypes()[0] == int.class
                        && method.getParameterTypes()[1] == int.class) {
                    // Invoke the method with parameters if it takes two int parameters
                    int result = (int) method.invoke(controller, 5, 7);
                    System.out.println("Result of " + method.getName() + ": " + result);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

