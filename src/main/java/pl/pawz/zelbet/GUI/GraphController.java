package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolverKNG;
import pl.pawz.zelbet.ULS.FourForcesLimit;

public class GraphController {
    @FXML
    public LineChart<Number, Number> lineChart;
    @FXML
    public TextField geometryHeight;
    @FXML
    public TextField test1;
    @FXML
    public TextField steelFYk;
    @FXML
    public TextField aS1;
    @FXML
    public TextField aS2;
    @FXML
    public TextField a1;
    @FXML
    public TextField a2;
    @FXML
    public TextField n1;
    @FXML
    public TextField n2;
    @FXML
    public TextField fCk;

    double fYk = 500;
    double fYd = 0;

    double aS1Value = 0;
    double aS2Value = 0;

    double n1Value = 0;
    double n2Value = 0;

    float a1Value = 0.05f;
    float a2Value = 0.05f;

    public void initialize() {
        a1.setText("50");
        a2.setText("50");
        test1.setText("30");
        geometryHeight.setText("60");
        aS1.setText("16");
        aS2.setText("16");


    }


    public static float getDataFromTextField(TextField specificTextField, String variable) {
        try {
            float value;
            if (specificTextField.getText().isEmpty()) {
                specificTextField.setText(String.valueOf(0));
            }

            value = Float.parseFloat(specificTextField.getText().replaceAll(",", "."));

            if (value >= 0) {
                return value;
            } else {
                AlertBox.display("Błąd", "Wartość powinna być liczbą dodatnią");
                return 0;
            }
        } catch (NumberFormatException e) {

            AlertBox.display("Błąd", "Wartość " + variable + " powinna być liczbą dodatnią");
            return 0;
        }
    }

    public void button() {

        fYk = 500;
        fYd = BasicValues.fYdValue(fYk);

        aS1Value = getDataFromTextField(aS1, "as1"); //Problem with value of a1/a2 - when tab is cliccked it takes zero, then the equasion isnt true
        aS2Value = getDataFromTextField(aS2, "as2");

        n1Value = getDataFromTextField(n1, "n1");
        n2Value = getDataFromTextField(n2, "n2");

        a1Value = (float) (getDataFromTextField(a1, "a1") * Math.pow(10, -3));
        a2Value = (float) (getDataFromTextField(a2, "a2") * Math.pow(10, -3));

        double aSTrueValue1 = Math.pow(aS1Value * Math.pow(10, -3) / 2, 2) * n1Value * Math.PI;
        double aSTrueValue2 = Math.pow(aS2Value * Math.pow(10, -3) / 2, 2) * n2Value * Math.PI;


        lineChart.getData().clear();

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();


        resultsRed(series1, aSTrueValue1, aSTrueValue2, a1Value, a2Value, fYd);
        resultsYellow(series2, aSTrueValue2, aSTrueValue1, a2Value, a1Value);


        series1.setName("KNG");
        series2.setName("KNG");


        lineChart.getData().add(series1);
        lineChart.getData().add(series2);


        lineChart.setCreateSymbols(false);
    }

    private void resultsRed(XYChart.Series series, double aS1, double aS2, float a1, float a2, double fYd) {

        double xLim = BasicValuesPillars.xLimVar(0.0035, 0.6f, a1, fYd, 200000);
        double xMinYd = BasicValuesPillars.xMinMinusYdVar(0.0035, 0.05f, fYd, 200000);
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

        //double[] results3Case = results.thirdCase();
        //double res4 = results3Case[0] * Math.pow(10, 3);
        //double res5 = results3Case[1] * Math.pow(10, 3);
        //double n4 = results3Case[2] * Math.pow(10, 3);
        //double n5 = results3Case[3] * Math.pow(10, 3);

        //double[] results4Case = results.fourthCase();
        //double res6 = results4Case[0] * Math.pow(10, 3);
        //double res7 = results4Case[1] * Math.pow(10, 3);
        //double n6 = results4Case[2] * Math.pow(10, 3);
        //double n7 = results4Case[3] * Math.pow(10, 3);

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
        //series.getData().add(new XYChart.Data<>(n4, res4));
        //series.getData().add(new XYChart.Data<>(n5, res5));



        double x = xMinYd;
        double h = 0.6;

        while (x <= xLim) {

            double n = fYd * (aS2 - aS1) + 1 * 21.43 * 0.3 * 0.8 * x;

            double res = fYd * aS1 * (0.5 *0.6 - a1) + fYd * aS2 * (0.5 * 0.6 - a2) + 1 * 21.43 * 0.3 * 0.8 * x * 0.5 * (0.6 - 0.8 * x);
            series.getData().add(new XYChart.Data<>(n * 1000, res * Math.pow(10, 3)));

            System.out.println(n * 1000);
            n = n + 0.1;

            x = (n + fYd * (aS1 - aS2)) / (1 * 21.43 * 0.3 * 0.8);

        }

        x = xLim;
        while (x <= h) {

            double sigmaS1Two = Math.min(fYd, 0.0035 * (0.55 - x) / x * 200000);
            double n = -0.0035 * (0.55 - x) / x * 200000 * aS1 + fYd * aS2 + 21.34 * 0.3 * 0.8 * x;
            double res = sigmaS1Two * aS1 * (0.5 * 0.6 - a1) + fYd * aS2 * (0.5 * 0.6 - a2) + 1 * 21.34 * 0.3 * 0.8 * x * 0.5 * (0.6 - 0.8 * x);
            series.getData().add(new XYChart.Data<>(n * 1000, res * Math.pow(10, 3)));

            System.out.println(n * 1000);
            n = n + 0.1;
            x = PolynomialSolverKNG.solverPhaseIV(n, fYd, aS1, 0.0035, 200000, aS2, 1, 21.34, 0.3f, 0.8, 0.55, 0);

        }


        series.getData().add(new XYChart.Data<>(n8, res8));
        series.getData().add(new XYChart.Data<>(n9, res9));
        series.getData().add(new XYChart.Data<>(n10, res10));
        series.getData().add(new XYChart.Data<>(n11, res11));
        series.getData().add(new XYChart.Data<>(n12, res12));
        series.getData().add(new XYChart.Data<>(n13, res13));


    }

    private void resultsYellow(XYChart.Series series, double aS1, double aS2, float a1, float a2) {
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

        //double[] results4Case = results.fourthCase();
        //double res6 = -results4Case[0] * Math.pow(10, 3);
        //double res7 = -results4Case[1] * Math.pow(10, 3);
        //double n6 = results4Case[2] * Math.pow(10, 3);
        // double n7 = results4Case[3] * Math.pow(10, 3);

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
        //series.getData().add(new XYChart.Data<>(n6, res6));
        //series.getData().add(new XYChart.Data<>(n7, res7));
        series.getData().add(new XYChart.Data<>(n8, res8));
        series.getData().add(new XYChart.Data<>(n9, res9));
        series.getData().add(new XYChart.Data<>(n10, res10));
        series.getData().add(new XYChart.Data<>(n11, res11));
        series.getData().add(new XYChart.Data<>(n12, res12));
        series.getData().add(new XYChart.Data<>(n13, res13));
    }


}
