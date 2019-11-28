package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.Serializable;

public abstract class GameElements implements Serializable{
    protected int x;
    protected int y;
    protected String path;
    protected ImageView img;
    protected Pane pane;
    public GameElements(int x_, int y_, String path, Pane p){
        this.x=x_;
        this.y=y_;
        this.path=path;
        this.pane=p;
        img = new ImageView();
        Image im=new Image(path);
        img.setImage(im);
        img.setX(x);
        img.setY(y);
        pane.getChildren().add(img);
    }
    public void disappear(){
        img.setDisable(true);
        img.setVisible(false);
    }

    public int getX(){
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
        img.setX(x);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        img.setY(y);
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

}
