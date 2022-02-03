package com.juiceline.farklescoring;

import com.juiceline.scoring.ScoreCard;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ScoreScreenController implements Initializable{

    @FXML
    private TableView<?> scoreCardTable;
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
        
        //ScoreCard.getGamer("Billy Bob");
        System.out.println("Did it work??  " + ScoreCard.getGamer("Billy Bob").getName());
    }
}