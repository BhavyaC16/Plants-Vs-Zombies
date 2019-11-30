package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {
    private int maxLevel;
    private static Database d;

    private ArrayList<DataTable>databaseFiles;

    private Database(){
        this.maxLevel=1;
        databaseFiles= new ArrayList<DataTable>();
    }
    public static Database getInstance(){
        if (d==null) {
            d=new Database();
        }
        return d;
    }


    protected Object readResolve()
    {
        return d;
    }
    public int getMaxLevel() { return maxLevel; }
    public void setMaxLevel(int maxLevel) {
        if (this.maxLevel< maxLevel) this.maxLevel=maxLevel;
    }

    public void addData(DataTable d){
        databaseFiles.add(d);
    }
    public void removeData(DataTable d) {
        if (databaseFiles.contains(d)) databaseFiles.remove(d);
    }
    public static void deleteAllProgress(){
        d=new Database();
    }
    public ArrayList<DataTable> getDatabaseFiles() {
        return databaseFiles;
    }
    public static void serialize() throws IOException {
        ObjectOutputStream out=null;
//        Database d2=Database.getInstance();
        try {
            out = new ObjectOutputStream (new FileOutputStream("database.txt"));
            out.writeObject(Database.getInstance());
            System.out.println("Saved!");
        }
        catch (FileNotFoundException f){
            System.out.println("cant find file");
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Not able to save");
        }
        finally {
            out.close();
        }
    }
    public static void deserialize() throws ClassNotFoundException, IOException{
        ObjectInputStream in = null;
        try {
            in=new ObjectInputStream (new FileInputStream("database.txt"));
            d=(Database) in.readObject();
            in.close();
        }
        catch (NullPointerException e) {
            d=new Database();
            e.printStackTrace();
        }
        catch (FileNotFoundException f){
            System.out.println("Cant find file");
        }
        catch(IOException e){
            System.out.println("Not able to save");
        }
        finally {
            try{
                in.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }

//            System.out.println("size "+Database.getInstance().getDatabaseFiles().size());
        }

    }


}

