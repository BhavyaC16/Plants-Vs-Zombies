package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
        try{
            Database.serialize();
        }
        catch(IOException e){
            System.out.println("Could not save the progress :(");
        }
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        Database.getInstance().setMaxLevel(5);

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(Database.getInstance().getMaxLevel(),new DataTable(Database.getInstance().getMaxLevel()));
        mainRoot.getChildren().setAll(pane);
    }

}
