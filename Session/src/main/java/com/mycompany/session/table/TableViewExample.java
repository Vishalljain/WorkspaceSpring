/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.session.table;

/**
 *
 * @author IXL1KOR
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;
import java.util.List;

public class TableViewExample extends Application {

    private TableView<DataEntity> tableView;
    private List<DataEntity> dataEntities;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        initData();
        createTableView();
        Button printButton = new Button("Print All Data");
        printButton.setOnAction(event -> printAllData());

        VBox vbox = new VBox(tableView,printButton);
        Scene scene = new Scene(vbox, 400, 300);

        stage.setTitle("Editable Table Example");
        stage.setScene(scene);
        stage.show();
    }

    private void initData() {
        dataEntities = new ArrayList<>();
        dataEntities.add(new Person("John","India",1,26,"Dsoza"));
        dataEntities.add(new Employee("Alice", "San Francisco", 2));
    }

    private void createTableView() {
        tableView = new TableView<>();
        tableView.setEditable(true);

        TableColumn<DataEntity, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(event -> {
            DataEntity entity = event.getRowValue();
            entity.setName(event.getNewValue());
        });

        TableColumn<DataEntity, String> cityColumn = new TableColumn<>("City");
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        cityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        cityColumn.setOnEditCommit(event -> {
            DataEntity entity = event.getRowValue();
            entity.setCity(event.getNewValue());
        });

        TableColumn<DataEntity, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        idColumn.setOnEditCommit(event -> {
            DataEntity entity = event.getRowValue();
            entity.setId(event.getNewValue());
        });

        // Additional columns for Person properties
        TableColumn<DataEntity, String> parentNameColumn = new TableColumn<>("Parent Name");
        parentNameColumn.setCellValueFactory(new PropertyValueFactory<>("parentsName"));
        parentNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        parentNameColumn.setOnEditCommit(event -> {
            if (event.getRowValue() instanceof Person) {
                ((Person) event.getRowValue()).setParentsName(event.getNewValue());
            }
        });

        TableColumn<DataEntity, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ageColumn.setOnEditCommit(event -> {
            if (event.getRowValue() instanceof Person) {
                ((Person) event.getRowValue()).setAge(event.getNewValue());
            }
        });

        tableView.getColumns().addAll(nameColumn, cityColumn, idColumn, parentNameColumn, ageColumn);
        tableView.sort();
        tableView.getItems().addAll(dataEntities);
      //  dataDisplay();
    }

   private void printAllData() {
        System.out.println("Printing all data:");
        for (DataEntity entity : dataEntities) {
            System.out.println(entity);
        }
    }
}

