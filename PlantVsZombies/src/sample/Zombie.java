package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public abstract class Zombie extends GameElements {

    protected int hp;
    protected int x;
    protected int y;
    protected int attackPower;

    public Zombie(int hp, int ap, String p, int x, int y, Pane pane, int width, int height) {
        super(x, y, p, pane, width, height);
        this.hp = hp;
        this.attackPower = ap;
        super.makeImage();
        //add code for displaying zombie
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (hp<=5) {
            img.setImage(new Image("file:src/sample/assets/normalzombie.gif", (double) 68,(double) 118,false,false));
            this.width=68;
            this.height=118;
        }

    }

    //    public Plant checkCollisionWithPlant(){
//
//    }
    public void setLane(int lane) {
        this.y = lane;
    }

    public void checkCollisionWithPlant() {

    }

    public boolean checkReachedHouse() {
        if (this.x <= 50) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlive() {
        if (this.hp > 0) {
            return true;
        } else {
            return false;
        }
    }

//    public void moveZombie() {
//        System.out.println("moving zombie");
//        double dx = -2;
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                System.out.println(getX());
//                setX(getX() - 2);
//                if (checkReachedHouse()) {
//                    //activate lawnmower or end game.
//}
//    public Plant checkCollisionWithPlant(){
//
//    }
//    public void checkReachedHouse() {
//        public void setLane ( int lane){
//            this.y = lane;
//        }
//        public int getX () {
//            return this.x;
//        }
//        public int getY () {
//            return this.y;
//        }
//        public void checkCollisionWithPlant () {
//
//        }
//        public boolean checkReachedHouse () {
//            if (this.x <= 50) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        public boolean isAlive ()
//        {
//            if (this.hp > 0) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        public void moveZombie () {
//            AnimationTimer timer = new AnimationTimer() {
//                double dx = -2;
//
//                @Override
//                public void handle(long now) {
//                    zombie.setLayoutX(zombie.getLayoutX() + dx);
//
//                    if (checkReachedHouse()) {
//                        //activate lawnmower or end game.
//                    }
//                /*
//                if(checkCollisionWithPlant())
//                {
//                    //make zombie wait (put sleep on thread for 8 seconds)
//                    //make plant disappear and resume zombie.
//                }
//                */
//                    if (!isAlive()) {
//                        //kill zombie
//                    }
//                }
//            };
//        }
//    }
//    public void run(){
//        while(this.hp>0) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if(this.hp==5)
//            Plant p=checkCollisionWithPlant();
//            if(p!=null){
//                while(p.getHp()>0) {
//                    p.setHp(p.getHp()-this.attackPower);
//                }
//                /*
//                if(checkCollisionWithPlant())
//                {
//                    //make zombie wait (put sleep on thread for 8 seconds)
//                    //make plant disappear and resume zombie.
//                }
//
//                    if (!isAlive()) {
//                        //kill zombie
//                    }
//
//                 */
//            }
//        };
//    }

    public void moveZombie() {
        Thread t = new Thread(() -> {
            while (this.hp > 0) {
                try {
                    //System.out.println("running");
                    setX(getX()-1);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        //if(this.hp<=5)
        //Plant p=checkCollisionWithPlant();
        //if(p!=null){
        //    while(p.getHp()>0) {
        //        p.setHp(p.getHp()-this.attackPower);
        //    }
        //}
        // if (checkReachedHouse()) {
//                GamePlayController.gameWon=True;
    }
    //moveZombie();
}