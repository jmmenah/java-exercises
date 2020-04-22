package com.zetcode.controls2.e22;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * Basic JavaFX controls II: http://zetcode.com/gui/javafx/controlsII/
 * JavaFX RadioButton
 */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonEx extends Application {

    private final double BORDER = 10d;
    private Label lbl2;

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new AnchorPane();

        var vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        var lbl1 = new Label("Difficulty");

        lbl2 = new Label("");
        lbl2.setStyle("-fx-background-color:wheat; -fx-padding: 0 0 0 5");
        lbl2.prefWidthProperty().bind(stage.widthProperty().subtract(2 * BORDER));

        var tg = new ToggleGroup();
        tg.selectedToggleProperty().addListener(new MyToggleListener());

        var rb1 = new RadioButton("Easy");
        rb1.setToggleGroup(tg);
        rb1.setSelected(true);

        var rb2 = new RadioButton("Medium");
        rb2.setToggleGroup(tg);

        var rb3 = new RadioButton("Hard");
        rb3.setToggleGroup(tg);

        vbox.getChildren().addAll(lbl1, rb1, rb2, rb3);
        root.getChildren().addAll(vbox, lbl2);

        AnchorPane.setTopAnchor(vbox, BORDER);
        AnchorPane.setBottomAnchor(lbl2, BORDER);
        AnchorPane.setLeftAnchor(lbl2, BORDER);

        var scene = new Scene(root, 300, 250);

        stage.setTitle("RadioButton");
        stage.setScene(scene);
        stage.show();
    }

    private class MyToggleListener implements ChangeListener<Toggle> {

        @Override
        public void changed(ObservableValue<? extends Toggle> observable,
                            Toggle oldValue, Toggle newValue) {

            var rb = (RadioButton) newValue;
            String txt = rb.getText();
            lbl2.setText(txt);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}