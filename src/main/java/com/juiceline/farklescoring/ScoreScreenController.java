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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class ScoreScreenController implements Initializable{
    
    private final char FARKLE = 'F';
    ObservableList<String> playerNames = FXCollections.observableArrayList();
    
    
    @FXML
    private Button saveGameButton;
    @FXML
    private Button addPlayer;
    @FXML
    private TextArea textAreaScoreCard;
    @FXML
    private Button startNewGameBuitton;
    @FXML
    private HBox cardHbox;
    
   
   

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
        System.out.println("\n\n\nStart of build.  Size of list is: " + ScoreCard.getScoreCardList().size());
        
        for(GamerScore g : ScoreCard.getScoreCardList()){
            // Had problems when declared outside of loop.  Duplicate erros on Hbox.
            ListView<ScoreList> list = new ListView<>(g.getScore());
            Button gamerNameButton = buildPlayerButton(g,list);
            TextField scoreTotal = buildTotalTextField(g);
            list.setPrefWidth(80);
            list.setEditable(true);
            list.setCellFactory(new Callback<ListView<ScoreList>, ListCell<ScoreList>>() {
                
                
                
                @Override
                public ListCell<ScoreList> call(ListView<ScoreList> param) {
                  return new TextFieldListCell<>(new StringConverter<ScoreList>() {
                        @Override
                        public String toString(ScoreList t) {
                            return t.toString();
                        }

                        @Override
                        public ScoreList fromString(String string) {
                            Integer i= Integer.valueOf(string);
                            if(i == 0){
                                i = ScoreCard.checkFarkleCount(g);
                            }else ScoreCard.resetFarkleCount(g);
//                            i = Integer.valueOf(string);
                            ScoreList sL = new ScoreList();
                            sL.setScore(i);
                            System.out.println("sL value: "+sL.toString());
                            ScoreCard.editScore(g, sL, param.getEditingIndex());
                            scoreTotal.setText(ScoreCard.getTotalScore(g).toString());
                            return sL;
                            }
                        });
                    }
                });
            //list.setOnEditCommit(eh);
            gamerNameButton.setOnMouseClicked(e -> playerButtonAction(g,list));
            VBox vList = new VBox(gamerNameButton,scoreTotal,list);
            cardHbox.getChildren().add(vList);
        }
        playerNames.addAll(ScoreCard.getNames());
        for(String n : playerNames)System.out.println(n);
        System.out.println("\n");
    
    }
    /*
    Build the button that has the player's name 
    */
    private Button buildPlayerButton(GamerScore g, ListView list){
        Button gamerNameButton = new Button();
        gamerNameButton.setText(g.getName());
        gamerNameButton.setPrefWidth(80);
        gamerNameButton.setOnMouseClicked(e -> playerButtonAction(g,list));
        return gamerNameButton;
    }
    /*
    Build the textfield that shows player's total
    */
    private TextField buildTotalTextField(GamerScore g){
        TextField scoreTotal = new TextField();
        if(g.getName().equals("Name")){
            scoreTotal.setText("Total Score");
            }
        else scoreTotal.setText(g.totalScore().toString());
        scoreTotal.setPrefWidth(80);
        scoreTotal.setEditable(false);
        
        return scoreTotal;
    }
    /*
    Defines action when player name button is clicked.
    Moves selection to next cell for adding score to list.
    */
    public void playerButtonAction(GamerScore g, ListView list){
        ScoreList s = new ScoreList();
        ScoreCard.addScore(g.getName(), s);
        list.refresh();
        list.getSelectionModel().selectLast();
        list.getFocusModel().focus(list.getEditingIndex());
        list.edit(list.getEditingIndex());
               
    }

    @FXML
    private void gameRulesButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RulesAndScore.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }
    
    class ScoreListCell extends ListCell<ScoreList>{
        
        ImageView image=new ImageView("f_dwg.png");
        
        @Override
        public void cancelEdit() {
            super.cancelEdit(); 
            
        }

        @Override
        public void commitEdit(ScoreList newValue) {
            super.commitEdit(newValue); 
            
        }

        @Override
        public void startEdit() {
            super.startEdit(); 
//            list.getSelectionModel().selectLast();
//            list.getFocusModel().focus(list.getEditingIndex());
//            list.edit(list.getEditingIndex());
        }

//        @Override
//        protected void updateItem(ScoreList item, boolean empty) {
//            super.updateItem(item, empty); 
//            
//            if(item.getScore() == -300){
//                setGraphic(image);
//            }
//        }
        
        
    
}

   
    
}