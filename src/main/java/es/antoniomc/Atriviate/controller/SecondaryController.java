package es.antoniomc.Atriviate.controller;

import java.io.IOException;

import es.antoniomc.Atriviate.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}