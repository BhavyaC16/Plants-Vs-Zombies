package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LoadGameController {

    @FXML
    private AnchorPane loadGameRoot;

    @FXML
    private ListView gameStateList;

    @FXML
    private ImageView backButton;

    @FXML
    private Button deleteProgress;
    ObservableList<DataTable> d= FXCollections.observableArrayList(Main.getDatabase().getDatabaseFiles());


    //   private ObservableList<String> items = FXCollections.observableArrayList("[14:50:00] [04-11-19] [Level 3]", "[19:20:45] [06-11-19] [Level 1]", "[09:22:16] [09-11-19] [Level 5]");
//    private ObservableList<String> timeStamps;
    @FXML
    public void initialize()
    {
//        ObservableList<DataTable> d= FXCollections.observableArrayList(Database.getInstance().getDatabaseFiles());
        deleteProgress.setStyle("-fx-background-color: #fcd432");
        //System.out.println(Main.getDatabase().getDatabaseFiles().size());
        gameStateList.setItems(d);
    }

    @FXML
    void loadPrevMenu(MouseEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        loadGameRoot.getChildren().setAll(pane);
    }


    @FXML
    void handleMouseClick(MouseEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
//        Main.deserialize();
        AnchorPane pane=fxmlLoader.load();
        DataTable d= (DataTable) gameStateList.getSelectionModel().getSelectedItem();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(d.getLevelNumber(),d);
        loadGameRoot.getChildren().setAll(pane);

    }

    @FXML
    void deleteAllProgress(MouseEvent event) throws Exception{
        File file = new File("database.txt");
        if(file.delete()){
            //System.out.println("database.txt File deleted");
            Database.deleteAllProgress();
            //System.out.println("Size is "+Main.getDatabase().getDatabaseFiles().size());
            gameStateList.getItems().clear();
//            gameStateList.setItems(d);
        }
        //else System.out.println("database.txt doesn't exist");

    }
}