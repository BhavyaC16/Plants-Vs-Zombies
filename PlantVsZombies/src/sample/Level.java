package sample;

import java.util.ArrayList;

public class Level {
    private int levelNumber;
    private int totalZombies;
    private ArrayList<String> availablePlants;
    private ArrayList<String> availableZombie;
    int levelTime=120000; //120 seconds
    public Level(int n){
        this.levelNumber=n;
        if (n>=1){
            this.availablePlants.add("Sunflower");
            this.availablePlants.add("PeaShooter");
            this.availableZombie.add("NormalZombie");
            this.totalZombies=10;
        }
        if (n >= 2) {
            this.availablePlants.add("Wallnut");
            this.availableZombie.add("ConeZombie");
            this.totalZombies=15;
        }
        if (n>=3){
            this.availablePlants.add("CherryBomb");
            this.availableZombie.add("BucketZombie");
            this.totalZombies=20;
        }
        if (n>=4){
            this.availablePlants.add("Repeater");
            this.totalZombies=25;
        }
        if (n>=5){
            this.availablePlants.add("Jalapeno");
            this.totalZombies=30;
        }

    }
}
