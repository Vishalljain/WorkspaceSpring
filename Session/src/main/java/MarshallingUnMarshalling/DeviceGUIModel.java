/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarshallingUnMarshalling;

/**
 *
 * @author IXL1KOR
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DeviceGUIModel {

    private ObservableList<DeviceData> deviceList = FXCollections.observableArrayList();

    // Getters and setters (you can generate these in your IDE)

    public ObservableList<DeviceData> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(ObservableList<DeviceData> deviceList) {
        this.deviceList = deviceList;
    }
}

