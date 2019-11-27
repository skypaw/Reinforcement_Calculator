package pl.pawz.zelbet.GUI.Menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    Button buttonSceneRectangle = new Button();
    @FXML
    Button buttonSceneT = new Button();
    @FXML
    GridPane test = new GridPane();

    public void onClick(){
        pl.pawz.zelbet.GUI.CrossSectionRectangle.Controller test = new pl.pawz.zelbet.GUI.CrossSectionRectangle.Controller();
        test.initialize();
    }

}
