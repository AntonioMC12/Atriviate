package es.antoniomc.Atriviate.controller;

import java.io.IOException;

import es.antoniomc.Atriviate.App;
import es.antoniomc.Atriviate.model.Usuario;
import es.antoniomc.Atriviate.model.usuarioHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrimaryController {

  @FXML
  protected Label userNameLabel;
  @FXML
  protected Button playButton;
  @FXML
  protected Button createPreguntaButton;
  @FXML
  protected Button editPreguntaButton;
  @FXML
  protected Button deletePreguntaButton;
  @FXML
  protected Button rankingButton;

  @FXML
  public void initialize() {
    usuarioHolder holder = usuarioHolder.getInstance();
    Usuario usuario = holder.getUser();
    this.userNameLabel.setText(usuario.getNombre());
  }
  
  @FXML
  public void createPregunta(ActionEvent event) {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreatePregunta.fxml"));
    Parent modal;
    try {
      modal = fxmlLoader.load();
      Stage modalStage = new Stage();
      modalStage.initModality(Modality.APPLICATION_MODAL);
      modalStage.initOwner(App.rootstage);
      Scene modalScene = new Scene(modal);
      modalStage.setScene(modalScene);
      modalStage.showAndWait();
      modalStage.setResizable(false);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @FXML
  public void editPregunta(ActionEvent event) {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("EditPregunta.fxml"));
    Parent modal;
    try {
      modal = fxmlLoader.load();
      Stage modalStage = new Stage();
      modalStage.initModality(Modality.APPLICATION_MODAL);
      modalStage.initOwner(App.rootstage);
      Scene modalScene = new Scene(modal);
      modalStage.setScene(modalScene);
      modalStage.showAndWait();
      modalStage.setResizable(false);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @FXML
  public void deletePregunta(ActionEvent event) {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("DeletePregunta.fxml"));
    Parent modal;
    try {
      modal = fxmlLoader.load();
      Stage modalStage = new Stage();
      modalStage.initModality(Modality.APPLICATION_MODAL);
      modalStage.initOwner(App.rootstage);
      Scene modalScene = new Scene(modal);
      modalStage.setScene(modalScene);
      modalStage.showAndWait();
      modalStage.setResizable(false);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @FXML
  public void ranking(ActionEvent event) {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Ranking.fxml"));
    Parent modal;
    try {
      modal = fxmlLoader.load();
      Stage modalStage = new Stage();
      modalStage.initModality(Modality.APPLICATION_MODAL);
      modalStage.initOwner(App.rootstage);
      Scene modalScene = new Scene(modal);
      modalStage.setScene(modalScene);
      modalStage.showAndWait();
      modalStage.setResizable(false);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  
}
