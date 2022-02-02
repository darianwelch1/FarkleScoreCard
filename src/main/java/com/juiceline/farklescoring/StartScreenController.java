package com.juiceline.farklescoring;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class StartScreenController {

    @FXML
    private TextArea nameTextBox;
            
    @FXML
    private ListView<String> nameEntry;
    @FXML
    private Button AddNameButton;
    @FXML
    private TextArea bottomTextBox;

    private void buildScoreCard() throws IOException {
        App.setRoot("scoreScreen");
    }

    @FXML
    private void namesEntered(ListView.EditEvent<String> event) {
        
    }

    @FXML
    private void buildScoreCard(ActionEvent event) throws IOException {
        App.setRoot("scoreScreen");
    }
}
