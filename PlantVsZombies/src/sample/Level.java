package sample;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class Level {
    private int levelNumber;
    private int numNormalZombie;
    private int numConeZombie;
    private int numBucketZombie;
    private int totalZombies;
    private ArrayList<Plant> availablePlants;
    private ArrayList<Zombie> availableZombies;
    private int levelTime; //120 seconds
    public Level(int n){
        this.levelNumber=n;
        this.availablePlants = new ArrayList<Plant>();
        this.availableZombies = new ArrayList<Zombie>();
        if (n>=1){
            this.totalZombies = 10;
            this.numNormalZombie =10;
            this.numConeZombie =0;
            this.numBucketZombie =0;
            this.levelTime = 90000;
        }
        if (n >= 2) {
            this.totalZombies = 15;
            this.numNormalZombie =10;
            this.numConeZombie =5;
            this.numBucketZombie =0;
            this.levelTime = 120000;
        }
        if (n>=3){
            this.totalZombies = 20;
            this.numNormalZombie = 10;
            this.numConeZombie = 8;
            this.numBucketZombie = 2;
            this.levelTime = 120000;
        }
        if (n>=4){
            this.totalZombies = 25;
            this.numNormalZombie = 12;
            this.numConeZombie = 9;
            this.numBucketZombie = 4;
            this.levelTime = 150000;
        }
        if (n>=5){
            this.totalZombies = 30;
            this.numNormalZombie = 12;
            this.numConeZombie = 10;
            this.numBucketZombie = 8;
            this.levelTime = 150000;
        }
    }

    public void spawnNormalZombie(Pane pane, int lane, int laneNumber)
    {
        NormalZombie z = new NormalZombie(1024, lane, pane, laneNumber);
        z.moveZombie();
    }

    public void spawnConeZombie(Pane pane, int lane, int laneNumber)
    {
        ConeZombie z = new ConeZombie(1024, lane, pane, laneNumber);
        z.moveZombie();
    }

    public void spawnBucketZombie(Pane pane, int lane, int laneNumber)
    {
        BucketZombie z = new BucketZombie(1024, lane, pane, laneNumber);
        z.moveZombie();
    }
}
