package es.antoniomc.Atriviate.controller;

import java.util.List;

import es.antoniomc.Atriviate.model.Pregunta;
import es.antoniomc.Atriviate.model.PreguntaDAO;
import es.antoniomc.Atriviate.model.Respuesta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class EditPreguntaController {
  
  @FXML
  private TextField txtPreguntaCategoria;
  @FXML
  private TextField txtPreguntaTexto;
  @FXML
  private TextField txtRespuestaTexto1;
  @FXML
  private TextField txtRespuestaTexto2;
  @FXML
  private TextField txtRespuestaTexto3;
  @FXML
  private TextField txtRespuestaTexto4;
  @FXML
  private CheckBox checkRespuesta1;
  @FXML
  private CheckBox checkRespuesta2;
  @FXML
  private CheckBox checkRespuesta3;
  @FXML
  private CheckBox checkRespuesta4;
  @FXML
  private ComboBox<Pregunta> comboPregunta;
  @FXML
  private Button closeButton;
  @FXML
  private Button saveButton;
  
  
  @FXML
  public void initialize() {
    ObservableList<Pregunta> preguntas = FXCollections.observableArrayList(PreguntaDAO.getPreguntas());
    this.comboPregunta.setItems(preguntas);
    this.saveButton.setDisable(true);
  }
  
  /**
   * Método que rellena los campos de texto con la información de la pregunta seleccionada en el ComboBox.
   */
  @FXML
  public void comboSelect() {
    this.saveButton.setDisable(false);
    Pregunta dummy = comboPregunta.getValue();
    List<Respuesta> dummyrespuestas = dummy.getRespuestas();
    
    this.txtPreguntaCategoria.setText(dummy.getCategoria());
    this.txtPreguntaTexto.setText(dummy.getTexto());
    this.txtRespuestaTexto1.setText(dummyrespuestas.get(0).getTexto());
    this.txtRespuestaTexto2.setText(dummyrespuestas.get(1).getTexto());
    this.txtRespuestaTexto3.setText(dummyrespuestas.get(2).getTexto());
    this.txtRespuestaTexto4.setText(dummyrespuestas.get(3).getTexto());
    this.checkRespuesta1.setSelected(dummyrespuestas.get(0).isCorrecta());
    this.checkRespuesta2.setSelected(dummyrespuestas.get(1).isCorrecta());
    this.checkRespuesta3.setSelected(dummyrespuestas.get(2).isCorrecta());
    this.checkRespuesta4.setSelected(dummyrespuestas.get(3).isCorrecta());
  }
  
  /**
   * Método que se encarga de que la pregunta sea actualizada con la nueva información introducida.
   * @param event
   */
  @FXML
  public void updatePregunta(Event event) {
    if(checkFields()) {
      PreguntaDAO pregunta = new PreguntaDAO(comboPregunta.getValue().getId());
      
      pregunta.setCategoria(txtPreguntaCategoria.getText());
      pregunta.setTexto(txtPreguntaTexto.getText());
      pregunta.deleteRespuestas();
      Respuesta respuesta1 = new Respuesta(pregunta,this.txtRespuestaTexto1.getText(),this.checkRespuesta1.isSelected());
      Respuesta respuesta2 = new Respuesta(pregunta,this.txtRespuestaTexto2.getText(),this.checkRespuesta2.isSelected());
      Respuesta respuesta3 = new Respuesta(pregunta,this.txtRespuestaTexto3.getText(),this.checkRespuesta3.isSelected());
      Respuesta respuesta4 = new Respuesta(pregunta,this.txtRespuestaTexto4.getText(),this.checkRespuesta4.isSelected());
      
      pregunta.addRespuesta(respuesta1);
      pregunta.addRespuesta(respuesta2);
      pregunta.addRespuesta(respuesta3);
      pregunta.addRespuesta(respuesta4);
      
      if(pregunta.update() != 0) {
        showValid("Se ha creado correctamente"); 
        clearFields();
      }else {
        showError("Se ha producido un error en la creación");
      }
    }else {
      showError("¡Error! Has introducido mal algún dato...");
    }
  }

  @FXML
  public boolean checkFields() {
    return (!this.txtPreguntaCategoria.getText().trim().isEmpty() && !this.txtPreguntaTexto.getText().trim().isEmpty()
        && !this.txtRespuestaTexto1.getText().trim().isEmpty() && !this.txtRespuestaTexto2.getText().trim().isEmpty()
        && !this.txtRespuestaTexto3.getText().trim().isEmpty() && !this.txtRespuestaTexto4.getText().trim().isEmpty()
        && checkCheckBox());
  }

  @FXML
  public boolean checkCheckBox() {
    return (this.checkRespuesta1.isSelected() || this.checkRespuesta2.isSelected() || this.checkRespuesta3.isSelected()
        || this.checkRespuesta4.isSelected());
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
  public void clearFields() {
    //this.comboPregunta.getSelectionModel().clearSelection();
    this.txtPreguntaCategoria.clear();
    this.txtPreguntaTexto.clear();
    this.txtRespuestaTexto1.clear();
    this.txtRespuestaTexto2.clear();
    this.txtRespuestaTexto3.clear();
    this.txtRespuestaTexto4.clear();
    this.checkRespuesta1.setSelected(false);
    this.checkRespuesta2.setSelected(false);
    this.checkRespuesta3.setSelected(false);
    this.checkRespuesta4.setSelected(false);
  }
  
  @FXML
  private void close(ActionEvent event){
    // get a handle to the stage
    Stage stage = (Stage) closeButton.getScene().getWindow();
    // do what you have to do
    stage.close();
  }

}
