package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Wallnut extends Plant{
    ImageView img;
    public Wallnut(int x, int y, Pane pane,int z) {
        super(x, y, "file:src/sample/assets/walnut_full_life.gif", pane, 25,75,66,z);

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
