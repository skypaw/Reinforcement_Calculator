package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pl.pawz.zelbet.Diagnostic.DiagnosticBendingBeamAndT;
import pl.pawz.zelbet.Diagnostic.DiagnosticCompression;
import pl.pawz.zelbet.Diagnostic.DiagnosticExtension;
import pl.pawz.zelbet.Diagnostic.DiagnosticShearing;
import pl.pawz.zelbet.SLS.Deflection;
import pl.pawz.zelbet.SLS.Scratch;
import pl.pawz.zelbet.ULS.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class SubController {

    public HashMap<String, Double> data;
    public HashMap<String, String> dataString;

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


    //SGU RESULTS

    @FXML
    Label wRes;
    @FXML
    Label wResTrue;
    @FXML
    Label fMRes;
    @FXML
    Label fMResTrue;
    @FXML
    Label fMPlusCRes;
    @FXML
    Label fMPlusCResTrue;

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
    TextField bFDimension = new TextField();
    TextField hFDimension = new TextField();
    TextField bFTDimension = new TextField();
    TextField hFTDimension = new TextField();
    private Label bFDimensionLabel = new Label("b_eff");
    private Label hFDimensionLabel = new Label("h_f");
    private Label bFTDimensionLabel = new Label("b_eff,t");
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
    private double bValue = 0;
    private double hValue = 0;
    private double fYk = 0;
    private double aS1Value = 0;
    private double aS2Value = 0;
    private double a1Value = 0;
    private double a2Value = 0;
    private double vEdValue = 0;
    private double vEdRedValue = 0;
    private double ctgThetaValue = 0;
    private double alphaValue = 0;
    private double aSw1Value = 0;
    private double nSw1Value = 0;
    private double mEkValue = 0;
    private double mEkLtValue = 0;
    private int tZeroValue = 0;
    private double rHValue = 0;
    private double cNomValue = 0;
    private double lEffValue = 0;
    private double alphaMValue = 0;
    private double aSl = 0;

    //values which depends on check box

    double fCk = 0;
    private double mEdValue = 0;
    private double nEdValue = 0;
    private double mEd1Value = 0;
    private double mEd2Value = 0;
    private double mEd3Value = 0;
    private double mEd4Value = 0;
    private double nEd1Value = 0;
    private double nEd2Value = 0;
    private double nEd3Value = 0;
    private double nEd4Value = 0;
    private double aSw2Value = 0;
    private double nSw2Value = 0;
    private double nSw2RodSValue = 0;
    private double bFValue = 0;
    private double bFTValue = 0;
    private double hFValue = 0;
    private double hFTValue = 0;

    //diagnostic values

    private double n1Value = 0;
    private double n2Value = 0;
    private double s1Value = 0;
    private double mRd1Value = 0;
    private double mRd2Value = 0;
    private double mRd3Value = 0;
    private double mRd4Value = 0;
    private double nRd1Value = 0;
    private double nRd2Value = 0;
    private double nRd3Value = 0;
    private double nRd4Value = 0;

    private char loadChar;
    private char cementChar;


    private double resRods1Value = 0;
    private double resRods2Value = 0;
    private double resRods1ValueAsymmetric = 0;
    private double resRods2ValueAsymmetric = 0;
    private double wResVar = 0;
    private double fMPlusCResVar = 0;
    private double fMResVar = 0;
    private double fCsVar = 0;

    private double res1AsymmetricVar = 0;
    private double res2AsymmetricVar = 0;
    private double resShearing = 0;
    private double res1trueAsymmetricVar = 0;
    private double res2trueAsymmetricVar = 0;
    private double mRd = 0;
    private double vRd = 0;

    private double wResVarTheoretical = 0;
    private double fMResVarTheoretical = 0;
    private double fMPlusCResVarTheoretical = 0;
    private double fCsVarTheoretical = 0;
    private double fiCrawling = 0;
    private double nRdValue = 0;

    private double s1SpacingVar = 0;
    private double s1SpacingVarTrue = 0;

    private String mm = " mm";
    private String cm = " cm";

    //checkbox booleans for passing to another controller



    //list booleans for passing to another controller

    String crossSectionCheck;



    public void initialize() {
        scrollCalculations.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        choiceBoxDimensions.setValue("Przekrój Prostokątny");

        loadsInit();
        concreteInit();
        checkBoxConcrete.setSelected(true);
        choiceBoxConcrete.setValue("C30/37");
        choiceBoxConcrete.getItems().addAll("C12/15", "C16/20", "C20/25", "C25/30", "C30/37", "C35/45", "C40/50", "C45/55", "C50/60", "C55/67", "C60/75", "C70/85", "C80/95", "C90/105", "C100/115");

        choiceBoxLoads.setValue("Obciążenie długotrwałe");
        choiceBoxCementClass.setValue("Klasa N");

        checkBoxLoads.setDisable(true);

        // Basic values for initialization
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
            //checkBoxLoads.setDisable(false);

            nEdLoadsTxt.setDisable(false);

        } else {
            gridDimensions.getChildren().removeAll(hFDimensionLabel, hFDimension, bFDimension, bFDimensionLabel, hFTDimension, hFTDimensionLabel, bFTDimension, bFTDimensionLabel); //todo change this solution
            gridDimensions.getChildren().addAll(hFDimensionLabel, hFDimension, bFDimension, bFDimensionLabel, hFTDimension, hFTDimensionLabel, bFTDimension, bFTDimensionLabel);
            //checkBoxLoads.setDisable(true);

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
    private static double getDataFromTextField(TextField specificTextField, String variable) {
        try {
            double value;
            if (specificTextField.getText().isEmpty()) {
                specificTextField.setText(String.valueOf(0));
            }

            value = Double.parseDouble(specificTextField.getText().replaceAll(",", "."));

            if (value >= 0) {
                return value;
            } else {
                AlertBox.display("Wartość powinna być liczbą dodatnią");
                return 0;
            }
        } catch (NumberFormatException e) {

            AlertBox.display("Wartość " + variable + " powinna być liczbą dodatnią");
            return 0;
        }
    }

    private static double getDataFromTextFieldForces(TextField specificTextField, String variable) {
        try {
            if (specificTextField.getText().isEmpty()) {
                specificTextField.setText(String.valueOf(0));
            }

            return Double.parseDouble(specificTextField.getText().replaceAll(",", "."));

        } catch (NumberFormatException e) {
            AlertBox.display("Wartość " + variable + " powinna być liczbą");
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

        bValue = (double) (getDataFromTextField(test1, "b") * Math.pow(10, -2));
        hValue = (double) (getDataFromTextField(geometryHeight, "h") * Math.pow(10, -2));
        if (choiceBoxDimensions.getValue().toString().equals("Przekrój Teowy")) {
            bFValue = (double) (getDataFromTextField(bFDimension, "b_eff") * Math.pow(10, -2));
            bFTValue = (double) (getDataFromTextField(bFTDimension, "b_eff,t") * Math.pow(10, -2));
            hFValue = (double) (getDataFromTextField(hFDimension, "h_f") * Math.pow(10, -2));
            hFTValue = (double) (getDataFromTextField(hFTDimension, "h_f,t") * Math.pow(10, -2));
        } else {
            bFValue = 0;
            bFTValue = 0;
            hFValue = 0;
            hFTValue = 0;
        }

    }

    private void longitudinalReinforcement() {
        aS1Value = getDataFromTextField(aS1, "a_S1") * Math.pow(10, -3);
        aS2Value = getDataFromTextField(aS2, "a_S2") * Math.pow(10, -3);
        a1Value = (double) (getDataFromTextField(a1, "a_1") * Math.pow(10, -3));
        a2Value = (double) (getDataFromTextField(a2, "a_2") * Math.pow(10, -3));
    }

    private void shearingValues() {
        vEdValue = getDataFromTextField(vEd, "V_Ed") * Math.pow(10, -3);
        vEdRedValue = getDataFromTextField(vEdRed, "V_EdRed") * Math.pow(10, -3);
        ctgThetaValue = getDataFromTextField(ctgTheta, "ctg_theta");
        alphaValue = getDataFromTextField(alpha, "alpha");
        aSl = getDataFromTextField(aSlTxt, "A_sl") * Math.pow(10, -4);

        aSw1Value = getDataFromTextField(aSw1, "a_Sw1") * Math.pow(10, -3);
        nSw1Value = getDataFromTextField(nSw1, "n_sw1");

        if (checkBoxRods.isSelected()) {
            aSw2Value = getDataFromTextField(aSw2RodTxt, "a_Sw2") * Math.pow(10, -3);
            nSw2Value = getDataFromTextField(nSw2RodTxt, "n_sw2");
            nSw2RodSValue = (double) (getDataFromTextField(nSw2RodSTxt, "s_sw2") * Math.pow(10, -2));
        }
    }

    private void forcesValues() {
        if (checkBoxLoads.isSelected()) {

            mEd1Value = (double) (getDataFromTextFieldForces(mEdLoadsTxt1, "M_Ed1") * Math.pow(10, -3));
            mEd2Value = (double) (getDataFromTextFieldForces(mEdLoadsTxt2, "M_Ed2") * Math.pow(10, -3));
            mEd3Value = (double) (getDataFromTextFieldForces(mEdLoadsTxt3, "M_Ed3") * Math.pow(10, -3));
            mEd4Value = (double) (getDataFromTextFieldForces(mEdLoadsTxt4, "M_Ed4") * Math.pow(10, -3));

            nEd1Value = (double) (getDataFromTextFieldForces(nEdLoadsTxt1, "N_Ed1") * Math.pow(10, -3));
            nEd2Value = (double) (getDataFromTextFieldForces(nEdLoadsTxt2, "N_Ed2") * Math.pow(10, -3));
            nEd3Value = (double) (getDataFromTextFieldForces(nEdLoadsTxt3, "N_Ed3") * Math.pow(10, -3));
            nEd4Value = (double) (getDataFromTextFieldForces(nEdLoadsTxt4, "N_Ed4") * Math.pow(10, -3));

        } else {
            mEdValue = (double) (getDataFromTextFieldForces(mEdLoadsTxt, "M_Ed") * Math.pow(10, -3));
            nEdValue = (double) (getDataFromTextFieldForces(nEdLoadsTxt, "N_Ed") * Math.pow(10, -3));

        }
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

    private double roundSixDigitShearing(double toRound) {
        return Math.round(toRound * 1000000.00) / 1000000D;
    }

    private double roundThreeDigitShearingReal(double toRound) {
        return Math.floor(toRound * 100.00) / 100D;
    }

    public void vEdRedText() {
        vEdRed.setText(String.valueOf(vEd.getText()));
    }

    public void mEkLtText() {


        if (mEk.getText().isEmpty()) {
            mEkLt.setText(String.valueOf(0));
        } else {
            mEkLt.setText(String.valueOf(roundTwoDigit(Double.parseDouble(mEk.getText()) * 0.85)));
        }
    }

    private void slsValues() {
        mEkValue = (double) (getDataFromTextFieldForces(mEk, "M_Ek") * Math.pow(10, -3));
        mEkLtValue = (double) (getDataFromTextFieldForces(mEkLt, "M_Ek,lt") * Math.pow(10, -3));

        tZeroValue = (int) getDataFromTextFieldForces(tZero, "t_0");
        rHValue = (getDataFromTextFieldForces(rH, "RH"));

        cNomValue = getDataFromTextFieldForces(cNom, "cNom") * Math.pow(10, -3);
        lEffValue = getDataFromTextFieldForces(lEff, "l_Eff");
        alphaMValue = getDataFromTextFieldForces(alphaM, "alpha_M");

        char[] loadList = {'S', 'L'};
        loadChar = loadList[choiceBoxLoads.getSelectionModel().getSelectedIndex()];

        char[] cementList = {'S', 'N', 'R'};
        cementChar = cementList[choiceBoxCementClass.getSelectionModel().getSelectedIndex()];
    }

    public void calculations() {
        fCk();
        fYk();
        dimension();
        forcesValues();
        longitudinalReinforcement();
        slsValues();

        String cm2 = " cm^2";
        String szt = " szt.";
        if (!checkBoxLoads.isSelected() && choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) {
            if (nEdValue == 0) {

                if (mEdValue < 0) {
                    BendingBeamRectangle beam = new BendingBeamRectangle(-mEdValue, fCk, fYk, hValue, bValue, a2Value, a1Value);
                    double[] ress = beam.resultsBendingBeamRectangle();
                    System.out.println(Arrays.toString(ress));

                    res1AsymmetricVar = roundTwoDigit(ress[1] * Math.pow(10, 4));
                    res2AsymmetricVar = roundTwoDigit(ress[0] * Math.pow(10, 4));


                    res1Asymmetric.setText(res1AsymmetricVar + cm2);
                    res2Asymmetric.setText(res2AsymmetricVar + cm2);

                    resRods1ValueAsymmetric = reinforcementRods(ress[1], aS1Value);
                    resRods2ValueAsymmetric = reinforcementRods(ress[0], aS2Value);

                    resRods1Asymmetric.setText(String.valueOf(resRods1ValueAsymmetric));
                    resRods2Asymmetric.setText(String.valueOf(resRods2ValueAsymmetric));

                    res1trueAsymmetricVar = roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4));
                    res2trueAsymmetricVar = roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4));

                    res1trueAsymmetric.setText(res1trueAsymmetricVar + cm2);
                    res2trueAsymmetric.setText(res2trueAsymmetricVar + cm2);

                    res1.setText("0" + cm2);
                    res2.setText("0" + cm2);

                    resRods1.setText("0" + szt);
                    resRods2.setText("0" + szt);

                    res1true.setText("0" + cm2);
                    res2true.setText("0" + cm2);

                    DiagnosticBendingBeamAndT beam1 = new DiagnosticBendingBeamAndT(fCk, fYk, bValue, bValue, hValue, 0, a2Value, a1Value, res2trueAsymmetricVar * Math.pow(10, -4), res1trueAsymmetricVar * Math.pow(10, -4));
                    double ress1 = beam1.resultDiagnostic();

                    mRd = -ress1;
                    nRdValue = 0;
                } else {

                    BendingBeamRectangle beam = new BendingBeamRectangle(mEdValue, fCk, fYk, hValue, bValue, a1Value, a2Value);
                    double[] ress = beam.resultsBendingBeamRectangle();
                    System.out.println(Arrays.toString(ress));

                    res1AsymmetricVar = roundTwoDigit(ress[0] * Math.pow(10, 4));
                    res2AsymmetricVar = roundTwoDigit(ress[1] * Math.pow(10, 4));


                    res1Asymmetric.setText(res1AsymmetricVar + cm2);
                    res2Asymmetric.setText(res2AsymmetricVar + cm2);

                    resRods1ValueAsymmetric = reinforcementRods(ress[0], aS1Value);
                    resRods2ValueAsymmetric = reinforcementRods(ress[1], aS2Value);

                    resRods1Asymmetric.setText(String.valueOf(resRods1ValueAsymmetric));
                    resRods2Asymmetric.setText(String.valueOf(resRods2ValueAsymmetric));

                    res1trueAsymmetricVar = roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4));
                    res2trueAsymmetricVar = roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4));

                    res1trueAsymmetric.setText(res1trueAsymmetricVar + cm2);
                    res2trueAsymmetric.setText(res2trueAsymmetricVar + cm2);

                    res1.setText("0" + cm2);
                    res2.setText("0" + cm2);

                    resRods1.setText("0" + szt);
                    resRods2.setText("0" + szt);

                    res1true.setText("0" + cm2);
                    res2true.setText("0" + cm2);

                    DiagnosticBendingBeamAndT beam1 = new DiagnosticBendingBeamAndT(fCk, fYk, bValue, bValue, hValue, 0, a1Value, a2Value, res1trueAsymmetricVar * Math.pow(10, -4), res2trueAsymmetricVar * Math.pow(10, -4));
                    double ress1 = beam1.resultDiagnostic();

                    mRd = ress1;
                    nRdValue = 0;
                }

            } else {
                if (nEdValue > 0) {

                    if (mEdValue < 0) {
                        CompressionSymmetricReinforcement beam1 = new CompressionSymmetricReinforcement(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a2Value, a1Value);
                        double[] results1 = beam1.resultsCompressionSymmetricReinforcement();


                        res1.setText(roundTwoDigit(results1[1] * Math.pow(10, 4)) + cm2);
                        res2.setText(roundTwoDigit(results1[0] * Math.pow(10, 4)) + cm2);

                        resRods1Value = reinforcementRods(results1[1], aS1Value);
                        resRods2Value = reinforcementRods(results1[0], aS2Value);

                        resRods1.setText(resRods1Value + szt);
                        resRods2.setText(resRods2Value + szt);

                        res1true.setText(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4)) + cm2);
                        res2true.setText(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4)) + cm2);

                        //asymmetric

                        CompressionAsymmetricReinforcement beam2 = new CompressionAsymmetricReinforcement(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a2Value, a1Value);
                        double[] results2 = beam2.resultsCompressionAsymmetricReinforcement();

                        res1AsymmetricVar = roundTwoDigit(results2[1] * Math.pow(10, 4));
                        res2AsymmetricVar = roundTwoDigit(results2[0] * Math.pow(10, 4));

                        res1Asymmetric.setText(res1AsymmetricVar + cm2);
                        res2Asymmetric.setText(res2AsymmetricVar + cm2);

                        resRods1ValueAsymmetric = reinforcementRods(results2[1], aS1Value);
                        resRods2ValueAsymmetric = reinforcementRods(results2[0], aS2Value);

                        resRods1Asymmetric.setText(resRods1ValueAsymmetric + szt);
                        resRods2Asymmetric.setText(resRods2ValueAsymmetric + szt);

                        res1trueAsymmetricVar = roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4));
                        res2trueAsymmetricVar = roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4));

                        res1trueAsymmetric.setText(res1trueAsymmetricVar + cm2);
                        res2trueAsymmetric.setText(res2trueAsymmetricVar + cm2);

                        DiagnosticCompression beam4 = new DiagnosticCompression(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a2Value, a1Value, res2trueAsymmetricVar * Math.pow(10, -4), res1trueAsymmetricVar * Math.pow(10, -4));
                        double[] results4 = beam4.resultsDiagnosticCompression();
                        mRd = -results4[1];
                        nRdValue = roundThreeDigitShearing(results4[0] * Math.pow(10, 3));
                    } else {
                        CompressionSymmetricReinforcement beam1 = new CompressionSymmetricReinforcement(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value);
                        double[] results1 = beam1.resultsCompressionSymmetricReinforcement();


                        res1.setText(roundTwoDigit(results1[0] * Math.pow(10, 4)) + cm2);
                        res2.setText(roundTwoDigit(results1[1] * Math.pow(10, 4)) + cm2);

                        resRods1Value = reinforcementRods(results1[0], aS1Value);
                        resRods2Value = reinforcementRods(results1[1], aS2Value);

                        resRods1.setText(resRods1Value + szt);
                        resRods2.setText(resRods2Value + szt);

                        res1true.setText(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4)) + cm2);
                        res2true.setText(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4)) + cm2);

                        //asymmetric

                        CompressionAsymmetricReinforcement beam2 = new CompressionAsymmetricReinforcement(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value);
                        double[] results2 = beam2.resultsCompressionAsymmetricReinforcement();

                        res1AsymmetricVar = roundTwoDigit(results2[0] * Math.pow(10, 4));
                        res2AsymmetricVar = roundTwoDigit(results2[1] * Math.pow(10, 4));

                        res1Asymmetric.setText(res1AsymmetricVar + cm2);
                        res2Asymmetric.setText(res2AsymmetricVar + cm2);

                        resRods1ValueAsymmetric = reinforcementRods(results2[0], aS1Value);
                        resRods2ValueAsymmetric = reinforcementRods(results2[1], aS2Value);

                        resRods1Asymmetric.setText(resRods1ValueAsymmetric + szt);
                        resRods2Asymmetric.setText(resRods2ValueAsymmetric + szt);

                        res1trueAsymmetricVar = roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4));
                        res2trueAsymmetricVar = roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4));

                        res1trueAsymmetric.setText(res1trueAsymmetricVar + cm2);
                        res2trueAsymmetric.setText(res2trueAsymmetricVar + cm2);

                        DiagnosticCompression beam4 = new DiagnosticCompression(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value, res1trueAsymmetricVar * Math.pow(10, -4), res2trueAsymmetricVar * Math.pow(10, -4));
                        double[] results4 = beam4.resultsDiagnosticCompression();
                        mRd = results4[1];
                        nRdValue = roundThreeDigitShearing(results4[0] * Math.pow(10, 3));
                    }

                } else {

                    if (mEdValue < 0) {
                        ExtensionSymmetricReinforcement beam1 = new ExtensionSymmetricReinforcement(-nEdValue, mEdValue, fCk, fYk, bValue, hValue, a2Value, a1Value);
                        double[] results1 = beam1.resultsExtensionSymmetric();
                        res1.setText(roundTwoDigit(results1[1] * Math.pow(10, 4)) + cm2);
                        res2.setText(roundTwoDigit(results1[0] * Math.pow(10, 4)) + cm2);

                        resRods1Value = reinforcementRods(results1[1], aS1Value);
                        resRods2Value = reinforcementRods(results1[0], aS2Value);

                        resRods1.setText(resRods1Value + szt);
                        resRods2.setText(resRods2Value + szt);

                        res1true.setText(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4)) + cm2);
                        res2true.setText(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4)) + cm2);

                        //asymmetric

                        ExtensionAsymmetricReinforcement beam2 = new ExtensionAsymmetricReinforcement(-nEdValue, mEdValue, fCk, fYk, bValue, hValue, a2Value, a1Value);
                        double[] results2 = beam2.resultsExtensionAsymmetric();

                        res1AsymmetricVar = roundTwoDigit(results2[1] * Math.pow(10, 4));
                        res2AsymmetricVar = roundTwoDigit(results2[0] * Math.pow(10, 4));

                        res1Asymmetric.setText(res1AsymmetricVar + cm2);
                        res2Asymmetric.setText(res2AsymmetricVar + cm2);

                        resRods1ValueAsymmetric = reinforcementRods(results2[1], aS1Value);
                        resRods2ValueAsymmetric = reinforcementRods(results2[0], aS2Value);

                        resRods1Asymmetric.setText(resRods1ValueAsymmetric + szt);
                        resRods2Asymmetric.setText(resRods2ValueAsymmetric + szt);


                        res1trueAsymmetricVar = roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4));
                        res2trueAsymmetricVar = roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4));

                        res1trueAsymmetric.setText(res1trueAsymmetricVar + cm2);
                        res2trueAsymmetric.setText(res2trueAsymmetricVar + cm2);

                        DiagnosticExtension beam7 = new DiagnosticExtension(-nEdValue, mEdValue, fCk, fYk, bValue, hValue, a2Value, a1Value, res2trueAsymmetricVar * Math.pow(10, -4), res1trueAsymmetricVar * Math.pow(10, -4));
                        double[] results7 = beam7.resultsDiagnosticExtension();
                        mRd = -results7[1];
                        nRdValue = roundThreeDigitShearing(-results7[0] * Math.pow(10, 3));

                    } else {
                        ExtensionSymmetricReinforcement beam1 = new ExtensionSymmetricReinforcement(-nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value);
                        double[] results1 = beam1.resultsExtensionSymmetric();
                        res1.setText(roundTwoDigit(results1[0] * Math.pow(10, 4)) + cm2);
                        res2.setText(roundTwoDigit(results1[1] * Math.pow(10, 4)) + cm2);

                        resRods1Value = reinforcementRods(results1[0], aS1Value);
                        resRods2Value = reinforcementRods(results1[1], aS2Value);

                        resRods1.setText(resRods1Value + szt);
                        resRods2.setText(resRods2Value + szt);

                        res1true.setText(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4)) + cm2);
                        res2true.setText(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4)) + cm2);

                        //asymmetric

                        ExtensionAsymmetricReinforcement beam2 = new ExtensionAsymmetricReinforcement(-nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value);
                        double[] results2 = beam2.resultsExtensionAsymmetric();

                        res1AsymmetricVar = roundTwoDigit(results2[0] * Math.pow(10, 4));
                        res2AsymmetricVar = roundTwoDigit(results2[1] * Math.pow(10, 4));

                        res1Asymmetric.setText(res1AsymmetricVar + cm2);
                        res2Asymmetric.setText(res2AsymmetricVar + cm2);

                        resRods1ValueAsymmetric = reinforcementRods(results2[0], aS1Value);
                        resRods2ValueAsymmetric = reinforcementRods(results2[1], aS2Value);

                        resRods1Asymmetric.setText(resRods1ValueAsymmetric + szt);
                        resRods2Asymmetric.setText(resRods2ValueAsymmetric + szt);


                        res1trueAsymmetricVar = roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4));
                        res2trueAsymmetricVar = roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4));

                        res1trueAsymmetric.setText(res1trueAsymmetricVar + cm2);
                        res2trueAsymmetric.setText(res2trueAsymmetricVar + cm2);

                        DiagnosticExtension beam7 = new DiagnosticExtension(-nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value, res1trueAsymmetricVar * Math.pow(10, -4), res2trueAsymmetricVar * Math.pow(10, -4));
                        double[] results7 = beam7.resultsDiagnosticExtension();
                        mRd = results7[1];
                        nRdValue = roundThreeDigitShearing(-results7[0] * Math.pow(10, 3));
                    }
                }
            }
        }

        //Shearing Calculations

        shearingValues();
        String m = " m";

        if (checkBoxRods.isSelected()) {
            ShearingBendRods shearing = new ShearingBendRods(hValue, a1Value, bValue, fCk, nEdValue, aSl, nSw1Value, nSw2Value, aSw1Value, aSw2Value, fYk, vEdRedValue, vEdValue, nSw2RodSValue, ctgThetaValue, alphaValue);
            double res = shearing.resultShearingStirrups();
            System.out.println(res);

            resShearing = roundThreeDigitShearingReal(res);

            sRods.setText(roundThreeDigitShearing(res) + m);

            sRodsReal.setText(roundThreeDigitShearingReal(res) + m);

            DiagnosticShearing shearing1 = new DiagnosticShearing(hValue, a1Value, bValue, fCk, nEdValue, aSl, nSw1Value, nSw2Value, aSw1Value, aSw2Value, fYk, vEdRedValue, vEdValue, nSw2RodSValue, resShearing, ctgThetaValue, alphaValue);
            vRd = shearing1.resultsShearingDiagnostic();


            s1SpacingVar = roundThreeDigitShearing(res);
            s1SpacingVarTrue = roundThreeDigitShearingReal(res);


        } else {

            ShearingStirrups shearing = new ShearingStirrups(hValue, bValue, a1Value, fCk, fYk, nEdValue, vEdValue, vEdRedValue, aSl, nSw1Value, aSw1Value, ctgThetaValue); //TODO ASL ISN'T just a dimension! cm^2, not mm
            double res = shearing.resultShearingStirrups();
            System.out.println(res);

            resShearing = roundThreeDigitShearingReal(res);
            sRods.setText(roundThreeDigitShearing(res) + m);

            sRodsReal.setText(roundThreeDigitShearingReal(res) + m);


            DiagnosticShearing shearing1 = new DiagnosticShearing(hValue, a1Value, bValue, fCk, nEdValue, aSl, nSw1Value, nSw2Value, aSw1Value, 0, fYk, vEdRedValue, vEdValue, nSw2RodSValue, resShearing, ctgThetaValue, alphaValue);
            vRd = shearing1.resultsShearingDiagnostic();

            s1SpacingVar = roundThreeDigitShearing(res);
            s1SpacingVarTrue = roundThreeDigitShearingReal(res);

            nSw2RodSValue = 0;
            nSw2Value = 0;
            aSw2Value = 0;



        }


        //tBeam


        if (choiceBoxDimensions.getValue().toString().equals("Przekrój Teowy")) {

            if (mEdValue < 0) {
                BendingBeamT beam = new BendingBeamT(-mEdValue, fCk, fYk, bValue, bFTValue, hValue, hFTValue, a2Value, a1Value);
                double[] ress = beam.resultsBendingT();
                System.out.println(Arrays.toString(ress));

                res1AsymmetricVar = roundTwoDigit(ress[1] * Math.pow(10, 4));
                res2AsymmetricVar = roundTwoDigit(ress[0] * Math.pow(10, 4));

                res1Asymmetric.setText(res1AsymmetricVar + cm2);
                res2Asymmetric.setText(res2AsymmetricVar + cm2);

                resRods1ValueAsymmetric = reinforcementRods(ress[1], aS1Value);
                resRods2ValueAsymmetric = reinforcementRods(ress[0], aS2Value);

                resRods1Asymmetric.setText(resRods1ValueAsymmetric + szt);
                resRods2Asymmetric.setText(resRods2ValueAsymmetric + szt);

                res1trueAsymmetricVar = roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4));
                res2trueAsymmetricVar = roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4));

                res1trueAsymmetric.setText(res1trueAsymmetricVar + cm2);
                res2trueAsymmetric.setText(res2trueAsymmetricVar + cm2);

                res1.setText("0" + cm2);
                res2.setText("0" + cm2);

                resRods1.setText("0" + szt);
                resRods2.setText("0" + szt);

                res1true.setText("0" + cm2);
                res2true.setText("0" + cm2);

                toPdfButton.setDisable(false);


                DiagnosticBendingBeamAndT beam1 = new DiagnosticBendingBeamAndT(fCk, fYk, bValue, bFTValue, hValue, hFTValue, a2Value, a1Value, res2trueAsymmetricVar * Math.pow(10, -4), res1trueAsymmetricVar * Math.pow(10, -4));
                double ress1 = beam1.resultDiagnostic();

                nRdValue = 0;
                mRd = -ress1;

            } else {

                BendingBeamT beam = new BendingBeamT(mEdValue, fCk, fYk, bValue, bFValue, hValue, hFValue, a1Value, a2Value);
                double[] ress = beam.resultsBendingT();
                System.out.println(Arrays.toString(ress));

                res1AsymmetricVar = roundTwoDigit(ress[0] * Math.pow(10, 4));
                res2AsymmetricVar = roundTwoDigit(ress[1] * Math.pow(10, 4));

                res1Asymmetric.setText(res1AsymmetricVar + cm2);
                res2Asymmetric.setText(res2AsymmetricVar + cm2);

                resRods1ValueAsymmetric = reinforcementRods(ress[0], aS1Value);
                resRods2ValueAsymmetric = reinforcementRods(ress[1], aS2Value);

                resRods1Asymmetric.setText(resRods1ValueAsymmetric + szt);
                resRods2Asymmetric.setText(resRods2ValueAsymmetric + szt);

                res1trueAsymmetricVar = roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1ValueAsymmetric * Math.pow(10, 4));
                res2trueAsymmetricVar = roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2ValueAsymmetric * Math.pow(10, 4));

                res1trueAsymmetric.setText(res1trueAsymmetricVar + cm2);
                res2trueAsymmetric.setText(res2trueAsymmetricVar + cm2);

                res1.setText("0" + cm2);
                res2.setText("0" + cm2);

                resRods1.setText("0" + szt);
                resRods2.setText("0" + szt);

                res1true.setText("0" + cm2);
                res2true.setText("0" + cm2);

                toPdfButton.setDisable(false);


                DiagnosticBendingBeamAndT beam1 = new DiagnosticBendingBeamAndT(fCk, fYk, bValue, bFValue, hValue, hFValue, a1Value, a2Value, res1trueAsymmetricVar * Math.pow(10, -4), res2trueAsymmetricVar * Math.pow(10, -4));
                double ress1 = beam1.resultDiagnostic();

                nRdValue = 0;
                mRd = ress1;

            }
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
        data.put("aSw1", roundTwoDigit(aSw1Value * 1000));
        data.put("aSw2", roundTwoDigit(aSw2Value * 1000));
        data.put("nSw1", roundTwoDigit(nSw1Value));
        data.put("nSw2", roundTwoDigit(nSw2Value));
        data.put("sSw2", roundTwoDigit(nSw2RodSValue * 100));

        data.put("mEk", roundTwoDigit(mEkValue * 1000));
        data.put("mEkLt", roundTwoDigit(mEkLtValue * 1000));
        data.put("tZero", roundTwoDigit(tZeroValue));
        data.put("rH", roundTwoDigit(rHValue));
        data.put("cNom", roundTwoDigit(cNomValue * 1000));
        data.put("lEff", (double) lEffValue);
        data.put("alphaM", roundThreeDigitShearing(alphaMValue));

        data.put("sSw1", roundTwoDigit(resShearing * 100));
        data.put("beff", roundTwoDigit(bFValue * 100));
        data.put("befft", roundTwoDigit(bFTValue * 100));
        data.put("hf", roundTwoDigit(hFValue * 100));
        data.put("hft", roundTwoDigit(hFTValue * 100));

        //values for lists


        //values for checkbox

        dataString = new HashMap<>();

        if (choiceBoxDimensions.getValue().toString().equals("Przekrój Teowy")) {
            crossSectionCheck = "Przekrój Teowy";

            dataString.put("cSC", crossSectionCheck);
        } else {
            crossSectionCheck = "Przekrój Prostokątny";

            dataString.put("cSC", crossSectionCheck);
        }


        if (nEdValue == 0) {
            if (mEdValue > 0) {
                if (choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) {
                    if (loadChar == 'L') {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * resRods1ValueAsymmetric;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * resRods2ValueAsymmetric;


                        Deflection res1 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, 0, 0, bValue, bValue, a1Value, a2Value, aS1True, aS2True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsLong();
                        double result1a = res1.resultsLongDeformation();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a1Value, a2Value, aS1True, aS2True, mEkValue, mEkLtValue, loadChar);
                        double result2 = res2.wK();


                        //res to labels
                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = roundThreeDigitShearing(result1a * Math.pow(10, 2));
                        fCsVar = fMPlusCResVar - fMResVar;

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(fMPlusCResVar + cm);

                        //res theroretical
                        double aS1Theoretical = res1AsymmetricVar * Math.pow(10, -4);
                        double aS2Theoretical = res2AsymmetricVar * Math.pow(10, -4);

                        double resRods1ValueTheoretical = res1AsymmetricVar * Math.pow(10, -4) / (Math.pow(aS1Value / 2, 2) * Math.PI);
                        System.out.println("Pręty teoretyczne" + resRods1ValueTheoretical);


                        Deflection res3 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, 0, 0, bValue, bValue, a1Value, a2Value, aS1Theoretical, aS2Theoretical, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result3 = res3.resultsLong();
                        double result3a = res3.resultsLongDeformation();

                        Scratch res4 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueTheoretical, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a1Value, a2Value, aS1Theoretical, aS2Theoretical, mEkValue, mEkLtValue, loadChar);
                        double result4 = res4.wK();


                        //res to labels
                        wResVarTheoretical = roundThreeDigitShearing(result4 * Math.pow(10, 3));
                        fMResVarTheoretical = roundThreeDigitShearing(result3 * Math.pow(10, 2));
                        fMPlusCResVarTheoretical = roundThreeDigitShearing(result3a * Math.pow(10, 2));
                        fCsVarTheoretical = fMPlusCResVarTheoretical - fMResVarTheoretical;

                        wRes.setText(wResVarTheoretical + mm);
                        fMRes.setText(fMResVarTheoretical + cm);
                        fMPlusCRes.setText(fMPlusCResVarTheoretical + cm);


                    } else {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * resRods1ValueAsymmetric;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * resRods2ValueAsymmetric;

                        Deflection res1 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, 0, 0, bValue, bValue, a1Value, a2Value, aS1True, aS2True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsShort();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a1Value, a2Value, aS1True, aS2True, mEkValue, mEkLtValue, loadChar);
                        double result2 = res2.wK();

                        //res to labels
                        String mm = " mm";
                        String cm = " cm";

                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = 0;
                        fCsVar = fMPlusCResVar - fMResVar;


                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(roundThreeDigitShearing(0) + cm);

                        //res theroretical
                        double aS1Theoretical = res1AsymmetricVar * Math.pow(10, -4);
                        double aS2Theoretical = res2AsymmetricVar * Math.pow(10, -4);

                        double resRods1ValueTheoretical = res1AsymmetricVar * Math.pow(10, -4) / (Math.pow(aS1Value / 2, 2) * Math.PI);
                        System.out.println("Pręty teoretyczne" + resRods1ValueTheoretical);


                        Deflection res3 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, 0, 0, bValue, bValue, a1Value, a2Value, aS1Theoretical, aS2Theoretical, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result3 = res3.resultsShort();

                        Scratch res4 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueTheoretical, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a1Value, a2Value, aS1Theoretical, aS2Theoretical, mEkValue, mEkLtValue, loadChar);
                        double result4 = res4.wK();


                        //res to labels
                        wResVarTheoretical = roundThreeDigitShearing(result4 * Math.pow(10, 3));
                        fMResVarTheoretical = roundThreeDigitShearing(result3 * Math.pow(10, 2));
                        fMPlusCResVarTheoretical = 0;
                        fCsVarTheoretical = fMPlusCResVarTheoretical - fMResVarTheoretical;

                        wRes.setText(wResVarTheoretical + mm);
                        fMRes.setText(fMResVarTheoretical + cm);
                        fMPlusCRes.setText(roundThreeDigitShearing(0) + cm);
                    }
                } else {
                    if (loadChar == 'L') {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * resRods1ValueAsymmetric;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * resRods2ValueAsymmetric;


                        Deflection res1 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, hFValue, hFTValue, bFValue, bFTValue, a1Value, a2Value, aS1True, aS2True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsLong();
                        double result1a = res1.resultsLongDeformation();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bFValue, bFTValue, hValue, hFValue, hFTValue, a1Value, a2Value, aS1True, aS2True, mEkValue, mEkLtValue, loadChar);
                        double result2 = res2.wK();


                        //res to labels
                        String mm = " mm";
                        String cm = " cm";

                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = roundThreeDigitShearing(result1a * Math.pow(10, 2));
                        fCsVar = fMPlusCResVar - fMResVar;

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(fMPlusCResVar + cm);


                        //theoretical
                        double aS1Theoretical = res1AsymmetricVar * Math.pow(10, -4);  //todo res 1 asymmetric var tbeam
                        double aS2Theoretical = res2AsymmetricVar * Math.pow(10, -4);

                        double resRods1ValueTheoretical = res1AsymmetricVar * Math.pow(10, -4) / (Math.pow(aS1Value / 2, 2) * Math.PI);
                        System.out.println("Pręty teoretyczne" + resRods1ValueTheoretical);

                        Deflection res3 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, hFValue, hFTValue, bFValue, bFTValue, a1Value, a2Value, aS1Theoretical, aS2Theoretical, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result3 = res3.resultsLong();
                        double result3a = res3.resultsLongDeformation();

                        Scratch res4 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueTheoretical, fCk, rHValue, tZeroValue, cementChar, bValue, bFValue, bFTValue, hValue, hFValue, hFTValue, a1Value, a2Value, aS1Theoretical, aS2Theoretical, mEkValue, mEkLtValue, loadChar);
                        double result4 = res4.wK();


                        //res to labels
                        wResVarTheoretical = roundThreeDigitShearing(result4 * Math.pow(10, 3));
                        fMResVarTheoretical = roundThreeDigitShearing(result3 * Math.pow(10, 2));
                        fMPlusCResVarTheoretical = roundThreeDigitShearing(result3a * Math.pow(10, 2));
                        fCsVarTheoretical = fMPlusCResVarTheoretical - fMResVarTheoretical;

                        wRes.setText(wResVarTheoretical + mm);
                        fMRes.setText(fMResVarTheoretical + cm);
                        fMPlusCRes.setText(fMPlusCResVarTheoretical + cm);

                    } else {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * resRods1ValueAsymmetric;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * resRods2ValueAsymmetric;

                        Deflection res1 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, hFValue, hFTValue, bFValue, bFTValue, a1Value, a2Value, aS1True, aS2True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsShort();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bFValue, bFTValue, hValue, hFValue, hFTValue, a1Value, a2Value, aS1True, aS2True, mEkValue, mEkLtValue, loadChar);
                        double result2 = res2.wK();

                        //res to labels


                        String mm = " mm";
                        String cm = " cm";

                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = 0;
                        fCsVar = fMPlusCResVar - fMResVar;

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(roundThreeDigitShearing(0) + cm);

                        //theoretical
                        double aS1Theoretical = res1AsymmetricVar * Math.pow(10, -4);
                        double aS2Theoretical = res2AsymmetricVar * Math.pow(10, -4);

                        double resRods1ValueTheoretical = res1AsymmetricVar * Math.pow(10, -4) / (Math.pow(aS1Value / 2, 2) * Math.PI);
                        System.out.println("Pręty teoretyczne" + resRods1ValueTheoretical);

                        Deflection res3 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, hFValue, hFTValue, bFValue, bFTValue, a1Value, a2Value, aS1Theoretical, aS2Theoretical, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result3 = res3.resultsShort();


                        Scratch res4 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueTheoretical, fCk, rHValue, tZeroValue, cementChar, bValue, bFValue, bFTValue, hValue, hFValue, hFTValue, a1Value, a2Value, aS1Theoretical, aS2Theoretical, mEkValue, mEkLtValue, loadChar);
                        double result4 = res4.wK();

                        //res to labels
                        wResVarTheoretical = roundThreeDigitShearing(result4 * Math.pow(10, 3));
                        fMResVarTheoretical = roundThreeDigitShearing(result3 * Math.pow(10, 2));
                        fMPlusCResVarTheoretical = 0;
                        fCsVarTheoretical = fMPlusCResVarTheoretical - fMResVarTheoretical;

                        wRes.setText(wResVarTheoretical + mm);
                        fMRes.setText(fMResVarTheoretical + cm);
                        fMPlusCRes.setText(roundThreeDigitShearing(0) + cm);


                    }
                }
            } else {
                if (choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) {
                    if (loadChar == 'L') {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * resRods1ValueAsymmetric;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * resRods2ValueAsymmetric;


                        Deflection res1 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, 0, 0, bValue, bValue, a2Value, a1Value, aS2True, aS1True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsLong();
                        double result1a = res1.resultsLongDeformation();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods2ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a2Value, a1Value, aS2True, aS1True, -mEkValue, -mEkLtValue, loadChar);
                        double result2 = res2.wK();


                        //res to labels
                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = roundThreeDigitShearing(result1a * Math.pow(10, 2));
                        fCsVar = fMPlusCResVar - fMResVar;

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(fMPlusCResVar + cm);

                        //res theroretical
                        double aS1Theoretical = res1AsymmetricVar * Math.pow(10, -4);
                        double aS2Theoretical = res2AsymmetricVar * Math.pow(10, -4);

                        double resRods1ValueTheoretical = res2AsymmetricVar * Math.pow(10, -4) / (Math.pow(aS2Value / 2, 2) * Math.PI);
                        System.out.println("Pręty teoretyczne" + resRods1ValueTheoretical);


                        Deflection res3 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, 0, 0, bValue, bValue, a2Value, a1Value, aS2Theoretical, aS1Theoretical, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result3 = res3.resultsLong();
                        double result3a = res3.resultsLongDeformation();

                        Scratch res4 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods1ValueTheoretical, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a2Value, a1Value, aS2Theoretical, aS1Theoretical, -mEkValue, -mEkLtValue, loadChar);
                        double result4 = res4.wK();


                        //res to labels
                        wResVarTheoretical = roundThreeDigitShearing(result4 * Math.pow(10, 3));
                        fMResVarTheoretical = roundThreeDigitShearing(result3 * Math.pow(10, 2));
                        fMPlusCResVarTheoretical = roundThreeDigitShearing(result3a * Math.pow(10, 2));
                        fCsVarTheoretical = fMPlusCResVarTheoretical - fMResVarTheoretical;

                        wRes.setText(wResVarTheoretical + mm);
                        fMRes.setText(fMResVarTheoretical + cm);
                        fMPlusCRes.setText(fMPlusCResVarTheoretical + cm);


                    } else {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * resRods1ValueAsymmetric;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * resRods2ValueAsymmetric;

                        Deflection res1 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, 0, 0, bValue, bValue, a2Value, a1Value, aS2True, aS1True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsShort();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods2ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a2Value, a1Value, aS2True, aS1True, -mEkValue, -mEkLtValue, loadChar);
                        double result2 = res2.wK();

                        //res to labels
                        String mm = " mm";
                        String cm = " cm";

                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = 0;
                        fCsVar = fMPlusCResVar - fMResVar;


                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(roundThreeDigitShearing(0) + cm);

                        //res theroretical
                        double aS1Theoretical = res1AsymmetricVar * Math.pow(10, -4);
                        double aS2Theoretical = res2AsymmetricVar * Math.pow(10, -4);

                        double resRods2ValueTheoretical = res2AsymmetricVar * Math.pow(10, -4) / (Math.pow(aS2Value / 2, 2) * Math.PI);
                        System.out.println("Pręty teoretyczne" + resRods2ValueTheoretical);


                        Deflection res3 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, 0, 0, bValue, bValue, a2Value, a1Value, aS2Theoretical, aS1Theoretical, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result3 = res3.resultsShort();

                        Scratch res4 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods2ValueTheoretical, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a2Value, a1Value, aS2Theoretical, aS1Theoretical, -mEkValue, -mEkLtValue, loadChar);
                        double result4 = res4.wK();


                        //res to labels
                        wResVarTheoretical = roundThreeDigitShearing(result4 * Math.pow(10, 3));
                        fMResVarTheoretical = roundThreeDigitShearing(result3 * Math.pow(10, 2));
                        fMPlusCResVarTheoretical = 0;
                        fCsVarTheoretical = fMPlusCResVarTheoretical - fMResVarTheoretical;

                        wRes.setText(wResVarTheoretical + mm);
                        fMRes.setText(fMResVarTheoretical + cm);
                        fMPlusCRes.setText(roundThreeDigitShearing(0) + cm);
                    }
                } else {
                    if (loadChar == 'L') {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * resRods1ValueAsymmetric;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * resRods2ValueAsymmetric;


                        Deflection res1 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, hFTValue, hFValue, bFTValue, bFValue, a2Value, a1Value, aS2True, aS1True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsLong();
                        double result1a = res1.resultsLongDeformation();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods2ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bFTValue, bFValue, hValue, hFTValue, hFValue, a2Value, a1Value, aS2True, aS1True, -mEkValue, -mEkLtValue, loadChar);
                        double result2 = res2.wK();


                        //res to labels
                        String mm = " mm";
                        String cm = " cm";

                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = roundThreeDigitShearing(result1a * Math.pow(10, 2));
                        fCsVar = fMPlusCResVar - fMResVar;

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(fMPlusCResVar + cm);


                        //theoretical
                        double aS1Theoretical = res1AsymmetricVar * Math.pow(10, -4);  //todo res 1 asymmetric var tbeam
                        double aS2Theoretical = res2AsymmetricVar * Math.pow(10, -4);

                        double resRods2ValueTheoretical = res2AsymmetricVar * Math.pow(10, -4) / (Math.pow(aS2Value / 2, 2) * Math.PI);
                        System.out.println("Pręty teoretyczne" + resRods2ValueTheoretical);

                        Deflection res3 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, hFTValue, hFValue, bFTValue, bFValue, a2Value, a1Value, aS2Theoretical, aS1Theoretical, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result3 = res3.resultsLong();
                        double result3a = res3.resultsLongDeformation();

                        Scratch res4 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods2ValueTheoretical, fCk, rHValue, tZeroValue, cementChar, bValue, bFTValue, bFValue, hValue, hFTValue, hFValue, a2Value, a1Value, aS2Theoretical, aS1Theoretical, -mEkValue, -mEkLtValue, loadChar);
                        double result4 = res4.wK();


                        //res to labels
                        wResVarTheoretical = roundThreeDigitShearing(result4 * Math.pow(10, 3));
                        fMResVarTheoretical = roundThreeDigitShearing(result3 * Math.pow(10, 2));
                        fMPlusCResVarTheoretical = roundThreeDigitShearing(result3a * Math.pow(10, 2));
                        fCsVarTheoretical = fMPlusCResVarTheoretical - fMResVarTheoretical;

                        wRes.setText(wResVarTheoretical + mm);
                        fMRes.setText(fMResVarTheoretical + cm);
                        fMPlusCRes.setText(fMPlusCResVarTheoretical + cm);

                    } else {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * resRods1ValueAsymmetric;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * resRods2ValueAsymmetric;

                        Deflection res1 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, hFTValue, hFValue, bFTValue, bFValue, a2Value, a1Value, aS2True, aS1True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsShort();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods2ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bFTValue, bFValue, hValue, hFTValue, hFValue, a2Value, a1Value, aS2True, aS1True, -mEkValue, -mEkLtValue, loadChar);
                        double result2 = res2.wK();

                        //res to labels


                        String mm = " mm";
                        String cm = " cm";

                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = 0;
                        fCsVar = fMPlusCResVar - fMResVar;

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(roundThreeDigitShearing(0) + cm);

                        //theoretical
                        double aS1Theoretical = res1AsymmetricVar * Math.pow(10, -4);
                        double aS2Theoretical = res2AsymmetricVar * Math.pow(10, -4);

                        double resRods2ValueTheoretical = res2AsymmetricVar * Math.pow(10, -4) / (Math.pow(aS2Value / 2, 2) * Math.PI);
                        System.out.println("Pręty teoretyczne" + resRods2ValueTheoretical);

                        Deflection res3 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, hFTValue, hFValue, bFTValue, bFValue, a2Value, a1Value, aS2Theoretical, aS1Theoretical, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result3 = res3.resultsShort();


                        Scratch res4 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods2ValueTheoretical, fCk, rHValue, tZeroValue, cementChar, bValue, bFTValue, bFValue, hValue, hFTValue, hFValue, a2Value, a1Value, aS2Theoretical, aS1Theoretical, -mEkValue, -mEkLtValue, loadChar);
                        double result4 = res4.wK();

                        //res to labels
                        wResVarTheoretical = roundThreeDigitShearing(result4 * Math.pow(10, 3));
                        fMResVarTheoretical = roundThreeDigitShearing(result3 * Math.pow(10, 2));
                        fMPlusCResVarTheoretical = 0;
                        fCsVarTheoretical = fMPlusCResVarTheoretical - fMResVarTheoretical;

                        wRes.setText(wResVarTheoretical + mm);
                        fMRes.setText(fMResVarTheoretical + cm);
                        fMPlusCRes.setText(roundThreeDigitShearing(0) + cm);


                    }
                }
            }
        } else {

            wResVar = 0;
            fMResVar = 0;
            fMPlusCResVar = 0;
            fCsVar = 0;

            wResVarTheoretical = 0;
            fMResVarTheoretical = 0;
            fMPlusCResVarTheoretical = 0;
            fCsVarTheoretical = 0;

            wResTrue.setText(0 + mm);
            fMResTrue.setText(0 + cm);
            fMPlusCResTrue.setText(0 + cm);


            wRes.setText(0 + mm);
            fMRes.setText(0 + cm);
            fMPlusCRes.setText(0 + cm);
        }


        toPdfButton.setDisable(false);


    }

    private void diagnosticValues() {

        n1Value = getDataFromTextFieldForces(n1, "n_1");
        n2Value = getDataFromTextFieldForces(n2, "n_2");
        s1Value = (double) (getDataFromTextFieldForces(s1, "s_1") * Math.pow(10, -2));
    }


    public void diagnostic() {

        fCk();
        fYk();
        dimension();
        forcesValues();
        longitudinalReinforcement();
        diagnosticValues();
        slsValues();


        double aS1ValueDiagnostic = Math.pow(aS1Value * 0.5, 2) * Math.PI * n1Value;
        double aS2ValueDiagnostic = Math.pow(aS2Value * 0.5, 2) * Math.PI * n2Value;


        String kNm = " kNm";
        String kN = " kN";
        if (!checkBoxLoads.isSelected() && choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) {
            if (nEdValue == 0) {
                if (mEdValue > 0) {
                    DiagnosticBendingBeamAndT beam = new DiagnosticBendingBeamAndT(fCk, fYk, bValue, bValue, hValue, 0, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                    double ress = beam.resultDiagnostic();
                    System.out.println(ress);

                    res1.setText(roundTwoDigit(ress * Math.pow(10, 3)) + kNm);
                    res1true.setText(roundTwoDigit(mEdValue * Math.pow(10, 3)) + kNm);

                    res2.setText(0 + kN);
                    res2true.setText(0 + kN);

                    nRdValue = 0;

                    res1trueAsymmetricVar = roundThreeDigitShearing(aS1ValueDiagnostic * Math.pow(10, 4));
                    res2trueAsymmetricVar = roundThreeDigitShearing(aS2ValueDiagnostic * Math.pow(10, 4));

                    mRd = ress;

                    resRods1ValueAsymmetric = reinforcementRods(aS1ValueDiagnostic, aS1Value);
                    resRods2ValueAsymmetric = reinforcementRods(aS2ValueDiagnostic, aS2Value);
                } else {
                    DiagnosticBendingBeamAndT beam = new DiagnosticBendingBeamAndT(fCk, fYk, bValue, bValue, hValue, 0, a2Value, a1Value, aS2ValueDiagnostic, aS1ValueDiagnostic);
                    double ress = -beam.resultDiagnostic();
                    System.out.println(ress);

                    res1.setText(roundTwoDigit(ress * Math.pow(10, 3)) + kNm);
                    res1true.setText(roundTwoDigit(mEdValue * Math.pow(10, 3)) + kNm);

                    res2.setText(0 + kN);
                    res2true.setText(0 + kN);

                    nRdValue = 0;

                    res1trueAsymmetricVar = roundThreeDigitShearing(aS1ValueDiagnostic * Math.pow(10, 4));
                    res2trueAsymmetricVar = roundThreeDigitShearing(aS2ValueDiagnostic * Math.pow(10, 4));

                    mRd = ress;

                    resRods1ValueAsymmetric = reinforcementRods(aS1ValueDiagnostic, aS1Value);
                    resRods2ValueAsymmetric = reinforcementRods(aS2ValueDiagnostic, aS2Value);
                }

            } else {
                if (nEdValue > 0) {
                    if (mEdValue < 0) {
                        DiagnosticCompression beam1 = new DiagnosticCompression(nEdValue, -mEdValue, fCk, fYk, bValue, hValue, a2Value, a1Value, aS2ValueDiagnostic, aS1ValueDiagnostic);
                        double[] results1 = beam1.resultsDiagnosticCompression();
                        res1.setText(roundTwoDigit(-results1[1] * Math.pow(10, 3)) + kNm);
                        res2.setText(roundTwoDigit(results1[0] * Math.pow(10, 3)) + kN);

                        res1true.setText(roundTwoDigit(mEdValue * Math.pow(10, 3)) + kNm);
                        res2true.setText(roundTwoDigit(nEdValue * Math.pow(10, 3)) + kN);

                        nRdValue = roundTwoDigit(results1[0] * Math.pow(10, 3));

                        res1trueAsymmetricVar = roundThreeDigitShearing(aS2ValueDiagnostic * Math.pow(10, 4));
                        res2trueAsymmetricVar = roundThreeDigitShearing(aS1ValueDiagnostic * Math.pow(10, 4));

                        mRd = -results1[1];

                        resRods1ValueAsymmetric = reinforcementRods(aS2ValueDiagnostic, aS2Value);
                        resRods2ValueAsymmetric = reinforcementRods(aS1ValueDiagnostic, aS1Value);
                    } else {
                        DiagnosticCompression beam1 = new DiagnosticCompression(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                        double[] results1 = beam1.resultsDiagnosticCompression();
                        res1.setText(roundTwoDigit(results1[1] * Math.pow(10, 3)) + kNm);
                        res2.setText(roundTwoDigit(results1[0] * Math.pow(10, 3)) + kN);

                        res1true.setText(roundTwoDigit(mEdValue * Math.pow(10, 3)) + kNm);
                        res2true.setText(roundTwoDigit(nEdValue * Math.pow(10, 3)) + kN);

                        nRdValue = roundTwoDigit(results1[0] * Math.pow(10, 3));

                        res1trueAsymmetricVar = roundThreeDigitShearing(aS1ValueDiagnostic * Math.pow(10, 4));
                        res2trueAsymmetricVar = roundThreeDigitShearing(aS2ValueDiagnostic * Math.pow(10, 4));

                        mRd = results1[1];

                        resRods1ValueAsymmetric = reinforcementRods(aS1ValueDiagnostic, aS1Value);
                        resRods2ValueAsymmetric = reinforcementRods(aS2ValueDiagnostic, aS2Value);
                    }
                } else {
                    if (mEdValue < 0) {
                        DiagnosticExtension beam1 = new DiagnosticExtension(-nEdValue, -mEdValue, fCk, fYk, bValue, hValue, a2Value, a1Value, aS2ValueDiagnostic, aS1ValueDiagnostic);
                        double[] results1 = beam1.resultsDiagnosticExtension();
                        res1.setText(roundTwoDigit(-results1[1] * Math.pow(10, 3)) + kNm);
                        res2.setText(roundTwoDigit(-results1[0] * Math.pow(10, 3)) + kN);

                        res1true.setText(roundTwoDigit(mEdValue * Math.pow(10, 3)) + kNm);
                        res2true.setText(roundTwoDigit(nEdValue * Math.pow(10, 3)) + kN);

                        nRdValue = roundTwoDigit(results1[0] * Math.pow(10, 3));

                        res1trueAsymmetricVar = roundThreeDigitShearing(aS2ValueDiagnostic * Math.pow(10, 4));
                        res2trueAsymmetricVar = roundThreeDigitShearing(aS1ValueDiagnostic * Math.pow(10, 4));

                        mRd = -results1[1];

                        resRods1ValueAsymmetric = reinforcementRods(aS2ValueDiagnostic, aS2Value);
                        resRods2ValueAsymmetric = reinforcementRods(aS1ValueDiagnostic, aS1Value);
                    } else {
                        DiagnosticExtension beam1 = new DiagnosticExtension(-nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                        double[] results1 = beam1.resultsDiagnosticExtension();
                        res1.setText(roundTwoDigit(results1[1] * Math.pow(10, 3)) + kNm);
                        res2.setText(roundTwoDigit(-results1[0] * Math.pow(10, 3)) + kN);

                        res1true.setText(roundTwoDigit(mEdValue * Math.pow(10, 3)) + kNm);
                        res2true.setText(roundTwoDigit(nEdValue * Math.pow(10, 3)) + kN);

                        nRdValue = roundTwoDigit(results1[0] * Math.pow(10, 3));

                        res1trueAsymmetricVar = roundThreeDigitShearing(aS1ValueDiagnostic * Math.pow(10, 4));
                        res2trueAsymmetricVar = roundThreeDigitShearing(aS2ValueDiagnostic * Math.pow(10, 4));

                        mRd = results1[1];

                        resRods1ValueAsymmetric = reinforcementRods(aS1ValueDiagnostic, aS1Value);
                        resRods2ValueAsymmetric = reinforcementRods(aS2ValueDiagnostic, aS2Value);
                    }
                }
            }
        }

        //Shearing Calculations

        shearingValues();
        if (checkBoxRods.isSelected()) {
            DiagnosticShearing shearing = new DiagnosticShearing(hValue, a1Value, bValue, fCk, nEdValue, aSl, nSw1Value, nSw2Value, aSw1Value, aSw2Value, fYk, vEdRedValue, vEdValue, nSw2RodSValue, s1Value, ctgThetaValue, alphaValue);
            double res = shearing.resultsShearingDiagnostic();
            System.out.println(res);
            sRods.setText(roundThreeDigitShearing(res * Math.pow(10, 3)) + kN);
            sRodsReal.setText(roundThreeDigitShearing(vEdValue * Math.pow(10, 3)) + kN);

            vRd = roundSixDigitShearing(res);
            resShearing = roundSixDigitShearing(res);

            s1SpacingVarTrue = 0;
            s1SpacingVarTrue = s1Value;
        } else {
            DiagnosticShearing shearing = new DiagnosticShearing(hValue, a1Value, bValue, fCk, nEdValue, aSl, nSw1Value, 0, aSw1Value, 0, fYk, vEdRedValue, vEdValue, nSw2RodSValue, s1Value, ctgThetaValue, alphaValue);
            double res = shearing.resultsShearingDiagnostic();
            System.out.println(res);
            sRods.setText(roundThreeDigitShearing(res * Math.pow(10, 3)) + kN);
            sRodsReal.setText(roundThreeDigitShearing(vEdValue * Math.pow(10, 3)) + kN);

            vRd = roundSixDigitShearing(res);
            resShearing = roundSixDigitShearing(res);

            s1SpacingVarTrue = 0;
            s1SpacingVarTrue = s1Value;

            nSw2RodSValue = 0;
            nSw2Value = 0;
            aSw2Value = 0;
        }

        //tBeam


        if (choiceBoxDimensions.getValue().toString().equals("Przekrój Teowy")) {
            if (mEdValue < 0) {
                DiagnosticBendingBeamAndT beam = new DiagnosticBendingBeamAndT(fCk, fYk, bValue, bFTValue, hValue, hFTValue, a2Value, a1Value, aS2ValueDiagnostic, aS1ValueDiagnostic);
                double ress = -beam.resultDiagnostic();
                System.out.println(ress);

                res1.setText(roundTwoDigit(ress * Math.pow(10, 3)) + kNm);
                res1true.setText(roundTwoDigit(mEdValue * Math.pow(10, 3)) + kNm);

                res1trueAsymmetricVar = roundThreeDigitShearing(aS2ValueDiagnostic * Math.pow(10, 4));
                res2trueAsymmetricVar = roundThreeDigitShearing(aS1ValueDiagnostic * Math.pow(10, 4));

                mRd = ress;

                res2.setText(0 + kN);
                res2true.setText(0 + kN);

                resRods1ValueAsymmetric = reinforcementRods(aS2ValueDiagnostic, aS2Value);
                resRods2ValueAsymmetric = reinforcementRods(aS1ValueDiagnostic, aS1Value);

                nRdValue = 0;
            } else {
                DiagnosticBendingBeamAndT beam = new DiagnosticBendingBeamAndT(fCk, fYk, bValue, bFValue, hValue, hFValue, a1Value, a2Value, aS1ValueDiagnostic, aS2ValueDiagnostic);
                double ress = beam.resultDiagnostic();
                System.out.println(ress);

                res1.setText(roundTwoDigit(ress * Math.pow(10, 3)) + kNm);
                res1true.setText(roundTwoDigit(mEdValue * Math.pow(10, 3)) + kNm);

                res1trueAsymmetricVar = roundThreeDigitShearing(aS1ValueDiagnostic * Math.pow(10, 4));
                res2trueAsymmetricVar = roundThreeDigitShearing(aS2ValueDiagnostic * Math.pow(10, 4));

                mRd = ress;

                res2.setText(0 + kN);
                res2true.setText(0 + kN);

                resRods1ValueAsymmetric = reinforcementRods(aS1ValueDiagnostic, aS1Value);
                resRods2ValueAsymmetric = reinforcementRods(aS2ValueDiagnostic, aS2Value);

                nRdValue = 0;
            }

            toPdfButton.setDisable(false);
        }


        if (nEdValue == 0) {

            if (mEdValue > 0) {
                if (choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) { //aS1Value - PROBABLY FI AS1!
                    if (loadChar == 'L') {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * n1Value;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * n2Value;


                        Deflection res1 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, 0, 0, bValue, bValue, a1Value, a2Value, aS1True, aS2True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsLong();
                        double result1a = res1.resultsLongDeformation();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a1Value, a2Value, aS1True, aS2True, mEkValue, mEkLtValue, loadChar);
                        double result2 = res2.wK();


                        //res to labels

                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = roundThreeDigitShearing(result1a * Math.pow(10, 2));
                        fCsVar = roundThreeDigitShearing(fMPlusCResVar - fMResVar);

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(fMPlusCResVar + cm);

                    } else {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * n1Value;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * n2Value;

                        Deflection res1 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, 0, 0, bValue, bValue, a1Value, a2Value, aS1True, aS2True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsShort();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a1Value, a2Value, aS1True, aS2True, mEkValue, mEkLtValue, loadChar);
                        double result2 = res2.wK();

                        //res to labels


                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = 0;
                        fCsVar = roundThreeDigitShearing(fMPlusCResVar - fMResVar);

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(roundThreeDigitShearing(0) + cm);
                    }
                } else {
                    if (loadChar == 'L') {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * n1Value;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * n2Value;


                        Deflection res1 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, hFValue, hFTValue, bFValue, bFTValue, a1Value, a2Value, aS1True, aS2True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsLong();
                        double result1a = res1.resultsLongDeformation();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bFValue, bFTValue, hValue, hFValue, hFTValue, a1Value, a2Value, aS1True, aS2True, mEkValue, mEkLtValue, loadChar);
                        double result2 = res2.wK();


                        //res to labels
                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = roundThreeDigitShearing(result1a * Math.pow(10, 2));
                        fCsVar = roundThreeDigitShearing(fMPlusCResVar - fMResVar);

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(fMPlusCResVar + cm);


                    } else {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * n1Value;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * n2Value;

                        Deflection res1 = new Deflection(lEffValue, mEkLtValue, mEkValue, alphaMValue, mEdValue, bValue, hValue, hFValue, hFTValue, bFValue, bFTValue, a1Value, a2Value, aS1True, aS2True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsShort();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS1Value, resRods1ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bFValue, bFTValue, hValue, hFValue, hFTValue, a1Value, a2Value, aS1True, aS2True, mEkValue, mEkLtValue, loadChar);
                        double result2 = res2.wK();

                        //res to labels


                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = 0;
                        fCsVar = roundThreeDigitShearing(fMPlusCResVar - fMResVar);

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(roundThreeDigitShearing(0) + cm);


                    }
                }
            } else {
                if (choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) { //aS1Value - PROBABLY FI AS1!
                    if (loadChar == 'L') {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * n1Value;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * n2Value;


                        Deflection res1 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, 0, 0, bValue, bValue, a2Value, a1Value, aS2True, aS1True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsLong();
                        double result1a = res1.resultsLongDeformation();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods2ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a2Value, a1Value, aS2True, aS1True, -mEkValue, -mEkLtValue, loadChar);
                        double result2 = res2.wK();


                        //res to labels

                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = roundThreeDigitShearing(result1a * Math.pow(10, 2));
                        fCsVar = roundThreeDigitShearing(fMPlusCResVar - fMResVar);

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(fMPlusCResVar + cm);

                    } else {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * n1Value;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * n2Value;

                        Deflection res1 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, 0, 0, bValue, bValue, a2Value, a1Value, aS2True, aS1True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsShort();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods2ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bValue, bValue, hValue, 0, 0, a2Value, a1Value, aS2True, aS1True, -mEkValue, -mEkLtValue, loadChar);
                        double result2 = res2.wK();

                        //res to labels


                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = 0;
                        fCsVar = roundThreeDigitShearing(fMPlusCResVar - fMResVar);

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(roundThreeDigitShearing(0) + cm);
                    }
                } else {
                    if (loadChar == 'L') {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * n1Value;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * n2Value;


                        Deflection res1 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, hFTValue, hFValue, bFTValue, bFValue, a2Value, a1Value, aS2True, aS1True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsLong();
                        double result1a = res1.resultsLongDeformation();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods2ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bFTValue, bFValue, hValue, hFTValue, hFValue, a2Value, a1Value, aS2True, aS1True, -mEkValue, -mEkLtValue, loadChar);
                        double result2 = res2.wK();


                        //res to labels
                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = roundThreeDigitShearing(result1a * Math.pow(10, 2));
                        fCsVar = roundThreeDigitShearing(fMPlusCResVar - fMResVar);

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(fMPlusCResVar + cm);


                    } else {
                        double aS1True = Math.pow(aS1Value / 2, 2) * Math.PI * n1Value;
                        double aS2True = Math.pow(aS2Value / 2, 2) * Math.PI * n2Value;

                        Deflection res1 = new Deflection(lEffValue, -mEkLtValue, -mEkValue, alphaMValue, -mEdValue, bValue, hValue, hFTValue, hFValue, bFTValue, bFValue, a2Value, a1Value, aS2True, aS1True, loadChar, fCk, rHValue, cementChar, tZeroValue);
                        double result1 = res1.resultsShort();
                        fiCrawling = res1.fiCrawling;

                        Scratch res2 = new Scratch(cNomValue, aSw1Value, aS2Value, resRods2ValueAsymmetric, fCk, rHValue, tZeroValue, cementChar, bValue, bFTValue, bFValue, hValue, hFTValue, hFValue, a2Value, a1Value, aS2True, aS1True, -mEkValue, -mEkLtValue, loadChar);
                        double result2 = res2.wK();

                        //res to labels


                        wResVar = roundThreeDigitShearing(result2 * Math.pow(10, 3));
                        fMResVar = roundThreeDigitShearing(result1 * Math.pow(10, 2));
                        fMPlusCResVar = 0;
                        fCsVar = roundThreeDigitShearing(fMPlusCResVar - fMResVar);

                        wResTrue.setText(wResVar + mm);
                        fMResTrue.setText(fMResVar + cm);
                        fMPlusCResTrue.setText(roundThreeDigitShearing(0) + cm);


                    }
                }
            }
        } else {

            wResVar = 0;
            fMResVar = 0;
            fMPlusCResVar = 0;
            fCsVar = 0;

            wResVarTheoretical = 0;
            fMResVarTheoretical = 0;
            fMPlusCResVarTheoretical = 0;
            fCsVarTheoretical = 0;

            wResTrue.setText(0 + mm);
            fMResTrue.setText(0 + cm);
            fMPlusCResTrue.setText(0 + cm);
        }

        toPdfButton.setDisable(false);
    }

    public void toPdf() throws IOException {
        System.out.println("toPDF");

        NamePDF stringPdf = new NamePDF();

        String fileName = stringPdf.display();
        if (!fileName.isEmpty()) {
            PrintPDF.print(fileName, fYk, rHValue, tZeroValue, mEdValue, mEkValue, mEkLtValue, vEdValue, vEdRedValue,
                    nEdValue, cementChar, fCk, res1AsymmetricVar, res2AsymmetricVar, res1trueAsymmetricVar, res2trueAsymmetricVar,
                    resRods1ValueAsymmetric, resRods2ValueAsymmetric, mRd, wResVarTheoretical, wResVar, fMResVarTheoretical, fMResVar, fCsVarTheoretical, fMPlusCResVarTheoretical, fCsVar, fMPlusCResVar,
                    alphaValue, aS1Value, aS2Value, nSw1Value, nSw2Value, aSw1Value, aSw2Value, s1SpacingVar, nSw2RodSValue, vEdValue, nSw1Value, nSw2Value, aSw1Value, aSw2Value, s1SpacingVarTrue, nSw2RodSValue, vRd, fiCrawling, bValue, hValue, cNomValue, a1Value, a2Value, bFValue, hFValue, bFTValue, hFTValue,
                    lEffValue, alphaMValue, nRdValue, ctgThetaValue);
        }

    }
}
