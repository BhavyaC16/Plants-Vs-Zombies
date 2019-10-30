package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.viewManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        viewManager view = new viewManager();
        primaryStage = view.getMainStage();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
