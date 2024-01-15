/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tableView.serialization;

/**
 *
 * @author IXL1KOR
 */

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public interface DataEntity {
    String getName();

    void setName(String name);

    String getCity();

    void setCity(String city);

    int getId();

    void setId(int id);
}


