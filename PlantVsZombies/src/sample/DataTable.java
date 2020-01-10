package sample;

import javafx.scene.layout.Pane;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataTable implements Serializable {
    private static final long serialVersionUID=42L;
    private static int id=0;
    private int gameId;
    private int sunCount;
    private List<Plant> allPlants;
    private List<Zombie> allZombie;
    private ArrayList<Integer> zombieList1;
    private ArrayList<Integer> zombieList2;
    private double timeElapsed;
    private boolean status = LevelMenuController.status;
    private List<LawnMower> allLawnMowers;
    private int levelNumber;
    private String savingTimeStamp;
    public static final int LANE1=50;
    public static final int LANE2=150;
    public static final int LANE3=250;
    public static final int LANE4=350;
    public static final int LANE5=450;

//    private String filename;
    public DataTable(int levelNumber){
        id++;
        this.gameId=id;
        this.sunCount=50;
        this.zombieList1 = new ArrayList<Integer>();
        this.zombieList2 = new ArrayList<Integer>();
        this.allZombie = Collections.synchronizedList(new ArrayList<Zombie>());
        this.allPlants = Collections.synchronizedList(new ArrayList<Plant>());
        this.allLawnMowers = Collections.synchronizedList(new ArrayList<LawnMower>());
        allLawnMowers.add(new LawnMower(249,LANE1+20,0));
        allLawnMowers.add(new LawnMower(249,LANE2+20,1));
        allLawnMowers.add(new LawnMower(249,LANE3+20,2));
        allLawnMowers.add(new LawnMower(243,LANE4+20,3));
        allLawnMowers.add(new LawnMower(236,LANE5+20,4));
        Level l = new Level(levelNumber);
        zombieList1 = l.getZombieList1();
        zombieList2 = l.getZombieList2();
        status = LevelMenuController.status;

    }

    public void update(int levelNumber, int sunCount, List<Plant> allPlants, List<Zombie> allZombie, List<LawnMower> allLawnMowers, double timeElapsed, ArrayList<Integer> zombieList1, ArrayList<Integer> zombieList2, boolean status) {
        this.sunCount = sunCount;
        this.allPlants = allPlants;
        this.allZombie = allZombie;
        this.allLawnMowers = allLawnMowers;
        this.levelNumber = levelNumber;
        this.timeElapsed = timeElapsed;
        this.zombieList1 = zombieList1;
        this.zombieList2 = zombieList2;
        this.status = status;
    }

    public void saveGame(){
        Main.getDatabase().getDatabaseFiles().add(this);
        try{
            Main.serialize();
        }
        catch (IOException e){
            //System.out.println("Cant close stream");
        }
    }

    public List<LawnMower> getAllLawnMowers() {
        return allLawnMowers;
    }

    public List<Plant> getAllPlants() {
        return allPlants;
    }

    public List<Zombie> getAllZombie() {
        return allZombie;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public String getSavingTimeStamp() {
        return savingTimeStamp;
    }

    public int getSunCount() {
        return sunCount;
    }

    public double getTimeElapsed() {
        //System.out.println(this.timeElapsed);
        return this.timeElapsed;
    }

    public String toString()
    {
        return ("Level: "+String.valueOf(levelNumber)+"                                                             Game"+String.valueOf(gameId));
    }
    public ArrayList<Integer> getZombieList1()
    {
        return this.zombieList1;
    }
    public ArrayList<Integer> getZombieList2()
    {
        return this.zombieList2;
    }
    public boolean getStatus() {return this.status;}
    
}
