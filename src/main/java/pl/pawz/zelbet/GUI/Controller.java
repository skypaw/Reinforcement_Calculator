package pl.pawz.zelbet.GUI;


import javafx.fxml.FXML;

public class Controller {


    @FXML
    SubController tab1Controller;
    @FXML
    SubController tab2Controller;


    public void dataPass() {


        if (tab1Controller.data != null) {

            tab2Controller.mEdLoadsTxt.setText(String.valueOf(tab1Controller.data.get("mEd")));
            tab2Controller.nEdLoadsTxt.setText(String.valueOf(tab1Controller.data.get("nEd")));

            tab2Controller.geometryHeight.setText(String.valueOf(tab1Controller.data.get("hValue")));
            tab2Controller.test1.setText(String.valueOf(tab1Controller.data.get("bValue")));
            tab2Controller.steelFYk.setText(String.valueOf(tab1Controller.data.get("fYk")));
            tab2Controller.aS1.setText(String.valueOf(tab1Controller.data.get("fiS1")));
            tab2Controller.aS2.setText(String.valueOf(tab1Controller.data.get("fiS2")));
            tab2Controller.a1.setText(String.valueOf(tab1Controller.data.get("a1")));
            tab2Controller.a2.setText(String.valueOf(tab1Controller.data.get("a2")));
            tab2Controller.n1.setText(String.valueOf(tab1Controller.data.get("ns1")));
            tab2Controller.n2.setText(String.valueOf(tab1Controller.data.get("ns2")));
            tab2Controller.vEd.setText(String.valueOf(tab1Controller.data.get("vEd")));
            tab2Controller.vEdRed.setText(String.valueOf(tab1Controller.data.get("vEdRed")));
            tab2Controller.ctgTheta.setText(String.valueOf(tab1Controller.data.get("ctg")));
            tab2Controller.alpha.setText(String.valueOf(tab1Controller.data.get("alpha")));
            tab2Controller.aSlTxt.setText(String.valueOf(tab1Controller.data.get("aSl")));
            tab2Controller.aSw1.setText(String.valueOf(tab1Controller.data.get("aSw1")));
            tab2Controller.aSw2RodTxt.setText(String.valueOf(tab1Controller.data.get("aSw2")));
            tab2Controller.nSw1.setText(String.valueOf(tab1Controller.data.get("nSw1")));
            tab2Controller.nSw2RodTxt.setText(String.valueOf(tab1Controller.data.get("nSw2")));
            tab2Controller.nSw2RodSTxt.setText(String.valueOf(tab1Controller.data.get("sSw2")));


        }


    }


}