package com.zetcode.animation.e41;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX animation: http://zetcode.com/gui/javafx/animation/
 * SequentialTransition
 */
import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class SequentialTransitionEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new Pane();

        var rect = new Rectangle(50, 50, 30, 30);
        rect.setArcHeight(10);
        rect.setArcWidth(10);
        rect.setFill(Color.CADETBLUE);

        var rottr = new RotateTransition(Duration.millis(2000), rect);
        rottr.setByAngle(180);
        rottr.setCycleCount(2);
        rottr.setAutoReverse(true);

        var sctr = new ScaleTransition(Duration.millis(2000), rect);
        sctr.setByX(2);
        sctr.setByY(2);
        sctr.setCycleCount(2);
        sctr.setAutoReverse(true);

        var fltr = new FillTransition(Duration.millis(2000), rect,
                Color.CADETBLUE, Color.STEELBLUE);
        fltr.setCycleCount(2);
        fltr.setAutoReverse(true);

        root.getChildren().add(rect);

        var str = new SequentialTransition();
        str.getChildren().addAll(rottr, sctr, fltr);

        str.play();

        var scene = new Scene(root, 300, 250);

        stage.setTitle("SequentialTransition");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

