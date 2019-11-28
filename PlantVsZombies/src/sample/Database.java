package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {
    private int sunCount;
    private ArrayList<Plant> allPlants;
    private ArrayList<Zombie> allZombie;
    private int timeElapsed;
    private ArrayList<LawnMower> allLawnMowers;
    private int levelNumber;
    private int savingTimeStamp;
    public Database(int levelNumber,int sunCount,ArrayList<Plant> allPlants,ArrayList<Zombie> allZombie,ArrayList<LawnMower> allLawnMowers, int timeElapsed,int savingTimeStamp){
        this.sunCount=sunCount;
        this.allPlants=allPlants;
        this.allZombie=allZombie;
        this.allLawnMowers=allLawnMowers;
        this.levelNumber=levelNumber;
        this.timeElapsed=timeElapsed;
        this.savingTimeStamp=savingTimeStamp;
    }

    public ArrayList<LawnMower> getAllLawnMowers() {
        return allLawnMowers;
    }

    public ArrayList<Plant> getAllPlants() {
        return allPlants;
    }

    public ArrayList<Zombie> getAllZombie() {
        return allZombie;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getSavingTimeStamp() {
        return savingTimeStamp;
    }

    public int getSunCount() {
        return sunCount;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }
    
}
