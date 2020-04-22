package com.zetcode.firstprograms.e05;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX first programs: http://zetcode.com/gui/javafx/firstprograms/
 * JavaFX styling a control
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StylingTextEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new HBox();
        root.setPadding(new Insets(20));

        var text = new Text("ZetCode");
        text.setFont(Font.font("Serif", FontWeight.BOLD, 76));

        text.setId("text");
        root.setId("root");

        root.getChildren().addAll(text);

        var scene = new Scene(root);
        scene.getStylesheets().add("style.css");

        stage.setTitle("Styling text");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
