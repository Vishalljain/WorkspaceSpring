/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author IXL1KOR
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Idevice {
    void turnOn();
    void turnOff();
    void displayDetails();
}

class Mobile {
    private String modelName;

    public Mobile(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }
}

class Iphone implements Idevice {
    private int batteryLife;
    private int RAM;
    private Mobile mobile;

    public Iphone(int batteryLife, int RAM, Mobile mobile) {
        this.batteryLife = batteryLife;
        this.RAM = RAM;
        this.mobile = mobile;
    }

    @Override
    public void turnOn() {
        System.out.println(mobile.getModelName() + " is turning on.");
    }

    @Override
    public void turnOff() {
        System.out.println(mobile.getModelName() + " is turning off.");
    }

    @Override
    public void displayDetails() {
        System.out.println("Details for " + mobile.getModelName() + ":");
        System.out.println("Battery Life: " + batteryLife + " hours");
        System.out.println("RAM: " + RAM + " GB");
    }
}

class Android implements Idevice {
    private int batteryLife;
    private int RAM;
    private List<Mobile> supportedMobiles;

    public Android(int batteryLife, int RAM, List<Mobile> supportedMobiles) {
        this.batteryLife = batteryLife;
        this.RAM = RAM;
        this.supportedMobiles = supportedMobiles;
    }

    @Override
    public void turnOn() {
        System.out.println("Android device is turning on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Android device is turning off.");
    }

    @Override
    public void displayDetails() {
        System.out.println("Details for Android device:");
        System.out.println("Battery Life: " + batteryLife + " hours");
        System.out.println("RAM: " + RAM + " GB");
        System.out.println("Supported Mobiles:");
        for (Mobile mobile : supportedMobiles) {
            System.out.println("- " + mobile.getModelName());
        }
    }
}

public class DeviceController {

    private static void loopData() {
        System.out.println("data");
    }
    private List<Idevice> deviceList;

    public DeviceController() {
        // Initialize the list and add instances of Iphone and Android
        deviceList = new ArrayList<>();
        
        List<Mobile> iphoneModels = Arrays.asList(new Mobile("Iphone 13"), new Mobile("Iphone 14"));
        Idevice iphone = new Iphone(10, 8, iphoneModels.get(0));
        
        List<Mobile> androidModels = Arrays.asList(new Mobile("Oppo"), new Mobile("Samsung"));
        Idevice android = new Android(12, 6, androidModels);

        deviceList.add(iphone);
        deviceList.add(android);

        // Access the elements from the list and call methods
        for (Idevice idevice : deviceList) {
            idevice.turnOn();
            idevice.displayDetails();
            idevice.turnOff();
            System.out.println("------------");
        }
    }

    public static void main(String[] args) {
        // Create an instance of DeviceController
        DeviceController controller = new DeviceController();
        loopData();
    }
}
