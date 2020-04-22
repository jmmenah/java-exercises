package com.zetcode.events.e25;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX events: http://zetcode.com/gui/javafx/events/
 * JavaFX Event properties
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EventSourceEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new Pane();

        var rect = new Rectangle(30, 30, 80, 80);
        rect.setOnMouseClicked(e -> {

            System.out.println(e.getSource());
            System.out.println(e.getTarget());
            System.out.println(e.getEventType());
            System.out.format("x:%f, y:%f%n", e.getSceneX(), e.getSceneY());
            System.out.format("x:%f, y:%f%n", e.getScreenX(), e.getScreenY());
        });

        root.getChildren().addAll(rect);

        var scene = new Scene(root, 300, 250);

        stage.setTitle("Event properties");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
