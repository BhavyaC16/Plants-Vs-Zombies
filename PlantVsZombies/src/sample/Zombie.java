package sample;

public class Zombie {
    protected int hp;
    protected int attackPower;
    protected String path;
    public Zombie(int hp, int ap,String p,int x,int y){
        super(x,y);
        this.hp=hp;
        this.attackPower=ap;
        this.path=p;
        //add code for displaying zombie
    }
    public int getHp(){
        return this.hp;
    }
    public void setHp(int hp){
        this.hp=hp;
    }
    public Plant checkCollisionWithPlant(){

    }
    public void checkReachedHouse(){

    }
    public void moveZombie(){

    }

    public void run(){
        while(this.hp>0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(this.hp==5)
            Plant p=checkCollisionWithPlant();
            if(p!=null){
                while(p.getHp()>0) {
                    p.setHp(p.getHp()-this.attackPower);
                }
            }
            if(checkReachedHouse()){
                GamePlayController.gameWon=True;
            }
            moveZombie();
        }
    }
}
