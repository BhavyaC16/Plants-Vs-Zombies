package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GamePlayController {

    @FXML
    private AnchorPane GamePlayRoot;

    @FXML
    private ImageView peaShooterBuy;

    @FXML
    private ImageView repeaterBuy;

    @FXML
    private ImageView cherryBombBuy;

    @FXML
    private ImageView jalapenoBuy;

    @FXML
    private ImageView wallnutBuy;

    @FXML
    private ImageView sunBuy;

    @FXML
    private ImageView lawnMower1;

    @FXML
    private ImageView lawnMower2;

    @FXML
    private ImageView lawnMower3;

    @FXML
    private ImageView lawnMower4;

    @FXML
    private ImageView lawnMower5;

    @FXML
    private Label sunCountLabel;

    @FXML
    private ImageView GameMenuLoaderButton;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private int levelNumber;

    public void initialize(){
        normalZombieWalk();
        coneheadZombieWalk();
        bucketheadZombieWalk();
        dropSun();
    }

    @FXML
    public void initData(int levelNumber){
        sunBuy.setDisable(false);
        sunBuy.setVisible(true);
        peaShooterBuy.setDisable(false);
        peaShooterBuy.setVisible(true);
        if (levelNumber==1){
            this.levelNumber=1;
            cherryBombBuy.setDisable(true);
            cherryBombBuy.setVisible(false);
            repeaterBuy.setDisable(true);
            repeaterBuy.setVisible(false);
            jalapenoBuy.setDisable(true);
            jalapenoBuy.setVisible(false);
            wallnutBuy.setDisable(true);
            wallnutBuy.setVisible(false);
        }
        else if (levelNumber==2){
            this.levelNumber=2;
            cherryBombBuy.setDisable(true);
            cherryBombBuy.setVisible(false);
            repeaterBuy.setDisable(true);
            repeaterBuy.setVisible(false);
            jalapenoBuy.setDisable(true);
            jalapenoBuy.setVisible(false);
        }
        else if (levelNumber==3){
            this.levelNumber=3;
            repeaterBuy.setDisable(true);
            repeaterBuy.setVisible(false);
            jalapenoBuy.setDisable(true);
            jalapenoBuy.setVisible(false);
        }
        else if (levelNumber==4) {
            this.levelNumber=4;
            jalapenoBuy.setDisable(true);
            jalapenoBuy.setVisible(false);
        }
        else{
            this.levelNumber=5;
        }
    }
    @FXML
    void loadGameMenu(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameMenu.fxml"));
        Parent gameMenu = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(gameMenu));
        GameMenuController controller = fxmlLoader.<GameMenuController>getController();
        controller.initData(GamePlayRoot,levelNumber);
        stage.show();
    }

    @FXML
    private void normalZombieWalk(){
        ImageView zombie = new ImageView();
        Image normalZombie = new Image("file:src/sample/assets/normalzombie.gif",68,118,false,false);
        zombie.setImage(normalZombie);
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(1024);
        translate.setDuration(Duration.millis(25000));
        translate.setCycleCount(1);
        translate.setFromY(40);
        translate.setFromX(1024);
        translate.setToX(100);
        translate.setNode(zombie);
        translate.play();
        GamePlayRoot.getChildren().addAll(zombie);
    }

    @FXML
    public void bucketheadZombieWalk(){
        ImageView zombie = new ImageView();
        Image bucketheadZombie = new Image("file:src/sample/assets/bucketheadzombie.gif",68,118,false,false);
        zombie.setImage(bucketheadZombie);
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(1024);
        translate.setDuration(Duration.millis(25000));
        translate.setCycleCount(1);
        translate.setFromY(420);
        translate.setFromX(1024);
        translate.setToX(100);
        translate.setNode(zombie);
        translate.play();
        GamePlayRoot.getChildren().addAll(zombie);
    }

    @FXML
    public void coneheadZombieWalk(){
        ImageView zombie = new ImageView();
        Image coneheadZombie = new Image("file:src/sample/assets/coneheadzombie.gif",133,122,false,false);
        zombie.setImage(coneheadZombie);
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(1024);
        translate.setDuration(Duration.millis(25000));
        translate.setCycleCount(1);
        translate.setFromY(240);
        translate.setFromX(1024);
        translate.setToX(100);
        translate.setNode(zombie);
        translate.play();
        GamePlayRoot.getChildren().addAll(zombie);
    }

    @FXML
    public void dropSun()
    {
        ImageView sunToken = new ImageView();
        Image sun = new Image("file:src/sample/assets/sun.png",50,50,false,false);
        sunToken.setImage(sun);
        TranslateTransition translate = new TranslateTransition();
        translate.setByY(600);
        translate.setDuration(Duration.millis(15000));
        translate.setCycleCount(1);
        translate.setFromY(0);
        translate.setFromX(500);
        translate.setToY(700);
        translate.setNode(sunToken);
        translate.play();
        GamePlayRoot.getChildren().addAll(sunToken);
    }

}
