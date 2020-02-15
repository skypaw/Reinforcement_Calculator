package pl.pawz.zelbet.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class GuiWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainTabs.fxml"));

        Scene sceneRectangle = new Scene(root);

        primaryStage.setTitle("Reinforcement Calculator");
        primaryStage.setScene(sceneRectangle);
        primaryStage.show();

        Image ico = new Image("/icons/ico.png");
        primaryStage.getIcons().add(ico);

    }

}
