package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.junit.FixMethodOrder;

public class Controller {


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
    TextField vEdRed = new TextField();
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

    // check boxes used to rebuild gui
    @FXML
    CheckBox checkBoxRods = new CheckBox();
    @FXML
    CheckBox checkBoxResults1 = new CheckBox();
    @FXML
    CheckBox checkBoxResults2 = new CheckBox();
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
    double bValue = 0;
    double hValue = 0;
    double fYk = 0;
    double aS1Value = 0;
    double aS2Value = 0;
    double a1Value = 0;
    double a2Value = 0;
    double vEdValue = 0;
    double vEdRedValue = 0;
    double ctgThetaValue = 0;
    double alphaValue = 0;
    double aSw1Value = 0;
    double nSw1Value = 0;
    double mEkValue = 0;
    double mEkLtValue = 0;
    double tZeroValue = 0;
    double rHValue = 0;
    double cNomValue = 0;
    double lEffValue = 0;
    double alphaMValue = 0;

    //values which depends on check box

    double concreteValue = 0;
    double mEdValue = 0;
    double nEdValue = 0;
    double mEd1Value = 0;
    double mEd2Value = 0;
    double mEd3Value = 0;
    double mEd4Value = 0;
    double nEd1Value = 0;
    double nEd2Value = 0;
    double nEd3Value = 0;
    double nEd4Value = 0;
    double aSw2Value = 0;
    double nSw2Value = 0;


    private double testString1;


    public void initialize() {
        checkBoxResults1.setSelected(true);
        checkBoxResults2.setSelected(true);
        checkBoxResults3.setSelected(true);
        loadsInit();
        concreteInit();
        checkBoxConcrete.setSelected(true);
        choiceBoxConcrete.setValue("C30/37");
        choiceBoxConcrete.getItems().addAll("C12/15", "C16/20", "C20/25", "C25/30", "C30/37", "C35/45", "C40/50", "C45/55", "C50/60", "C55/67", "C60/75", "C70/85", "C80/95", "C90/105", "C100/115");


        GridPane.setConstraints(test2, 8, 8);
        gridPaneShearing.getChildren().add(test2);

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

    public void bottomButtonsController() {
        if (checkBoxResults1.isSelected()) {
            gridPaneSGN.setDisable(false);
        } else {
            gridPaneSGN.setDisable(true);
        }

        if (checkBoxResults2.isSelected()) {
            gridPaneShearing.setDisable(false);
        } else {
            gridPaneShearing.setDisable(true);
        }

        if (checkBoxResults3.isSelected()) {
            gridPaneSGU.setDisable(false);
        } else {
            gridPaneSGU.setDisable(true);
        }

    }

    public void test1() {
        String testString = test1.getText();

        if (testString.isEmpty() || testString.equals("-0") || testString.equals("-")) {
            testString = "0";
        }

        testString = testString.replaceAll(",", ".");
        double testString1 = Double.valueOf(testString);
        System.out.println(testString1);
        test2.setText(Double.toString(testString1));

    }


    //Functionality, calculations and returning correct values


    private double fCk(){
        if (checkBoxConcrete.isSelected()){
            double[] concreteList = {12,16,20,25,30,25,40,45,50,55,60,70,80,90,100};
            return concreteList[choiceBoxConcrete.getSelectionModel().getSelectedIndex()];
        }else{
            try {

                double value = Double.parseDouble(concreteTxt.getText().replaceAll(",","."));
                if(value>=0) {return value;}
                else{
                    AlertBox.display("Błąd","Wartość nie może być ujemna");
                    return 0;
                }
            }catch (NumberFormatException e){
                AlertBox.display("Błąd","Błąd przy podawaniu danych.");
                return 0;
            }
        }
    }


    public void calculations() {
        System.out.println(fCk());
    }


    /* public void todoValues(){
        //values which depends on check box

        //static Values
        bValue = Double.parseDouble(test1.getText());
        hValue = Double.parseDouble(geometryHeight.getText());
        fYk = Double.parseDouble(steelFYk.getText());
        aS1Value = Double.parseDouble(aS1.getText());
        aS2Value = Double.parseDouble(aS2.getText());
        a1Value = Double.parseDouble(a1.getText());
        a2Value = Double.parseDouble(a2.getText());
        vEdValue = Double.parseDouble(vEd.getText());
        vEdRedValue = Double.parseDouble(vEdRed.getText());
        ctgThetaValue = Double.parseDouble(ctgTheta.getText());
        alphaValue = Double.parseDouble(alpha.getText());
        aSw1Value = Double.parseDouble(aSw1.getText());
        nSw1Value = Double.parseDouble(nSw1.getText());
        mEkValue = Double.parseDouble(mEk.getText());
        mEkLtValue = Double.parseDouble(mEkLt.getText());
        tZeroValue = Double.parseDouble(tZero.getText());
        rHValue = Double.parseDouble(rH.getText());
        cNomValue = Double.parseDouble(cNom.getText());
        lEffValue = Double.parseDouble(lEff.getText());
        alphaMValue = Double.parseDouble(alphaM.getText());


        concreteValue = Double.parseDouble(concreteTxt.getText());
        mEdValue = Double.parseDouble(mEdLoadsTxt.getText());
        nEdValue = Double.parseDouble(nEdLoadsTxt.getText());
        mEd1Value = Double.parseDouble(mEdLoadsTxt1.getText());
        mEd2Value = Double.parseDouble(mEdLoadsTxt2.getText());
        mEd3Value = Double.parseDouble(mEdLoadsTxt3.getText());
        mEd4Value = Double.parseDouble(mEdLoadsTxt4.getText());
        nEd1Value = Double.parseDouble(nEdLoadsTxt1.getText());
        nEd2Value = Double.parseDouble(nEdLoadsTxt2.getText());
        nEd3Value = Double.parseDouble(nEdLoadsTxt3.getText());
        nEd4Value = Double.parseDouble(nEdLoadsTxt4.getText());
        aSw2Value = Double.parseDouble(aSw2RodTxt.getText());
        nSw2Value = Double.parseDouble(nSw2RodTxt.getText());
    }*/
}
