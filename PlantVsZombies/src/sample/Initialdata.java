package sample;
import java.io.Serializable;
import java.util.ArrayList;

public class Initialdata implements Serializable {
    private int maxLevel;
    private static Initialdata d;
    private ArrayList<Database> databaseFiles;

    private Initialdata(){
        this.maxLevel=0;
        databaseFiles=new ArrayList<Database>();
    }
    public static Initialdata getInstance(){
        if (d==null) {
            Initialdata d=new Initialdata();
        }
        return d;
    }
    public int getMaxLevel() { return maxLevel; }
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
    public void addData(Database d){
        databaseFiles.add(d);
    }
    public void removeData(Database d) {
        if (databaseFiles.contains(d)) databaseFiles.remove(d);
    }
    public ArrayList<Database> getDatabaseFiles() {
        return databaseFiles;
    }
}
