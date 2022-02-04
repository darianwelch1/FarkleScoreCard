package com.juiceline.farklescoring;

import com.juiceline.scoring.GamerScore;
import com.juiceline.scoring.ScoreCard;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class ScoreScreenController implements Initializable{
    
    LinkedList<Integer> score;

    @FXML
    private TableView<GamerScore> scoreCardTable;
    @FXML
    private Button saveGameButton;
    @FXML
    private Button addPlayer;
    @FXML
    private TextArea textAreaScoreCard;
    @FXML
    private Button startNewGameBuitton;
   
    @FXML
    private void saveGame(ActionEvent event) {
    }

    @FXML
    private void addPlayer(ActionEvent event) {
    }

    @FXML
    private void startNewGame(ActionEvent event) throws IOException {
        App.setRoot("startScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       score = new LinkedList<>();
       System.out.println("ScoreCard initialized....");
       TableColumn<GamerScore, Integer> header = new TableColumn<>("Name");
       header.setCellValueFactory(new PropertyValueFactory<GamerScore, Integer>("Score"));
       ScoreCard.getGamer("Name").printToConsole();
       scoreCardTable.getColumns().add(header);
       
       //for(GamerScore g : ScoreCard.getScoreList())g.toString(g);
       
       //for(GamerScore g : ScoreCard.)
        
        
    }
    
    
    
}