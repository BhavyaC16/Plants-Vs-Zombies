package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
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

    public void initialize(){
        placeSunflower();
        placePeashooter();
        ImageView z1 = new ImageView();
        ImageView z2 = new ImageView();
        ImageView z3 = new ImageView();
        ImageView z4 = new ImageView();
        z1 = normalZombieWalk();
        z2 = coneheadZombieWalk();
        z3 = bucketheadZombieWalk();
        z4 = normalZombie2();
        dropSun();
        System.out.println(z1.getX());
        //checkConditions();
        while(z1.getX()>=600)
        {
            System.out.println();
            if(z1.getX()<600)
            {
                z1.setVisible(true);
            }
        }
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
        img = addTransition(25000, 1, 1024, 40, 270, 40, zombie);
        return(img);
    }

    @FXML
    private ImageView normalZombie2()
    {
        ImageView zombie = new ImageView();
        ImageView img = new ImageView();
        Image normalZombie = new Image("file:src/sample/assets/normalzombie.gif",68,118,false,false);
        zombie.setImage(normalZombie);
        img = addTransition(50000, 1, 2048, 420, 270, 420, zombie);
        return(img);
    }

    @FXML
    private ImageView bucketheadZombieWalk(){
        ImageView img = new ImageView();
        ImageView zombie = new ImageView();
        Image bucketheadZombie = new Image("file:src/sample/assets/bucketheadzombie.gif",68,118,false,false);
        zombie.setImage(bucketheadZombie);
        img = addTransition(25000, 1, 1024, 420, 270, 420, zombie);
        return(img);
    }

    @FXML
    private ImageView coneheadZombieWalk(){
        ImageView img = new ImageView();
        ImageView zombie = new ImageView();
        Image coneheadZombie = new Image("file:src/sample/assets/coneheadzombie.gif",133,122,false,false);
        zombie.setImage(coneheadZombie);
        img = addTransition(25000, 1, 1024, 220, 250, 220, zombie);
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
        addTransition(15000, 1, startX, 0, stopX, 700, sunToken);
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
        System.out.println(img.getLayoutX());
        GamePlayRoot.getChildren().addAll(img);
        return(img);
    }

}
