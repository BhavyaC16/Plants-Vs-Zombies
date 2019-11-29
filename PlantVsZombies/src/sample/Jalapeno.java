package sample;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Jalapeno extends Plant {
    private ImageView[] fireViews;

    public Jalapeno(int x, int y, Pane pane, int z, GridPane grid,int row,int col) {
        super(x, y, "file:src/sample/assets/jalapeno.gif", pane, 4,100,100, z, grid,row,col);
        System.out.println("Placed plant");
        fireViews=new ImageView[9];;
        for(int i=0;i<9;i++){
            fireViews[i]=new ImageView(new Image("file:src/sample/assets/jalapenoFire.gif",(double) 100, (double) 100, false,false));
            fireViews[i].setDisable(true);
            fireViews[i].setVisible(false);
            lawn.add(fireViews[i],i,this.row,1,1);
        }
        attack();
    }

    public void sleep(int time){
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
    @Override
    public void attack() {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1650);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            img.setVisible(false);
            img.setDisable(true);
            for(int i=0;i<9;i++){
                fireViews[i].setVisible(true);
            }
            removefire();


        });
        t.start();
    }

   public void removefire(){
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<9;i++) {
                fireViews[i].setVisible(false);
                fireViews[i].setDisable(true);
            }
        });
        t.start();
    }

}
