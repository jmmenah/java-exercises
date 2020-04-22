package com.zetcode.effects.e36;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX effects: http://zetcode.com/gui/javafx/effects/
 * JavaFX Combining effects
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CombiningEffectsEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new StackPane();

        Light.Distant light = new Light.Distant();
        light.setAzimuth(50);

        var lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5);

        var text = new Text();
        text.setText("ZetCode");
        text.setFill(Color.CADETBLUE);
        text.setFont(Font.font(null, FontWeight.BOLD, 60));

        var ref = new Reflection();
        ref.setInput(lighting);
        text.setEffect(ref);

        root.getChildren().add(text);

        var scene = new Scene(root, 300, 250, Color.WHITESMOKE);

        stage.setTitle("Combining effects");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
