/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import java.lang.reflect.Method;

/**
 *
 * In Java, you can check whether two objects reference the same memory location using the == operator. The == operator compares the memory addresses of the two objects, determining if they refer to the same instance.
 */

public class ObjectComparisonExample {

    public static void main(String[] args) {
        // Creating two instances of a class
        Object obj1 = new Object();
        Object obj2 = new Object();

        // Checking if obj1 and obj2 reference the same memory location
        if (obj1 == obj2) {
            System.out.println("obj1 and obj2 reference the same memory location.");
        } else {
            System.out.println("obj1 and obj2 do not reference the same memory location.");
        }

        // Creating another reference to obj1
        Object obj3 = obj1;

        // Checking if obj1 and obj3 reference the same memory location
        if (obj1 == obj3) {
            System.out.println("obj1 and obj3 reference the same memory location.");
        } else {
            System.out.println("obj1 and obj3 do not reference the same memory location.");
        }
        
        
        Class<DeviceController> aClass = DeviceController.class;
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method str :declaredMethods){
            
        }
    }
}

