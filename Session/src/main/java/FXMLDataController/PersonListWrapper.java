/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FXMLDataController;

/**
 *
 * @author IXL1KOR
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "persons")
public class PersonListWrapper {
    private ObservableList<Person> persons;

    public PersonListWrapper() {
        this(FXCollections.observableArrayList());
    }

    public PersonListWrapper(List<Person> persons) {
        this.persons = FXCollections.observableArrayList(persons);
    }

    @XmlElement(name = "person")
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = FXCollections.observableArrayList(persons);
    }
}

