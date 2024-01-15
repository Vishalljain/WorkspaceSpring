/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarshallingUnMarshalling;

/**
 *
 * @author IXL1KOR
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class DeviceController {

    @FXML
    private ComboBox<String> MobileColorOne;

    @FXML
    private ComboBox<String> MobileColorTwo;

    @FXML
    private ComboBox<String> MobileColorThree;

    @FXML
    private ComboBox<String> MobileColorFour;

    @FXML
    private ComboBox<String> MobileModelOne;

    @FXML
    private ComboBox<String> MobileModelTwo;
    
    @FXML
    private ComboBox<String> MobileModelThree;

    @FXML
    private ComboBox<String> MobileModelFour;

    @FXML
    private Button loadButton;

    @FXML
    private Button saveButton;

    private DeviceGUIModel guiModel;
    
    private String xmlPath="C:\\Users\\IXL1KOR\\Desktop\\xsd\\device.xml";
    private String schemaPath = "C:\\Users\\IXL1KOR\\Desktop\\xsd\\device.xsd";

    public void initialize() throws InvalidConfigurationException, FileNotFoundException {
        guiModel = new DeviceGUIModel();
        initComboBoxes();
        loadDevicesFromFile();
        
    }

    private void initComboBoxes() {
        // Add some default values to the ComboBoxes
        MobileColorOne.getItems().addAll("Color1-A", "Color1-B", "Color1-C", "Color1-D");
        MobileColorTwo.getItems().addAll("Color2-A", "Color2-B", "Color2-C", "Color2-D");
        MobileColorThree.getItems().addAll("Color3-A", "Color3-B", "Color3-C", "Color3-D");
        MobileColorFour.getItems().addAll("Color4-A", "Color4-B", "Color4-C", "Color4-D");

        MobileModelOne.getItems().addAll("Model1-A", "Model1-B", "Model1-C", "Model1-D");
        MobileModelTwo.getItems().addAll("Model2-A", "Model2-B", "Model2-C", "Model2-D");
        MobileModelThree.getItems().addAll("Model3-A", "Model3-B", "Model3-C", "Model3-D");
        MobileModelFour.getItems().addAll("Model4-A", "Model4-B", "Model4-C", "Model4-D");

    }

    private void loadDevicesFromFile() throws InvalidConfigurationException, FileNotFoundException {
        // Load data from file when the stage is created
        boolean validateXmlAgainstSchema = validateXmlAgainstSchema(xmlPath,schemaPath);
        if(validateXmlAgainstSchema){
            try {
                JAXBContext context = JAXBContext.newInstance(DevicesModel.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();

                DevicesModel devicesModel = (DevicesModel) unmarshaller.unmarshal(new FileInputStream(xmlPath));
                List<DeviceData> devices = devicesModel.getDevices();

                // Update ComboBoxes with loaded data
                for (DeviceData device : devices) {
                    MobileColorOne.valueProperty().setValue(device.getColor1());
                    MobileColorTwo.valueProperty().setValue(device.getColor2());
                    MobileColorThree.valueProperty().setValue(device.getColor3());
                    MobileColorFour.valueProperty().setValue(device.getColor4());

                    MobileModelOne.valueProperty().setValue(device.getModel1());
                    MobileModelTwo.valueProperty().setValue(device.getModel2());
                    MobileModelThree.valueProperty().setValue(device.getModel3());
                    MobileModelFour.valueProperty().setValue(device.getModel4());
                }
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    
        else{
            throw new InvalidConfigurationException("Configuration validation against Schema Failed!");
        }
    }

    @FXML
    private void handleSaveButton() throws FileNotFoundException {
        
        // Get selected values from ComboBoxes
        String selectedColor1 = MobileColorOne.getValue();
        String selectedColor2 = MobileColorTwo.getValue();
        String selectedColor3 = MobileColorThree.getValue();
        String selectedColor4 = MobileColorFour.getValue();

        String selectedModel1 = MobileModelOne.getValue();
        String selectedModel2 = MobileModelTwo.getValue();
        String selectedModel3 = MobileModelThree.getValue();
        String selectedModel4 = MobileModelFour.getValue();

        // Create a new DeviceData instance with selected values
        DeviceData newDevice = new DeviceData();
        newDevice.setColor1(selectedColor1);
        newDevice.setColor2(selectedColor2);
        newDevice.setColor3(selectedColor3);
        newDevice.setColor4(selectedColor4);

        newDevice.setModel1(selectedModel1);
        newDevice.setModel2(selectedModel2);
        newDevice.setModel3(selectedModel3);
        newDevice.setModel4(selectedModel4);
        

        // Add the new device to the GUI model
      //  List<DeviceData> list = new ArrayList();
       // list.add(newDevice);
        guiModel.getDeviceList().add(newDevice);
            try {
                JAXBContext context = JAXBContext.newInstance(DevicesModel.class);
                Marshaller marshaller = context.createMarshaller();

                DevicesModel devicesModel = new DevicesModel();
                devicesModel.setDevices(guiModel.getDeviceList());
               // devicesModel.setDevices(list);

                // Marshal the devicesModel to the file
                marshaller.marshal(devicesModel, new FileOutputStream(xmlPath));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
       // }
    }
    
     public static boolean validateXmlAgainstSchema(String validateXmlFile, String schemaFile) {

        boolean validXml = true;
        try {
            //Adding Schema Factory
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(schemaFile));

            //Validation
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File(validateXmlFile)));
        } catch (SAXException | IOException exception) {
            //Handled internally and the exception is not logged
            validXml = false;
        }

        return validXml;
    }

}

