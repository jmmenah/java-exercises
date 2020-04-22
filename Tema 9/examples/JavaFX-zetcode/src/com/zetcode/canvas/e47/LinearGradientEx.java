package com.zetcode.canvas.e47;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX Canvas: http://zetcode.com/gui/javafx/canvas/
 * JavaFx gradients
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class LinearGradientEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new Pane();

        var canvas = new Canvas(300, 300);
        var gc = canvas.getGraphicsContext2D();
        doDrawing(gc);

        root.getChildren().add(canvas);

        var scene = new Scene(root, 300, 250, Color.WHITESMOKE);

        stage.setTitle("Linear gradient");
        stage.setScene(scene);
        stage.show();
    }

    private void doDrawing(GraphicsContext gc) {

        var stops1 = new Stop[] { new Stop(0.2, Color.BLACK),
                new Stop(0.5, Color.RED), new Stop(0.8, Color.BLACK)};

        var lg1 = new LinearGradient(0, 0, 1, 0, true,
                CycleMethod.NO_CYCLE, stops1);

        gc.setFill(lg1);
        gc.fillRect(50, 30, 200, 180);
    }

    public static void main(String[] args) {
        launch(args);
    }
}