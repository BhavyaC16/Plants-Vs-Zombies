package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    @FXML
    private GridPane lawn_grid;
    //private GamePlay g;
    private ArrayList<Plant> allPlants;
    private ArrayList<Zombie> allZombies;
    private static int sunCount;
    private final int LANE1;
    private final int LANE2;
    private final int LANE3;
    private final int LANE4;
    private final int LANE5;
    public static boolean gameStatus;
    public static Timeline sunTimeline;
    private static Label sunCountDisplay;


    public GamePlayController() {
        allPlants = new ArrayList<Plant>();
        allZombies = new ArrayList<Zombie>();
        LANE1 = 50;
        LANE2 = 150;
        LANE3 = 250;
        LANE4 = 350;
        LANE5 = 450;
    }


    public void initialize() throws Exception {
        gameStatus = true;
        sunCount = 50;
        sunCountDisplay = sunCountLabel;
        sunCountDisplay.setText("50");
        Random rand = new Random();
        //NormalZombie n = new NormalZombie(1024, 450, GamePlayRoot);
        //n.moveZombie();

        fallingSuns(rand);
    }

    public static void updateSunCount(int val)
    {
        sunCount+=val;
        System.out.println(sunCount);
        getSunCountLabel().setText(Integer.toString(sunCount));
    }

    public static Label getSunCountLabel()
    {
        return(sunCountDisplay);
    }

    public void fallingSuns(Random rand) {
        Timeline sunDropper = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int sunPosition = rand.nextInt(850);
                sunPosition += 100;
                Sun s = new Sun(sunPosition, 0, GamePlayRoot, true);
                s.dropSun();
            }
        }));
        sunDropper.setCycleCount(Timeline.INDEFINITE);
        sunDropper.play();
        sunTimeline = sunDropper;
    }

//    public void fallingSuns(Random rand) {
//        {
//            Thread t = new Thread(() -> {
//                while (gameStatus) {
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    int sunPosition = rand.nextInt(850);
//                    sunPosition += 100;
//                    Sun s = new Sun(sunPosition, 0, GamePlayRoot);
//                    s.dropSun();
//                }
//            });
//            t.start();
//        }
//    }
    @FXML
    public void initData(int levelNumber) {
        //System.out.println("initData");
        this.levelNumber = levelNumber;
        SidebarElement.getSideBarElements(levelNumber, GamePlayRoot);
    }

    @FXML
    void getGridPosition(MouseEvent event) throws IOException {
        if (SidebarElement.getCardSelected() != -1) {
            Node source = (Node) event.getSource();
//            int col=(int) (source.getLayoutX() + source.getParent().getLayoutX());
//            int row=(int) (source.getLayoutY() + source.getParent().getLayoutY());
            Integer colIndex = lawn_grid.getColumnIndex(source);
            Integer rowIndex = lawn_grid.getRowIndex(source);
            if (colIndex != null && rowIndex != null) {
                boolean flag = true;
                for (Plant p : allPlants) {
                    if (p.getX() == colIndex && p.getY() == rowIndex) {
                        flag = false;
                    }
                }
                System.out.println("Placing "+rowIndex+" "+colIndex);
                if ((flag) && SidebarElement.getElement(SidebarElement.getCardSelected()).getCost() <= sunCount) {
                    placePlant(SidebarElement.getCardSelected(), colIndex, rowIndex);
                    updateSunCount((-1)*SidebarElement.getElement(SidebarElement.getCardSelected()).getCost());
                    SidebarElement.getElement(SidebarElement.getCardSelected()).setDisabledOn();
                } else System.out.println("Not enough suns" + Integer.valueOf(sunCountLabel.getText()));
            }
            SidebarElement.setCardSelectedToNull();
        }
    }

    public void placePlant(int val, int x, int y) {
        System.out.println("Placing Plant");
        int z=0;
        switch(y){
            case 1:
                z=LANE1;
                break;
            case 2:
                z=LANE2;
                break;
            case 3:
                z=LANE3;
                break;
            case 4:
                z=LANE4;
                break;
            case 5:
                z=LANE5;
                break;
            default:
                System.out.println("Cant find lane "+y);
        }
        switch (val) {
            case 1:
                allPlants.add(new Sunflower(x, y, GamePlayRoot,z,lawn_grid));
                break;
            case 2:
                allPlants.add(new PeaShooter(x, y, GamePlayRoot,z,lawn_grid));
                break;
            case 3:
                allPlants.add(new Wallnut(x, y, GamePlayRoot,z,lawn_grid));
                break;
            case 4:
                allPlants.add(new CherryBomb(x, y, GamePlayRoot,z,lawn_grid));
                break;
            case 5:
                allPlants.add(new Repeater(x, y, GamePlayRoot,z,lawn_grid));
                break;
            case 6:
                allPlants.add(new Jalapeno(x, y, GamePlayRoot,z,lawn_grid));
                break;
            default:
                System.out.println("No case match" + val);
        }
    }

    @FXML
    void loadGameMenu(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameMenu.fxml"));
        Parent gameMenu = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(gameMenu));
        GameMenuController controller = fxmlLoader.<GameMenuController>getController();
        controller.initData(GamePlayRoot, levelNumber);
        stage.show();
    }

    @FXML
    private void placeSunflower() {
        ImageView plant = new ImageView();
        Image Sunflower = new Image("file:src/sample/assets/sunflower.gif", 60, 60, false, false);
        plant.setImage(Sunflower);
        plant.setX(330);
        plant.setY(180);
        GamePlayRoot.getChildren().addAll(plant);
    }

    @FXML
    private void placePeashooter() {
        ImageView plant = new ImageView();
        Image peashooter = new Image("file:src/sample/assets/peashooter.gif", 60, 60, false, false);
        plant.setImage(peashooter);
        plant.setX(330);
        plant.setY(80);
        GamePlayRoot.getChildren().addAll(plant);
    }

    @FXML
    private ImageView normalZombieWalk() {
        ImageView zombie = new ImageView();
        ImageView img = new ImageView();
        Image normalZombie = new Image("file:src/sample/assets/normalzombie.gif", 68, 118, false, false);
        zombie.setImage(normalZombie);
        img = addTransition(30000, 1, 1024, 40, 270, 40, zombie);
        return (img);
    }

    @FXML
    private ImageView shootPea() {
        ImageView Pea = new ImageView();
        ImageView img = new ImageView();
        Image pea = new Image("file:src/sample/assets/pea.png", 20, 20, false, false);
        Pea.setImage(pea);
        img = addTransition(3000, 5000, 380, 85, 1100, 85, Pea);
        return (img);

    }

    @FXML
    private ImageView normalZombie2() {
        ImageView zombie = new ImageView();
        ImageView img = new ImageView();
        Image normalZombie = new Image("file:src/sample/assets/normalzombie.gif", 68, 118, false, false);
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


        return (img);

    }

    @FXML
    private ImageView bucketheadZombieWalk() {
        ImageView img = new ImageView();
        ImageView lawnMower = new ImageView();
        Image lm = new Image("file:src/sample/assets/lawnmowerActivated.gif", 100, 100, false, false);
        lawnMower.setImage(lm);
        ImageView zombie = new ImageView();
        Image bucketheadZombie = new Image("file:src/sample/assets/bucketheadzombie.gif", 68, 118, false, false);
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
        return (img);
    }

    @FXML
    private ImageView coneheadZombieWalk() {

        ImageView img = new ImageView();
        ImageView lawnMower = new ImageView();
        Image lm = new Image("file:src/sample/assets/lawnmowerActivated.gif", 100, 100, false, false);
        lawnMower.setImage(lm);
        ImageView zombie = new ImageView();
        Image coneheadZombie = new Image("file:src/sample/assets/coneheadzombie.gif", 133, 122, false, false);
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
        return (img);
    }

    @FXML
    private void dropSun() {
        ImageView sunToken = new ImageView();
        Image sun = new Image("file:src/sample/assets/sun.png", 50, 50, false, false);
        sunToken.setImage(sun);
        Random rand = new Random();
        int startX = rand.nextInt(850) + 270;
        int stopX = startX;
        addTransition(15000, 1, startX, 0, stopX, 550, sunToken);
    }

    private ImageView addTransition(double duration, int count, double startX, double startY, double stopX, double stopY, ImageView img) {
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
        return (img);
    }
}
