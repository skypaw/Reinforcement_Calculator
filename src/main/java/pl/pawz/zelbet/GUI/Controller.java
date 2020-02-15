package pl.pawz.zelbet.GUI;


import javafx.fxml.FXML;

public class Controller {


    @FXML
    SubController tab1Controller;
    @FXML
    SubController tab2Controller;
    @FXML
    GraphController tab3Controller;

    public void button(){
        tab3Controller.button();
    }

    public void dataPass() {


        if (tab1Controller.data != null) {
            tab3Controller.geometryHeight.setText(String.valueOf(tab1Controller.data.get("hValue")));
            tab3Controller.test1.setText(String.valueOf(tab1Controller.data.get("bValue")));
            tab3Controller.steelFYk.setText(String.valueOf(tab1Controller.data.get("fYk")));
            tab3Controller.aS1.setText(String.valueOf(tab1Controller.data.get("fiS1")));
            tab3Controller.aS2.setText(String.valueOf(tab1Controller.data.get("fiS2")));
            tab3Controller.a1.setText(String.valueOf(tab1Controller.data.get("a1")));
            tab3Controller.a2.setText(String.valueOf(tab1Controller.data.get("a2")));
            tab3Controller.n1.setText(String.valueOf(tab1Controller.data.get("ns1")));
            tab3Controller.n2.setText(String.valueOf(tab1Controller.data.get("ns2")));
            tab3Controller.fCk.setText(String.valueOf(tab1Controller.fCk));




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

            tab2Controller.mEk.setText(String.valueOf(tab1Controller.data.get("mEk")));
            tab2Controller.mEkLt.setText(String.valueOf(tab1Controller.data.get("mEkLt")));
            tab2Controller.tZero.setText(String.valueOf(tab1Controller.data.get("tZero")));
            tab2Controller.rH.setText(String.valueOf(tab1Controller.data.get("rH")));
            tab2Controller.cNom.setText(String.valueOf(tab1Controller.data.get("cNom")));
            tab2Controller.lEff.setText(String.valueOf(tab1Controller.data.get("lEff")));
            tab2Controller.alphaM.setText(String.valueOf(tab1Controller.data.get("alphaM")));

            tab2Controller.s1.setText(String.valueOf(tab1Controller.data.get("sSw1")));
            tab2Controller.bFDimension.setText(String.valueOf(tab1Controller.data.get("beff")));
            tab2Controller.bFTDimension.setText(String.valueOf(tab1Controller.data.get("befft")));
            tab2Controller.hFDimension.setText(String.valueOf(tab1Controller.data.get("hf")));
            tab2Controller.hFTDimension.setText(String.valueOf(tab1Controller.data.get("hft")));

            if (tab1Controller.choiceBoxDimensions.getValue().equals("Przekrój Prostokątny")){
                if (!tab2Controller.choiceBoxDimensions.getValue().equals("Przekrój Prostokątny")){
                    tab2Controller.choiceBoxDimensions.setValue("Przekrój Prostokątny");
                }
            }
            if (tab1Controller.choiceBoxDimensions.getValue().equals("Przekrój Teowy")){
                if (!tab2Controller.choiceBoxDimensions.getValue().equals("Przekrój Teowy")){
                    tab2Controller.choiceBoxDimensions.setValue("Przekrój Teowy");
                }
            }


            if (tab1Controller.choiceBoxLoads.getValue().equals("Obciążenie doraźne")){
                if (!tab2Controller.choiceBoxLoads.getValue().equals("Obciążenie doraźne")){
                    tab2Controller.choiceBoxLoads.setValue("Obciążenie doraźne");
                }
            }
            if (tab1Controller.choiceBoxLoads.getValue().equals("Obciążenie długotrwałe")){
                if (!tab2Controller.choiceBoxLoads.getValue().equals("Obciążenie długotrwałe")){
                    tab2Controller.choiceBoxLoads.setValue("Obciążenie długotrwałe");
                }
            }

            if (tab1Controller.choiceBoxCementClass.getValue().equals("Klasa N")){
                if (!tab2Controller.choiceBoxCementClass.getValue().equals("Klasa N")){
                    tab2Controller.choiceBoxCementClass.setValue("Klasa N");
                }
            }

            if (tab1Controller.choiceBoxCementClass.getValue().equals("Klasa S")){
                if (!tab2Controller.choiceBoxCementClass.getValue().equals("Klasa S")){
                    tab2Controller.choiceBoxCementClass.setValue("Klasa S");
                }
            }

            if (tab1Controller.choiceBoxCementClass.getValue().equals("Klasa R")){
                if (!tab2Controller.choiceBoxCementClass.getValue().equals("Klasa R")){
                    tab2Controller.choiceBoxCementClass.setValue("Klasa R");
                }
            }


        }


    }


}
