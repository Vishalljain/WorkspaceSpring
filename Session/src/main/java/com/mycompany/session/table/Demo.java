/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.session.table;

/**
 *
 * @author IXL1KOR
 */
public class Demo {
    
    /*
    
    1)Column Creation:
    TableColumn<DataEntity, String> nameColumn = new TableColumn<>("Name");
    This line creates a TableColumn named nameColumn that will display data of type String and has the column header "Name".
    The <DataEntity, String> in TableColumn<DataEntity, String> represents the types of data that the TableColumn will work with. Let's break it down:

DataEntity (First Parameter):

DataEntity is the type of the elements in your data model, in this case, the type of objects that your table is going to display in each row.
In your example, DataEntity is an interface or a base class that Person and Employee implement. It provides a common structure for objects that can be displayed in the table.
String (Second Parameter):

String is the type of data that the TableColumn will display or edit. It specifies the type of the property in the DataEntity that this column will work with.
In this specific example, it indicates that the "Name" column is going to display and edit values of type String.

2)Cell Value Factory:

nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
This line sets up the cell value factory for the column. It tells the table how to retrieve values for this column from your data model (DataEntity). It uses the name property of the DataEntity class.    
    
 3)Cell Factory for Editing:

nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
This line sets the cell factory for the column. It specifies that a TextFieldTableCell should be used for editing. This means that when you click on a cell in this column, it will be replaced with a text field for editing.

4)On Edit Commit Action:


nameColumn.setOnEditCommit(event -> {
    DataEntity entity = event.getRowValue();
    entity.setName(event.getNewValue());
});
This line sets an event handler for when a cell in the column is edited and committed. When a cell is edited, this event handler is called.
It retrieves the DataEntity associated with the edited row using event.getRowValue().
It sets the new value from the edited cell to the name property of the entity using entity.setName(event.getNewValue()).
    
    
    
    
    */
    
}
