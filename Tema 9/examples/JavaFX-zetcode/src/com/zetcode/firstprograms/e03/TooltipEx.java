package com.zetcode.firstprograms.e03;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX first programs: http://zetcode.com/gui/javafx/firstprograms/
 * JavaFX tooltip
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TooltipEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new HBox();
        root.setPadding(new Insets(20));

        var btn = new Button("Button");
        var tooltip = new Tooltip("Button control");
        Tooltip.install(btn, tooltip);

        root.getChildren().add(btn);

        var scene = new Scene(root, 300, 250);

        stage.setTitle("Tooltip");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}