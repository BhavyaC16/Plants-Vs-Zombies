package sample;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.nio.file.spi.FileSystemProvider;

public abstract class Plant extends GameElements{
    String path;
//    protected GridPane lawn;
    protected int hp;
    protected int col;
    protected int row;
    public Plant(int x, int y, String path, int hp,int width,int height,int col,int row){
        super(x,y,path,width,height);
        this.hp=hp;
//        this.lawn=lawn;
        this.col=col;
        this.row=row;

    }

    public void makeImage(GridPane lawn){
        img = new ImageView();
        Image im=new Image(path,(double) width,(double) height,false,false);
        img.setImage(im);
        lawn.add(img,col,row,1,1);
    }

    public void attack(Pane p){

    }

    public int getHp(){
        return this.hp;
    }

    public void setHp(int hp){
        this.hp=hp;
        if (this.hp<=0){
            GamePlayController.allPlants.remove(this);
            img.setVisible(false);
            img.setDisable(true);
        }
    }

    public void endAnimation(Timeline t)
    {
        t.stop();
    }

}
