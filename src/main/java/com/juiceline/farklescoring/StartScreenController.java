package com.juiceline.farklescoring;

import com.juiceline.scoring.GamerScore;
import com.juiceline.scoring.ScoreCard;
import com.juiceline.scoring.ScoreList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartScreenController implements Initializable{

//    GamerScore player;
//    String name = "Billy Bob";
    
    
    ObservableList<String> playerNames = FXCollections.observableArrayList();
    
    
    
    @FXML
    private Label nameTextBox;
            
    @FXML
    private ListView<String> nameEntry;
    
    @FXML
    private Button addplayerNameButton;
    @FXML
    private TextArea bottomTextBox;
    @FXML
    private TextField nameTextField;
    @FXML
    private Button addNameButton;
    @FXML
    private Button removeName;
    

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // clear list to ensure empty
        playerNames.clear();
//        nameEntry.setEditable(true); // Not using this feature at this time.  Dont work.... 
        playerNames.add("Joe Bob");
        nameEntry.setItems(playerNames);
    }

    @FXML
    private void buildScoreCardAction(ActionEvent event) throws IOException {
        Stage scorescreen = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //ScoreCard.makeRowHeader();  //Changed to being built in adGamer() method
       
        for(String name : playerNames)ScoreCard.addGamer(name);
        
        ScoreCard.addGamerNames(playerNames);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreScreen.fxml"));
        Scene scene = new Scene(loader.load());
        scorescreen.setScene(scene);
                
    }

    
    

    @FXML
    private void udpateNameList(ActionEvent event) {
        // Button that gets name from nameTextField
        String n = nameTextField.getText();
        playerNames.add(n);
        nameTextField.clear();
        
    }

    @FXML
    private void removeNameButtonClick(ActionEvent event) {
        // Removes selected name after checking is selection is made
//        System.out.println("index selected:" + nameEntry.getSelectionModel().getSelectedIndex());
        if(nameEntry.getSelectionModel().getSelectedIndex() >= 0){
            int i = nameEntry.getSelectionModel().getSelectedIndex();
            playerNames.remove(i);
        }
        
        
    }
    
//    private void addGamersScores() {
//        System.out.println("\n\nAdding scores to players: \n");
//        for(String name: playerNames) {
//            int[] numbs = {500,300,1500,450};
//            GamerScore g = ScoreCard.getGamer(name);
//            ScoreList sL = new ScoreList();
//            for(int i=0; i<numbs.length; i++){
//                sL.setScore(numbs[i]);
//                ScoreCard.addScore(name, sL);
//                g.printToConsole();
//                }
//            
//        }
//    }
        
}
