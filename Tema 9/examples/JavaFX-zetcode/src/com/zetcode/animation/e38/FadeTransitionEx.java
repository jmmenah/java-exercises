package com.zetcode.animation.e38;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX animation: http://zetcode.com/gui/javafx/animation/
 * FadeTransition
 */
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeTransitionEx extends Application {

    private FadeTransition ft;
    private Rectangle rect;

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new Group();

        rect = new Rectangle(20, 20, 150, 150);
        rect.setOnMouseClicked(new RectClickHandler());

        ft = new FadeTransition(Duration.millis(5000), rect);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);

        root.getChildren().add(rect);

        var scene = new Scene(root, 300, 250);

        stage.setTitle("Fading transition");
        stage.setScene(scene);
        stage.show();
    }

    private class RectClickHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {

            doHandle();
        }

        private void doHandle() {

            double opa = rect.getOpacity();

            if ((int) opa == 0) {
                return;
            }

            Animation.Status as = ft.getStatus();

            if (as == Animation.Status.RUNNING) {
                return;
            }

            if (as == Animation.Status.STOPPED) {
                ft.play();
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}