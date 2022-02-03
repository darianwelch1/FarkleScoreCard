package com.juiceline.farklescoring;

import com.juiceline.scoring.GamerScore;
import com.juiceline.scoring.ScoreCard;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

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
    

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerNames.clear();
        nameEntry.setEditable(true);
        playerNames.add("Joe Bob");
//        ReadOnlyObjectProperty<ObservableList<String>> listProperties = 
//                new SimpleObjectProperty<>(FXCollections.observableArrayList());
//        listProperties.get().addAll(playerNames);
//        nameEntry.itemsProperty().bind(listProperties);
        nameEntry.setItems(playerNames);
        System.out.println("Is this editable? " + nameEntry.editableProperty().toString());
        
        
//        nameEntry.setItems(playerNames);
       
        
        
        
//        LinkedList num = new LinkedList<>();
//        Integer[] s = {12,15,75,85,36};
//        num.addAll(Arrays.asList(s));
//        player = new GamerScore(name,num);
//        System.out.println(player.getName());
        
    }

    @FXML
    private void buildScoreCardAction(ActionEvent event) throws IOException {
        
        
        
//        System.out.println("\nBuild score card ");
//        System.out.println("player to add: "+player.getName());
//        ScoreCard.addGamer(player);
//        System.out.println("Score Card:");
//        System.out.println("from scorecard: " + ScoreCard.getGamer(name).getName());
        
        App.setRoot("scoreScreen");
    }

    

    @FXML
    private void udpateNameList(ActionEvent event) {
        
        String n = nameTextField.getText();
        playerNames.add(n);
        nameTextField.clear();
        
    }
    
    
    
}
