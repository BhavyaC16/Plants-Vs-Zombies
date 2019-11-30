package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Wallnut extends Plant{
    ImageView img;
    public Wallnut(int x, int y, Pane pane, GridPane grid,int row,int col) {
        super(x, y, "file:src/sample/assets/walnut_full_life.gif", pane, 1500,60,75,grid,row,col);

    }
    @Override
    public void setHp(int hp){
        super.setHp(hp);
        if (hp<=750) {
            img.setImage(new Image("file:src/sample/assets/walnut_half_life.gif", (double) width, (double) height, false, false));
        }
    }
//        img = new ImageView();
//        Image im=new Image(path);
//        img.setImage(im);
//        img.setX(x);
//        img.setY(y);
//        pane.getChildren().add(img);
//    }
//
//    public void disappear(){
//        img.setDisable(true);
//        img.setVisible(false);
//    }
}
