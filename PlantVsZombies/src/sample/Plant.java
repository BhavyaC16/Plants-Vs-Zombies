package sample;

import javafx.scene.layout.Pane;

public abstract class Plant extends GameElements{
    String path;
    protected int hp;
    public Plant(int x, int y, String path, Pane pane, int hp){
        super(x,y,path,pane);
        this.hp=hp;
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
