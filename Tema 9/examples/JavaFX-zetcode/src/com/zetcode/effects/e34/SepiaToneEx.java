package com.zetcode.effects.e34;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX effects: http://zetcode.com/gui/javafx/effects/
 * JavaFX SepiaTone
 */

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.effect.Effect;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SepiaToneEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new StackPane();
        // http://upload.wikimedia.org/wikipedia/commons/3/32/Agaricus_bisporus_Zuchtchampignon.JPG
        // CC BY-SA 2.5, https://commons.wikimedia.org/w/index.php?curid=15694796
        var image = new Image("mushroom.jpg");  // By böhringer friedrich
        var iw = new ImageView(image);

        var sepia = new SepiaTone();
        iw.effectProperty().bind(
                Bindings.when(iw.hoverProperty())
                        .then((Effect) sepia)
                        .otherwise((Effect) null)
        );

        iw.setCache(true);
        iw.setCacheHint(CacheHint.SPEED);

        root.getChildren().add(iw);

        var scene = new Scene(root);

        stage.setTitle("SepiaTone");
        scene.setFill(Color.WHITESMOKE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}