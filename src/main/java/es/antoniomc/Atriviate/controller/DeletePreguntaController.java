package es.antoniomc.Atriviate.controller;

import es.antoniomc.Atriviate.model.Pregunta;
import es.antoniomc.Atriviate.model.PreguntaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DeletePreguntaController {
  @FXML
  private ComboBox<Pregunta> comboPregunta;
  @FXML
  private Button closeButton;
  @FXML
  private Button deleteButton;
  
  @FXML
  public void initialize() {
    ObservableList<Pregunta> preguntas = FXCollections.observableArrayList(PreguntaDAO.getPreguntas());
    this.comboPregunta.setItems(preguntas);
    this.deleteButton.setDisable(true);
  }
  
  /**
   * Método que activa el botón de borrar una vez seleccionada la pregunta deseada.
   */
  @FXML
  public void comboSelect() {
    this.deleteButton.setDisable(false);
  }
  
  /**
   * Método para el correcto borrado de las preguntas, obteniendola de un combobox.
   * 
   * @param event
   */
  @FXML
  public void deletePregunta(ActionEvent event) {
    if(this.comboPregunta.getValue()!=null) {
      PreguntaDAO dummy = new PreguntaDAO(this.comboPregunta.getValue());
      int rs = dummy.deletePregunta();
      if(rs != 0) {
        showValid("Borrado Correcto");
        }else {
          showError("Se ha producido un error");
        }
    }else {
      showError("Se ha producido un error");
    }
  }
  @FXML
  public void showError(String text) {
    Alert alert = new Alert(AlertType.ERROR);
    
    alert.setHeaderText(null);
    alert.setTitle("Error");
    alert.setContentText(text);
    alert.showAndWait();
  }
  
  @FXML
  public void showValid(String text) {
    Alert alert = new Alert(AlertType.INFORMATION);
    
    alert.setHeaderText(null);
    alert.setTitle("Éxito");
    alert.setContentText(text);
    alert.showAndWait();
  }
  
  @FXML
  private void close(ActionEvent event){
    // get a handle to the stage
    Stage stage = (Stage) closeButton.getScene().getWindow();
    // do what you have to do
    stage.close();
  }
}
