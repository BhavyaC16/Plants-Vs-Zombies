package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameMenuController {
    @FXML
    private AnchorPane GamePlayRoot;

    @FXML
    private AnchorPane GameMenuRoot;

    @FXML
    private ImageView returnToMainMenuButton;

    @FXML
    private ImageView saveGameButton;

    @FXML
    private ImageView restartGameButton;

    @FXML
    private Label GameMenuMessage;

    @FXML
    private int levelNumber;

    @FXML
    public void initData(AnchorPane gamePlayRoot,int levelNumber){
        this.GamePlayRoot=gamePlayRoot;
        this.levelNumber=levelNumber;
    }

    @FXML
    void restartGame(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(levelNumber);
        Stage stage = (Stage) restartGameButton.getScene().getWindow();
        stage.close();
        AnchorPane game= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        GamePlayRoot.getChildren().setAll(game);
    }

    @FXML
    void saveGame(MouseEvent event) throws IOException {
        GameMenuMessage.setText("Game Saved!");
    }

    @FXML
    void showMainMenu(MouseEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        GamePlayRoot.getChildren().setAll(pane);
        Stage stage = (Stage) restartGameButton.getScene().getWindow();
        stage.close();

    }

}

