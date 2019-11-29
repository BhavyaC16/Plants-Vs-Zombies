package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class LoadGameController {

    @FXML
    private AnchorPane loadGameRoot;

    @FXML
    private ListView gameStateList;

    @FXML
    private ImageView backButton;

   private ObservableList<String> timeStamps = FXCollections.observableArrayList("[14:50:00] [04-11-19] [Level 3]", "[19:20:45] [06-11-19] [Level 1]", "[09:22:16] [09-11-19] [Level 5]");
//    private ObservableList<String> timeStamps;
    @FXML
    public void initialize()
    {
//        timeStamps=new ArrayList<String>();
//        if (Initialdata.getInstance().getDatabaseFiles().size()!=0){
//            for (Database d : Initialdata.getInstance().getDatabaseFiles()){
//
//
//            }
//        }
        gameStateList.setItems(timeStamps);
    }


    @FXML
    void loadPrevMenu(MouseEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        loadGameRoot.getChildren().setAll(pane);
    }


    @FXML
    void handleMouseClick(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        loadGameRoot.getChildren().setAll(pane);
    }
}