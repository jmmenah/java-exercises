package com.zetcode.controls1.e15;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * Basic JavaFX controls: http://zetcode.com/gui/javafx/controls/
 * JavaFX CheckBox
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CheckBoxEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new HBox();
        root.setPadding(new Insets(10, 0, 0, 10));

        var cbox = new CheckBox("Show title");
        cbox.setSelected(true);

        cbox.setOnAction((ActionEvent event) -> {
            if (cbox.isSelected()) {
                stage.setTitle("CheckBox");
            } else {
                stage.setTitle("");
            }
        });

        root.getChildren().add(cbox);

        var scene = new Scene(root, 300, 200);

        stage.setTitle("CheckBox");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
