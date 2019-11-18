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

    private Label aSw2Rod = new Label("A_sw2");
    private Label nSw2Rod = new Label("n_sw2");
    private TextField aSw2RodTxt = new TextField();
    private TextField nSw2RodTxt = new TextField();

    public void  initialize(){
        checkBoxResults1.setSelected(true);
        checkBoxResults2.setSelected(true);
        checkBoxResults3.setSelected(true);
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

}