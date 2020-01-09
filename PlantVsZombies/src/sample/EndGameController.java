package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class EndGameController {

    @FXML
    private AnchorPane endGame;

    @FXML
    private ImageView zombiesAteYourBrains;

    @FXML
    private ImageView youAteZombiesBrains;

    @FXML
    private ImageView plantImage;

    @FXML
    private Label plantName;

    @FXML
    private ImageView youWon;

    @FXML
    private ImageView nextLevelButton;

    @FXML
    private Button mainMenuButton;

    private int l;
    private boolean gameWin;

    @FXML
    void goToMainMenu(MouseEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        endGame.getChildren().setAll(pane);
    }

    @FXML
    void goToNextLevel(MouseEvent event) throws IOException{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("LevelMenu.fxml"));
        endGame.getChildren().setAll(pane);
    }

    @FXML
    public void initialize(){
        zombiesAteYourBrains.setVisible(false);
        youWon.setVisible(false);
        nextLevelButton.setVisible(false);
        nextLevelButton.setDisable(true);
        plantImage.setVisible(false);
        youAteZombiesBrains.setVisible(false);
        plantName.setVisible(false);
    }
    @FXML
    public void initData(int levelNumber, boolean gameWin,DataTable d){
        Main.getDatabase().removeData(d);
        if (gameWin==false){
            zombiesAteYourBrains.setVisible(true);
        }
        else{
            if(levelNumber==5){
                youAteZombiesBrains.setVisible(true);
            }
            else{
                Main.getDatabase().setMaxLevel(levelNumber+1);
                plantName.setVisible(true);
                plantImage.setVisible(true);
                youWon.setVisible(true);
                nextLevelButton.setVisible(true);
                nextLevelButton.setDisable(false);
                if(levelNumber==1){
                    plantName.setText("Walnut");
                    plantImage.setImage(new Image(getClass().getResource("/assets/L2.png").toString()));
                }
                else if(levelNumber==2){
                    plantName.setText("Cherry Bomb");
                    plantImage.setImage(new Image(getClass().getResource("/assets/L3.png").toString()));
                }
                else if(levelNumber==3){
                    plantName.setText("Repeater");
                    plantImage.setImage(new Image(getClass().getResource("/assets/L4.png").toString()));
                }
                else if(levelNumber==4){
                    plantName.setText("Jalapeno");
                    plantImage.setImage(new Image(getClass().getResource("/assets/L5.png").toString()));
                }
            }

        }

    }

}
