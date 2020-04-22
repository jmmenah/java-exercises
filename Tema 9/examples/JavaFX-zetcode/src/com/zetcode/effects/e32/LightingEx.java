package com.zetcode.effects.e32;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX effects: http://zetcode.com/gui/javafx/effects/
 * JavaFX Lighting
 */
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LightingEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new VBox(30);
        root.setPadding(new Insets(10));

        var azimuth = new SimpleDoubleProperty(0);

        Light.Distant light = new Light.Distant();
        light.setAzimuth(0);

        var lighting = new Lighting(light);
        lighting.setSurfaceScale(5.0);

        var text = new Text();
        text.setText("ZetCode");
        text.setFill(Color.LIGHTSKYBLUE);
        text.setFont(Font.font(null, FontWeight.BOLD, 60));

        var slider = new Slider(1, 360, 0);
        azimuth.bind(slider.valueProperty());

        slider.valueProperty().addListener(event -> {

            light.setAzimuth(azimuth.get());
            lighting.setLight(light);
            text.setEffect(lighting);
        });

        text.setEffect(lighting);

        root.getChildren().addAll(slider, text);

        var scene = new Scene(root, 300, 250, Color.WHITESMOKE);

        stage.setTitle("Lighting");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
