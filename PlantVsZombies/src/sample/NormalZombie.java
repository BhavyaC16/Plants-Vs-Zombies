package sample;

import javafx.scene.layout.Pane;

public class NormalZombie extends Zombie{
    public NormalZombie(int x, int y, int lane) {
        super(7, 1, "/assets/normalzombie.gif", x, y, 68, 118, lane);
        this.path=getClass().getResource("/assets/normalzombie.gif").toString();
    }
}
