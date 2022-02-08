package com.juiceline.farklescoring;

import com.juiceline.scoring.GamerScore;
import com.juiceline.scoring.ScoreCard;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.StringConverter;

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
       
       nameHbox.getChildren().clear();
       scoreHbox.getChildren().clear();
       listViewHbox.getChildren().clear();
       
       buildListViews();
       
       
    }
       
    private void buildListViews(){
        System.out.println("\n\n\nStart of build.  Size of list is: " + ScoreCard.getScoreList().size());
        
        for(GamerScore g : ScoreCard.getScoreList()){
            // Had problems when declared outside of loop.  Duplicate erros on Hbox.
            Button gamerNameButton = new Button();
            TextField scoreTotal = new TextField();
            ListView<Integer> list = new ListView<>(g.getScore());
            gamerNameButton.setText(g.getName());
            if(g.getName().equals("Name")){
                scoreTotal.setText("Total Score");
                }
            else scoreTotal.setText(g.totalScore().toString());
            scoreTotal.setPrefWidth(80);
            scoreTotal.setEditable(false);
            gamerNameButton.setPrefWidth(80);
            
            list.setPrefWidth(80);
            list.setEditable(true);
            list.setCellFactory(l -> new ListCell<Integer>(){
                
                int index = l.itemsProperty().get().indexOf(this);
                
                @Override
                public void startEdit() {
                    super.startEdit(); 
//                    l.edit(l.itemsProperty().get().indexOf(this));
                    
                }
                
                @Override
                public void commitEdit(Integer newValue) {
                    super.commitEdit(newValue); 
                     g.enterScore(newValue, l.itemsProperty().get().indexOf(this));
                     scoreTotal.setText(g.totalScore().toString());
                     
                }

                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty); 
                    
                    if (empty || item == null || item.getScore() == null) {
                        setText(null);
                    } else {
                        setText(item.getWord());
                    }
                }
                
            });
//            list.setOnMouseClicked(new EventHandler<MouseEvent>(){
//                @Override
//                public void handle(MouseEvent t) {
//                    
//                    list.edit(list.getItems().size());
//                }
//                
//            });
           
            nameHbox.getChildren().add(gamerNameButton);
            scoreHbox.getChildren().add(scoreTotal);
            listViewHbox.getChildren().add(list);
            }
        }
    
    
    
}