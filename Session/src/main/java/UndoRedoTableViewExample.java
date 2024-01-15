import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;
import javafx.collections.ListChangeListener;

public class UndoRedoTableViewExample extends Application {

    private TableView<Person> tableView;
    private Stack<ObservableList<Person>> undoStack;
    private Stack<ObservableList<Person>> redoStack;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        tableView = createTableView();
        undoStack = new Stack<>();
        redoStack = new Stack<>();

        VBox root = new VBox(tableView);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Undo Redo TableView Example");
        primaryStage.show();
    }

    private TableView<Person> createTableView() {
        TableView<Person> tableView = new TableView<>();
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");

        firstNameCol.setCellValueFactory(data -> data.getValue().firstNameProperty());
        lastNameCol.setCellValueFactory(data -> data.getValue().lastNameProperty());

        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getColumns().addAll(firstNameCol, lastNameCol);

        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("John", "Doe"),
                new Person("Jane", "Smith"),
                new Person("Bob", "Johnson")
        );

        tableView.setItems(data);

        tableView.setEditable(true);

        // Add change listener for undo/redo
       // Add change listener for undo/redo
tableView.getItems().addListener((ListChangeListener.Change<? extends Person> change) -> {
    while (change.next()) {
        if (change.wasUpdated() || change.wasAdded() || change.wasRemoved()) {
            undoStack.push(FXCollections.observableArrayList(change.getRemoved()));
            redoStack.clear();
        }
    }
});

        return tableView;
    }

    private static class Person {
        private final StringProperty firstName;
        private final StringProperty lastName;

        public Person(String firstName, String lastName) {
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
        }

        public StringProperty firstNameProperty() {
            return firstName;
        }

        public StringProperty lastNameProperty() {
            return lastName;
        }
    }

    
}
