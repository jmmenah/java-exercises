package com.zetcode.events.e27;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX events: http://zetcode.com/gui/javafx/events/
 * JavaFX Multiple sources
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleSourcesEx extends Application {

    private Label lbl;

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new AnchorPane();

        var vbox = new VBox(5);

        var btn1 = new Button("Close");
        var btn2 = new Button("Open");
        var btn3 = new Button("Find");
        var btn4 = new Button("Save");

        var mbh = new MyButtonHandler();

        btn1.setOnAction(mbh);
        btn2.setOnAction(mbh);
        btn3.setOnAction(mbh);
        btn4.setOnAction(mbh);

        vbox.getChildren().addAll(btn1, btn2, btn3, btn4);

        lbl = new Label("Ready");

        AnchorPane.setTopAnchor(vbox, 10d);
        AnchorPane.setLeftAnchor(vbox, 10d);
        AnchorPane.setBottomAnchor(lbl, 10d);
        AnchorPane.setLeftAnchor(lbl, 10d);

        root.getChildren().addAll(vbox, lbl);

        var scene = new Scene(root, 350, 200);

        stage.setTitle("Multiple sources");
        stage.setScene(scene);
        stage.show();
    }

    private class MyButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            var btn = (Button) event.getSource();
            lbl.setText(String.format("Button %s fired", btn.getText()));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
