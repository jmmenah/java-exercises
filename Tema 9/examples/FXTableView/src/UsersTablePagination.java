/*
 * Based on Tim Büthe code
 * https://gist.github.com/timbuethe/7becdc4556225e7c5b7b
 *
 * users.csv test data from https://mockaroo.com/
 */

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersTablePagination extends Application {

    private final static int dataSize = 1000;
    private final static int rowsPerPage = 100;

    private final TableView<User> table = createTable();
    private final List<User> data = createData();

    private List<User> createData() {
        List<User> list = new ArrayList<>(dataSize);

        Scanner input = new Scanner(TableViewCSV.class.getResourceAsStream("users.csv"));
        // skip header, first csv line
        String line;
        input.nextLine();

        while (input.hasNext()) {
            line = input.nextLine();
            String[] data = line.split(",");
            // csv file: id,first_name,last_name,email,gender,ip_address
            Gender g = Gender.NO_GENDER;
            if(data[4].equalsIgnoreCase("Male")) g = Gender.MALE;
            else if(data[4].equalsIgnoreCase("Female")) g = Gender.FEMALE;

            list.add( new User(Integer.parseInt(data[0]), data[1], data[2], data[3], g, data[5]));
        }
        input.close();

        return list;
    }

    private TableView<User> createTable() {

        TableView<User> table = new TableView<>();

        TableColumn<User, Integer> columnId = new TableColumn<>("Id");
        columnId.setCellValueFactory(param -> param.getValue().id);

        TableColumn<User, String> columnFirstName = new TableColumn<>("First Name");
        columnFirstName.setCellValueFactory(param -> param.getValue().firstName);
        columnFirstName.setPrefWidth(100);

        TableColumn<User, String> columnLastName = new TableColumn<>("Last Name");
        columnLastName.setCellValueFactory(param -> param.getValue().lastName);
        columnLastName.setPrefWidth(150);

        TableColumn<User, String> columnEmail = new TableColumn<>("email");
        columnEmail.setCellValueFactory(param -> param.getValue().email);
        columnEmail.setPrefWidth(250);

        TableColumn<User, Gender> columnGender = new TableColumn<>("Gender");
        columnGender.setCellValueFactory(param -> param.getValue().gender);
        columnGender.setPrefWidth(70);

        TableColumn<User, String> columnIp = new TableColumn<>("IP");
        columnIp.setCellValueFactory(param -> param.getValue().ip);
        columnIp.setPrefWidth(150);

        table.getColumns().addAll(columnId, columnFirstName, columnLastName, columnEmail,columnGender, columnIp);

        return table;
    }

    private Node createPage(int pageIndex) {

        int fromIndex = pageIndex * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage, data.size());
        table.setItems(FXCollections.observableArrayList(data.subList(fromIndex, toIndex)));

        return new BorderPane(table);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        Pagination pagination = new Pagination((data.size() / rowsPerPage ), 0);
        pagination.setPageFactory(this::createPage);

        Scene scene = new Scene(new BorderPane(pagination), 1024, 768);
        stage.setScene(scene);
        stage.setTitle("Users Table Pagination");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class User {

        private final ObservableValue<Integer> id;
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final ObservableValue<Gender> gender;
        private final SimpleStringProperty ip;


        private User(int id, String firstName, String lastName, String email, Gender gender, String ip) {
            this.id = new SimpleObjectProperty<>(id);
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.email = new SimpleStringProperty(email);
            this.gender = new SimpleObjectProperty<>(gender);
            this.ip = new SimpleStringProperty(ip);
        }
    }

    public enum Gender {
        MALE, FEMALE, NO_GENDER
    }

}