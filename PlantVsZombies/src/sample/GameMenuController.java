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
    public void initData(AnchorPane gamePlayRoot){
        this.GamePlayRoot=gamePlayRoot;
    }

    @FXML
    void restartGame(MouseEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        this.GamePlayRoot.getChildren().setAll(pane);
        Stage stage = (Stage) restartGameButton.getScene().getWindow();
        stage.close();
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

