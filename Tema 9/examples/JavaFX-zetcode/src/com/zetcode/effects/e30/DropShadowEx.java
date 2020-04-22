package com.zetcode.effects.e30;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX effects: http://zetcode.com/gui/javafx/effects/
 * JavaFX DropShadow
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DropShadowEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new StackPane();

        var rect = new Rectangle(0, 0, 100, 100);
        rect.setFill(Color.GREENYELLOW);

        var ds = new DropShadow(15, Color.DARKGREEN);

        rect.setEffect(ds);

        root.getChildren().add(rect);

        var scene = new Scene(root, 250, 200, Color.WHITESMOKE);

        stage.setTitle("DropShadow");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
