package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import pl.pawz.zelbet.ULS.FourForcesLimit;

public class GraphController {
    @FXML
    LineChart<Number, Number> lineChart;


    public void button() {

        FourForcesLimit results = new FourForcesLimit(500, 0.001256, 0.001256, 0.3f, 0.6f, 30, 0.05f, 0.05f);

        double[] results1Case = results.firstCase();
        double res0 = results1Case[0] * Math.pow(10, 3);
        double res1 = results1Case[1] * Math.pow(10, 3);
        double n0 = results1Case[2] * Math.pow(10, 3);
        double n1 = results1Case[3] * Math.pow(10, 3);

        double[] results2Case = results.secondCase();
        double res2 = results2Case[0] * Math.pow(10, 3);
        double res3 = results2Case[1] * Math.pow(10, 3);
        double n2 = results2Case[2] * Math.pow(10, 3);
        double n3 = results2Case[3] * Math.pow(10, 3);

        lineChart.getData().clear();

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();


        series1.getData().add(new XYChart.Data<>(n0, res0));
        series1.getData().add(new XYChart.Data<>(n1, res1));
        series1.getData().add(new XYChart.Data<>(n2, res2));
        series1.getData().add(new XYChart.Data<>(n3, res3));

        series1.setName("KNG");
        series2.setName("KNG");

        series2.getData().add(new XYChart.Data<>(-122, -233));
        series2.getData().add(new XYChart.Data<>(120, 110));

        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
    }

}
