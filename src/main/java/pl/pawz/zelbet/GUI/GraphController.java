package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class GraphController {
    @FXML
    LineChart<Number, Number> lineChart;

    public void button() {
        lineChart.getData().clear();

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();


        series1.getData().add(new XYChart.Data<>(122,233));
        series1.getData().add(new XYChart.Data<>(-120,-110));

        series1.setName("KNG");
        series2.setName("KNG");

        series2.getData().add(new XYChart.Data<>(-122,-233));
        series2.getData().add(new XYChart.Data<>(120,110));

        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
    }

}
