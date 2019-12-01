package sample;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Level {
    private int levelNumber;
    private int numNormalZombie;
    private int numConeZombie;
    private int numBucketZombie;
    private int totalZombies;
    private ArrayList<Plant> availablePlants;
    private ArrayList<Integer> availableZombies;
    private ArrayList<Integer> zombieList1;
    private ArrayList<Integer> zombieList2;
    public Level(int n){
        this.levelNumber=n;
        this.availablePlants = new ArrayList<Plant>();
        this.availableZombies = new ArrayList<Integer>();
        this.zombieList1 = new ArrayList<Integer>();
        this.zombieList2 = new ArrayList<Integer>();
        if (n>=1){
            this.totalZombies = 10;
            this.numNormalZombie = 10;
            this.numConeZombie = 0;
            this.numBucketZombie = 0;
        }
        if (n >= 2) {
            this.totalZombies = 15;
            this.numNormalZombie =10;
            this.numConeZombie =5;
            this.numBucketZombie =0;
        }
        if (n>=3){
            this.totalZombies = 20;
            this.numNormalZombie = 10;
            this.numConeZombie = 8;
            this.numBucketZombie = 2;
        }
        if (n>=4){
            this.totalZombies = 25;
            this.numNormalZombie = 12;
            this.numConeZombie = 9;
            this.numBucketZombie = 4;
        }
        if (n>=5){
            this.totalZombies = 30;
            this.numNormalZombie = 12;
            this.numConeZombie = 10;
            this.numBucketZombie = 8;
        }
        for(int i = 0; i<this.numNormalZombie; i++)
        {
            this.availableZombies.add(0);
        }
        for(int j = 0; j<this.numConeZombie; j++)
        {
            this.availableZombies.add(1);
        }
        for(int k = 0; k<this.numBucketZombie; k++)
        {
            this.availableZombies.add(2);
        }
        Collections.shuffle(availableZombies);
        for(int m = 0; m<availableZombies.size(); m++)
        {
            if(m%2==0)
            {
                this.zombieList1.add(availableZombies.get(m));
            }
            else {
                this.zombieList2.add(availableZombies.get(m));
            }
        }
    }

    public ArrayList<Integer> getZombieList1()
    {
        return(this.zombieList1);
    }

    public ArrayList<Integer> getZombieList2()
    {
        return(this.zombieList2);
    }

    public static void spawnNormalZombie(Pane pane, int lane, int laneNumber)
    {
        NormalZombie z = new NormalZombie(1024, lane, laneNumber);
        z.makeImage(pane);
        GamePlayController.allZombies.add(z);
        z.moveZombie();
    }

    public static void spawnConeZombie(Pane pane, int lane, int laneNumber)
    {
        ConeZombie z = new ConeZombie(1024, lane, laneNumber);
        z.makeImage(pane);
        GamePlayController.allZombies.add(z);
        z.moveZombie();
    }

    public static void spawnBucketZombie(Pane pane, int lane, int laneNumber)
    {
        BucketZombie z = new BucketZombie(1024, lane, laneNumber);
        z.makeImage(pane);
        GamePlayController.allZombies.add(z);
        z.moveZombie();
    }

    public int getTotalZombies()
    {
        return(this.totalZombies);
    }

}
