package com.juiceline.farklescoring;

import java.io.IOException;
import javafx.fxml.FXML;

public class ScoreScreenController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("startScreen");
    }
}