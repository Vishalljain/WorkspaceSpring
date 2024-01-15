/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FXML1DataController;

/**
 *
 * @author IXL1KOR
 */

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import java.io.File;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class PersonListController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, Number> ageColumn;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
        // Initialize the table columns
       nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
    }

   public void loadDataFromXML() {
    try {
        // Load data from XML file
        File file = new File("C:\\Users\\IXL1KOR\\Documents\\vishal Docs\\data.xml");
        if (file.exists()) {
            JAXBContext context = JAXBContext.newInstance(PersonListWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PersonListWrapper wrapper = (PersonListWrapper) unmarshaller.unmarshal(file);
            personTable.getItems().addAll(wrapper.getPersons());
        }
    } catch (JAXBException e) {
        e.printStackTrace();
    }
}


    public void saveDataToFXML() {
        // Save data to FXML file
        File file = new File("C:\\Users\\IXL1KOR\\Documents\\vishal Docs\\data.xml");
        PersonListWrapper wrapper = new PersonListWrapper(personTable.getItems());
        JAXB.marshal(wrapper, file);
    }
}

