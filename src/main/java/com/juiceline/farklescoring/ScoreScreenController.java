package com.juiceline.farklescoring;

import com.juiceline.scoring.GamerScore;
import com.juiceline.scoring.ScoreCard;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ScoreScreenController implements Initializable{
    
    
    @FXML
    private Button saveGameButton;
    @FXML
    private Button addPlayer;
    @FXML
    private TextArea textAreaScoreCard;
    @FXML
    private Button startNewGameBuitton;
    @FXML
    private HBox nameHbox;
    @FXML
    private HBox scoreHbox;
    @FXML
    private HBox listViewHbox;
   
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
       System.out.println("ScoreCard initialized....");
       buildListViews();
       
      
    }
       
    private void buildListViews(){
        for(GamerScore g : ScoreCard.getScoreList()){
            TextField gamerName = new TextField();
            gamerName.setText(g.getName());
            TextField scoreTotal = new TextField();
            if(g.getName().equals("Name")){
                scoreTotal.setText("Total Score");
                }
            else scoreTotal.setText(g.totalScore().toString());
            ListView<Integer> list = new ListView<Integer>(g.getScore());
            nameHbox.getChildren().add(gamerName);
            scoreHbox.getChildren().add(scoreTotal);
            listViewHbox.getChildren().add(list);
            
            
        }
        
        
        
        
    }
    
    
}