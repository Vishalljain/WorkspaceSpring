/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Copy;

/**
 *
 * @author IXL1KOR
 */
import java.util.ArrayList;
import java.util.List;

// Interface representing a generic device
interface Device {
    void displayInfo();
}

// Concrete implementation: Phone
class Phone implements Device {
    private String brand;

    public Phone(String brand) {
        this.brand = brand;
    }

    @Override
    public void displayInfo() {
        System.out.println("Phone - Brand: " + brand);
    }
}

// Concrete implementation: Tablet
class Tablet implements Device {
    private String brand;

    public Tablet(String brand) {
        this.brand = brand;
    }

    @Override
    public void displayInfo() {
        System.out.println("Tablet - Brand: " + brand);
    }
}

public class DeviceProcessor {
    public static void main(String[] args) {
        // Creating a list of Device objects with both Phone and Tablet
        List<Device> devices = new ArrayList<>();
        devices.add(new Phone("Samsung"));
        devices.add(new Tablet("Apple"));

        // Processing Device objects based on their type
        for (Device device : devices) {
            if (device instanceof Phone) {
                // Perform Phone-specific operation
                System.out.println("Performing Phone-specific operation");
                ((Phone) device).displayInfo();
            } else if (device instanceof Tablet) {
                // Perform Tablet-specific operation
                System.out.println("Performing Tablet-specific operation");
                ((Tablet) device).displayInfo();
            }

            // Perform common operation for all devices
            System.out.println("Common operation for all devices");
        }
        
        System.out.println("-------------------------");
        for(Device device : devices){
            device.displayInfo();
        }
    }
}
