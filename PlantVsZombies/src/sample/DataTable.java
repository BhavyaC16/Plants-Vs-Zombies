package sample;

import javafx.scene.layout.Pane;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DataTable implements Serializable {
    private static int id=0;
    private int gameId;
    private int sunCount;
    private List<Plant> allPlants;
    private List<Zombie> allZombie;
    private int timeElapsed;
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
        this.allZombie = Collections.synchronizedList(new ArrayList<Zombie>());
        this.allPlants = Collections.synchronizedList(new ArrayList<Plant>());
        this.allLawnMowers = Collections.synchronizedList(new ArrayList<LawnMower>());
        allLawnMowers.add(new LawnMower(249,LANE1+20,0));
        allLawnMowers.add(new LawnMower(249,LANE2+20,1));
        allLawnMowers.add(new LawnMower(249,LANE3+20,2));
        allLawnMowers.add(new LawnMower(243,LANE4+20,3));
        allLawnMowers.add(new LawnMower(236,LANE5+20,4));

    }
//    public DataTable(int levelNumber,int sunCount,ArrayList<Plant> allPlants,ArrayList<Zombie> allZombie,ArrayList<LawnMower> allLawnMowers, int timeElapsed){
//        this.sunCount=sunCount;
//        this.allPlants=allPlants;
//        this.allZombie=allZombie;
//        this.allLawnMowers=allLawnMowers;
//        this.levelNumber=levelNumber;
//        this.timeElapsed=timeElapsed;
////        this.filename="";
////        setNewDate();
//    }

    public void update(int levelNumber, int sunCount, List<Plant> allPlants, List<Zombie> allZombie, List<LawnMower> allLawnMowers, int timeElapsed){
        this.sunCount=sunCount;
        this.allPlants=allPlants;
        this.allZombie=allZombie;
        this.allLawnMowers=allLawnMowers;
        this.levelNumber=levelNumber;
        this.timeElapsed=timeElapsed;
    }


//    public void setNewDate(){
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        Date date = new Date();
//        savingTimeStamp=("Level: "+String.valueOf(levelNumber)+"                                                             "+String.valueOf(dateFormat.format(date)));
//        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
////        filename="Level: "+String.valueOf(levelNumber)+" "+String.valueOf(dateFormat.format(date));
//    }
    public void saveGame(){
//        this.setNewDate();
        Database.getInstance().getDatabaseFiles().add(this);
//        try{
//            Main.serialize();
//        }
//        catch (IOException e){
//            System.out.println("Cant close stream");
//        }
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

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public String toString()
    {
        return ("Level: "+String.valueOf(levelNumber)+"                                                             Game"+String.valueOf(gameId));
    }
    
}
