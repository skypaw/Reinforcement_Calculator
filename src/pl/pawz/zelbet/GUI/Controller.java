package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Controller {



    @FXML
    SubController tab1Controller;
    @FXML
    SubController tab2Controller;
    @FXML
    private TabPane tabPane;



    public void initialize()
    {
        tab1Controller = new SubController();
        //System.out.println(tab1Controller.data);
    }


    public void passData(){

       // System.out.println(tab1Controller.data);
    }
}
