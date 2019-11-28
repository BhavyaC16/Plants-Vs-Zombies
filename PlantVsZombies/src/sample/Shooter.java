package sample;

import javafx.scene.layout.Pane;

public class Shooter extends Plant {
    public Shooter(int x, int y, String path, Pane pane, int hp,int width,int height){
        super(x,y,path,pane,hp,width,height);

    }
    @Override
    public void attack(){
        //throwpea
    }
}
