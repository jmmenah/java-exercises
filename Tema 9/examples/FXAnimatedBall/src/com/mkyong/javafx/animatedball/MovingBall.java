/*
 * JavaFX Animated Ball Example By Marilena | January 16, 2017
 * https://mkyong.com/javafx/javafx-animated-ball-example/
 */

// 1. Moving Ball Example

package com.mkyong.javafx.animatedball;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingBall extends Application{

    @Override
    public void start(Stage stage) {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 300, 300);
        Circle ball = new Circle(10, Color.RED);
        ball.relocate(0, 10);

        canvas.getChildren().add(ball);

        stage.setTitle("Moving Ball");
        stage.setScene(scene);
        stage.show();

        Bounds bounds = canvas.getBoundsInLocal();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3),
                new KeyValue(ball.layoutXProperty(), bounds.getMaxX()-ball.getRadius())));
        // Equivalent to previous one-line code
        /*
        KeyValue keyValue = new KeyValue(ball.layoutXProperty(), bounds.getMaxX()-ball.getRadius());
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(3), keyValue);
        Timeline timeline = new Timeline(keyFrame);
        */

        timeline.setCycleCount(2);
        timeline.play();
    }

    public static void main(String[] args) {
        launch();
    }
}
