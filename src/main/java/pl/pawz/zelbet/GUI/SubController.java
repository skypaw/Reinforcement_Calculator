package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pl.pawz.zelbet.Diagnostic.DiagnosticBendingBeamAndT;
import pl.pawz.zelbet.Diagnostic.DiagnosticCompression;
import pl.pawz.zelbet.Diagnostic.DiagnosticExtension;
import pl.pawz.zelbet.Diagnostic.DiagnosticShearing;
import pl.pawz.zelbet.ULS.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class SubController {

    public HashMap<String, Double> data;

    @FXML
    Label res1 = new Label();
    @FXML
    Label res2 = new Label();

    @FXML
    Button toPdfButton;


    // Static text fields to read data from. Used in method "calculations"
    @FXML
    TextField geometryHeight;
    @FXML
    TextField steelFYk;
    @FXML
    TextField aS1;
    @FXML
    TextField aS2;
    @FXML
    TextField a1;
    @FXML
    TextField a2;
    @FXML
    TextField vEd;
    @FXML
    TextField vEdRed;
    @FXML
    TextField ctgTheta;
    @FXML
    TextField alpha;
    @FXML
    TextField aSw1;
    @FXML
    TextField nSw1;
    @FXML
    TextField mEk;
    @FXML
    TextField mEkLt;
    @FXML
    TextField tZero;
    @FXML
    TextField rH;
    @FXML
    TextField cNom;
    @FXML
    TextField lEff;
    @FXML
    TextField alphaM;

    @FXML
    Label res1true;
    @FXML
    Label res2true;
    @FXML
    Label resRods1;
    @FXML
    Label resRods2;

    @FXML
    Label res1trueAsymmetric;
    @FXML
    Label res2trueAsymmetric;
    @FXML
    Label resRods1Asymmetric;
    @FXML
    Label resRods2Asymmetric;

    @FXML
    Label res1Asymmetric;
    @FXML
    Label res2Asymmetric;

    @FXML
    Label sRods;
    @FXML
    TextField aSlTxt;
    @FXML
    ChoiceBox choiceBoxDimensions;
    @FXML
    Label sRodsReal;
    @FXML
    GridPane gridResults;
    @FXML
    GridPane gridResultsShearing;


    //non static text fields which depends on check boxes like "four loads", or "bend rods"


    //for four loads basic option

    TextField mEdLoadsTxt = new TextField();
    TextField nEdLoadsTxt = new TextField();
    //for four loads extended


    private TextField mEdLoadsTxt1 = new TextField();
    private TextField mEdLoadsTxt2 = new TextField();
    private TextField mEdLoadsTxt3 = new TextField();
    private TextField mEdLoadsTxt4 = new TextField();
    private TextField nEdLoadsTxt1 = new TextField();
    private TextField nEdLoadsTxt2 = new TextField();
    private TextField nEdLoadsTxt3 = new TextField();
    private TextField nEdLoadsTxt4 = new TextField();

    //for dimension
    private TextField bFDimension = new TextField();
    private TextField hFDimension = new TextField();
    private TextField bFTDimension = new TextField();
    private TextField hFTDimension = new TextField();
    private Label bFDimensionLabel = new Label("b_f");
    private Label hFDimensionLabel = new Label("h_f");
    private Label bFTDimensionLabel = new Label("b_f,t");
    private Label hFTDimensionLabel = new Label("h_f,t");


    //for bend rods
    private Label aSw2Rod = new Label("A_sw2");
    private Label nSw2Rod = new Label("n_sw2");
    private Label nSw2RodS = new Label("s_sw2");
    TextField aSw2RodTxt = new TextField();
    TextField nSw2RodTxt = new TextField();
    TextField nSw2RodSTxt = new TextField();


    //Labels to name the text fields

    //basic version of four loads
    private Label mEdLoads = new Label("M_Ed");
    private Label nEdLoads = new Label("N_Ed");

    //extended version of four loads
    private Label nEdLoads1 = new Label("N_Ed");
    private Label mEdLoads1 = new Label("M_Ed");
    private Label loadsDesc1 = new Label("M_Ed_max");
    private Label loadsDesc2 = new Label("M_Ed_min");
    private Label loadsDesc3 = new Label("N_Ed_max");
    private Label loadsDesc4 = new Label("N_Ed_min");


    //extended version of four loads in diagnostic results
    private Label mRd1Label = new Label("0");
    private Label mRd2Label = new Label("0");
    private Label mRd3Label = new Label("0");
    private Label mRd4Label = new Label("0");
    private Label nRd1Label = new Label("0");
    private Label nRd2Label = new Label("0");
    private Label nRd3Label = new Label("0");
    private Label nRd4Label = new Label("0");

    private Label diagnosticRes1 = new Label("M_max");
    private Label diagnosticRes2 = new Label("M_min");
    private Label diagnosticRes3 = new Label("N_max");
    private Label diagnosticRes4 = new Label("N_min");


    //text field for materials could be replaced with choice box depending on check box
    private TextField concreteTxt = new TextField();


    // Grid panes used to make dynamic gui - while check box is marked it will rebuild some of the items

    @FXML
    GridPane gridPaneShearing = new GridPane();
    @FXML
    GridPane gridPaneSGU = new GridPane();
    @FXML
    GridPane gridPaneSGN = new GridPane();
    @FXML
    GridPane gridDimensions = new GridPane();
    @FXML
    GridPane gridLoads = new GridPane();

    @FXML
    ScrollPane scrollCalculations;

    // check boxes used to rebuild gui
    @FXML
    CheckBox checkBoxRods = new CheckBox();

    @FXML
    CheckBox checkBoxResults3 = new CheckBox();
    @FXML
    CheckBox checkBoxLoads = new CheckBox();
    @FXML
    CheckBox checkBoxConcrete = new CheckBox();

    //choice boxes to take data from

    @FXML
    ChoiceBox choiceBoxConcrete = new ChoiceBox();
    @FXML
    ChoiceBox choiceBoxLoads = new ChoiceBox();
    @FXML
    ChoiceBox choiceBoxCementClass = new ChoiceBox();


    @FXML
    VBox vBoxCenter = new VBox();

    @FXML
    TextField test1 = new TextField();

    //Diagnostic values

    @FXML
    Label resultsEd;
    @FXML
    Label resultsRd;

    @FXML
    TextField n1;

    @FXML
    TextField n2;

    @FXML
    TextField s1;

    //basic values for variables

    //static Values
    private float bValue = 0;
    private float hValue = 0;
    private double fYk = 0;
    private double aS1Value = 0;
    private double aS2Value = 0;
    private float a1Value = 0;
    private float a2Value = 0;
    private double vEdValue = 0;
    private double vEdRedValue = 0;
    private double ctgThetaValue = 0;
    private double alphaValue = 0;
    private double aSw1Value = 0;
    private double nSw1Value = 0;
    private double mEkValue = 0;
    private double mEkLtValue = 0;
    private double tZeroValue = 0;
    private double rHValue = 0;
    private double cNomValue = 0;
    private double lEffValue = 0;
    private double alphaMValue = 0;
    private double aSl = 0;

    //values which depends on check box

    private double fCk = 0;
    private float mEdValue = 0;
    private float nEdValue = 0;
    private float mEd1Value = 0;
    private float mEd2Value = 0;
    private float mEd3Value = 0;
    private float mEd4Value = 0;
    private float nEd1Value = 0;
    private float nEd2Value = 0;
    private float nEd3Value = 0;
    private float nEd4Value = 0;
    private double aSw2Value = 0;
    private double nSw2Value = 0;
    private float nSw2RodSValue = 0;
    private float bFValue = 0;
    private float bFTValue = 0;
    private float hFValue = 0;
    private float hFTValue = 0;

    //diagnostic values

    private float n1Value = 0;
    private float n2Value = 0;
    private float s1Value = 0;
    private float mRd1Value = 0;
    private float mRd2Value = 0;
    private float mRd3Value = 0;
    private float mRd4Value = 0;
    private float nRd1Value = 0;
    private float nRd2Value = 0;
    private float nRd3Value = 0;
    private float nRd4Value = 0;


    double resRods1Value;
    double resRods2Value;
    double resRods1ValueAsymmetric;
    double resRods2ValueAsymmetric;

    private Scene mainScene;


    public void initialize() {
        scrollCalculations.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        choiceBoxDimensions.setValue("Przekrój Prostokątny");


        checkBoxResults3.setSelected(false);
        checkBoxResults3.setTooltip(new Tooltip("Stan Graniczny Użytkowalności nie jest liczony dla przekrojów z siłą podłużną"));
        loadsInit();
        concreteInit();
        checkBoxConcrete.setSelected(true);
        choiceBoxConcrete.setValue("C30/37");
        choiceBoxConcrete.getItems().addAll("C12/15", "C16/20", "C20/25", "C25/30", "C30/37", "C35/45", "C40/50", "C45/55", "C50/60", "C55/67", "C60/75", "C70/85", "C80/95", "C90/105", "C100/115");

        choiceBoxLoads.setValue("Obciążenie długotrwałe");
        choiceBoxCementClass.setValue("Klasa N");

    }

    public void dimensionsChoice() {
        hFDimension.setPrefWidth(70);
        hFTDimension.setPrefWidth(70);
        bFDimension.setPrefWidth(70);
        bFTDimension.setPrefWidth(70);

        hFDimension.setPromptText("[cm]");
        hFTDimension.setPromptText("[cm]");
        bFDimension.setPromptText("[cm]");
        bFTDimension.setPromptText("[cm]");

        GridPane.setConstraints(hFDimensionLabel, 0, 4);
        GridPane.setConstraints(hFDimension, 1, 4);
        GridPane.setConstraints(bFDimensionLabel, 0, 5);
        GridPane.setConstraints(bFDimension, 1, 5);
        GridPane.setConstraints(hFTDimensionLabel, 0, 6);
        GridPane.setConstraints(hFTDimension, 1, 6);
        GridPane.setConstraints(bFTDimensionLabel, 0, 7);
        GridPane.setConstraints(bFTDimension, 1, 7);

        if (choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) {
            gridDimensions.getChildren().removeAll(hFDimensionLabel, hFDimension, bFDimension, bFDimensionLabel, hFTDimension, hFTDimensionLabel, bFTDimension, bFTDimensionLabel);
            checkBoxLoads.setDisable(false);

            nEdLoadsTxt.setDisable(false);

        } else {
            gridDimensions.getChildren().addAll(hFDimensionLabel, hFDimension, bFDimension, bFDimensionLabel, hFTDimension, hFTDimensionLabel, bFTDimension, bFTDimensionLabel);
            checkBoxLoads.setDisable(true);

            nEdLoadsTxt.setDisable(true);
            nEdLoadsTxt.setText("");

            if (checkBoxLoads.isSelected()) {
                gridLoads.getChildren().removeAll(mEdLoads1, loadsDesc1, loadsDesc2, loadsDesc3, loadsDesc4, mEdLoadsTxt1,
                        mEdLoadsTxt2, mEdLoadsTxt3, mEdLoadsTxt4, nEdLoads1, nEdLoadsTxt1, nEdLoadsTxt2,
                        nEdLoadsTxt3, nEdLoadsTxt4);

                gridLoads.getChildren().addAll(mEdLoads, mEdLoadsTxt, nEdLoads, nEdLoadsTxt);
                checkBoxLoads.setSelected(false);
            }
        }
    }

    public void checkBoxRod() {
        aSw2RodTxt.setPrefWidth(70);
        nSw2RodTxt.setPrefWidth(70);
        nSw2RodSTxt.setPrefWidth(40);
        aSw2RodTxt.setPromptText("[mm]");
        nSw2RodTxt.setPromptText("[szt]");
        nSw2RodSTxt.setPromptText("[cm]");

        if (checkBoxRods.isSelected()) {
            GridPane.setConstraints(aSw2Rod, 0, 3);
            GridPane.setConstraints(aSw2RodTxt, 1, 3);

            GridPane.setConstraints(nSw2Rod, 2, 3);
            GridPane.setConstraints(nSw2RodTxt, 3, 3);

            GridPane.setConstraints(nSw2RodS, 4, 3);
            GridPane.setConstraints(nSw2RodSTxt, 5, 3);

            gridPaneShearing.getChildren().addAll(aSw2Rod, nSw2Rod, aSw2RodTxt, nSw2RodTxt, nSw2RodS, nSw2RodSTxt);
        } else {

            gridPaneShearing.getChildren().removeAll(aSw2Rod, nSw2Rod, aSw2RodTxt, nSw2RodTxt, nSw2RodS, nSw2RodSTxt);
        }
    }

    public void fourLoads() {
        if (checkBoxLoads.isSelected()) {

            mEdLoadsTxt1.setPrefWidth(70);
            mEdLoadsTxt2.setPrefWidth(70);
            mEdLoadsTxt3.setPrefWidth(70);
            mEdLoadsTxt4.setPrefWidth(70);

            nEdLoadsTxt1.setPrefWidth(70);
            nEdLoadsTxt2.setPrefWidth(70);
            nEdLoadsTxt3.setPrefWidth(70);
            nEdLoadsTxt4.setPrefWidth(70);

            mEdLoadsTxt1.setPromptText("[kNm]");
            mEdLoadsTxt2.setPromptText("[kNm]");
            mEdLoadsTxt3.setPromptText("[kNm]");
            mEdLoadsTxt4.setPromptText("[kNm]");

            nEdLoadsTxt1.setPromptText("[kN]");
            nEdLoadsTxt2.setPromptText("[kN]");
            nEdLoadsTxt3.setPromptText("[kN]");
            nEdLoadsTxt4.setPromptText("[kN]");

            GridPane.setConstraints(loadsDesc1, 1, 3);
            GridPane.setConstraints(loadsDesc2, 2, 3);
            GridPane.setConstraints(loadsDesc3, 3, 3);
            GridPane.setConstraints(loadsDesc4, 4, 3);

            GridPane.setConstraints(mEdLoads1, 0, 4);
            GridPane.setConstraints(mEdLoadsTxt1, 1, 4);
            GridPane.setConstraints(mEdLoadsTxt2, 2, 4);
            GridPane.setConstraints(mEdLoadsTxt3, 3, 4);
            GridPane.setConstraints(mEdLoadsTxt4, 4, 4);

            GridPane.setConstraints(nEdLoads1, 0, 5);
            GridPane.setConstraints(nEdLoadsTxt1, 1, 5);
            GridPane.setConstraints(nEdLoadsTxt2, 2, 5);
            GridPane.setConstraints(nEdLoadsTxt3, 3, 5);
            GridPane.setConstraints(nEdLoadsTxt4, 4, 5);


            gridLoads.getChildren().removeAll(mEdLoads, mEdLoadsTxt, nEdLoads, nEdLoadsTxt);
            gridLoads.getChildren().addAll(mEdLoads1, loadsDesc1, loadsDesc2, loadsDesc3, loadsDesc4, mEdLoadsTxt1, mEdLoadsTxt2,
                    mEdLoadsTxt3, mEdLoadsTxt4, nEdLoads1, nEdLoadsTxt1, nEdLoadsTxt2,
                    nEdLoadsTxt3, nEdLoadsTxt4);


        } else {
            loadsInit();
        }
    }

    private void loadsInit() {
        mEdLoadsTxt.setPrefWidth(70);
        nEdLoadsTxt.setPrefWidth(70);

        mEdLoadsTxt.setPromptText("[kNm]");
        nEdLoadsTxt.setPromptText("[kN]");

        GridPane.setConstraints(mEdLoads, 0, 3);
        GridPane.setConstraints(mEdLoadsTxt, 1, 3);

        GridPane.setConstraints(nEdLoads, 0, 4);
        GridPane.setConstraints(nEdLoadsTxt, 1, 4);

        gridLoads.getChildren().removeAll(mEdLoads1, loadsDesc1, loadsDesc2, loadsDesc3, loadsDesc4, mEdLoadsTxt1,
                mEdLoadsTxt2, mEdLoadsTxt3, mEdLoadsTxt4, nEdLoads1, nEdLoadsTxt1, nEdLoadsTxt2,
                nEdLoadsTxt3, nEdLoadsTxt4);

        gridLoads.getChildren().addAll(mEdLoads, mEdLoadsTxt, nEdLoads, nEdLoadsTxt);
    }

    public void changingConcrete() {
        if (checkBoxConcrete.isSelected()) {

            concreteInit();
            choiceBoxConcrete.setValue("C30/37");

        } else {

            concreteTxt.setPrefWidth(70);
            concreteTxt.setPromptText("[MPa]");
            GridPane.setConstraints(concreteTxt, 4, 1);
            gridDimensions.getChildren().remove(choiceBoxConcrete);
            gridDimensions.getChildren().add(concreteTxt);
        }

    }

    private void concreteInit() {
        choiceBoxConcrete.setPrefWidth(70);


        GridPane.setConstraints(choiceBoxConcrete, 4, 1);
        gridDimensions.getChildren().remove(concreteTxt);
        gridDimensions.getChildren().add(choiceBoxConcrete);
    }

    public void bottomButtonsController() { //todo delete some code, cause of checkboxes are deleted

        if (checkBoxResults3.isSelected()) {
            gridPaneSGU.setDisable(false);
        } else {
            gridPaneSGU.setDisable(true);
        }

    }

    public void fourLoadsResults() {
        gridResultsController();
        fourLoads();
    }

    private void gridResultsController() {
        if (checkBoxLoads.isSelected()) {


            GridPane.setConstraints(diagnosticRes1, 1, 0);
            GridPane.setConstraints(diagnosticRes2, 2, 0);
            GridPane.setConstraints(diagnosticRes3, 3, 0);
            GridPane.setConstraints(diagnosticRes4, 4, 0);

            GridPane.setConstraints(mRd1Label, 1, 1);
            GridPane.setConstraints(mRd2Label, 2, 1);
            GridPane.setConstraints(mRd3Label, 3, 1);
            GridPane.setConstraints(mRd4Label, 4, 1);

            GridPane.setConstraints(nRd1Label, 1, 2);
            GridPane.setConstraints(nRd2Label, 2, 2);
            GridPane.setConstraints(nRd3Label, 3, 2);
            GridPane.setConstraints(nRd4Label, 4, 2);

            gridResults.getChildren().removeAll(res1, res1true, res2, res2true, resultsEd, resultsRd);

            gridResults.getChildren().addAll(mRd1Label, mRd2Label, mRd3Label, mRd4Label, nRd1Label, nRd2Label, nRd3Label, nRd4Label, diagnosticRes1, diagnosticRes2, diagnosticRes3, diagnosticRes4);

        } else {
            gridResults.getChildren().addAll(res1, res1true, res2, res2true, resultsEd, resultsRd);
            gridResults.getChildren().removeAll(mRd1Label, mRd2Label, mRd3Label, mRd4Label, nRd1Label, nRd2Label, nRd3Label, nRd4Label, diagnosticRes1, diagnosticRes2, diagnosticRes3, diagnosticRes4);
        }
    }


    //Functionality, calculations and returning correct value
    private static float getDataFromTextField(TextField specificTextField, String variable) {
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

    private static float getDataFromTextFieldForces(TextField specificTextField, String variable) {
        try {
            if (specificTextField.getText().isEmpty()) {
                specificTextField.setText(String.valueOf(0));
            }

            return Float.parseFloat(specificTextField.getText().replaceAll(",", "."));

        } catch (NumberFormatException e) {
            AlertBox.display("Błąd", "Wartość " + variable + " powinna być liczbą");
            return 0;

        }
    }

    private void fCk() {
        if (checkBoxConcrete.isSelected()) {
            double[] concreteList = {12, 16, 20, 25, 30, 25, 40, 45, 50, 55, 60, 70, 80, 90, 100};
            fCk = concreteList[choiceBoxConcrete.getSelectionModel().getSelectedIndex()];
        } else {
            fCk = getDataFromTextField(concreteTxt, "f_Ck");
        }
    }

    private void fYk() {
        fYk = getDataFromTextField(steelFYk, "f_Yk");
    }

    private void dimension() {

        bValue = (float) (getDataFromTextField(test1, "b") * Math.pow(10, -2));
        hValue = (float) (getDataFromTextField(geometryHeight, "h") * Math.pow(10, -2));
        if (choiceBoxDimensions.getValue().toString().equals("Przekrój Teowy")) {
            bFValue = (float) (getDataFromTextField(bFDimension, "b_f") * Math.pow(10, -2));
            bFTValue = (float) (getDataFromTextField(bFTDimension, "b_f,t") * Math.pow(10, -2));
            hFValue = (float) (getDataFromTextField(hFDimension, "h_f") * Math.pow(10, -2));
            hFTValue = (float) (getDataFromTextField(hFTDimension, "h_f,t") * Math.pow(10, -2));
        }

    }

    private void longitudinalReinforcement() {
        aS1Value = getDataFromTextField(aS1, "a_S1") * Math.pow(10, -3);
        aS2Value = getDataFromTextField(aS2, "a_S2") * Math.pow(10, -3);
        a1Value = (float) (getDataFromTextField(a1, "a_1") * Math.pow(10, -3));
        a2Value = (float) (getDataFromTextField(a2, "a_2") * Math.pow(10, -3));
    }

    private void shearingValues() {
        vEdValue = getDataFromTextField(vEd, "V_Ed") * Math.pow(10, -3);
        vEdRedValue = getDataFromTextField(vEdRed, "V_EdRed") * Math.pow(10, -3);
        ctgThetaValue = getDataFromTextField(ctgTheta, "ctg_theta");
        alphaValue = getDataFromTextField(alpha, "alpha");
        aSl = getDataFromTextField(aSlTxt, "A_sl");

        aSw1Value = getDataFromTextField(aSw1, "a_Sw1") * Math.pow(10, -3);
        nSw1Value = getDataFromTextField(nSw1, "n_sw1");

        if (checkBoxRods.isSelected()) {
            aSw2Value = getDataFromTextField(aSw2RodTxt, "a_Sw2") * Math.pow(10, -4);
            nSw2Value = getDataFromTextField(nSw2RodTxt, "n_sw2");
            nSw2RodSValue = (float) (getDataFromTextField(nSw2RodSTxt, "s_sw2") * Math.pow(10, -2));
        }
    }

    private void forcesValues() {
        if (checkBoxLoads.isSelected()) {

            mEd1Value = (float) (getDataFromTextFieldForces(mEdLoadsTxt1, "M_Ed1") * Math.pow(10, -3));
            mEd2Value = (float) (getDataFromTextFieldForces(mEdLoadsTxt2, "M_Ed2") * Math.pow(10, -3));
            mEd3Value = (float) (getDataFromTextFieldForces(mEdLoadsTxt3, "M_Ed3") * Math.pow(10, -3));
            mEd4Value = (float) (getDataFromTextFieldForces(mEdLoadsTxt4, "M_Ed4") * Math.pow(10, -3));

            nEd1Value = (float) (getDataFromTextFieldForces(nEdLoadsTxt1, "N_Ed1") * Math.pow(10, -3));
            nEd2Value = (float) (getDataFromTextFieldForces(nEdLoadsTxt2, "N_Ed2") * Math.pow(10, -3));
            nEd3Value = (float) (getDataFromTextFieldForces(nEdLoadsTxt3, "N_Ed3") * Math.pow(10, -3));
            nEd4Value = (float) (getDataFromTextFieldForces(nEdLoadsTxt4, "N_Ed4") * Math.pow(10, -3));

        } else {
            mEdValue = (float) (getDataFromTextFieldForces(mEdLoadsTxt, "M_Ed") * Math.pow(10, -3));
            nEdValue = (float) (getDataFromTextFieldForces(nEdLoadsTxt, "N_Ed") * Math.pow(10, -3));

        }
    }

    public void setDefaults() {
        geometryHeight.setText(String.valueOf(60));
        test1.setText(String.valueOf(30));
        steelFYk.setText(String.valueOf(500));
        aS1.setText(String.valueOf(16));
        aS2.setText(String.valueOf(16));
        a1.setText(String.valueOf(50));
        a2.setText(String.valueOf(50));

        ctgTheta.setText(String.valueOf(2));
        alpha.setText(String.valueOf(45));
        aSw1.setText(String.valueOf(8));
        nSw1.setText(String.valueOf(2));

        tZero.setText(String.valueOf(28));
        alphaM.setText("0.104");
        lEff.setText("6.0");
        rH.setText("50");
        cNom.setText("30");
    }

    private double reinforcementRods(double resultsToRods, double resultTheoretical) {
        double res = Math.ceil(resultsToRods / (Math.pow(resultTheoretical * 0.5, 2) * Math.PI));
        System.out.println(res);
        return res;
    }

    private double roundTwoDigit(double toRound) {
        return Math.round(toRound * 100.00) / 100D;
    }

    private double roundThreeDigitShearing(double toRound) {
        return Math.round(toRound * 1000.00) / 1000D;
    }

    private double roundThreeDigitShearingReal(double toRound) {
        return Math.floor(toRound * 100.00) / 100D;
    }

    public void vEdRedText() {
        vEdRed.setText(String.valueOf(vEd.getText()));
    }


    public void calculations() {
        fCk();
        fYk();
        dimension();
        forcesValues();
        longitudinalReinforcement();

        if (!checkBoxLoads.isSelected() && choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) {
            if (nEdValue == 0) {
                BendingBeamRectangle beam = new BendingBeamRectangle(mEdValue, fCk, fYk, hValue, bValue, a1Value, a2Value);
                double[] ress = beam.resultsBendingBeamRectangle();
                System.out.println(Arrays.toString(ress));

                res1Asymmetric.setText(String.valueOf(roundTwoDigit(ress[0] * Math.pow(10, 4))));
                res2Asymmetric.setText(String.valueOf(roundTwoDigit(ress[1] * Math.pow(10, 4))));

                resRods1ValueAsymmetric = reinforcementRods(ress[0], aS1Value);
                resRods2ValueAsymmetric = reinforcementRods(ress[1], aS2Value);

                resRods1Asymmetric.setText(String.valueOf(resRods1ValueAsymmetric));
                resRods2Asymmetric.setText(String.valueOf(resRods2ValueAsymmetric));

                res1trueAsymmetric.setText(String.valueOf(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4))));
                res2trueAsymmetric.setText(String.valueOf(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4))));

                res1.setText("0");
                res2.setText("0");

                resRods1.setText("0");
                resRods2.setText("0");

                res1true.setText("0");
                res2true.setText("0");


            } else {
                if (nEdValue > 0) {
                    CompressionSymmetricReinforcement beam1 = new CompressionSymmetricReinforcement(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value);
                    double[] results1 = beam1.resultsCompressionSymmetricReinforcement();

                    res1.setText(String.valueOf(roundTwoDigit(results1[0] * Math.pow(10, 4))));
                    res2.setText(String.valueOf(roundTwoDigit(results1[1] * Math.pow(10, 4))));

                    resRods1Value = reinforcementRods(results1[0], aS1Value);
                    resRods2Value = reinforcementRods(results1[1], aS2Value);

                    resRods1.setText(String.valueOf(resRods1Value));
                    resRods2.setText(String.valueOf(resRods2Value));

                    res1true.setText(String.valueOf(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4))));
                    res2true.setText(String.valueOf(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4))));

                    //asymmetric

                    CompressionAsymmetricReinforcement beam2 = new CompressionAsymmetricReinforcement(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value);
                    double[] results2 = beam2.resultsCompressionAsymmetricReinforcement();

                    res1Asymmetric.setText(String.valueOf(roundTwoDigit(results2[0] * Math.pow(10, 4))));
                    res2Asymmetric.setText(String.valueOf(roundTwoDigit(results2[1] * Math.pow(10, 4))));

                    resRods1ValueAsymmetric = reinforcementRods(results2[0], aS1Value);
                    resRods2ValueAsymmetric = reinforcementRods(results2[1], aS2Value);

                    resRods1Asymmetric.setText(String.valueOf(resRods1ValueAsymmetric));
                    resRods2Asymmetric.setText(String.valueOf(resRods2ValueAsymmetric));

                    res1trueAsymmetric.setText(String.valueOf(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4))));
                    res2trueAsymmetric.setText(String.valueOf(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4))));


                } else {
                    ExtensionSymmetricReinforcement beam1 = new ExtensionSymmetricReinforcement(-nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value);
                    double[] results1 = beam1.resultsExtensionSymmetric();
                    res1.setText(String.valueOf(roundTwoDigit(results1[0] * Math.pow(10, 4))));
                    res2.setText(String.valueOf(roundTwoDigit(results1[1] * Math.pow(10, 4))));

                    resRods1Value = reinforcementRods(results1[0], aS1Value);
                    resRods2Value = reinforcementRods(results1[1], aS2Value);

                    resRods1.setText(String.valueOf(resRods1Value));
                    resRods2.setText(String.valueOf(resRods2Value));

                    res1true.setText(String.valueOf(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4))));
                    res2true.setText(String.valueOf(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4))));

                    //asymmetric

                    ExtensionAsymmetricReinforcement beam2 = new ExtensionAsymmetricReinforcement(-nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value);
                    double[] results2 = beam2.resultsExtensionAsymmetric();

                    res1Asymmetric.setText(String.valueOf(roundTwoDigit(results2[0] * Math.pow(10, 4))));
                    res2Asymmetric.setText(String.valueOf(roundTwoDigit(results2[1] * Math.pow(10, 4))));

                    resRods1ValueAsymmetric = reinforcementRods(results2[0], aS1Value);
                    resRods2ValueAsymmetric = reinforcementRods(results2[1], aS2Value);

                    resRods1Asymmetric.setText(String.valueOf(resRods1ValueAsymmetric));
                    resRods2Asymmetric.setText(String.valueOf(resRods2ValueAsymmetric));

                    res1trueAsymmetric.setText(String.valueOf(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4))));
                    res2trueAsymmetric.setText(String.valueOf(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4))));

                }
            }
        } else if (choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) {
            System.out.println(nEd1Value);
            System.out.println(mEd1Value);

            double[] results1;
            double[] results2;
            double[] results3;
            double[] results4;

            double[] results1Asymmetric;
            double[] results2Asymmetric;
            double[] results3Asymmetric;
            double[] results4Asymmetric;

            if (nEd1Value > 0) {

                CompressionSymmetricReinforcement beam1 = new CompressionSymmetricReinforcement(nEd1Value, mEd1Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results1 = beam1.resultsCompressionSymmetricReinforcement();
                System.out.println(Arrays.toString(results1));

                CompressionAsymmetricReinforcement beam1Asymmetric = new CompressionAsymmetricReinforcement(nEd1Value, mEd1Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results1Asymmetric = beam1Asymmetric.resultsCompressionAsymmetricReinforcement();

            } else {
                ExtensionSymmetricReinforcement beam1 = new ExtensionSymmetricReinforcement(-nEd1Value, mEd1Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results1 = beam1.resultsExtensionSymmetric();
                System.out.println(Arrays.toString(results1));

                ExtensionAsymmetricReinforcement beam1Asymmetric = new ExtensionAsymmetricReinforcement(-nEd1Value, mEd1Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results1Asymmetric = beam1Asymmetric.resultsExtensionAsymmetric();
            }

            if (nEd2Value > 0) {

                CompressionSymmetricReinforcement beam2 = new CompressionSymmetricReinforcement(nEd2Value, mEd2Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results2 = beam2.resultsCompressionSymmetricReinforcement();
                System.out.println(Arrays.toString(results2));

                CompressionAsymmetricReinforcement beam2Asymmetric = new CompressionAsymmetricReinforcement(nEd2Value, mEd2Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results2Asymmetric = beam2Asymmetric.resultsCompressionAsymmetricReinforcement();

            } else {
                ExtensionSymmetricReinforcement beam2 = new ExtensionSymmetricReinforcement(-nEd2Value, mEd2Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results2 = beam2.resultsExtensionSymmetric();
                System.out.println(Arrays.toString(results2));

                ExtensionAsymmetricReinforcement beam2Asymmetric = new ExtensionAsymmetricReinforcement(-nEd2Value, mEd2Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results2Asymmetric = beam2Asymmetric.resultsExtensionAsymmetric();
            }

            if (nEd3Value > 0) {

                CompressionSymmetricReinforcement beam3 = new CompressionSymmetricReinforcement(nEd3Value, mEd3Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results3 = beam3.resultsCompressionSymmetricReinforcement();
                System.out.println(Arrays.toString(results3));

                CompressionAsymmetricReinforcement beam3Asymmetric = new CompressionAsymmetricReinforcement(nEd3Value, mEd3Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results3Asymmetric = beam3Asymmetric.resultsCompressionAsymmetricReinforcement();

            } else {
                ExtensionSymmetricReinforcement beam3 = new ExtensionSymmetricReinforcement(-nEd3Value, mEd3Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results3 = beam3.resultsExtensionSymmetric();
                System.out.println(Arrays.toString(results3));

                ExtensionAsymmetricReinforcement beam3Asymmetric = new ExtensionAsymmetricReinforcement(-nEd3Value, mEd3Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results3Asymmetric = beam3Asymmetric.resultsExtensionAsymmetric();
            }

            if (nEd4Value > 0) {

                CompressionSymmetricReinforcement beam4 = new CompressionSymmetricReinforcement(nEd4Value, mEd4Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results4 = beam4.resultsCompressionSymmetricReinforcement();
                System.out.println(Arrays.toString(results4));

                CompressionAsymmetricReinforcement beam4Asymmetric = new CompressionAsymmetricReinforcement(nEd4Value, mEd4Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results4Asymmetric = beam4Asymmetric.resultsCompressionAsymmetricReinforcement();

            } else {
                ExtensionSymmetricReinforcement beam4 = new ExtensionSymmetricReinforcement(-nEd4Value, mEd4Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results4 = beam4.resultsExtensionSymmetric();
                System.out.println(Arrays.toString(results4));

                ExtensionAsymmetricReinforcement beam4Asymmetric = new ExtensionAsymmetricReinforcement(-nEd4Value, mEd4Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
                results4Asymmetric = beam4Asymmetric.resultsExtensionAsymmetric();
            }

            res1.setText(String.valueOf(roundTwoDigit(Math.max(Math.max(Math.max(results1[0], results2[0]), results3[0]), results4[0]) * Math.pow(10, 4))));
            res2.setText(String.valueOf(roundTwoDigit(Math.max(Math.max(Math.max(results1[1], results2[1]), results3[1]), results4[1]) * Math.pow(10, 4))));

            resRods1Value = reinforcementRods(Math.max(Math.max(Math.max(results1[0], results2[0]), results3[0]), results4[0]), aS1Value);
            resRods2Value = reinforcementRods(Math.max(Math.max(Math.max(results1[1], results2[1]), results3[1]), results4[1]), aS2Value);

            resRods1.setText(String.valueOf(resRods1Value));
            resRods2.setText(String.valueOf(resRods2Value));


            res1true.setText(String.valueOf(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4))));
            res2true.setText(String.valueOf(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4))));

            //asymmetric

            res1Asymmetric.setText(String.valueOf(roundTwoDigit(Math.max(Math.max(Math.max(results1Asymmetric[0], results2Asymmetric[0]), results3Asymmetric[0]), results4Asymmetric[0]) * Math.pow(10, 4))));
            res2Asymmetric.setText(String.valueOf(roundTwoDigit(Math.max(Math.max(Math.max(results1Asymmetric[1], results2Asymmetric[1]), results3Asymmetric[1]), results4Asymmetric[1]) * Math.pow(10, 4))));

            resRods1ValueAsymmetric = reinforcementRods(results2Asymmetric[0], aS1Value);
            resRods2ValueAsymmetric = reinforcementRods(results2Asymmetric[1], aS2Value);

            resRods1Asymmetric.setText(String.valueOf(resRods1ValueAsymmetric));
            resRods2Asymmetric.setText(String.valueOf(resRods2ValueAsymmetric));

            res1trueAsymmetric.setText(String.valueOf(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4))));
            res2trueAsymmetric.setText(String.valueOf(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4))));

        }

        //Shearing Calculations

        shearingValues();
        if (checkBoxRods.isSelected()) {
            ShearingBendRods shearing = new ShearingBendRods(hValue, a1Value, bValue, fCk, nEdValue, aSl, nSw1Value, nSw2Value, aSw1Value, aS2Value, fYk, vEdRedValue, vEdValue, nSw2RodSValue, ctgThetaValue, alphaValue);
            double res = shearing.resultShearingStirrups();
            System.out.println(res);
            sRods.setText(String.valueOf(roundThreeDigitShearing(res)));

            sRodsReal.setText(String.valueOf(roundThreeDigitShearingReal(res)));
        } else {

            ShearingStirrups shearing = new ShearingStirrups(hValue, bValue, a1Value, fCk, fYk, nEdValue, vEdValue, vEdRedValue, aSl, nSw1Value, aSw1Value, ctgThetaValue); //TODO ASL ISN'T just a dimension! cm^2, not mm
            double res = shearing.resultShearingStirrups();
            System.out.println(res);

            sRods.setText(String.valueOf(roundThreeDigitShearing(res)));

            sRodsReal.setText(String.valueOf(roundThreeDigitShearingReal(res)));
        }


        //tBeam


        if (choiceBoxDimensions.getValue().toString().equals("Przekrój Teowy")) {
            BendingBeamT beam = new BendingBeamT(mEdValue, fCk, fYk, bValue, 2 * bFValue + bValue, hValue, hFValue, a1Value, a2Value);
            double[] ress = beam.resultsBendingT();
            System.out.println(Arrays.toString(ress));

            res1Asymmetric.setText(String.valueOf(roundTwoDigit(ress[0] * Math.pow(10, 4))));
            res2Asymmetric.setText(String.valueOf(roundTwoDigit(ress[1] * Math.pow(10, 4))));

            resRods1ValueAsymmetric = reinforcementRods(ress[0], aS1Value);
            resRods2ValueAsymmetric = reinforcementRods(ress[1], aS2Value);

            resRods1Asymmetric.setText(String.valueOf(resRods1Value));
            resRods2Asymmetric.setText(String.valueOf(resRods2Value));

            res1trueAsymmetric.setText(String.valueOf(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4))));
            res2trueAsymmetric.setText(String.valueOf(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4))));

            res1.setText("0");
            res2.setText("0");

            resRods1.setText("0");
            resRods2.setText("0");

            res1true.setText("0");
            res2true.setText("0");
        }

        data = new HashMap<>();

        data.put("mEd", roundTwoDigit(mEdValue * 1000));
        data.put("nEd", roundTwoDigit(nEdValue * 1000));
        data.put("hValue", roundTwoDigit(hValue * 100));
        data.put("bValue", roundTwoDigit(bValue * 100));
        data.put("fYk", roundTwoDigit(fYk));
        data.put("fiS1", roundTwoDigit(aS1Value * 1000));
        data.put("fiS2", roundTwoDigit(aS2Value * 1000));
        data.put("a1", roundTwoDigit(a1Value * 1000));
        data.put("a2", roundTwoDigit(a2Value * 1000));
        data.put("ns1", resRods1ValueAsymmetric);
        data.put("ns2", resRods2ValueAsymmetric);

        data.put("vEd", roundTwoDigit(vEdValue * 1000));
        data.put("vEdRed", roundTwoDigit(vEdRedValue * 1000));
        data.put("ctg", roundTwoDigit(ctgThetaValue));
        data.put("alpha", roundTwoDigit(alphaValue));
        data.put("aSl", roundTwoDigit(aSl));
        data.put("aSw1", roundTwoDigit(aSw1Value));
        data.put("aSw2", roundTwoDigit(aSw2Value));
        data.put("nSw1", roundTwoDigit(nSw1Value));
        data.put("nSw2", roundTwoDigit(nSw2Value));
        data.put("sSw2", roundTwoDigit(nSw2RodSValue));


        if (checkBoxResults3.isSelected()) {
            double bEff = bFValue * 2 + bValue;
            double bEffT = bFTValue * 2 + bValue;

            float fiSt = 0.008f;
            char cementChar = 'N';
            double mEdkValue = 200;
            double mEdKLtValue = 200;
            double eCmValue = 200;
            char alphaChar = 'A'; //todo change
            double fCtmValue = 20;
            int eSValue = 20;
            char loadLong = 'L';


        }

        toPdfButton.setDisable(false);

    }

    private void diagnosticValues() {

        n1Value = getDataFromTextFieldForces(n1, "n_1");
        n2Value = getDataFromTextFieldForces(n2, "n_2");
        s1Value = (float) (getDataFromTextFieldForces(s1, "s_1") * Math.pow(10, -2));
    }


    public void diagnostic() {

        System.out.println();
        fCk();
        fYk();
        dimension();
        forcesValues();
        longitudinalReinforcement();
        diagnosticValues();


        double aS1ValueDiagnostic = Math.pow(aS1Value * 0.5, 2) * Math.PI * n1Value;
        double aS2ValueDiagnostic = Math.pow(aS2Value * 0.5, 2) * Math.PI * n2Value;


        if (!checkBoxLoads.isSelected() && choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) {
            if (nEdValue == 0) {
                DiagnosticBendingBeamAndT beam = new DiagnosticBendingBeamAndT(fCk, fYk, bValue, bValue, hValue, 0, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                double ress = beam.resultDiagnostic();
                System.out.println(ress);

                res1.setText(String.valueOf(roundTwoDigit(ress * Math.pow(10, 3))));
                res1true.setText(String.valueOf(roundTwoDigit(mEdValue * Math.pow(10, 3))));

                res2.setText(String.valueOf(0));
                res2true.setText(String.valueOf(0));


            } else {
                if (nEdValue > 0) {
                    DiagnosticCompression beam1 = new DiagnosticCompression(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                    double[] results1 = beam1.resultsDiagnosticCompression();
                    res1.setText(String.valueOf(roundTwoDigit(results1[1] * Math.pow(10, 3))));
                    res2.setText(String.valueOf(roundTwoDigit(results1[0] * Math.pow(10, 3))));

                    res1true.setText(String.valueOf(roundTwoDigit(mEdValue * Math.pow(10, 3))));
                    res2true.setText(String.valueOf(roundTwoDigit(nEdValue * Math.pow(10, 3))));

                } else {
                    DiagnosticExtension beam1 = new DiagnosticExtension(-nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                    double[] results1 = beam1.resultsDiagnosticExtension();
                    res1.setText(String.valueOf(roundTwoDigit(results1[1] * Math.pow(10, 3))));
                    res2.setText(String.valueOf(roundTwoDigit(results1[0] * Math.pow(10, 3))));

                    res1true.setText(String.valueOf(roundTwoDigit(mEdValue * Math.pow(10, 3))));
                    res2true.setText(String.valueOf(roundTwoDigit(nEdValue * Math.pow(10, 3))));

                }
            }
        } else if (choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) {
            System.out.println(nEd1Value); //todo add extension!
            System.out.println(mEd1Value);

            double[] results1;
            double[] results2;
            double[] results3;
            double[] results4;

            if (nEd1Value > 0) {
                DiagnosticCompression beam1 = new DiagnosticCompression(nEd1Value, mEd1Value, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                results1 = beam1.resultsDiagnosticCompression();
                System.out.println(Arrays.toString(results1));
            } else {
                DiagnosticExtension beam1 = new DiagnosticExtension(-nEd1Value, mEd1Value, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                results1 = beam1.resultsDiagnosticExtension();
                System.out.println(Arrays.toString(results1));
            }

            if (nEd2Value > 0) {

                DiagnosticCompression beam2 = new DiagnosticCompression(nEd2Value, mEd2Value, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                results2 = beam2.resultsDiagnosticCompression();
                System.out.println(Arrays.toString(results2));
            } else {
                DiagnosticExtension beam2 = new DiagnosticExtension(-nEd2Value, mEd2Value, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                results2 = beam2.resultsDiagnosticExtension();
                System.out.println(Arrays.toString(results2));
            }

            if (nEd3Value > 0) {

                DiagnosticCompression beam3 = new DiagnosticCompression(nEd3Value, mEd3Value, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                results3 = beam3.resultsDiagnosticCompression();
                System.out.println(Arrays.toString(results3));
            } else {
                DiagnosticExtension beam3 = new DiagnosticExtension(-nEd3Value, mEd3Value, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                results3 = beam3.resultsDiagnosticExtension();
                System.out.println(Arrays.toString(results3));
            }

            if (nEd4Value > 0) {

                DiagnosticCompression beam4 = new DiagnosticCompression(nEd4Value, mEd4Value, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                results4 = beam4.resultsDiagnosticCompression();
                System.out.println(Arrays.toString(results4));

            } else {
                DiagnosticExtension beam4 = new DiagnosticExtension(-nEd4Value, mEd4Value, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                results4 = beam4.resultsDiagnosticExtension();
                System.out.println(Arrays.toString(results4));
            }


            mRd1Label.setText(String.valueOf(roundTwoDigit(results1[1] * Math.pow(10, 3))));
            mRd2Label.setText(String.valueOf(roundTwoDigit(results2[1] * Math.pow(10, 3))));
            mRd3Label.setText(String.valueOf(roundTwoDigit(results3[1] * Math.pow(10, 3))));
            mRd4Label.setText(String.valueOf(roundTwoDigit(results4[1] * Math.pow(10, 3))));

            nRd1Label.setText(String.valueOf(roundTwoDigit(results1[0] * Math.pow(10, 3))));
            nRd2Label.setText(String.valueOf(roundTwoDigit(results2[0] * Math.pow(10, 3))));
            nRd3Label.setText(String.valueOf(roundTwoDigit(results3[0] * Math.pow(10, 3))));
            nRd4Label.setText(String.valueOf(roundTwoDigit(results4[0] * Math.pow(10, 3))));


        }

        //Shearing Calculations

        shearingValues();

        DiagnosticShearing shearing = new DiagnosticShearing(hValue, a1Value, bValue, fCk, nEdValue, aSl, nSw1Value, nSw2Value, aSw1Value, aS2Value, fYk, vEdRedValue, vEdValue, nSw2RodSValue, s1Value, ctgThetaValue, alphaValue);
        double res = shearing.resultsShearingDiagnostic();
        System.out.println(res);
        sRods.setText(String.valueOf(roundThreeDigitShearing(res * Math.pow(10, 3))));


        //tBeam


        if (choiceBoxDimensions.getValue().toString().equals("Przekrój Teowy")) {
            DiagnosticBendingBeamAndT beam = new DiagnosticBendingBeamAndT(fCk, fYk, bValue, 2 * bFValue + bValue, hValue, hFValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
            double ress = beam.resultDiagnostic();
            System.out.println(ress);

            res1.setText(String.valueOf(roundTwoDigit(ress * Math.pow(10, 3))));
            res1true.setText(String.valueOf(roundTwoDigit(mEdValue * Math.pow(10, 3))));

            res2.setText(String.valueOf(0));
            res2true.setText(String.valueOf(0));
        }

        toPdfButton.setDisable(false);
    }

    public void toPdf() throws IOException {
        System.out.println("toPDF");

        NamePDF stringPdf = new NamePDF();

        String fileName = stringPdf.display();
        if (!fileName.isEmpty()) {
            PrintPDF.print(fileName, fYk);
        }

    }
}
