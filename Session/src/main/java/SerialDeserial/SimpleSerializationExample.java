package SerialDeserial; 

import javax.xml.bind.*;
import java.io.File;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

public class SimpleSerializationExample {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\IXL1KOR\\Documents\\NetBeansProjects\\Session\\src\\main\\java\\SerialDeserial\\person.xml";

        // Create a person object
        Person person = new Person("John", 30);

        // Serialize the person to XML
        serializeToXML(person, filePath);

        // Deserialize the person from XML and print it
        Person deserializedPerson = deserializeFromXML(filePath);
        System.out.println("Deserialized Person: " + deserializedPerson);
    }

    private static void serializeToXML(Object object, String filename) {
        try {
            javax.xml.bind.JAXBContext jaxbContext = javax.xml.bind.JAXBContext.newInstance(object.getClass());
            javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);

            if (object instanceof Person) {
                marshaller.marshal(object, new java.io.File(filename));
            } else {
                marshaller.marshal(object, new java.io.File(filename));
            }
        } catch (javax.xml.bind.JAXBException e) {
            System.err.println("Error: JAXB exception while writing to file");
            e.printStackTrace();
        }
    }

    private static Person deserializeFromXML(String filename) {
        try {
            javax.xml.bind.JAXBContext jaxbContext = javax.xml.bind.JAXBContext.newInstance(Person.class);
            javax.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Person) unmarshaller.unmarshal(new java.io.File(filename));
        } catch (javax.xml.bind.JAXBException e) {
            System.err.println("Error: JAXB exception while reading from file");
            e.printStackTrace();
            return null;
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
