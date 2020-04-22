package com.zetcode.controls1.e16;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * Basic JavaFX controls: http://zetcode.com/gui/javafx/controls/
 * JavaFX Slider
 * Icons from https://icons8.com/iconizer/en/search/1/collection:Gnome_Web_Icons
 */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SliderEx extends Application {

    private ImageView iview;
    private Image muteImg;
    private Image minImg;
    private Image maxImg;
    private Image medImg;

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new HBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(15));

        loadImages();

        iview = new ImageView(muteImg);

        var slider = new Slider(0, 100, 0);
        slider.valueProperty().addListener(new MyChangeListener());

        var scene = new Scene(root);

        root.getChildren().addAll(slider, iview);

        stage.setTitle("Slider");
        stage.setScene(scene);
        stage.show();
    }

    private void loadImages() {

        muteImg = new Image("mute.png");
        minImg = new Image("min.png");
        maxImg = new Image("max.png");
        medImg = new Image("med.png");
    }

    private class MyChangeListener implements ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> observable,
                            Number oldValue, Number newValue) {

            double value = newValue.doubleValue();

            if (value == 0) {
                iview.setImage(muteImg);
            } else if (value > 0 && value <= 30) {
                iview.setImage(minImg);
            } else if (value > 30 && value < 80) {
                iview.setImage(medImg);
            } else {
                iview.setImage(maxImg);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}