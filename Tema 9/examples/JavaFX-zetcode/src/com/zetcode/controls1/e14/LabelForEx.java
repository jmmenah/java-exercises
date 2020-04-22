package com.zetcode.controls1.e14;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * Basic JavaFX controls: http://zetcode.com/gui/javafx/controls/
 * The labelFor property
 */
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LabelForEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new GridPane();
        root.setVgap(10);
        root.setHgap(5);
        root.setPadding(new Insets(10));

        var lbl1 = new Label("_Name:");
        var lbl2 = new Label("_Address:");
        var lbl3 = new Label("_Occupation:");

        var field1 = new TextField();
        var field2 = new TextField();
        var field3 = new TextField();

        lbl1.setLabelFor(field1);
        lbl1.setMnemonicParsing(true);
        lbl2.setLabelFor(field2);
        lbl2.setMnemonicParsing(true);
        lbl3.setLabelFor(field3);
        lbl3.setMnemonicParsing(true);

        root.add(lbl1, 0, 0);
        root.add(field1, 2, 0);
        root.add(lbl2, 0, 1);
        root.add(field2, 2, 1);
        root.add(lbl3, 0, 2);
        root.add(field3, 2, 2);

        GridPane.setHalignment(lbl1, HPos.RIGHT);
        GridPane.setHalignment(lbl2, HPos.RIGHT);
        GridPane.setHalignment(lbl3, HPos.RIGHT);

        var scene = new Scene(root);

        stage.setTitle("TextField");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
