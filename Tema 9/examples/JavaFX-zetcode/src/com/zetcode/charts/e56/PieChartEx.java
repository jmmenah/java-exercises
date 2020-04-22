package com.zetcode.charts.e56;
/*
 * JavaFX tutorial: http://zetcode.com/gui/javafx/
 * JavaFX Charts: http://zetcode.com/gui/javafx/charts/
 * JavaFX PieChart
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class PieChartEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new HBox();

        var scene = new Scene(root, 450, 330);

        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                new PieChart.Data("Apache", 52),
                new PieChart.Data("Nginx", 31),
                new PieChart.Data("IIS", 12),
                new PieChart.Data("LiteSpeed", 2),
                new PieChart.Data("Google server", 1),
                new PieChart.Data("Others", 2));

        var pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Web servers market share (2016)");

        root.getChildren().add(pieChart);

        stage.setTitle("PieChart");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
