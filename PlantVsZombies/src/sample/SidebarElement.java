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
    public SidebarElement(int x,int y,String path, int width,int height,int cost){
        super(x,y,path,width,height);
        this.cost=cost;
//        super.makeImage();
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
        path="file:assets/sunflowerCard.png";
        x=24;
        y=79;
        if(level>=1){
            path="/assets/sunflowerCard.png";
            x=24;
            y=79;
            SidebarElement sunflowerCard=new SidebarElement(x,y,path,width,height,50);
            sunflowerCard.makeImage(pane);
            sunflowerCard.timeoutTime=5000;
            allElements.put(1,sunflowerCard);
            sunflowerCard.img.setOnMouseClicked(e->{
                if (!sunflowerCard.isDisabled){
                    setCardSelected(1);
                    Shovel.getInstance().disable();
                }
            });
        }
        if(level>=1){
            path="/assets/peashooterCard.png";
            x=22;
            y=147;
            SidebarElement peashooterCard=new SidebarElement(x,y,path,width,height,100);
            peashooterCard.makeImage(pane);
            peashooterCard.timeoutTime=6000;
            allElements.put(2,peashooterCard);
            peashooterCard.img.setOnMouseClicked(e->{
                if (!peashooterCard.isDisabled){
                      setCardSelected(2);
                      Shovel.getInstance().disable();
                }
            });
        }
        if (level>=2){
            path="/assets/wallnutCard.png";
            x=22;
            y=217;
            SidebarElement wallnutCard=new SidebarElement(x,y,path,width,height,50);
            wallnutCard.makeImage(pane);
            wallnutCard.timeoutTime=7000;
            allElements.put(3,wallnutCard);
            wallnutCard.img.setOnMouseClicked(e->{
                if (!wallnutCard.isDisabled) {
                    setCardSelected(3);
                    Shovel.getInstance().disable();
                }
            });
        }
        if (level>=3) {
            path="/assets/cherrybombCard.png";
            x=22;
            y=284;
            SidebarElement cherrybombCard=new SidebarElement(x,y,path,width,height,150);
            cherrybombCard.makeImage(pane);
            cherrybombCard.timeoutTime=15000;
            allElements.put(4,cherrybombCard);
            cherrybombCard.img.setOnMouseClicked(e->{
                if (!cherrybombCard.isDisabled) {
                    setCardSelected(4);
                    Shovel.getInstance().disable();
                }
            });
        }
        if(level>=4) {
            path="/assets/repeaterCard.png";
            x=23;
            y=352;
            SidebarElement repeaterCard=new SidebarElement(x,y,path,width,height,200);
            repeaterCard.makeImage(pane);
            repeaterCard.timeoutTime=10000;
            allElements.put(5,repeaterCard);
            repeaterCard.img.setOnMouseClicked(e->{
                if (!repeaterCard.isDisabled){
                    setCardSelected(5);
                    Shovel.getInstance().disable();
                }
            });
        }
        if (level>=5) {
            path="/assets/jalapenoCard.png";
            x=24;
            y=420;
            SidebarElement jalapenoCard=new SidebarElement(x,y,path,width,height,125);
            jalapenoCard.makeImage(pane);
            jalapenoCard.timeoutTime=12000;
            allElements.put(6,jalapenoCard);
            jalapenoCard.img.setOnMouseClicked(e->{
                if (!jalapenoCard.isDisabled) {
                    setCardSelected(6);
                    Shovel.getInstance().disable();
                }
            });

        }
        String border_path = SidebarElement.class.getResource("/assets/selectedCardBorder.png").toString();
        selectedBorder = new ImageView(new Image(border_path,110.0,72.0,false,false));
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

    public void setDisabledOn(Pane pane){
        this.isDisabled=true;
        ImageView im =new ImageView(new Image(getClass().getResource("/assets/lock.png").toString(),50.0,50.0,false,false));
        im.setX(this.getX()+20);
        im.setY(this.getY());
        pane.getChildren().add(im);
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(this.timeoutTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.isDisabled=false;
            im.setVisible(false);
            im.setDisable(true);
        });
        t.start();

    }
}
