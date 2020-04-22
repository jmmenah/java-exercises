package com.zetcode.canvas.e51;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX Canvas: http://zetcode.com/gui/javafx/canvas/
 * JavaFX transparent rectangles
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TransparentRectanglesEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new Pane();

        var canvas = new Canvas(600, 300);
        var gc = canvas.getGraphicsContext2D();
        drawRectangles(gc);

        root.getChildren().add(canvas);

        var scene = new Scene(root, 600, 100, Color.WHITESMOKE);

        stage.setTitle("Transparent rectangles");
        stage.setScene(scene);
        stage.show();
    }

    private void drawRectangles(GraphicsContext gc) {

        for (int i = 1; i <= 10; i++) {

            float alpha = i * 0.1f;

            gc.setFill(Color.FORESTGREEN);
            gc.setGlobalAlpha(alpha);
            gc.fillRect(50 * i, 20, 40, 40);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}