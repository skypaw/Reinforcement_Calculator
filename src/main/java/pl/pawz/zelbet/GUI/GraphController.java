package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import pl.pawz.zelbet.ULS.FourForcesLimit;

public class GraphController {
    @FXML
    LineChart<Number, Number> lineChart;


    public void button() {
        double aS1 =0.0004021;
        double aS2 =0.0036191;
        float a1 =0.05f;
        float a2 =0.05f;


        lineChart.getData().clear();

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();


        resultsRed(series1, aS1, aS2, a1, a2);
        resultsYellow(series2, aS2, aS1, a2, a1);


        series1.setName("KNG");
        series2.setName("KNG");


        lineChart.getData().add(series1);
        lineChart.getData().add(series2);


        lineChart.setCreateSymbols(false);
    }

    private void resultsRed(XYChart.Series series, double aS1, double aS2, float a1, float a2){
        FourForcesLimit results = new FourForcesLimit(500, aS1, aS2, 0.3f, 0.6f, 30, a1, a2);

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

        double[] results3Case = results.thirdCase();
        double res4 = results3Case[0] * Math.pow(10, 3);
        double res5 = results3Case[1] * Math.pow(10, 3);
        double n4 = results3Case[2] * Math.pow(10, 3);
        double n5 = results3Case[3] * Math.pow(10, 3);

        double[] results4Case = results.fourthCase();
        double res6 = results4Case[0] * Math.pow(10, 3);
        double res7 = results4Case[1] * Math.pow(10, 3);
        double n6 = results4Case[2] * Math.pow(10, 3);
        double n7 = results4Case[3] * Math.pow(10, 3);

        double[] results5Case = results.fifthCase();
        double res8 = results5Case[0] * Math.pow(10, 3);
        double res9 = results5Case[1] * Math.pow(10, 3);
        double n8 = results5Case[2] * Math.pow(10, 3);
        double n9 = results5Case[3] * Math.pow(10, 3);

        double[] results6Case = results.sixthCase();
        double res10 = results6Case[0] * Math.pow(10, 3);
        double res11 = results6Case[1] * Math.pow(10, 3);
        double n10 = results6Case[2] * Math.pow(10, 3);
        double n11 = results6Case[3] * Math.pow(10, 3);

        double[] results7Case = results.seventhCase();
        double res12 = results7Case[0] * Math.pow(10, 3);
        double res13 = results7Case[1] * Math.pow(10, 3);
        double n12 = results7Case[2] * Math.pow(10, 3);
        double n13 = results7Case[3] * Math.pow(10, 3);

        series.getData().add(new XYChart.Data<>(n0, res0));
        series.getData().add(new XYChart.Data<>(n1, res1));
        series.getData().add(new XYChart.Data<>(n2, res2));
        series.getData().add(new XYChart.Data<>(n3, res3));
        series.getData().add(new XYChart.Data<>(n4, res4));
        series.getData().add(new XYChart.Data<>(n5, res5));
        series.getData().add(new XYChart.Data<>(n6, res6));
        series.getData().add(new XYChart.Data<>(n7, res7));
        series.getData().add(new XYChart.Data<>(n8, res8));
        series.getData().add(new XYChart.Data<>(n9, res9));
        series.getData().add(new XYChart.Data<>(n10, res10));
        series.getData().add(new XYChart.Data<>(n11, res11));
        series.getData().add(new XYChart.Data<>(n12, res12));
        series.getData().add(new XYChart.Data<>(n13, res13));
    }

    private void resultsYellow(XYChart.Series series, double aS1, double aS2, float a1, float a2){
        FourForcesLimit results = new FourForcesLimit(500, aS1, aS2, 0.3f, 0.6f, 30, a1, a2);

        double[] results1Case = results.firstCase();
        double res0 = -results1Case[0] * Math.pow(10, 3);
        double res1 = -results1Case[1] * Math.pow(10, 3);
        double n0 = results1Case[2] * Math.pow(10, 3);
        double n1 = results1Case[3] * Math.pow(10, 3);

        double[] results2Case = results.secondCase();
        double res2 = -results2Case[0] * Math.pow(10, 3);
        double res3 = -results2Case[1] * Math.pow(10, 3);
        double n2 = results2Case[2] * Math.pow(10, 3);
        double n3 = results2Case[3] * Math.pow(10, 3);

        double[] results3Case = results.thirdCase();
        double res4 = -results3Case[0] * Math.pow(10, 3);
        double res5 = -results3Case[1] * Math.pow(10, 3);
        double n4 = results3Case[2] * Math.pow(10, 3);
        double n5 = results3Case[3] * Math.pow(10, 3);

        double[] results4Case = results.fourthCase();
        double res6 = -results4Case[0] * Math.pow(10, 3);
        double res7 = -results4Case[1] * Math.pow(10, 3);
        double n6 = results4Case[2] * Math.pow(10, 3);
        double n7 = results4Case[3] * Math.pow(10, 3);

        double[] results5Case = results.fifthCase();
        double res8 = -results5Case[0] * Math.pow(10, 3);
        double res9 = -results5Case[1] * Math.pow(10, 3);
        double n8 = results5Case[2] * Math.pow(10, 3);
        double n9 = results5Case[3] * Math.pow(10, 3);

        double[] results6Case = results.sixthCase();
        double res10 = -results6Case[0] * Math.pow(10, 3);
        double res11 = -results6Case[1] * Math.pow(10, 3);
        double n10 = results6Case[2] * Math.pow(10, 3);
        double n11 = results6Case[3] * Math.pow(10, 3);

        double[] results7Case = results.seventhCase();
        double res12 = -results7Case[0] * Math.pow(10, 3);
        double res13 = -results7Case[1] * Math.pow(10, 3);
        double n12 = results7Case[2] * Math.pow(10, 3);
        double n13 = results7Case[3] * Math.pow(10, 3);

        series.getData().add(new XYChart.Data<>(n0, res0));
        series.getData().add(new XYChart.Data<>(n1, res1));
        series.getData().add(new XYChart.Data<>(n2, res2));
        series.getData().add(new XYChart.Data<>(n3, res3));
        series.getData().add(new XYChart.Data<>(n4, res4));
        series.getData().add(new XYChart.Data<>(n5, res5));
        series.getData().add(new XYChart.Data<>(n6, res6));
        series.getData().add(new XYChart.Data<>(n7, res7));
        series.getData().add(new XYChart.Data<>(n8, res8));
        series.getData().add(new XYChart.Data<>(n9, res9));
        series.getData().add(new XYChart.Data<>(n10, res10));
        series.getData().add(new XYChart.Data<>(n11, res11));
        series.getData().add(new XYChart.Data<>(n12, res12));
        series.getData().add(new XYChart.Data<>(n13, res13));
    }


}
