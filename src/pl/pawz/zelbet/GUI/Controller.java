package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Controller {


    @FXML
    CheckBox checkBoxRods = new CheckBox();
    @FXML
    GridPane gridPaneShearing = new GridPane();
    @FXML
    GridPane gridPaneSGU = new GridPane();
    @FXML
    GridPane gridPaneSGN = new GridPane();

    @FXML
    CheckBox checkBoxResults1 = new CheckBox();
    @FXML
    CheckBox checkBoxResults2 = new CheckBox();
    @FXML
    CheckBox checkBoxResults3 = new CheckBox();

    @FXML
    CheckBox checkBoxLoads = new CheckBox();
    @FXML
    GridPane gridLoads = new GridPane();

    @FXML
    CheckBox checkBoxConcrete = new CheckBox();
    @FXML
    GridPane gridDimensions = new GridPane();
    @FXML
    ChoiceBox choiceBoxConcrete = new ChoiceBox();

    @FXML
    VBox vBoxCenter = new VBox();

    private Label aSw2Rod = new Label("A_sw2");
    private Label nSw2Rod = new Label("n_sw2");
    private Label nSw2RodS = new Label("s_sw2");
    private TextField aSw2RodTxt = new TextField();
    private TextField nSw2RodTxt = new TextField();
    private TextField nSw2RodSTxt = new TextField();

    private Label mEdLoads = new Label("M_Ed");
    private Label nEdLoads = new Label("N_Ed");
    private Label vEdLoads = new Label("V_Ed");
    private TextField mEdLoadsTxt = new TextField();
    private TextField nEdLoadsTxt = new TextField();
    private TextField vEdLoadsTxt = new TextField();


    private Label mEdLoads1 = new Label("M_Ed");

    private Label loadsDesc1 = new Label("M_Ed_max");
    private Label loadsDesc2 = new Label("M_Ed_min");
    private Label loadsDesc3 = new Label("N_Ed_max");
    private Label loadsDesc4 = new Label("N_Ed_min");

    private Label nEdLoads1 = new Label("N_Ed");


    private TextField mEdLoadsTxt1 = new TextField();
    private TextField mEdLoadsTxt2 = new TextField();
    private TextField mEdLoadsTxt3 = new TextField();
    private TextField mEdLoadsTxt4 = new TextField();
    private TextField nEdLoadsTxt1 = new TextField();
    private TextField nEdLoadsTxt2 = new TextField();
    private TextField nEdLoadsTxt3 = new TextField();
    private TextField nEdLoadsTxt4 = new TextField();

    private TextField concreteTxt = new TextField();


    public void initialize() {
        checkBoxResults1.setSelected(true);
        checkBoxResults2.setSelected(true);
        checkBoxResults3.setSelected(true);
        loadsInit();
        concreteInit();
        checkBoxConcrete.setSelected(true);
        choiceBoxConcrete.setValue("C30/37");
        choiceBoxConcrete.getItems().addAll("C12/15", "C16/20", "C20/25", "C25/30", "C30/37", "C35/45", "C40/50", "C45/55", "C50/60", "C55/67", "C60/75", "C70/85", "C80/95", "C90/105", "C100/115");


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

            gridPaneShearing.getChildren().addAll(aSw2Rod, nSw2Rod, aSw2RodTxt, nSw2RodTxt,nSw2RodS,nSw2RodSTxt);
        } else {

            gridPaneShearing.getChildren().removeAll(aSw2Rod, nSw2Rod, aSw2RodTxt, nSw2RodTxt,nSw2RodS,nSw2RodSTxt);
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
        vEdLoadsTxt.setPrefWidth(70);

        mEdLoadsTxt.setPromptText("[kNm]");
        nEdLoadsTxt.setPromptText("[kN]");
        vEdLoadsTxt.setPromptText("[kN]");

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

    public void bottomButtonsController(){
        if (checkBoxResults1.isSelected()){
            gridPaneSGN.setDisable(false);
        }else {
            gridPaneSGN.setDisable(true);
        }

        if (checkBoxResults2.isSelected()){
            gridPaneShearing.setDisable(false);
        }else {
            gridPaneShearing.setDisable(true);
        }

        if (checkBoxResults3.isSelected()){
            gridPaneSGU.setDisable(false);
        }else {
            gridPaneSGU.setDisable(true);
        }

    }
}
