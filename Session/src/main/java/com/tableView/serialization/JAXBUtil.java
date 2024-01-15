/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tableView.serialization;

/**
 *
 * @author IXL1KOR
 */
import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBUtil {

    public static void marshal(List<DataEntity> entities, String fileName) throws JAXBException {
        File file = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(DataEntityListWrapper.class, Person.class, Employee.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        DataEntityListWrapper wrapper = new DataEntityListWrapper();
        

        marshaller.marshal(wrapper, file);
    }

    public static List<DataEntity> unmarshal(String fileName) throws JAXBException {
        File file = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(DataEntityListWrapper.class, Person.class, Employee.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        
        //return (DataEntityListWrapper) unmarshaller.unmarshal(file);
        return null;
    }
}
