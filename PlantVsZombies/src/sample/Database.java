package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {
    private int maxLevel;
    private static Database d;
    private ObservableList<DataTable> databaseFiles;

    private Database(){
        this.maxLevel=0;
        databaseFiles= FXCollections.observableArrayList(new ArrayList<DataTable>());
    }
    public static Database getInstance(){
        if (d==null) {
            d=new Database();
        }
        return d;
    }
    public int getMaxLevel() { return maxLevel; }
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
    public void addData(DataTable d){
        databaseFiles.add(d);
    }
    public void removeData(DataTable d) {
        if (databaseFiles.contains(d)) databaseFiles.remove(d);
    }
    public ObservableList<DataTable> getDatabaseFiles() {
        return databaseFiles;
    }
}

