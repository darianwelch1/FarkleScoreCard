/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juiceline.farklescoring;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.juiceline.farklescoring.ScoreScreenController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * FXML Controller class
 *
 * @author darianwelch
 */
public class AddPlayerController implements Initializable {

    public StringProperty playerNameToAdd = new SimpleStringProperty();
    
    @FXML
    public TextField playerNameText;
    @FXML
    private Button playeButtonToEnter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void playerButtonClick(ActionEvent event) {
        
        Stage scorescreen = (Stage) ((Node)event.getSource()).getScene().getWindow();
        System.out.println(playerNameToAdd.getValue());
        playerNameToAdd.setValue(playerNameText.getText());
        scorescreen.close();
    }

    public StringProperty playerNameToAddProperty() {
        return playerNameToAdd;
    }
    
    
}
