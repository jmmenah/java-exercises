package com.zetcode.controls1.e13;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * Basic JavaFX controls: http://zetcode.com/gui/javafx/controls/
 * JavaFX Label
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LabelEx extends Application {

    String lyrics = "It's way too late to think of\n"
            + "Someone I would call now\n"
            + "And neon signs got tired\n"
            + "Red eye flights help the stars out\n"
            + "I'm safe in a corner\n"
            + "Just hours before me\n"
            + "\n"
            + "I'm waking with the roaches\n"
            + "The world has surrendered\n"
            + "I'm dating ancient ghosts\n"
            + "The ones I made friends with\n"
            + "The comfort of fireflies\n"
            + "Long gone before daylight\n"
            + "\n"
            + "And if I had one wishful field tonight\n"
            + "I'd ask for the sun to never rise\n"
            + "If God leant his voice for me to speak\n"
            + "I'd say go to bed, world\n"
            + "\n"
            + "I've always been too late\n"
            + "To see what's before me\n"
            + "And I know nothing sweeter than\n"
            + "Champaign from last New Years\n"
            + "Sweet music in my ears\n"
            + "And a night full of no fears\n"
            + "\n"
            + "But if I had one wishful field tonight\n"
            + "I'd ask for the sun to never rise\n"
            + "If God passed a mic to me to speak\n"
            + "I'd say stay in bed, world\n"
            + "Sleep in peace";

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new HBox();
        root.setPadding(new Insets(10));

        var lbl = new Label(lyrics);
        root.getChildren().add(lbl);

        var scene = new Scene(root);

        stage.setTitle("No sleep");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}