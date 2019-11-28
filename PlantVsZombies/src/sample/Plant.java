package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.nio.file.spi.FileSystemProvider;

public abstract class Plant extends GameElements{
    String path;
    protected GridPane lawn;
    protected int hp;
    private int zombierow;
    private int col;
    private int row;
    public Plant(int x, int y, String path, Pane pane, int hp,int width,int height,int z,GridPane lawn,int col,int row){
        super(x,y,path,pane,width,height);
        this.hp=hp;
        this.zombierow=z;
        this.lawn=lawn;
        this.col=col;
        this.row=row;
        this.makeImage();

    }

    @Override
    public void makeImage(){
        lawn.add(img,col,row,1,1);
    }

    public void attack(){

    }

    public int getHp(){
        return this.hp;
    }
    public void setHp(int n){
        this.hp-=n;
        if (this.hp<=0){
            System.out.println("Plant dead");
            //disappear
            //remove from list
        }
    }

}
