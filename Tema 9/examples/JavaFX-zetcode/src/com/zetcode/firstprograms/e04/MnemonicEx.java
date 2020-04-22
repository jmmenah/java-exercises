package com.zetcode.firstprograms.e04;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX first programs: http://zetcode.com/gui/javafx/firstprograms/
 * JavaFX mnemonics
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MnemonicEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new HBox();
        root.setPadding(new Insets(20));

        var btn = new Button("_Button");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Button fired");
        });

        root.getChildren().add(btn);

        var scene = new Scene(root, 300, 250);

        stage.setTitle("Mnemonic");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
