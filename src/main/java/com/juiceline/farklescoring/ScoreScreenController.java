package com.juiceline.farklescoring;

import com.juiceline.scoring.GamerScore;
import com.juiceline.scoring.ScoreCard;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class ScoreScreenController implements Initializable{
    
    
    @FXML
    private TableView scoreCardTable;
    @FXML
    private Button saveGameButton;
    @FXML
    private Button addPlayer;
    @FXML
    private TextArea textAreaScoreCard;
    @FXML
    private Button startNewGameBuitton;
    @FXML
    private TextField runningTotalTextBox;
   
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
       
       TableColumn header = new TableColumn<GamerScore, Integer>("Name");
       header.setCellValueFactory(new Callback<CellDataFeatures<GamerScore, Integer>, ObservableValue<Integer>>(){
           public ObservableValue<Integer> call(CellDataFeatures<GamerScore, Integer> p) {
               return (ObservableValue<Integer>) p.getValue().getScore();
           }
        });
    }
       // ScoreCard.getGamer("Name").printToConsole();
       // scoreCardTable.getColumns().add(header);
//       for (GamerScore g : ScoreCard.getScoreList()){
//           TableColumn row = new TableColumn<GamerScore, Integer>(g.getName());
//           row.setCellValueFactory(new PropertyValueFactory<GamerScore, Integer>("score"));
//           scoreCardTable.getColumns().add(row);
//           }
//       
       //for(GamerScore g : ScoreCard.getScoreList())g.toString(g);
       
       //for(GamerScore g : ScoreCard.)
        
        
//    }
    
    
    
}