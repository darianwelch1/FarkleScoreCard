package com.juiceline.farklescoring;

import com.juiceline.scoring.GamerScore;
import com.juiceline.scoring.ScoreCard;
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
    private Button AddNameButton;
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
        // This is supposed to make list editable but is not working 
        nameEntry.setEditable(true);
        playerNames.add("Joe Bob");
        // This was supposed to create wrapper and bind to ListView
//        ReadOnlyObjectProperty<ObservableList<String>> listProperties = 
//                new SimpleObjectProperty<>(FXCollections.observableArrayList());
//        listProperties.get().addAll(playerNames);
//        nameEntry.itemsProperty().bind(listProperties);
        nameEntry.setItems(playerNames);
//        System.out.println("Is this editable? " + nameEntry.editableProperty().toString());
    }

    @FXML
    private void buildScoreCardAction(ActionEvent event) throws IOException {
        Stage scorescreen = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //ScoreCard.makeRowHeader();  //Changed to being built in adGamer() method
        int p = 0;
        for(String name : playerNames){
            GamerScore g = new GamerScore(name);
            ScoreCard.addGamer(g);
            g.printToConsole();
        }
        
        GamerScore header = ScoreCard.getGamer("Name");
        header.printToConsole();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreScreen.fxml"));
        Scene scene = new Scene(loader.load());
        scorescreen.setScene(scene);
        
//        System.out.println("\nBuild score card ");
//        System.out.println("player to add: "+player.getName());
//        ScoreCard.addGamer(player);
//        System.out.println("Score Card:");
//        System.out.println("from scorecard: " + ScoreCard.getGamer(name).getName());
        
//        App.setRoot("scoreScreen");
                
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
        System.out.println("index selected:" + nameEntry.getSelectionModel().getSelectedIndex());
        if(nameEntry.getSelectionModel().getSelectedIndex() >= 0){
            int i = nameEntry.getSelectionModel().getSelectedIndex();
            playerNames.remove(i);
        }
        
        
    }
    
    
    
}
