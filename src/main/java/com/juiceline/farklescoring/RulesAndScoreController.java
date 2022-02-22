/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juiceline.farklescoring;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author darianwelch
 */
public class RulesAndScoreController implements Initializable {
    
    private final String RULESFILE = "/src/main/resources/com/juiceline/farklescoring/farkleRules.txt";
    private final String FACTSFILE = "/src/main/resources/com/juiceline/farklescoring/facts.txt";
    private final String OBJECTIVEFILE = "/src/main/resources/com/juiceline/farklescoring/objective.txt";
    private final String SETUPFILE = "/src/main/resources/com/juiceline/farklescoring/setup.txt";
    private final String WINNINGFILE = "/src/main/resources/com/juiceline/farklescoring/winning.txt";
    private final String SCOREFILE = "/src/main/resources/com/juiceline/farklescoring/ruleScores.txt";
    @FXML
    private TextField titleTextField;
    @FXML
    private VBox ruleVbox;
    @FXML
    private VBox scoreVbox;
    @FXML
    private Button closeButton;

    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        titleTextField.setEditable(false);
        
        String filepath = new File("").getAbsolutePath();
//        File facts = new File(filepath.concat(FACTSFILE));
//        File objective = new File(filepath.concat(OBJECTIVEFILE));
//        File setup = new File(filepath.concat(SETUPFILE));
//        File winning = new File(filepath.concat(WINNINGFILE));
        File rulesfile = new File(filepath.concat(RULESFILE));
        File score = new File(filepath.concat(SCOREFILE));
//        System.out.println("Path to file: " + facts.getPath());
//        System.out.println("Path to file: " + objective.getPath());
//        System.out.println("Path to file: " + setup.getPath());
        
//        StringBuilder rulesText = new StringBuilder();
        readFile(rulesfile, ruleVbox);
        readFile(score, scoreVbox);
        closeButton.setFocusTraversable(true);
        titleTextField.setFocusTraversable(false);

    }    

    @FXML
    private void closeButtonClick(ActionEvent event) {
        Stage scorescreen = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scorescreen.close();
        
    }
    
    public void readFile(File file, VBox vbox){
        StringBuilder rulesText = new StringBuilder();
        List<TextField> children = new ArrayList<>();
        try {
            Scanner in = new Scanner(file);
            String line;
            while(in.hasNextLine()){
                line = in.nextLine();
                TextField textfield = new TextField(line);
                textfield.setEditable(false);
                textfield.setFocusTraversable(false);
                children.add(textfield);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File read error.");
        }
        vbox.getChildren().addAll(children);
    }
    
}
