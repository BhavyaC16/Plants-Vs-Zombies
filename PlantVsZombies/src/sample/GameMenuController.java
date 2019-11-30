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
import java.util.List;

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
    public static List<Plant> allPlants;
    private static List<LawnMower> allMowers;
    private static int sunCount;
    private static List<Zombie> allZombies;
    private static int time;

    @FXML
    public void initData(AnchorPane gamePlayRoot, int levelNumber, DataTable d, int sunCount, List<Plant> allPlants, List<Zombie> allZombie, List<LawnMower> allLawnMowers, int timeElapsed){
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
        GamePlayController.endAnimations();
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
        GameMenuMessage.setText("Game Saved!");
        Database.getInstance().removeData(data);
        data.update(levelNumber,sunCount, allPlants,allZombies,allMowers, time);
        data.saveGame();
        Database.getInstance().setMaxLevel(levelNumber);

    }

    @FXML
    void showMainMenu(MouseEvent event) throws IOException {
        GamePlayController.gameStatus = false;
        GamePlayController.endAnimations();
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        GamePlayRoot.getChildren().setAll(pane);
        Stage stage = (Stage) restartGameButton.getScene().getWindow();
        stage.close();

    }

}

