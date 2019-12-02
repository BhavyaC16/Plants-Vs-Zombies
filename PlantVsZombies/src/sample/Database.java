package sample;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {
    private static final long serialVersionUID=42L;
    private int maxLevel;
    private static Database d;

    private ArrayList<DataTable> databaseFiles;

    public Database() {
        this.maxLevel = 1;
        databaseFiles = new ArrayList<DataTable>();
    }


    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        if (this.maxLevel < maxLevel) this.maxLevel = maxLevel;
    }

    public void addData(DataTable d) {
        databaseFiles.add(d);
    }

    public void removeData(DataTable d) {
        if (databaseFiles.contains(d)) databaseFiles.remove(d);
    }

    public static void deleteAllProgress() {
        d = new Database();
    }

    public ArrayList<DataTable> getDatabaseFiles() {
        return databaseFiles;
    }
}

