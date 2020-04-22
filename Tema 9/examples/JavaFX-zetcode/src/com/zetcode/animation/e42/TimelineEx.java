package com.zetcode.animation.e42;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX animation: http://zetcode.com/gui/javafx/animation/
 * Timeline
 */
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class TimelineEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new Pane();

        var rect = new Rectangle(20, 20, 60, 60);
        rect.setEffect(new Lighting());
        rect.setFill(Color.CADETBLUE);

        var tl = new Timeline();

        tl.setCycleCount(2);
        tl.setAutoReverse(true);

        var kv = new KeyValue(rect.translateXProperty(), 200);
        var kf = new KeyFrame(Duration.millis(2000), kv);
        tl.getKeyFrames().addAll(kf);

        tl.play();

        root.getChildren().addAll(rect);

        var scene = new Scene(root, 350, 250);

        stage.setTitle("Timeline");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
