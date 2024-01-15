/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProperData;

/**
 *
 * @author IXL1KOR
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private TableView<DataEntity> tableView;
    //private List<DataEntity> dataEntities;
    DataEntity copiedItem;
    private ObservableList<DataEntity> dataEntities = FXCollections.observableArrayList();
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

        Button OverWritingpasteRowButton = new Button("OverWritngPaste Row");
        OverWritingpasteRowButton.setOnAction(e -> OverWritingpasteRow());

        Button pasteRowButton = new Button("Paste Row");
        pasteRowButton.setOnAction(e -> pasteRow());
        
        Button addButton = new Button("Add Row");
        addButton.setOnAction(e -> addRow(tableView));
        
        Button getButton = new Button("Get Info");
        getButton.setOnAction(e -> getInfo(tableView));

        HBox buttonsBox = new HBox(addColumnButton, copyRowButton, pasteRowButton,addButton,getButton);
        VBox vbox = new VBox(tableView, buttonsBox);
        Scene scene = new Scene(vbox, 600, 400);

        stage.setTitle("Extended Table Example");
        stage.setScene(scene);
        stage.show();
    }

    private void initData() {
     //   dataEntities = new ArrayList<>();
        dataEntities.add(new Person("John", "New York", 1, 30,"Doe"));
        dataEntities.add(new Employee("Alice", "San Francisco", 2));
    }

    private void createTableView() {
        tableView = new TableView<>();
        tableView.setEditable(true);

        // Existing columns
        createAndAddColumn("Name", "name");
        createAndAddColumn("City", "city");
        createAndAddColumn("ID", "id");
        createAndAddColumn("Parent Name", "parentsName");
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
                    } else if ("parentsName".equals(property)) {
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
      copiedItem   = tableView.getSelectionModel().getSelectedItem();
    }
//this if for overwriiting
    private void OverWritingpasteRow() {
        if(copiedItem!=null){
            DataEntity selectedItem = tableView.getSelectionModel().getSelectedItem();
            if(selectedItem!=null){
            selectedItem.setCity(copiedItem.getCity());
            selectedItem.setId(copiedItem.getId());
            selectedItem.setName(copiedItem.getName());
            if(selectedItem instanceof Person && copiedItem instanceof Person){
                ((Person)selectedItem).setAge(((Person)copiedItem).getAge());
                ((Person) selectedItem).setParentsName(((Person) copiedItem).getParentsName());
            }
            tableView.refresh(); 
        }
        }
    }
    
    
    private void pasteRow(){
        tableView.getItems().add(copyDataEntity(copiedItem));
        
        
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
   
    private void addRow(TableView<DataEntity> tableView) {
        // Create a default instance (Person or Employee) and add it to the table
        
        DataEntity defaultEntity = new Person("", "", 0, 0, "");
        tableView.getItems().add(defaultEntity);
        
        
    }

    public void getInfo(TableView<DataEntity> tableView1) {
        tableView1.getItems().forEach((t) -> {
            if(t instanceof Person){
                System.out.println(((Person) t).getAge());
                System.out.println(((Person) t).getCity());
                System.out.println(((Person) t).getId());
                System.out.println(((Person) t).getName());
                System.out.println(((Person) t).getParentsName());
                System.out.println("-------------------");
            }else if(t instanceof Employee){
                System.out.println(t.getId());
                System.out.println(t.getName());
                System.out.println(t.getCity());
                System.out.println("-----------------------");
                
            }
        });
        //tableView.getSelectionModel().select(dataEntities.size() +1);
        //tableView.scrollTo(dataEntities.size() - 1);
    }
}

