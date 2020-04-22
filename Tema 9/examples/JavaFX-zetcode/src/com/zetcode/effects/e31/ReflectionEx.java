package com.zetcode.effects.e31;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX effects: http://zetcode.com/gui/javafx/effects/
 * JavaFX Reflection
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReflectionEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new StackPane();

        var text = new Text();
        text.setText("ZetCode");
        text.setFill(Color.STEELBLUE);
        text.setFont(Font.font("Serif", FontWeight.BOLD, 60));

        var ref = new Reflection();
        text.setEffect(ref);

        root.getChildren().add(text);

        var scene = new Scene(root, 300, 250, Color.WHITESMOKE);

        stage.setTitle("Reflection");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

