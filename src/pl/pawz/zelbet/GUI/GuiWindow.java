package pl.pawz.zelbet.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class GuiWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(root);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        Scene sceneRectangle = new Scene(scrollPane);

        primaryStage.setTitle("Reinforcement Calculator");
        primaryStage.setScene(sceneRectangle);
        primaryStage.show();

    }

}
