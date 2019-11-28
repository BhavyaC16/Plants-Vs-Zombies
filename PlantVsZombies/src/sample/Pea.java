package sample;

import javafx.scene.layout.Pane;

public class Pea extends GameElements{
    String path="./assets/pea.png";
    public Pea(int x, int y, Pane pane) {
        super(x, y, "file:src/sample/assets/pea.png", pane,50,50);
    }
}
