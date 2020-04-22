package com.zetcode.effects.e33;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX effects: http://zetcode.com/gui/javafx/effects/
 * JavaFX GaussianBlur
 */
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GaussianBlurEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new VBox(30);
        root.setPadding(new Insets(10));

        var radius = new SimpleDoubleProperty(0);

        var blurredText = new Text("Inception");
        blurredText.setFont(Font.font(38));

        var slider = new Slider(1, 20, 1);
        radius.bind(slider.valueProperty());

        slider.valueProperty().addListener(event -> {
            blurredText.setEffect(new GaussianBlur(radius.get()));
        });

        root.getChildren().addAll(slider, blurredText);

        var scene = new Scene(root, 300, 250, Color.WHITESMOKE);

        stage.setTitle("Blur effect");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
