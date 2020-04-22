package com.zetcode.events.e26;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX events: http://zetcode.com/gui/javafx/events/
 * JavaFX Generic handler
 */
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GenericHandlerEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new StackPane();

        var btn = new Button("Button");
        btn.addEventHandler(EventType.ROOT, new GenericHandler());

        root.getChildren().add(btn);

        var scene = new Scene(root, 300, 250);

        stage.setTitle("Generic handler");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class GenericHandler implements EventHandler<Event> {

        @Override
        public void handle(Event event) {

            System.out.println(event.getEventType());
        }
    }
}