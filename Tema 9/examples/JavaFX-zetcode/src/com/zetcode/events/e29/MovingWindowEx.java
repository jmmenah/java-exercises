package com.zetcode.events.e29;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX events: http://zetcode.com/gui/javafx/events/
 * JavaFX Moving a window
 */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovingWindowEx extends Application {

    int x = 0;
    int y = 0;
    Label lbl_x;
    Label lbl_y;

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new VBox(10);
        root.setPadding(new Insets(10));

        var txt1 = String.format("x: %d", x);
        lbl_x = new Label(txt1);

        var txt2 = String.format("y: %d", y);
        lbl_y = new Label(txt2);

        root.getChildren().addAll(lbl_x, lbl_y);

        stage.xProperty().addListener(new ChangeListener<>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {

                doChange(newValue);
            }

            private void doChange(Number newValue) {

                x = newValue.intValue();
                updateXLabel();
            }

        });

        stage.yProperty().addListener(new ChangeListener<>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {

                doChange(newValue);
            }

            private void doChange(Number newValue) {

                y = newValue.intValue();
                updateYLabel();
            }

        });

        var scene = new Scene(root, 300, 250);

        stage.setTitle("Moving window");
        stage.setScene(scene);
        stage.show();
    }

    private void updateXLabel() {

        var txt = String.format("x: %d", x);
        lbl_x.setText(txt);
    }

    private void updateYLabel() {

        var txt = String.format("y: %d", y);
        lbl_y.setText(txt);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

