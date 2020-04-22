package com.zetcode.animation.e43;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX animation: http://zetcode.com/gui/javafx/animation/
 * Sequential Timeline animation
 */
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SequentialTimelineEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new Pane();

        var c = new Circle(50, 100, 10);
        c.setFill(Color.CADETBLUE);

        var kv1 = new KeyValue(c.scaleXProperty(), 4);
        var kv2 = new KeyValue(c.scaleYProperty(), 4);
        var kf1 = new KeyFrame(Duration.millis(3000), kv1, kv2);

        var scale = new Timeline();
        scale.getKeyFrames().add(kf1);

        var kv3 = new KeyValue(c.centerXProperty(), 250);
        var kf2 = new KeyFrame(Duration.millis(5000), kv3);

        var move = new Timeline();
        move.getKeyFrames().add(kf2);

        var kv4 = new KeyValue(c.scaleXProperty(), 1);
        var kv5 = new KeyValue(c.scaleYProperty(), 1);
        var kf3 = new KeyFrame(Duration.millis(3000), kv4, kv5);

        var scale2 = new Timeline();
        scale2.getKeyFrames().add(kf3);

        var seqtr = new SequentialTransition(scale, move, scale2);
        seqtr.play();

        root.getChildren().add(c);

        var scene = new Scene(root, 300, 250);

        stage.setTitle("Sequential Timeline animation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}