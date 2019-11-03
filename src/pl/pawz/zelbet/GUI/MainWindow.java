package pl.pawz.zelbet.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MainWindow extends Application {
    public void mainWindow(){
        launch();
    }
    public void start (Stage primaryStage) throws Exception{
        primaryStage.setTitle("Beton");
        StackPane layout = new StackPane();
        layout.getChildren();

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
