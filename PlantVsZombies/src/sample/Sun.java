package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sun implements Runnable{
    private int x;
    private int y;
    private ImageView sun;
    private Image sunImage;

    public Sun(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.sunImage = new Image("file:src/sample/assets/sun.png",50,50,false,false);
        this.sun = new ImageView();
        this.sun.setImage(this.sunImage);
    }
    @Override
    public void run()
    {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dropSun();
    }

    private void dropSun()
    {
        AnimationTimer timer = new AnimationTimer()
        {
            double dy = 2;
            @Override
            public void handle(long now)
            {
                sun.setLayoutY(sun.getLayoutY()+dy);
            }
        };
    }
}
