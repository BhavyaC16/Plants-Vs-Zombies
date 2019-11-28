package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class SidebarElement extends GameElements{
    private static int cardSelected=-1;
    private int timeoutTime;
    private boolean isDisabled=false;
    private static ImageView selectedBorder;
    private static HashMap<Integer,SidebarElement> allElements;
    private final int cost;
    public SidebarElement(int x,int y,String path,Pane pane, int width,int height,int cost){
        super(x,y,path,pane,width,height);
        this.cost=cost;
        super.makeImage();
    }

    public int getCost(){
        return this.cost;
    }

    public static void getSideBarElements(int level,Pane pane){
        String path;
        int x;
        int y;
        int width=97;
        int height=58;
        allElements=new HashMap<Integer, SidebarElement>();
        if(level>=1){
            path="file:src/sample/assets/sunflowerCard.png";
            x=24;
            y=79;
            SidebarElement sunflowerCard=new SidebarElement(x,y,path,pane,width,height,50);
//            sunflowerCard.makeImage();
            sunflowerCard.timeoutTime=5000;
            allElements.put(1,sunflowerCard);
            sunflowerCard.img.setOnMouseClicked(e->{
                if (!sunflowerCard.isDisabled){
                    System.out.println("SUnflowerclcked");
                    setCardSelected(1);
                }
            });
        }
        if(level>=1){
            path="file:src/sample/assets/peashooterCard.png";
            x=22;
            y=147;
            SidebarElement peashooterCard=new SidebarElement(x,y,path,pane,width,height,100);
//            peashooterCard.makeImage();
            peashooterCard.timeoutTime=6000;
            allElements.put(2,peashooterCard);
            peashooterCard.img.setOnMouseClicked(e->{
                if (!peashooterCard.isDisabled){
                    System.out.println("pealcked");
                      setCardSelected(2);
                }
            });
        }
        if (level>=2){
            path="file:src/sample/assets/wallnutCard.png";
            x=22;
            y=217;
            SidebarElement wallnutCard=new SidebarElement(x,y,path,pane,width,height,50);
//            wallnutCard.makeImage();
            wallnutCard.timeoutTime=7000;
            allElements.put(3,wallnutCard);
            wallnutCard.img.setOnMouseClicked(e->{
                if (!wallnutCard.isDisabled) {
                    setCardSelected(3);
                }
            });
        }
        if (level>=3) {
            path="file:src/sample/assets/cherrybombCard.png";
            x=22;
            y=284;
            SidebarElement cherrybombCard=new SidebarElement(x,y,path,pane,width,height,150);
//            cherrybombCard.makeImage();
            cherrybombCard.timeoutTime=8000;
            allElements.put(4,cherrybombCard);
            cherrybombCard.img.setOnMouseClicked(e->{
                if (!cherrybombCard.isDisabled) {
                    System.out.println("CherryBomb clicked");
                    setCardSelected(4);
                }
            });
        }
        if(level>=4) {
            path="file:src/sample/assets/repeaterCard.png";
            x=23;
            y=352;
            SidebarElement repeaterCard=new SidebarElement(x,y,path,pane,width,height,200);
//            repeaterCard.makeImage();
            repeaterCard.timeoutTime=9000;
            allElements.put(5,repeaterCard);
            repeaterCard.img.setOnMouseClicked(e->{
                if (!repeaterCard.isDisabled){
                    System.out.println("repeater clicked");
                    setCardSelected(5);
                }
            });
        }
        if (level>=5) {
            path="file:src/sample/assets/jalapenoCard.png";
            x=24;
            y=420;
            SidebarElement jalapenoCard=new SidebarElement(x,y,path,pane,width,height,125);
//            jalapenoCard.makeImage();
            jalapenoCard.timeoutTime=10000;
            allElements.put(6,jalapenoCard);
            jalapenoCard.img.setOnMouseClicked(e->{
                if (!jalapenoCard.isDisabled) {
                    System.out.println("Jalapeno clicked");
                    setCardSelected(6);
                }
            });

        }
        selectedBorder =new ImageView(new Image("file:src/sample/assets/selectedCardBorder.png",110.0,72.0,false,false));
        pane.getChildren().add(selectedBorder);
        selectedBorder.setVisible(false);
        selectedBorder.setDisable(true);
    }

    public static int getCardSelected() {
        return cardSelected;
    }
    private static void setCardSelected(int i){
        cardSelected=i;
        selectedBorder.setVisible(true);
        System.out.println("Card selected"+selectedBorder);
        selectedBorder.setX(allElements.get(cardSelected).getX()-5);
        selectedBorder.setY(allElements.get(cardSelected).getY()-5);
    }
    public static void setCardSelectedToNull(){
        cardSelected=-1;
        selectedBorder.setVisible(false);
    }

    public static SidebarElement getElement(int x){
        if (allElements.containsKey(x)) return allElements.get(x);
        else return null;
    }

    public void setDisabledOn(){
        this.isDisabled=true;
        ImageView im =new ImageView(new Image("file:src/sample/assets/lock.png",50.0,50.0,false,false));
        im.setX(this.getX()+20);
        im.setY(this.getY());
        this.pane.getChildren().add(im);
        System.out.println("Added lock image");

        Thread t = new Thread(() -> {
            try {
                System.out.println("now disabled");
                Thread.sleep(this.timeoutTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.isDisabled=false;
            System.out.println("Now not disabled");
            im.setVisible(false);
            im.setDisable(true);
        });
        t.start();

    }
}
