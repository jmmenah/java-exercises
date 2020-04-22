package com.zetcode.charts.e55;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX Charts: http://zetcode.com/gui/javafx/charts/
 * JavaFX BarChart
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class BarChartEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new HBox();

        var scene = new Scene(root, 480, 330);
        var xAxis = new CategoryAxis();

        var yAxis = new NumberAxis();
        yAxis.setLabel("Gold medals");

        var barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Olympic gold medals in London");

        var data = new XYChart.Series<String, Number>();

        data.getData().add(new XYChart.Data<>("USA", 46));
        data.getData().add(new XYChart.Data<>("China", 38));
        data.getData().add(new XYChart.Data<>("UK", 29));
        data.getData().add(new XYChart.Data<>("Russia", 22));
        data.getData().add(new XYChart.Data<>("South Korea", 13));
        data.getData().add(new XYChart.Data<>("Germany", 11));

        barChart.getData().add(data);
        barChart.setLegendVisible(false);

        root.getChildren().add(barChart);

        stage.setTitle("BarChart");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
