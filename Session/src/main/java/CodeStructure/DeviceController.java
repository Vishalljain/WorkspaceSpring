/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeStructure;

/**
 *
 * @author IXL1KOR
 */
import java.util.ArrayList;
import java.util.List;

// DeviceController class
public class DeviceController {
    private List<IDevice> deviceList;

    public DeviceController() {
        this.deviceList = new ArrayList<>();
    }

    public void addDevice(IDevice device) {
        deviceList.add(device);
    }

    public IDevice getDevice(int index) {
        return deviceList.get(index);
    }

    public static void main(String[] args) {
        DeviceController deviceController = new DeviceController();

        // Adding an Iphone and an Android to the list
        deviceController.addDevice(new Iphone("12 GB", "BLACK COLOR"));
        deviceController.addDevice(new Android("12 GB", "Yellow Color"));

        // Getting the first device
        IDevice firstDevice = deviceController.getDevice(0);
        firstDevice.setColor("Green");

        // Printing information about the first device
        System.out.println("Storage: " + firstDevice.getStorage());
        System.out.println("Color: " + firstDevice.getColor());
        
        
    }
}
