package sample.view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;

public class viewManager {

    private static final int height = 600;
    private static final int width = 1024;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    public viewManager()
    {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, width, height);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
//        createButtons();
    }

    public Stage getMainStage()
    {
        return mainStage;
    }

//    private void createButtons()
//    {
//        Button button = new Button("Click me!");
//        mainPane.getChildren().add(button);
//    }
}
