package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

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
    private DataTable data;
    public static ArrayList<Plant> allPlants;
    private static ArrayList<LawnMower> allMowers;
    private static int sunCount;
    private static ArrayList<Zombie> allZombies;
    private static int time;

    @FXML
    public void initData(AnchorPane gamePlayRoot,int levelNumber,DataTable d, int sunCount,ArrayList<Plant> allPlants,ArrayList<Zombie> allZombie,ArrayList<LawnMower> allLawnMowers, int timeElapsed){
        this.GamePlayRoot=gamePlayRoot;
        this.levelNumber=levelNumber;
        this.data=d;
        this.sunCount=sunCount;
        this.allPlants=allPlants;
        this.allZombies=allZombie;
        this.allMowers=allLawnMowers;
        this.time=timeElapsed;
    }

    @FXML
    void restartGame(MouseEvent event) throws IOException {
        GamePlayController.gameStatus = false;
        GamePlayController.sunTimeline.stop();
        System.out.println("restart called");
        Stage stage = (Stage) restartGameButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane game=fxmlLoader.load();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        data=new DataTable(levelNumber);
        controller.initData(levelNumber,data);

        GamePlayRoot.getChildren().setAll(game);
    }

    @FXML
    void saveGame(MouseEvent event) throws IOException {
        GamePlayController.gameStatus = false;
        GamePlayController.sunTimeline.stop();
        GameMenuMessage.setText("Game Saved!");
        data.update(levelNumber,sunCount, allPlants,allZombies,allMowers, time);
        data.saveGame();
        Database.getInstance().setMaxLevel(levelNumber);
    }

    @FXML
    void showMainMenu(MouseEvent event) throws IOException {
        GamePlayController.gameStatus = false;
        GamePlayController.sunTimeline.stop();
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        GamePlayRoot.getChildren().setAll(pane);
        Stage stage = (Stage) restartGameButton.getScene().getWindow();
        stage.close();

    }

}

