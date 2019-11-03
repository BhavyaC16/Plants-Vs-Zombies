package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import java.util.Random;

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

    public void initialize() throws Exception{
        placeSunflower();
        placePeashooter();
        ImageView z1 = new ImageView();
        ImageView z2 = new ImageView();
        ImageView z3 = new ImageView();
        ImageView z4 = new ImageView();
        ImageView Pea = new ImageView();
        //z1 = normalZombieWalk();
        z2 = coneheadZombieWalk();
        z3 = bucketheadZombieWalk();
        z4 = normalZombie2();
        Pea = shootPea();
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
    private void placeSunflower()
    {
        ImageView plant = new ImageView();
        Image Sunflower = new Image("file:src/sample/assets/sunflower.gif", 60, 60, false, false);
        plant.setImage(Sunflower);
        plant.setX(330);
        plant.setY(180);
        GamePlayRoot.getChildren().addAll(plant);
    }

    @FXML
    private void placePeashooter()
    {
        ImageView plant = new ImageView();
        Image peashooter = new Image("file:src/sample/assets/peashooter.gif", 60, 60, false, false);
        plant.setImage(peashooter);
        plant.setX(330);
        plant.setY(80);
        GamePlayRoot.getChildren().addAll(plant);
    }

    @FXML
    private ImageView normalZombieWalk(){
        ImageView zombie = new ImageView();
        ImageView img = new ImageView();
        Image normalZombie = new Image("file:src/sample/assets/normalzombie.gif",68,118,false,false);
        zombie.setImage(normalZombie);
        img = addTransition(30000, 1, 1024, 40, 270, 40, zombie);
        return(img);
    }

    @FXML
    private ImageView shootPea()
    {
        ImageView Pea = new ImageView();
        ImageView img = new ImageView();
        Image pea = new Image("file:src/sample/assets/pea.png", 20, 20, false, false);
        Pea.setImage(pea);
        img = addTransition(3000, 5000, 380, 85, 1100, 85, Pea);
        return(img);

    }

    @FXML
    private ImageView normalZombie2()
    {
        ImageView zombie = new ImageView();
        ImageView img = new ImageView();
        Image normalZombie = new Image("file:src/sample/assets/normalzombie.gif",68,118,false,false);
        zombie.setImage(normalZombie);
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(60000));
        translate.setCycleCount(1);
        translate.setFromY(420);
        translate.setFromX(2048);
        translate.setToX(270);
        translate.setToY(420);
        translate.setNode(zombie);
        translate.play();
        GamePlayRoot.getChildren().addAll(zombie);
        translate.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                zombie.setVisible(false);
                ImageView gameEnded = new ImageView();
                Image gameEnd = new Image("file:src/sample/assets/ZombiesAteYourBrains.png", 500, 300, false, false);
                gameEnded.setImage(gameEnd);
                gameEnded.setX(400);
                gameEnded.setY(150);
                GamePlayRoot.getChildren().addAll(gameEnded);
            }
        });


        return(img);

    }

    @FXML
    private ImageView bucketheadZombieWalk(){
        ImageView img = new ImageView();
        ImageView lawnMower = new ImageView();
        Image lm = new Image("file:src/sample/assets/lawnmowerActivated.gif", 100, 100, false, false);
        lawnMower.setImage(lm);
        ImageView zombie = new ImageView();
        Image bucketheadZombie = new Image("file:src/sample/assets/bucketheadzombie.gif",68,118,false,false);
        zombie.setImage(bucketheadZombie);
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(30000));
        translate.setCycleCount(1);
        translate.setFromY(420);
        translate.setFromX(1024);
        translate.setToX(270);
        translate.setToY(420);
        translate.setNode(zombie);
        translate.play();

        TranslateTransition lawnmower = new TranslateTransition();
        lawnmower.setDuration(Duration.millis(3000));
        lawnmower.setCycleCount(1);
        lawnmower.setFromY(460);
        lawnmower.setFromX(270);
        lawnmower.setToX(1100);
        lawnmower.setToY(460);
        lawnmower.setNode(lawnMower);
        GamePlayRoot.getChildren().addAll(zombie);
        translate.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lawnMower5.setVisible(false);
                zombie.setVisible(false);
                lawnmower.play();
                GamePlayRoot.getChildren().addAll(lawnMower);
            }
        });
        return(img);
    }

    @FXML
    private ImageView coneheadZombieWalk(){

        ImageView img = new ImageView();
        ImageView lawnMower = new ImageView();
        Image lm = new Image("file:src/sample/assets/lawnmowerActivated.gif", 100, 100, false, false);
        lawnMower.setImage(lm);
        ImageView zombie = new ImageView();
        Image coneheadZombie = new Image("file:src/sample/assets/coneheadzombie.gif",133,122,false,false);
        zombie.setImage(coneheadZombie);
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(30000));
        translate.setCycleCount(1);
        translate.setFromY(220);
        translate.setFromX(1024);
        translate.setToX(250);
        translate.setToY(220);
        translate.setNode(zombie);
        translate.play();

        TranslateTransition lawnmower = new TranslateTransition();
        lawnmower.setDuration(Duration.millis(3000));
        lawnmower.setCycleCount(1);
        lawnmower.setFromY(270);
        lawnmower.setFromX(270);
        lawnmower.setToX(1100);
        lawnmower.setToY(270);
        lawnmower.setNode(lawnMower);
        //Bounds bounds = translate.getNode().localToScene(translate.getNode().getBoundsInLocal());
        GamePlayRoot.getChildren().addAll(zombie);
        translate.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lawnMower3.setVisible(false);
                zombie.setVisible(false);
                lawnmower.play();
                GamePlayRoot.getChildren().addAll(lawnMower);
            }
        });
        return(img);
    }

    @FXML
    private void dropSun()
    {
        ImageView sunToken = new ImageView();
        Image sun = new Image("file:src/sample/assets/sun.png",50,50,false,false);
        sunToken.setImage(sun);
        Random rand = new Random();
        int startX = rand.nextInt(850) + 270;
        int stopX = startX;
        addTransition(15000, 1, startX, 0, stopX, 550, sunToken);
    }

    private ImageView addTransition(double duration, int count, double startX, double startY, double stopX, double stopY, ImageView img)
    {
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(duration));
        translate.setCycleCount(count);
        translate.setFromY(startY);
        translate.setFromX(startX);
        translate.setToX(stopX);
        translate.setToY(stopY);
        translate.setNode(img);
        translate.play();
        GamePlayRoot.getChildren().addAll(img);
        return(img);
    }

}
