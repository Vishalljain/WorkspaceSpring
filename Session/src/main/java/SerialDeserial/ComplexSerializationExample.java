/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SerialDeserial;

/**
 *
 * @author IXL1KOR
 */
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;

public class ComplexSerializationExample {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\IXL1KOR\\Documents\\NetBeansProjects\\Session\\src\\main\\java\\SerialDeserial\\persons.xml";

         // Create a list of persons
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 30));
        persons.add(new Person("Alice", 25));
        // Serialize the list of persons to XML
        serializeToXML(persons, filePath);

        // Deserialize the list of persons from XML and print them
        List<Person> deserializedPersons = deserializeFromXML(filePath);
        System.out.println("Deserialized Persons: " + deserializedPersons);
    }

    private static void serializeToXML(List<Person> persons, String filename) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonsWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            PersonsWrapper wrapper = new PersonsWrapper(persons);
            JAXBElement<PersonsWrapper> jaxbElement = new JAXBElement<>(new QName(PersonsWrapper.class.getSimpleName()), PersonsWrapper.class, wrapper);

            marshaller.marshal(jaxbElement, new File(filename));
        } catch (JAXBException e) {
            System.err.println("Error: JAXB exception while writing to file");
            e.printStackTrace();
        }
    }

    private static List<Person> deserializeFromXML(String filename) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonsWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<PersonsWrapper> jaxbElement = (JAXBElement<PersonsWrapper>) unmarshaller.unmarshal(new File(filename));

            return jaxbElement.getValue().getPersons();
        } catch (JAXBException e) {
            System.err.println("Error: JAXB exception while reading from file");
            e.printStackTrace();
            return null;
        }
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    static class PersonsWrapper implements Serializable {
        @XmlElement(name = "person")
        private List<Person> persons;

        public PersonsWrapper() {
            // Default constructor is required for JAXB
        }

        public PersonsWrapper(List<Person> persons) {
            this.persons = persons;
        }

        public List<Person> getPersons() {
            return persons;
        }

        public void setPersons(List<Person> persons) {
            this.persons = persons;
        }
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    static class Person implements Serializable {
        private String name;
        private int age;

        public Person() {
            // Default constructor is required for JAXB
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
