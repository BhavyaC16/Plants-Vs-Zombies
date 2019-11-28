package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GamePlay {

    private Label sunCountLabel;
    private int levelNumber;
    private GridPane lawn;
    private ArrayList<Plant> allPlants;
    private ArrayList<Zombie> allZombies;
    private int sunCount;
    private Pane main_pane;

    public GamePlay(Pane pane, int levelNumber, GridPane lawn_grid)
    {
        this.allPlants = new ArrayList<Plant>();
        this.allZombies = new ArrayList<Zombie>();
        this.sunCount = 50;

        this.sunCountLabel = new Label("50");
        sunCountLabel.setLayoutX(58);
        sunCountLabel.setLayoutY(3);
        sunCountLabel.setFont(Font.font("Dyuthi", 45));
        sunCountLabel.setTextFill(Color.WHITE);
        pane.getChildren().add(sunCountLabel);

        this.levelNumber = levelNumber;
        this.lawn = lawn_grid;
        this.main_pane = pane;

        SidebarElement.getSideBarElements(levelNumber, main_pane);
    }

    public void fallingSuns(Random rand, Pane pane) {
        Timeline sunDropper = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int sunPosition = rand.nextInt(800);
                sunPosition += 100;
                Sun s = new Sun(sunPosition, 0, pane);
                s.dropSun();
            }
        }));
        sunDropper.setCycleCount(Timeline.INDEFINITE);
        sunDropper.play();
    }

    public void getGridPosition(MouseEvent event) throws IOException {
        if (SidebarElement.getCardSelected() != -1) {
            Node source = (Node) event.getSource();
            int col=(int) (source.getLayoutX() + source.getParent().getLayoutX());
            int row=(int) (source.getLayoutY() + source.getParent().getLayoutY());

            boolean flag=true;
            for (Plant p: allPlants){
                if (p.getX()==col && p.getY()==row) {
                    flag=false;
                }
            }
            if ((flag) && SidebarElement.getElement(SidebarElement.getCardSelected()).getCost()<=Integer.valueOf(sunCountLabel.getText())){
                placePlant(SidebarElement.getCardSelected(), col, row);
                SidebarElement.getElement(SidebarElement.getCardSelected()).setDisabledOn();
            }
            else System.out.println("Not enough suns"+Integer.valueOf(sunCountLabel.getText()));
            SidebarElement.setCardSelectedToNull();
        }
    }

    public void placePlant(int val, int x, int y) {
        System.out.println("Placing Plant");
        switch (val) {
            case 1:
                allPlants.add(new Sunflower(x, y, main_pane));
                break;
            case 2:
                allPlants.add(new PeaShooter(x, y, main_pane));
                break;
            case 3:
                allPlants.add(new Wallnut(x, y, main_pane));
                break;
            case 4:
                allPlants.add(new CherryBomb(x, y, main_pane));
                break;
            case 5:
                allPlants.add(new Repeater(x, y, main_pane));
                break;
            case 6:
                allPlants.add(new Jalapeno(x, y, main_pane));
                break;
            default:
                System.out.println("No case match" + val);
        }
    }



}
