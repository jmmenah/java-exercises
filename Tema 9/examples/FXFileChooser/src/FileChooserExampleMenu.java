/*
 * JavaFX – FileChooserExampleMenu
 * Similar to FileChooserExampleMenuSwing
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileChooserExampleMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX File Chooser Example");

        TextArea textArea = new TextArea("No open file yet");

        Label statusLabel = new Label("File name");

        MenuBar menuBar = getMenuBar(stage, textArea, statusLabel);
        /*
        for (int i = 0; i < menuBar.getMenus().size(); i++) {
            Menu m = menuBar.getMenus().get(i);
            System.out.println(m.getText());
            for (int j = 0; j < m.getItems().size(); j++) {
                System.out.println(m.getItems().get(j).getText());
            }
        }
        */
        BorderPane pane = new BorderPane();

        pane.setTop(menuBar);
        pane.setCenter(textArea);
        pane.setBottom(statusLabel);

        Scene scene = new Scene(pane, 400, 500);
        stage.setScene(scene);
        stage.setX(200);
        stage.setY(200);
        stage.setResizable(false);
        stage.show();

    }

    private MenuBar getMenuBar(Stage stage, TextArea textArea, Label statusLabel) {
        var fileMenu = new Menu("_File");
        var editMenu = new Menu("_Edit");
        var helpMenu = new Menu("_Help");

        var openMenuItem = new MenuItem("_Open");
        var saveMenuItem = new MenuItem("_Save");
        var exitMenuItem = new MenuItem("E_xit");

        openMenuItem.setGraphic(new ImageView("/open.png"));
        saveMenuItem.setGraphic(new ImageView("/save.png"));
        exitMenuItem.setGraphic(new ImageView("/exit.png"));

        fileMenu.getItems().addAll(openMenuItem, saveMenuItem, new SeparatorMenuItem(), exitMenuItem);

        var cutMenuItem = new MenuItem("Cut");
        var copyMenuItem = new MenuItem("Copy");
        var pasteMenuItem = new MenuItem("Paste");
        var selectAllMenuItem = new MenuItem("Select All");

        exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+W"));
        cutMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        copyMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        pasteMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));
        selectAllMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));

        editMenu.getItems().addAll(cutMenuItem, copyMenuItem, pasteMenuItem, selectAllMenuItem);

        // MenuItem Events
        openMenuItem.setOnAction(e -> openFile(stage, textArea, statusLabel));
        saveMenuItem.setOnAction(e -> saveFile(stage, textArea, statusLabel));
        exitMenuItem.setOnAction(e -> Platform.exit());

        cutMenuItem.setOnAction(e -> textArea.cut());
        copyMenuItem.setOnAction(e -> textArea.copy());
        pasteMenuItem.setOnAction(e -> textArea.paste());
        selectAllMenuItem.setOnAction(e -> textArea.selectAll());

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        return menuBar;
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
