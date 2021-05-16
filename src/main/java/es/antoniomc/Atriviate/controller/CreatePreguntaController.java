package es.antoniomc.Atriviate.controller;

import es.antoniomc.Atriviate.model.PreguntaDAO;
import es.antoniomc.Atriviate.model.Respuesta;
import es.antoniomc.Atriviate.utils.doQuery;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class CreatePreguntaController {

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
  private Button createPreguntaButton;
  @FXML
  private Button closeButton;

  @FXML
  public void initialize() {
  }
  
  /**
   * Método que gestiona la creación de una pregunta, comprobando que los campos estén rellenos y haciendo un insert en la base 
   * de datos tanto de la pregunta como de sus correspondientes respuestas.
   * 
   * @param event
   */
  @FXML
  public void createPregunta(Event event) {
    if(checkFields()) {
      PreguntaDAO pregunta = new PreguntaDAO(this.txtPreguntaCategoria.getText(),this.txtPreguntaTexto.getText());
      
      pregunta.setId(doQuery.getIdAutoIncrement());
      Respuesta respuesta1 = new Respuesta(pregunta,this.txtRespuestaTexto1.getText(),this.checkRespuesta1.isSelected());
      Respuesta respuesta2 = new Respuesta(pregunta,this.txtRespuestaTexto2.getText(),this.checkRespuesta2.isSelected());
      Respuesta respuesta3 = new Respuesta(pregunta,this.txtRespuestaTexto3.getText(),this.checkRespuesta3.isSelected());
      Respuesta respuesta4 = new Respuesta(pregunta,this.txtRespuestaTexto4.getText(),this.checkRespuesta4.isSelected());
      
      pregunta.addRespuesta(respuesta1);
      pregunta.addRespuesta(respuesta2);
      pregunta.addRespuesta(respuesta3);
      pregunta.addRespuesta(respuesta4);
      
      if(pregunta.save() != 0) {
        showValid("Se ha creado correctamente"); 
        clearFields();
      }else {
        showError("Se ha producido un error en la creación");
      }
    }else {
      showError("¡Error! Has introducido mal algún dato...");
    }
  }

  /**
   * Método para la comprobación del correcto uso de los campos de texto.
   * 
   * @return true si están bien rellenos.
   */
  @FXML
  public boolean checkFields() {
    return (!this.txtPreguntaCategoria.getText().trim().isEmpty() && !this.txtPreguntaTexto.getText().trim().isEmpty()
        && !this.txtRespuestaTexto1.getText().trim().isEmpty() && !this.txtRespuestaTexto2.getText().trim().isEmpty()
        && !this.txtRespuestaTexto3.getText().trim().isEmpty() && !this.txtRespuestaTexto4.getText().trim().isEmpty()
        && checkCheckBox());
  }

  /**
   * Comprueba que las checkbox de las respuestas correctas, estén al menos 1 marcada.
   * 
   * @return boolean true si hay al meno 1 marcada.
   */
  @FXML
  public boolean checkCheckBox() {
    return (this.checkRespuesta1.isSelected() || this.checkRespuesta2.isSelected() || this.checkRespuesta3.isSelected()
        || this.checkRespuesta4.isSelected());
  }
  
  /**
   * Método para mostra ventana de errores
   * 
   * @param text
   */
  @FXML
  public void showError(String text) {
    Alert alert = new Alert(AlertType.ERROR);
    
    alert.setHeaderText(null);
    alert.setTitle("Error");
    alert.setContentText(text);
    alert.showAndWait();
  }
  
  /**
   * Método para mostrar una ventana con información
   * 
   * @param text
   */
  @FXML
  public void showValid(String text) {
    Alert alert = new Alert(AlertType.INFORMATION);
    
    alert.setHeaderText(null);
    alert.setTitle("Éxito");
    alert.setContentText(text);
    alert.showAndWait();
  }
  
  /**
   * Método para limpiar el texto dentro de los diferentes campos.
   */
  @FXML
  public void clearFields() {
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
