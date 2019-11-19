package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller {

    @FXML
    CheckBox checkBoxRods = new CheckBox();
    @FXML
    GridPane gridPaneRods = new GridPane();

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

    private Label aSw2Rod = new Label("A_sw2");
    private Label nSw2Rod = new Label("n_sw2");
    private TextField aSw2RodTxt = new TextField();
    private TextField nSw2RodTxt = new TextField();

    private Label mEdLoads = new Label("M_ed");
    private Label nEdLoads = new Label("N_ed");
    private Label vEdLoads = new Label("V_ed");
    private TextField mEdLoadsTxt = new TextField();
    private TextField nEdLoadsTxt = new TextField();
    private TextField vEdLoadsTxt = new TextField();


    private Label mEdLoads1 = new Label("M_ed");

    private Label loadsDesc1 = new Label("M_ed_max");
    private Label loadsDesc2 = new Label("M_ed_min");
    private Label loadsDesc3= new Label("N_ed_max");
    private Label loadsDesc4 = new Label("N_ed_min");

    private Label nEdLoads1 = new Label("N_ed");


    private TextField mEdLoadsTxt1 = new TextField();
    private TextField mEdLoadsTxt2 = new TextField();
    private TextField mEdLoadsTxt3 = new TextField();
    private TextField mEdLoadsTxt4 = new TextField();
    private TextField nEdLoadsTxt1 = new TextField();
    private TextField nEdLoadsTxt2 = new TextField();
    private TextField nEdLoadsTxt3 = new TextField();
    private TextField nEdLoadsTxt4 = new TextField();


    public void initialize() {
        checkBoxResults1.setSelected(true);
        checkBoxResults2.setSelected(true);
        checkBoxResults3.setSelected(true);
        loadsInit();

    }

    public void checkBoxRod() {
        aSw2RodTxt.setPrefWidth(70);
        nSw2RodTxt.setPrefWidth(40);
        aSw2RodTxt.setPromptText("[mm]");
        nSw2RodTxt.setPromptText("[szt]");

        if (checkBoxRods.isSelected()) {
            GridPane.setConstraints(aSw2Rod, 0, 3);
            GridPane.setConstraints(aSw2RodTxt, 1, 3);

            GridPane.setConstraints(nSw2Rod, 2, 3);
            GridPane.setConstraints(nSw2RodTxt, 3, 3);

            gridPaneRods.getChildren().addAll(aSw2Rod, nSw2Rod, aSw2RodTxt, nSw2RodTxt);
        } else {

            gridPaneRods.getChildren().removeAll(aSw2Rod, nSw2Rod, aSw2RodTxt, nSw2RodTxt);
        }
    }

    public void fourLoads() {
        if (checkBoxLoads.isSelected()) {

            GridPane.setConstraints(loadsDesc1,1,3);
            GridPane.setConstraints(loadsDesc2,2,3);
            GridPane.setConstraints(loadsDesc3,3,3);
            GridPane.setConstraints(loadsDesc4,4,3);

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

            GridPane.setConstraints(vEdLoads, 0, 6);
            GridPane.setConstraints(vEdLoadsTxt, 1, 6);

            gridLoads.getChildren().removeAll(mEdLoads, mEdLoadsTxt, nEdLoads, nEdLoadsTxt, vEdLoads, vEdLoadsTxt);
            gridLoads.getChildren().addAll(mEdLoads1, loadsDesc1, loadsDesc2, loadsDesc3,loadsDesc4, mEdLoadsTxt1, mEdLoadsTxt2,
                    mEdLoadsTxt3, mEdLoadsTxt4, nEdLoads1, nEdLoadsTxt1, nEdLoadsTxt2,
                    nEdLoadsTxt3, nEdLoadsTxt4, vEdLoads, vEdLoadsTxt);


        } else {
            loadsInit();
        }
    }

    private void loadsInit() {

        GridPane.setConstraints(mEdLoads, 0, 3);
        GridPane.setConstraints(mEdLoadsTxt, 1, 3);

        GridPane.setConstraints(vEdLoads, 2, 3);
        GridPane.setConstraints(vEdLoadsTxt, 3, 3);

        GridPane.setConstraints(nEdLoads, 4, 3);
        GridPane.setConstraints(nEdLoadsTxt, 5, 3);

        gridLoads.getChildren().removeAll(mEdLoads1, loadsDesc1, loadsDesc2, loadsDesc3,loadsDesc4, mEdLoadsTxt1,
                mEdLoadsTxt2, mEdLoadsTxt3, mEdLoadsTxt4, nEdLoads1, nEdLoadsTxt1, nEdLoadsTxt2,
                nEdLoadsTxt3, nEdLoadsTxt4, vEdLoads, vEdLoadsTxt);

        gridLoads.getChildren().addAll(mEdLoads, mEdLoadsTxt, nEdLoads, nEdLoadsTxt, vEdLoads, vEdLoadsTxt);
    }
}
