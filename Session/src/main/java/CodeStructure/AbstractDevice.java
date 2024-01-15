/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeStructure;

/**
 *
 * @author IXL1KOR
 */
// AbstractDevice class implementing IDevice
public abstract class AbstractDevice implements IDevice {
    private String storage;
    private String color;

    @Override
    public void setStorage(String storage) {
        this.storage = storage;
    }
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public AbstractDevice(String storage, String color) {
        this.storage = storage;
        this.color = color;
    }

    @Override
    public String getStorage() {
        return storage;
    }

    @Override
    public String getColor() {
        return color;
    }
}

