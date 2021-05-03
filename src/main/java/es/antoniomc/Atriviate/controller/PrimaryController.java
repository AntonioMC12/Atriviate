package es.antoniomc.Atriviate.controller;

import java.io.IOException;

import es.antoniomc.Atriviate.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
