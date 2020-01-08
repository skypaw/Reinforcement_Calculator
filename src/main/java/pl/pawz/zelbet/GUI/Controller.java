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
            tab2Controller.test1.setText(String.valueOf(tab1Controller.data.get("bValue")));
            tab2Controller.steelFYk.setText(String.valueOf(tab1Controller.data.get("fYk")));
            tab2Controller.aS1.setText(String.valueOf(tab1Controller.data.get("fiS1")));
            tab2Controller.aS2.setText(String.valueOf(tab1Controller.data.get("fiS2")));
            tab2Controller.a1.setText(String.valueOf(tab1Controller.data.get("a1")));
            tab2Controller.a2.setText(String.valueOf(tab1Controller.data.get("a2")));
            tab2Controller.n1.setText(String.valueOf(tab1Controller.data.get("ns1")));
            tab2Controller.n2.setText(String.valueOf(tab1Controller.data.get("ns2")));


        }


    }


}
