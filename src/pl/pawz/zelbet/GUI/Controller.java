package pl.pawz.zelbet.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pl.pawz.zelbet.ULS.*;

import java.util.Arrays;

public class Controller {


    @FXML
    private SubController tab1Controller;
    @FXML
    private SubController tab2Controller;
    @FXML
    private TabPane tabPane;



    public void initialize()
    {

        GlobalStatic.setScene(tabPane.getScene());
        System.out.println();
        System.out.println();
    }

}
