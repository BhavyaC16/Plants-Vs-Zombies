package sample;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataTable implements Serializable {
    private int sunCount;
    private ArrayList<Plant> allPlants;
    private ArrayList<Zombie> allZombie;
    private int timeElapsed;
    private ArrayList<LawnMower> allLawnMowers;
    private int levelNumber;
    private String savingTimeStamp;
//    private String filename;
    public DataTable(int levelNumber,int sunCount,ArrayList<Plant> allPlants,ArrayList<Zombie> allZombie,ArrayList<LawnMower> allLawnMowers, int timeElapsed){
        this.sunCount=sunCount;
        this.allPlants=allPlants;
        this.allZombie=allZombie;
        this.allLawnMowers=allLawnMowers;
        this.levelNumber=levelNumber;
        this.timeElapsed=timeElapsed;
//        this.filename="";
        setNewDate();
    }
    public void setNewDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        savingTimeStamp=("Level: "+String.valueOf(levelNumber)+"                                                             "+String.valueOf(dateFormat.format(date)));
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
//        filename="Level: "+String.valueOf(levelNumber)+" "+String.valueOf(dateFormat.format(date));
    }
    public void saveGame(){
        Database.getInstance().getDatabaseFiles().add(this);
        try{
            Database.serialize();
        }
        catch (IOException e){
            System.out.println("Cant close stream");
        }
    }
    public void deleteGame(){
        Database.getInstance().getDatabaseFiles().remove(this);
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
        return savingTimeStamp;
    }
    
}
