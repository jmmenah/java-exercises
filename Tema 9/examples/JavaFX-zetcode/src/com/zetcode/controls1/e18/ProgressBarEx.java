package com.zetcode.controls1.e18;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * Basic JavaFX controls: http://zetcode.com/gui/javafx/controls/
 * JavaFX ProgressBar
 */
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProgressBarEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new HBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        var pbar = new ProgressBar(0);
        pbar.setPrefWidth(150);

        var frame1 = new KeyFrame(Duration.ZERO,
                new KeyValue(pbar.progressProperty(), 0));

        var frame2 = new KeyFrame(Duration.seconds(3),
                new KeyValue(pbar.progressProperty(), 1));

        var task = new Timeline(frame1, frame2);

        var btn = new Button("Start");
        btn.setOnAction((ActionEvent actionEvent) -> task.playFromStart());

        root.getChildren().addAll(pbar, btn);

        var scene = new Scene(root);

        stage.setTitle("ProgressBar");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}