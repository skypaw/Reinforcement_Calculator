package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.BasicValuesPillars;
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

    private double fYkValue = 0;
    private double fCkValue = 0;
    private double aS1Value = 0;
    private double aS2Value = 0;
    private double n1Value = 0;
    private double n2Value = 0;
    private double a1Value = 0.05f;
    private double a2Value = 0.05f;
    private double bDimension = 0;
    private double hDimension = 0;

    private Object FourForcesLimit;


    public void initialize() {
        a1.setText("50");
        a2.setText("50");
        test1.setText("30");
        geometryHeight.setText("60");
        aS1.setText("16");
        aS2.setText("16");
        fCk.setText("30");
        steelFYk.setText("500");
    }


    public void button() {
        takeData();
        double aSTrueValue1 = Math.pow(aS1Value * Math.pow(10, -3) / 2, 2) * n1Value * Math.PI;
        double aSTrueValue2 = Math.pow(aS2Value * Math.pow(10, -3) / 2, 2) * n2Value * Math.PI;


        lineChart.getData().clear();

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();

        resultsRed(series1, aSTrueValue1, aSTrueValue2, a1Value, a2Value, fYkValue, bDimension, hDimension, fCkValue);
        yellowRes(series2, aSTrueValue2, aSTrueValue1, a2Value, a1Value, fYkValue, bDimension, hDimension, fCkValue);


        series1.setName("KNG");
        series2.setName("KNG");
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);

        lineChart.setCreateSymbols(false);

    }

    public void takeData() {
        Validator validator = new Validator();

        fYkValue = validator.textToPositiveNumber(steelFYk, 500);
        fCkValue = validator.textToPositiveNumber(fCk, 30);

        aS1Value = validator.textToPositiveNumber(aS1, 16);
        aS2Value = validator.textToPositiveNumber(aS2, 16);

        n1Value = validator.textToPositiveNumber(n1, 0);
        n2Value = validator.textToPositiveNumber(n2, 0);

        a1Value = (double) (validator.textToPositiveNumber(a1, 50) * Math.pow(10, -3));
        a2Value = (double) (validator.textToPositiveNumber(a2, 50) * Math.pow(10, -3));

        bDimension = (double) (validator.textToPositiveNumber(test1, 30) * Math.pow(10, -2));
        hDimension = (double) (validator.textToPositiveNumber(geometryHeight, 60) * Math.pow(10, -2));

    }

    private void resultsRed(XYChart.Series series, double aS1, double aS2, double a1, double a2, double fYk, double bDimension, double hDimension, double fCk) {

        int eS = BasicValues.steelE();
        double epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        double lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);
        double fYd = BasicValues.fYdValue(fYk);
        double xLim = BasicValuesPillars.xLimVar(epsilonCu3, hDimension, a1, fYd, eS);
        double xMinYd = BasicValuesPillars.xMinYdVar(epsilonCu3, a2Value, fYd, eS);
        double xMinMinusYd = BasicValuesPillars.xMinMinusYdVar(epsilonCu3, a2Value, fYd, eS);

        this.FourForcesLimit = new FourForcesLimit(fYk, aS1, aS2, bDimension, hDimension, fCk, a1, a2);
        FourForcesLimit graph = (pl.pawz.zelbet.ULS.FourForcesLimit) FourForcesLimit; //to think about that


        //Limit values for graph

        double[] firstIntervalLimit = graph.limitFirst();
        double[] secondIntervalLimit = graph.limitSecond();
        double[] thirdIntervalLimit = graph.limitThird();
        double[] fourthIntervalLimit = graph.limitFourth();
        double[] fifthIntervalLimit = graph.limitFifth();
        double[] sixthIntervalLimit = graph.limitSixth();
        double[] seventhIntervalLimit = graph.limitSeventh();
        double[] eighthIntervalLimit = graph.limitEighth();

        series.getData().add(new XYChart.Data<>(firstIntervalLimit[0] * 1000, firstIntervalLimit[1] * 1000));
        series.getData().add(new XYChart.Data<>(thirdIntervalLimit[0] * 1000, thirdIntervalLimit[1] * 1000));
        series.getData().add(new XYChart.Data<>(sixthIntervalLimit[0] * 1000, sixthIntervalLimit[1] * 1000));
        series.getData().add(new XYChart.Data<>(seventhIntervalLimit[0] * 1000, seventhIntervalLimit[1] * 1000));
        series.getData().add(new XYChart.Data<>(eighthIntervalLimit[0] * 1000, eighthIntervalLimit[1] * 1000));

        double secondIntervalPoints = (thirdIntervalLimit[0]-secondIntervalLimit[0])/20;
        double fourthIntervalPoints = (fifthIntervalLimit[0]-fourthIntervalLimit[0])/20;
        double fifthIntervalPoints = (sixthIntervalLimit[0]-fifthIntervalLimit[0])/20;

        double x = xMinMinusYd;

        while (x < xMinYd) {
            double[] results = graph.secondCase(x, secondIntervalPoints);

            double nValue = results[0] * 1000;
            double mValue = results[1] * 1000;
            series.getData().add(new XYChart.Data<>(nValue, mValue));

            x = results[2];
        }

        x = xLim;

        while (x < hDimension) {
            double[] results = graph.fourthCase(x, fourthIntervalPoints);

            double nValue = results[0] * 1000;
            double mValue = results[1] * 1000;
            series.getData().add(new XYChart.Data<>(nValue, mValue));

            x = results[2];
        }

        x= hDimension;

        while (x < hDimension/lambdaConcrete) {
            double[] results = graph.fifthCase(x, fifthIntervalPoints);

            double nValue = results[0] * 1000;
            double mValue = results[1] * 1000;
            series.getData().add(new XYChart.Data<>(nValue, mValue));

            x = results[2];
        }

    }

    private void yellowRes(XYChart.Series series, double aS1, double aS2, double a1, double a2, double fYk, double bDimension, double hDimension, double fCk) {

        int eS = BasicValues.steelE();
        double epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        double lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);
        double fYd = BasicValues.fYdValue(fYk);
        double xLim = BasicValuesPillars.xLimVar(epsilonCu3, hDimension, a1, fYd, eS);
        double xMinYd = BasicValuesPillars.xMinYdVar(epsilonCu3, a2Value, fYd, eS);
        double xMinMinusYd = BasicValuesPillars.xMinMinusYdVar(epsilonCu3, a2Value, fYd, eS);
        this.FourForcesLimit = new FourForcesLimit(fYk, aS1, aS2, bDimension, hDimension, fCk, a1, a2);
        FourForcesLimit graph = (pl.pawz.zelbet.ULS.FourForcesLimit) FourForcesLimit; //to think about that


        double[] firstIntervalLimit = graph.limitFirst();
        double[] secondIntervalLimit = graph.limitSecond();
        double[] thirdIntervalLimit = graph.limitThird();
        double[] fourthIntervalLimit = graph.limitFourth();
        double[] fifthIntervalLimit = graph.limitFifth();
        double[] sixthIntervalLimit = graph.limitSixth();
        double[] seventhIntervalLimit = graph.limitSeventh();
        double[] eighthIntervalLimit = graph.limitEighth();


        series.getData().add(new XYChart.Data<>(firstIntervalLimit[0] * 1000, -firstIntervalLimit[1] * 1000));
        series.getData().add(new XYChart.Data<>(thirdIntervalLimit[0] * 1000, -thirdIntervalLimit[1] * 1000));
        series.getData().add(new XYChart.Data<>(sixthIntervalLimit[0] * 1000, -sixthIntervalLimit[1] * 1000));
        series.getData().add(new XYChart.Data<>(seventhIntervalLimit[0] * 1000, -seventhIntervalLimit[1] * 1000));
        series.getData().add(new XYChart.Data<>(eighthIntervalLimit[0] * 1000, -eighthIntervalLimit[1] * 1000));


        double secondIntervalPoints = (thirdIntervalLimit[0]-secondIntervalLimit[0])/20;
        double fourthIntervalPoints = (fifthIntervalLimit[0]-fourthIntervalLimit[0])/20;
        double fifthIntervalPoints = (sixthIntervalLimit[0]-fifthIntervalLimit[0])/20;

        double x = xMinMinusYd;

        while (x < xMinYd) {
            double[] results = graph.secondCase(x, secondIntervalPoints);

            double nValue = results[0] * 1000;
            double mValue = -results[1] * 1000;
            series.getData().add(new XYChart.Data<>(nValue, mValue));

            x = results[2];
        }

        x = xLim;

        while (x < hDimension) {
            double[] results = graph.fourthCase(x, fourthIntervalPoints);

            double nValue = results[0] * 1000;
            double mValue = -results[1] * 1000;
            series.getData().add(new XYChart.Data<>(nValue, mValue));

            x = results[2];
        }

        x= hDimension;

        while (x < hDimension/lambdaConcrete) {
            double[] results = graph.fifthCase(x, fifthIntervalPoints);

            double nValue = results[0] * 1000;
            double mValue = -results[1] * 1000;
            series.getData().add(new XYChart.Data<>(nValue, mValue));

            x = results[2];
        }


    }
}