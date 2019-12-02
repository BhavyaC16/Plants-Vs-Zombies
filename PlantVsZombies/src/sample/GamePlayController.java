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
import java.util.*;

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
    private Label sunCountLabel;
    @FXML
    private ImageView GameMenuLoaderButton;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private int levelNumber;
    @FXML
    private GridPane lawn_grid;
    //public static ArrayList<Plant> allPlants;
    //public static ArrayList<LawnMower> allMowers;
    private static int sunCount;
    public static final int LANE1=50;
    public static final int LANE2=150;
    public static final int LANE3=250;
    public static final int LANE4=350;
    public static final int LANE5=450;
    public static boolean gameStatus;
    public static Timeline sunTimeline;
    public static Timeline spZ1;
    public static Timeline spZ2;
    private static Label sunCountDisplay;
    private static double timeElapsed;
    private static Level l;
    public static List allZombies;
    public static List allPlants;
    public static List allMowers;
    public static ArrayList<Integer> zombieList1;
    public static ArrayList<Integer> zombieList2;
    //public static ArrayList<Zombie> allZombies = new ArrayList<Zombie>();
    private static DataTable d;
    public static int wonGame = 0;
    private volatile int spawnedZombies = 0;
    public static double numZombiesKilled = 0;
    public static ArrayList<Timeline> animationTimelines;
    private Shovel shovel;


    public void initialize() throws Exception {
        l = null;
        gameStatus = true;
        sunCountDisplay = sunCountLabel;
        allZombies = Collections.synchronizedList(new ArrayList<Zombie>());
        allPlants = Collections.synchronizedList(new ArrayList<Plant>());
        allMowers = Collections.synchronizedList(new ArrayList<LawnMower>());
        //progressBar.setProgress(0);
    }

    @FXML
    public void initData(int levelNumber, DataTable d) {

        Random rand = new Random();
        this.levelNumber = levelNumber;
        Level l = new Level(levelNumber);
        this.l = l;
        zombieList1 = d.getZombieList1();
        zombieList2 = d.getZombieList2();
        allPlants = d.getAllPlants();
        allZombies = d.getAllZombie();
        allMowers=d.getAllLawnMowers();
        sunCount=d.getSunCount();
        timeElapsed = d.getTimeElapsed();
        System.out.println("timeElapsed"+timeElapsed);
        animationTimelines = new ArrayList<Timeline>();
        startAnimations(rand);

        synchronized (allMowers)
        {
            Iterator<LawnMower> i = allMowers.iterator();
            while(i.hasNext())
            {
                i.next().makeImage(GamePlayRoot);
            }
        }
        shovel=Shovel.getInstance();
        shovel.makeImage(GamePlayRoot);
        sunCountDisplay.setText(String.valueOf(sunCount));
        this.d=d;
        SidebarElement.getSideBarElements(levelNumber, GamePlayRoot);

        gameProgress();
        fallingSuns(rand);
    }

    public void startAnimations(Random rand)
    {
        synchronized (allPlants) {
            Iterator<Plant> i = allPlants.iterator();
            while (i.hasNext()) {
                Plant p = i.next();
                p.makeImage(lawn_grid);
                System.out.println(lawn_grid);
                p.attack(GamePlayRoot);
                System.out.print(p.row);
                System.out.println(" "+p.col);
            }
        }
        synchronized (allZombies)
        {
            Iterator<Zombie> i = allZombies.iterator();
            while(i.hasNext())
            {
                Zombie z = i.next();
                z.makeImage(GamePlayRoot);
                z.moveZombie();
            }
        }
        numZombiesKilled = l.getTotalZombies()*timeElapsed;
        progressBar.setProgress(timeElapsed);
        zombieSpawner1(rand);
        zombieSpawner2(rand);
    }

    public void gameProgress()
    {
        Timeline gameStatus = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    timeElapsed = ( numZombiesKilled / l.getTotalZombies());
                    progressBar.setProgress(timeElapsed);
                    if (wonGame == (-1)) {
                        System.out.println("LostGame :(");
                        numZombiesKilled = 0;
                        endAnimations();
                        gameLost();
                    } else if (wonGame == 0 && allZombies.size() == 0 && l.getTotalZombies() == spawnedZombies) {
                        System.out.println("GAME WON!!");
                        numZombiesKilled = 0;
                        endAnimations();
                        gameWon();
                    }
                    else if(progressBar.getProgress()>=1)
                    {
                        spZ1.stop();
                        spZ2.stop();
                            endAnimations();
                            gameWon();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("PROGRESS"+progressBar.getProgress());
            }
        }));
        gameStatus.setCycleCount(Timeline.INDEFINITE);
        gameStatus.play();
        animationTimelines.add(gameStatus);
    }


    public synchronized void updateSpawnedZombies()
    {
        this.spawnedZombies+=1;
    }

    @FXML
    void loadGameMenu(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameMenu.fxml"));
        Parent gameMenu = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(gameMenu));
        GameMenuController controller = fxmlLoader.<GameMenuController>getController();
        controller.initData(GamePlayRoot, levelNumber,d,sunCount,allPlants, allZombies, allMowers, timeElapsed, l.getZombieList1(), l.getZombieList2());
        stage.show();
    }

    public static void removePlant(Plant p){
        p.img.setVisible(false);
        allPlants.remove(p);
    }
    public static void removeZombie(Zombie z){
        z.img.setVisible(false);
        allZombies.remove(z);
    }
    public static void removeMower(LawnMower l){
        l.img.setVisible(false);
        allMowers.remove(l);
    }

    public static void updateSunCount(int val) {
        sunCount+=val;
        getSunCountLabel().setText(Integer.toString(sunCount));
    }

    public static Label getSunCountLabel() {
        return(sunCountDisplay);
    }

    public void fallingSuns(Random rand) {
        Timeline sunDropper = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int sunPosition = rand.nextInt(850);
                sunPosition += 100;
                Sun s = new Sun(sunPosition, 0, true);
                s.makeImage(GamePlayRoot);
                s.dropSun();
            }
        }));
        sunDropper.setCycleCount(Timeline.INDEFINITE);
        sunDropper.play();
        sunTimeline = sunDropper;
        animationTimelines.add(sunDropper);
    }

    public void zombieSpawner1(Random rand){
        Timeline spawnZombie1 = new Timeline(new KeyFrame(Duration.seconds(15), event -> {
            int lane;
            int laneNumber = rand.nextInt(5);
            if(laneNumber==0)
                lane = LANE1;
            else if(laneNumber==1)
                lane = LANE2;
            else if(laneNumber==2)
                lane = LANE3;
            else if(laneNumber==3)
                lane = LANE4;
            else
                lane = LANE5;
            try
            {
                if(zombieList1.get(0)==0) {
                    Level.spawnNormalZombie(GamePlayRoot, lane, laneNumber);
                    zombieList1.remove(0);
                    updateSpawnedZombies();
                }
                else if(zombieList1.get(0)==1)
                {
                    Level.spawnConeZombie(GamePlayRoot, lane, laneNumber);
                    zombieList1.remove(0);
                    updateSpawnedZombies();
                }
                else if(zombieList1.get(0)==2)
                {
                    Level.spawnBucketZombie(GamePlayRoot, lane, laneNumber);
                    zombieList1.remove(0);
                    updateSpawnedZombies();
                }
            }
            catch(IndexOutOfBoundsException e)
            {
                endZombieSpawner1();
            }
        }));

        spawnZombie1.setCycleCount(Timeline.INDEFINITE);
        spawnZombie1.play();
        spZ1 = spawnZombie1;
        animationTimelines.add(spawnZombie1);
    }

    public void zombieSpawner2(Random rand){
        Timeline spawnZombie2 = new Timeline(new KeyFrame(Duration.seconds(30), event -> {
            int lane;
            int laneNumber = rand.nextInt(5);
            if(laneNumber==0)
                lane = LANE1;
            else if(laneNumber==1)
                lane = LANE2;
            else if(laneNumber==2)
                lane = LANE3;
            else if(laneNumber==3)
                lane = LANE4;
            else
                lane = LANE5;
            try
            {
                if(zombieList2.get(0)==0) {
                    Level.spawnNormalZombie(GamePlayRoot, lane, laneNumber);
                    zombieList2.remove(0);
                    updateSpawnedZombies();
                }
                else if(zombieList2.get(0)==1)
                {
                    Level.spawnConeZombie(GamePlayRoot, lane, laneNumber);
                    zombieList2.remove(0);
                    updateSpawnedZombies();
                }
                else if(zombieList2.get(0)==2)
                {
                    Level.spawnBucketZombie(GamePlayRoot, lane, laneNumber);
                    zombieList2.remove(0);
                    updateSpawnedZombies();
                }
            }
            catch(IndexOutOfBoundsException e)
            {
                endZombieSpawner2();
            }
        }));

        spawnZombie2.setCycleCount(Timeline.INDEFINITE);
        spawnZombie2.play();
        spZ2 = spawnZombie2;
        animationTimelines.add(spawnZombie2);
    }

    public void endZombieSpawner1()
    {
        spZ1.stop();
    }

    public void endZombieSpawner2()
    {
        spZ2.stop();
    }

    @FXML
    void getGridPosition(MouseEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Integer colIndex = lawn_grid.getColumnIndex(source);
        Integer rowIndex = lawn_grid.getRowIndex(source);
        if (!shovel.isIsDisabled()) {
            shovel.disable();
            if (colIndex != null && rowIndex != null) {
                System.out.println("shovelling"+colIndex+" "+rowIndex);
                synchronized (allPlants) {
                    Iterator<Plant> i = allPlants.iterator();
                    while (i.hasNext()) {
                        Plant p = i.next();
                        System.out.println("plant"+p.col+" "+p.row);
                        if (p.col == colIndex && p.row == rowIndex) {
                            p.img.setVisible(false);
                            p.img.setDisable(true);
                            allPlants.remove(p);
                            System.out.println(p.getClass());
                            p.setHp(0);
                            ((Shooter)p).checkHp();
                            ((Sunflower)p).checkHp();
                            break;
                        }
                    }
                }
            }
        }
        if (SidebarElement.getCardSelected() != -1) {
            if (colIndex != null && rowIndex != null) {
                boolean flag = true;
                synchronized (allPlants) {
                    Iterator<Plant> i = allPlants.iterator();
                    while (i.hasNext()) {
                        Plant p = i.next();
                        if (p.col == colIndex && p.row == rowIndex) {
                            flag = false;
                        }
                    }
                }
                if (flag) {
                    if (SidebarElement.getElement(SidebarElement.getCardSelected()).getCost() <= sunCount) {
                        placePlant(SidebarElement.getCardSelected(), (int) (source.getLayoutX() + source.getParent().getLayoutX()), (int) (source.getLayoutY() + source.getParent().getLayoutY()), colIndex, rowIndex);
                        updateSunCount((-1) * SidebarElement.getElement(SidebarElement.getCardSelected()).getCost());
                        SidebarElement.getElement(SidebarElement.getCardSelected()).setDisabledOn(GamePlayRoot);
                    } else System.out.println("Not enough sun score");
                } else System.out.println("Cant place more than one plant on cell");

            }
            SidebarElement.setCardSelectedToNull();
        }

    }

    public void placePlant(int val, int x, int y,int row,int col) {
        Plant p;
        switch (val) {
            case 1:
                p=new Sunflower(x, y,row,col);
                allPlants.add(p);
                //System.out.println(lawn_grid);
                p.makeImage(lawn_grid);
                p.attack(GamePlayRoot);
                break;
            case 2:
                p=new PeaShooter(x, y,row,col);
                allPlants.add(p);
                p.makeImage(lawn_grid);
                p.attack(GamePlayRoot);
                break;
            case 3:
                p=new Wallnut(x, y,row,col);
                allPlants.add(p);
                p.makeImage(lawn_grid);
                p.attack(GamePlayRoot);
                break;
            case 4:
                p=new CherryBomb(x, y,row,col);
                allPlants.add(p);
                p.makeImage(lawn_grid);
                p.attack(GamePlayRoot);
                break;
            case 5:
                p=new Repeater(x, y,row,col);
                allPlants.add(p);
                p.makeImage(lawn_grid);
                p.attack(GamePlayRoot);
                break;
            case 6:
                p=new Jalapeno(x, y,row,col);
                allPlants.add(p);
                p.makeImage(lawn_grid);
                p.attack(GamePlayRoot);
                break;
            default:
                System.out.println("No case match" + val);
        }
    }

    public static void endAnimations()
    {
        for(int i = 0; i<animationTimelines.size(); i++)
        {
            animationTimelines.get(i).stop();
        }
    }
    public void gameLost() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EndGame.fxml"));
        AnchorPane pane=fxmlLoader.load();
        EndGameController controller = fxmlLoader.<EndGameController>getController();
        controller.initData(levelNumber, false,d);
        GamePlayRoot.getChildren().setAll(pane);

    }
    public void gameWon() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EndGame.fxml"));
        AnchorPane pane=fxmlLoader.load();
        EndGameController controller = fxmlLoader.<EndGameController>getController();
        controller.initData(levelNumber, true,d);
        GamePlayRoot.getChildren().setAll(pane);

    }
}
