package com.zetcode.canvas.e50;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX Canvas: http://zetcode.com/gui/javafx/canvas/
 * JavaFX star shape
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StarShapeEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new Pane();

        var canvas = new Canvas(300, 300);
        var gc = canvas.getGraphicsContext2D();
        drawStarShape(gc);

        root.getChildren().add(canvas);

        var scene = new Scene(root, 300, 250, Color.WHITESMOKE);

        stage.setTitle("Star");
        stage.setScene(scene);
        stage.show();
    }

    private void drawStarShape(GraphicsContext gc) {

        double[] xpoints = {10, 85, 110, 135, 210, 160,
                170, 110, 50, 60};
        double[] ypoints = {85, 75, 10, 75, 85, 125,
                190, 150, 190, 125};

        gc.strokePolygon(xpoints, ypoints, xpoints.length);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
