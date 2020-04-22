package com.zetcode.events.e28;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX events: http://zetcode.com/gui/javafx/events/
 * The java.util.Timer
 */
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TimerEx extends Application {

    int delay = 0;

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new HBox(10);
        root.setPadding(new Insets(10));

        var timer = new Timer();

        var spinner = new Spinner<>(1, 60, 5);
        spinner.setPrefWidth(80);

        var btn = new Button("Show message");
        btn.setOnAction(event -> {

            delay = (int) spinner.getValue();
            timer.schedule(new MyTimerTask(), delay*1000);
        });

        root.getChildren().addAll(btn, spinner);

        stage.setOnCloseRequest(event -> timer.cancel());

        var scene = new Scene(root);

        stage.setTitle("Timer");
        stage.setScene(scene);
        stage.show();
    }

    private class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            Platform.runLater(() -> {

                var alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information dialog");
                alert.setHeaderText("Time elapsed information");

                String contxt;

                if (delay == 1) {
                    contxt = "1 second has elapsed";
                } else {
                    contxt = String.format("%d seconds have elapsed",
                            delay);
                }

                alert.setContentText(contxt);
                alert.showAndWait();
            });
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
