package sample;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CherryBomb extends Plant{
    public CherryBomb(int x, int y, Pane pane, int z, GridPane grid,int row,int col) {
        super(x, y, "file:src/sample/assets/newCherryBomb.gif", pane, 4,200,200,z,grid,row,col);
//        System.out.println(this.path);
//        Image cImage = new Image("file:src/sample/assets/cherryBomb.gif", 150, 150, false, false);
//        System.out.println(cImage);
//        img.setImage(cImage);
//        System.out.println("Adding a cherr");
    }
    @Override
    public void attack(){
        //blast all the zombies around
    }
}
