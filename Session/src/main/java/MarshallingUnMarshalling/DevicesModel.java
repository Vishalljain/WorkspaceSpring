/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarshallingUnMarshalling;

/**
 *
 * @author IXL1KOR
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "devices")
public class DevicesModel {

    private List<DeviceData> devices;

    // Getters and setters (you can generate these in your IDE)

    @XmlElement(name = "device")
    public List<DeviceData> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceData> devices) {
        this.devices = devices;
    }
}
