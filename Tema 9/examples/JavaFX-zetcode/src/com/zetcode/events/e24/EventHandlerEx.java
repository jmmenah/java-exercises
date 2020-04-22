package com.zetcode.events.e24;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX events: http://zetcode.com/gui/javafx/events/
 * JavaFX Event handler
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EventHandlerEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new HBox();

        var conMenu = new ContextMenu();
        var noopMi = new MenuItem("No op");
        var exitMi = new MenuItem("Exit");

        conMenu.getItems().addAll(noopMi, exitMi);

        exitMi.setOnAction(event -> Platform.exit());

        root.setOnMousePressed(event -> {
            if (event.isSecondaryButtonDown()) {
                conMenu.show(root, event.getScreenX(),
                        event.getScreenY());
            }
        });

        var scene = new Scene(root, 300, 250);

        stage.setTitle("EventHandler");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
