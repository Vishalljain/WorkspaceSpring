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

class DeviceController11 {
    public int loop(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // Create an instance of DeviceController
        DeviceController11 controller = new DeviceController11();

        // Get the Class object for DeviceController
        Class<DeviceController11> aClass = DeviceController11.class;

        // Get the Method object for the loop method with two int parameters
        Method loopMethod = aClass.getDeclaredMethod("loop", int.class, int.class);

        // Prepare the arguments for the method
        int arg1 = 5;
        int arg2 = 7;

        // Invoke the method using reflection
        try {
            // If the method is non-static, you need an instance to invoke it on
            int result = (int) loopMethod.invoke(controller, arg1, arg2);
            System.out.println("Result of loop method: " + result);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
