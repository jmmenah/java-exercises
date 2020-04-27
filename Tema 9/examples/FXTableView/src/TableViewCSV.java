/* Based on
 * http://tutorials.jenkov.com/javafx/tableview.html
 * users.csv test data from https://mockaroo.com/
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;

public class TableViewCSV extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TableView tableView = new TableView();

        TableColumn<String, Person> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));


        TableColumn<String, Person> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        // tableView.getItems().add(new Person("John", "Doe"));
        // tableView.getItems().add(new Person("Jane", "Deer"));


        Scanner input = new Scanner(TableViewCSV.class.getResourceAsStream("users.csv"));
        // skip header, first csv line
        String line = input.nextLine();

        while (input.hasNext()) {
            line = input.nextLine();
            String[] data = line.split(",");
            // csv file: id,first_name,last_name,email,gender,ip_address
            tableView.getItems().add(new Person(data[1], data[2]));
        }
        input.close();


        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }


}
