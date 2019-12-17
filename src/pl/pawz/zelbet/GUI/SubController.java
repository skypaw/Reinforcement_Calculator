package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pl.pawz.zelbet.ULS.*;

import java.util.Arrays;

public class SubController {


    @FXML
    Label res1 = new Label();
    @FXML
    Label res2 = new Label();


    // Static text fields to read data from. Used in method "calculations"
    @FXML
    TextField geometryHeight = new TextField();
    @FXML
    TextField steelFYk = new TextField();
    @FXML
    TextField aS1 = new TextField();
    @FXML
    TextField aS2 = new TextField();
    @FXML
    TextField a1 = new TextField();
    @FXML
    TextField a2 = new TextField();
    @FXML
    TextField vEd = new TextField();
    @FXML
    TextField vEdRed;
    @FXML
    TextField ctgTheta = new TextField();
    @FXML
    TextField alpha = new TextField();
    @FXML
    TextField aSw1 = new TextField();
    @FXML
    TextField nSw1 = new TextField();
    @FXML
    TextField mEk = new TextField();
    @FXML
    TextField mEkLt = new TextField();
    @FXML
    TextField tZero = new TextField();
    @FXML
    TextField rH = new TextField();
    @FXML
    TextField cNom = new TextField();
    @FXML
    TextField lEff = new TextField();
    @FXML
    TextField alphaM = new TextField();

    @FXML
    Label res1true;
    @FXML
    Label res2true;
    @FXML
    Label resRods1;
    @FXML
    Label resRods2;

    @FXML
    Label sRods;
    @FXML
    TextField aSlTxt;
    @FXML
    ChoiceBox choiceBoxDimensions;
    @FXML
    Label sRodsReal;


    //non static text fields which depends on check boxes like "four loads", or "bend rods"


    //for four loads basic option

    private TextField mEdLoadsTxt = new TextField();
    private TextField nEdLoadsTxt = new TextField();
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
    private TextField aSw2RodTxt = new TextField();
    private TextField nSw2RodTxt = new TextField();
    private TextField nSw2RodSTxt = new TextField();


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

    private Label test2 = new Label();


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
        nSw2RodSTxt.setPromptText("[m]");

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
            bFValue =(float) (getDataFromTextField(bFDimension, "b_f") * Math.pow(10, -2));
            bFTValue =(float) (getDataFromTextField(bFTDimension, "b_f,t") * Math.pow(10, -2));
            hFValue =(float) (getDataFromTextField(hFDimension, "h_f") * Math.pow(10, -2));
            hFTValue =(float) (getDataFromTextField(hFTDimension, "h_f,t") * Math.pow(10, -2));
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
            nSw2RodSValue = getDataFromTextField(nSw2RodSTxt, "s_sw2");
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

                res1.setText(String.valueOf(roundTwoDigit(ress[0] * Math.pow(10, 4))));
                res2.setText(String.valueOf(roundTwoDigit(ress[1] * Math.pow(10, 4))));

                double resRods1Value = reinforcementRods(ress[0], aS1Value);
                double resRods2Value = reinforcementRods(ress[1], aS2Value);

                resRods1.setText(String.valueOf(resRods1Value));
                resRods2.setText(String.valueOf(resRods2Value));

                res1true.setText(String.valueOf(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4))));
                res2true.setText(String.valueOf(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4))));


            } else {
                if (nEdValue > 0) {
                    CompressionSymmetricReinforcement beam1 = new CompressionSymmetricReinforcement(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value);
                    double[] results1 = beam1.resultsCompressionSymmetricReinforcement();
                    res1.setText(String.valueOf(results1[0] * Math.pow(10, 4)));
                    res2.setText(String.valueOf(results1[1] * Math.pow(10, 4)));

                    double resRods1Value = reinforcementRods(results1[0], aS1Value);
                    double resRods2Value = reinforcementRods(results1[1], aS2Value);

                    resRods1.setText(String.valueOf(resRods1Value));
                    resRods2.setText(String.valueOf(resRods2Value));

                    res1true.setText(String.valueOf(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4)));
                    res2true.setText(String.valueOf(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4)));

                    CompressionAsymmetricReinforcement beam2 = new CompressionAsymmetricReinforcement(nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value);
                    double[] results2 = beam2.resultsCompressionAsymmetricReinforcement();

                } else {
                    ExtensionSymmetricReinforcement beam1 = new ExtensionSymmetricReinforcement(-nEdValue, mEdValue, fCk, fYk, bValue, hValue, a1Value, a2Value);
                    double[] results1 = beam1.resultsExtensionSymmetric();
                    res1.setText(String.valueOf(results1[0] * Math.pow(10, 4)));
                    res2.setText(String.valueOf(results1[1] * Math.pow(10, 4)));

                    double resRods1Value = reinforcementRods(results1[0], aS1Value);
                    double resRods2Value = reinforcementRods(results1[1], aS2Value);

                    resRods1.setText(String.valueOf(resRods1Value));
                    resRods2.setText(String.valueOf(resRods2Value));

                    res1true.setText(String.valueOf(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4)));
                    res2true.setText(String.valueOf(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4)));

                }
            }
        } else if(choiceBoxDimensions.getValue().toString().equals("Przekrój Prostokątny")) {
            System.out.println(nEd1Value); //todo add extension!
            System.out.println(mEd1Value);

            CompressionSymmetricReinforcement beam1 = new CompressionSymmetricReinforcement(nEd1Value, mEd1Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
            double[] results1 = beam1.resultsCompressionSymmetricReinforcement();
            System.out.println(Arrays.toString(results1));

            CompressionSymmetricReinforcement beam2 = new CompressionSymmetricReinforcement(nEd2Value, mEd2Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
            double[] results2 = beam2.resultsCompressionSymmetricReinforcement();
            System.out.println(Arrays.toString(results2));

            CompressionSymmetricReinforcement beam3 = new CompressionSymmetricReinforcement(nEd3Value, mEd3Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
            double[] results3 = beam3.resultsCompressionSymmetricReinforcement();
            System.out.println(Arrays.toString(results3));

            CompressionSymmetricReinforcement beam4 = new CompressionSymmetricReinforcement(nEd4Value, mEd4Value, fCk, fYk, bValue, hValue, a1Value, a2Value);
            double[] results4 = beam4.resultsCompressionSymmetricReinforcement();
            System.out.println(Arrays.toString(results4));

            res1.setText(String.valueOf(Math.max(Math.max(Math.max(results1[0], results2[0]), results3[0]), results4[0]) * Math.pow(10, 4)));
            res2.setText(String.valueOf(Math.max(Math.max(Math.max(results1[1], results2[1]), results3[1]), results4[1]) * Math.pow(10, 4)));

            double resRods1Value = reinforcementRods(Math.max(Math.max(Math.max(results1[0], results2[0]), results3[0]), results4[0]), aS1Value);
            double resRods2Value = reinforcementRods(Math.max(Math.max(Math.max(results1[1], results2[1]), results3[1]), results4[1]), aS2Value);

            resRods1.setText(String.valueOf(resRods1Value));
            resRods2.setText(String.valueOf(resRods2Value));


            res1true.setText(String.valueOf(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4)));
            res2true.setText(String.valueOf(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4)));


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


        if (choiceBoxDimensions.getValue().toString().equals("Przekrój Teowy")){
            BendingBeamT beam = new BendingBeamT(mEdValue, fCk, fYk,bValue ,2*bFValue+bValue,hValue, hFValue, a1Value, a2Value);
            double[] ress = beam.resultsBendingT();
            System.out.println(Arrays.toString(ress));

            res1.setText(String.valueOf(roundTwoDigit(ress[0] * Math.pow(10, 4))));
            res2.setText(String.valueOf(roundTwoDigit(ress[1] * Math.pow(10, 4))));

            double resRods1Value = reinforcementRods(ress[0], aS1Value);
            double resRods2Value = reinforcementRods(ress[1], aS2Value);

            resRods1.setText(String.valueOf(resRods1Value));
            resRods2.setText(String.valueOf(resRods2Value));

            res1true.setText(String.valueOf(roundTwoDigit(Math.pow(aS1Value * 0.5, 2) * Math.PI * resRods1Value * Math.pow(10, 4))));
            res2true.setText(String.valueOf(roundTwoDigit(Math.pow(aS2Value * 0.5, 2) * Math.PI * resRods2Value * Math.pow(10, 4))));
        }

    }
}
