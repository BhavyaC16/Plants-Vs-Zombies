package sample;

import javafx.scene.layout.Pane;

public class NormalZombie extends Zombie{
//    String p="./assets/normalzombie.gif";
    public NormalZombie(int x, int y, Pane pane){
        super(5,1,"file:src/sample//assets/normalzombie.gif",x,y,pane);
    }
}
