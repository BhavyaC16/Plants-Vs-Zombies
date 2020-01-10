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
    private static double time;
    private static ArrayList<Integer> zombieList1;
    private static ArrayList<Integer> zombieList2;

    @FXML
    public void initData(AnchorPane gamePlayRoot, int levelNumber, DataTable d, int sCount, List<Plant> allPlant, List<Zombie> allZombie, List<LawnMower> allLawnMowers, double timeElapsed, ArrayList<Integer> zL1, ArrayList<Integer> zL2){
        this.GamePlayRoot=gamePlayRoot;
        this.levelNumber=levelNumber;
        this.data=d;
        sunCount=sCount;
        allPlants=allPlant;
        allZombies=allZombie;
        allMowers=allLawnMowers;
        time=timeElapsed;
        zombieList1 = zL1;
        zombieList2 = zL2;
    }

    @FXML
    void restartGame(MouseEvent event) throws IOException {
        GamePlayController.gameStatus = false;
        GamePlayController.endAnimations();
        //System.out.println("restart called");
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
        data.update(levelNumber,sunCount, allPlants,allZombies,allMowers, time, zombieList1, zombieList2, LevelMenuController.status);
        Main.getDatabase().removeData(data);
        data.saveGame();
        Main.getDatabase().setMaxLevel(levelNumber);

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

