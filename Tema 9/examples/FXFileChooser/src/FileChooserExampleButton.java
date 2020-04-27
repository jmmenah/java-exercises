/*
 * JavaFX – FileChooserExampleButton
 * Similar to FileChooserExampleButtonSwing
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileChooserExampleButton extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)  {
        stage.setTitle("JavaFX File Chooser Example");

        TextArea textArea = new TextArea("No open file yet");
        Button openButton = new Button("Open file");
        Button saveButton = new Button("Save file");
        Label statusLabel = new Label("File name");

        // ScrollPane scrollPane = new ScrollPane(textArea);

        // Button Events
        openButton.setOnAction(e -> openFile(stage, textArea, statusLabel));

        saveButton.setOnAction(e -> saveFile(stage, textArea, statusLabel));

        openButton.setPrefWidth(200);
        saveButton.setPrefWidth(200);

        HBox hbox = new HBox(openButton, saveButton);
        hbox.setAlignment(Pos.TOP_CENTER);

        BorderPane pane = new BorderPane();

        pane.setTop(hbox);
        pane.setCenter(textArea);
        pane.setBottom(statusLabel);

        Scene scene = new Scene(pane, 400, 500);
        stage.setScene(scene);
        stage.setX(200);
        stage.setY(200);
        stage.setResizable(false);
        stage.show();
    }

    private void openFile(Stage stage, TextArea textArea, Label statusLabel) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a text file");
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("*.txt", "*.txt");
        FileChooser.ExtensionFilter htmlFilter = new FileChooser.ExtensionFilter("*.htm, *.html", "*.htm", "*.html");

        fileChooser.getExtensionFilters().add(txtFilter);
        fileChooser.getExtensionFilters().add(htmlFilter);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Markdown *.md", "*.md"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        String str = "";
        String txt = "";
        if (selectedFile == null) str = "File selection cancelled!";
        else {
            try {
                str = selectedFile.getAbsolutePath();
                txt = new String(Files.readAllBytes(Paths.get(str)));
            } catch (IOException ex) {
                str = "No file selected";
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ex.getMessage());
                alert.show();
            }
        }
        statusLabel.setText(str);
        textArea.setText(txt);
    }

    private void saveFile(Stage stage, TextArea textArea, Label statusLabel) {
        String str = "";
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Saving a text file");
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("*.txt", "*.txt");
        fileChooser.getExtensionFilters().add(txtFilter);

        File selectedFile = fileChooser.showSaveDialog(stage);
        if (selectedFile == null) str = "File saving cancelled!";
        else {
            try {
                FileWriter save = new FileWriter(selectedFile + ".txt");
                save.write(textArea.getText());
                save.close();
                str = selectedFile.getAbsolutePath() + ".txt";
            } catch (IOException ex) {
                str = "No file saved";
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ex.getMessage());
                alert.show();
            }
        }
        statusLabel.setText(str);
    }

}
