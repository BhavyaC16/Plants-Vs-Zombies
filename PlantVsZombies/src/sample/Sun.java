package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Sun extends GameElements{
    private int x;
    private int y;

    public Sun(int x, int y, Pane pane)
    {
        super(x, y, "file:src/sample/assets/sun.png", pane, 50, 50);
    }

    public void dropSun()
    { Thread t = new Thread(() -> {
       while(getY()<=550)
       {
           try
           {
               Thread.sleep(20);
               setY(getY()+1);
               this.img.setOnMouseClicked(e->{
                   System.out.println("Falling sun clicked");
                   this.img.setVisible(false);
                   this.img.setDisable(true);
               });

           }
           catch(InterruptedException e)
           {
               e.printStackTrace();
           }
       }
    });
    t.start();
    }
}
