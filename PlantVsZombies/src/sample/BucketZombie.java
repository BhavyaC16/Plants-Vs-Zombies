package sample;

import javafx.scene.layout.Pane;

public class BucketZombie extends Zombie {
    public BucketZombie(int x, int y, int lane) {
        super(25, 3, "/assets/bucketheadzombie.gif", x, y, 68, 118, lane);
        this.path = getClass().getResource("/assets/bucketheadzombie.gif").toString();
    }
}
