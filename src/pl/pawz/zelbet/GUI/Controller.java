package pl.pawz.zelbet.GUI;


import javafx.fxml.FXML;

public class Controller {


    @FXML
    SubController tab1Controller;
    @FXML
    SubController tab2Controller;


    public void dataPass() {


        if (tab1Controller.data != null) {

            tab2Controller.geometryHeight.setText(String.valueOf(tab1Controller.data.get("hValue")));
        }


    }


}
