package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {
    @FXML
    private AnchorPane mainRoot;

    @FXML
    private Button startGame;

    @FXML
    private Button startGame1;

    @FXML
    private ImageView startgame;

    @FXML
    private ImageView exitGame;

    @FXML
    private ImageView selectLevel;

    @FXML
    private ImageView loadGame;

    @FXML
    void exitGame(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

    @FXML
    void showLevelMenu(MouseEvent event) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("LevelMenu.fxml"));
        mainRoot.getChildren().setAll(pane);
    }

    @FXML
    void showSavedGames(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("loadGame.fxml"));
        mainRoot.getChildren().setAll(pane);
    }

    @FXML
    void startGame(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        mainRoot.getChildren().setAll(pane);
    }

}
