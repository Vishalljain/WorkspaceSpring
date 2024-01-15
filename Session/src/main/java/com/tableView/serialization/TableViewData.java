/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tableView.serialization;

/**
 *
 * @author IXL1KOR
 */

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class TableViewData extends Application {

    private TableView<DataEntity> tableView;
    private List<DataEntity> dataEntities;
    DataEntity copiedRow;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        initData();
        createTableView();

        Button addColumnButton = new Button("Add Column");
        addColumnButton.setOnAction(e -> addColumn());

        Button copyRowButton = new Button("Copy Row");
        copyRowButton.setOnAction(e -> copyRow());

        Button pasteRowButton = new Button("Paste Row");
        pasteRowButton.setOnAction(e -> pasteRow());

        Button saveToXMLButton = new Button("Save to XML");
        saveToXMLButton.setOnAction(e -> saveToXML());

        Button loadFromXMLButton = new Button("Load from XML");
        loadFromXMLButton.setOnAction(e -> loadFromXML());

        HBox buttonsBox = new HBox(addColumnButton, copyRowButton, pasteRowButton, saveToXMLButton, loadFromXMLButton);
        VBox vbox = new VBox(tableView, buttonsBox);
        Scene scene = new Scene(vbox, 600, 400);

        stage.setTitle("Extended Table Example");
        stage.setScene(scene);
        stage.show();
    }

    private void initData() {
        dataEntities = new ArrayList<>();
        dataEntities.add(new Person("John", "New York", 1, 30, "Doe"));
        dataEntities.add(new Employee("Alice", "San Francisco", 2));
    }

    private void createTableView() {
        tableView = new TableView<>();
        tableView.setEditable(true);

        // Existing columns
        createAndAddColumn("Name", "name");
        createAndAddColumn("City", "city");
        createAndAddColumn("ID", "id");
        createAndAddColumn("Parent Name", "parentName");
        createAndAddColumn("Age", "age");

        tableView.getItems().addAll(dataEntities);
    }

    private void createAndAddColumn(String columnName, String property) {
        TableColumn<DataEntity, ?> column;
        if ("age".equals(property) || "id".equals(property)) {
            // Handle Integer properties
            TableColumn<DataEntity, Integer> intColumn = new TableColumn<>(columnName);
            intColumn.setCellValueFactory(new PropertyValueFactory<>(property));
            intColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            intColumn.setOnEditCommit(event -> {
                DataEntity entity = event.getRowValue();
                if (entity instanceof Person) {
                    if ("id".equals(property)) {
                        ((Person) entity).setId(event.getNewValue());
                    } else if ("age".equals(property)) {
                        ((Person) entity).setAge(event.getNewValue());
                    }
                }
            });
            column = intColumn;
        } else {
            // Handle String properties
            TableColumn<DataEntity, String> stringColumn = new TableColumn<>(columnName);
            stringColumn.setCellValueFactory(new PropertyValueFactory<>(property));
            stringColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            stringColumn.setOnEditCommit(event -> {
                DataEntity entity = event.getRowValue();
                if (entity instanceof Person) {
                    if ("name".equals(property)) {
                        entity.setName(event.getNewValue());
                    } else if ("city".equals(property)) {
                        entity.setCity(event.getNewValue());
                    } else if ("parentName".equals(property)) {
                        ((Person) entity).setParentsName(event.getNewValue());
                    }
                }
            });
            column = stringColumn;
        }

        tableView.getColumns().add(column);
    }

    private void addColumn() {
        // Prompt user for column name and property
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Column");
        dialog.setHeaderText("Enter Column Name and Property");
        dialog.setContentText("Column Name:");
        dialog.showAndWait().ifPresent(columnName -> {
            TextInputDialog propertyDialog = new TextInputDialog();
            propertyDialog.setTitle("Add Column");
            propertyDialog.setHeaderText("Enter Column Property");
            propertyDialog.setContentText("Column Property:");
            propertyDialog.showAndWait().ifPresent(property -> {
                createAndAddColumn(columnName, property);
            });
        });
    }

    private void copyRow() {
        // Store the selected row as the copied row
         copiedRow = tableView.getSelectionModel().getSelectedItem();
    }

    private void pasteRow() {
        // Paste the copied row into the selected row
      tableView.getItems().add(copyDataEntity(copiedRow));
    }
    private DataEntity copyDataEntity(DataEntity original) {
        if (original instanceof Person) {
            return new Person(
                    original.getName(),
                    original.getCity(),
                    original.getId(),
                    ((Person) original).getAge(),
                    ((Person) original).getParentsName()
            );
        } else if (original instanceof Employee) {
            return new Employee(
                    original.getName(),
                    original.getCity() ,
                    original.getId()
            );
        }
        return null;
    }

    private void saveToXML() {
        try {
            JAXBUtil.marshal(dataEntities, "data.xml");
            System.out.println("Data saved to XML successfully.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void loadFromXML() {
        try {
            dataEntities = JAXBUtil.unmarshal("data.xml");
            tableView.getItems().clear();
            tableView.getItems().addAll(dataEntities);
            System.out.println("Data loaded from XML successfully.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
