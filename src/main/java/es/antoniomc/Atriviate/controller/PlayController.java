package es.antoniomc.Atriviate.controller;

import java.util.List;

import es.antoniomc.Atriviate.model.Pregunta;
import es.antoniomc.Atriviate.model.PreguntaDAO;
import es.antoniomc.Atriviate.model.Usuario;
import es.antoniomc.Atriviate.model.UsuarioDAO;
import es.antoniomc.Atriviate.model.usuarioHolder;
import es.antoniomc.Atriviate.utils.AudioFilePlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PlayController {

  @FXML
  private TextArea txtPreguntaTexto;
  @FXML
  private Button Respuesta1Button;
  @FXML
  private Button Respuesta2Button;
  @FXML
  private Button Respuesta3Button;
  @FXML
  private Button Respuesta4Button;
  @FXML
  private Button exitButton;
  @FXML
  private Label LVidas;
  @FXML
  private Label LPuntos;

  private int VIDAS = 5;
  private List<Pregunta> preguntas;
  private int index;
  private Usuario usuario;
  AudioFilePlayer audio;

  @FXML
  public void initialize() {
    audio = new AudioFilePlayer();
    audio.start();

    usuarioHolder holder = usuarioHolder.getInstance();
    usuario = holder.getUser();
    preguntas = PreguntaDAO.getPreguntas();

    LVidas.setText(String.valueOf(this.VIDAS));
    LPuntos.setText(String.valueOf(usuario.getPuntos()));

    this.txtPreguntaTexto.setEditable(false);
    cargaPregunta();
  }

  /**
   * Método que carga la información de la pregunta en los 
   * diferentes campos de texto de la vista.
   */
  @FXML
  public void cargaPregunta() {

    if (this.VIDAS > 0) {

      index = (int) Math.floor(Math.random() * preguntas.size());
      LVidas.setText(String.valueOf(this.VIDAS));
      LPuntos.setText(String.valueOf(usuario.getPuntos()));

      this.txtPreguntaTexto.setText(preguntas.get(index).getTexto());
      this.Respuesta1Button.setText(preguntas.get(index).getRespuestas().get(0).getTexto());
      this.Respuesta2Button.setText(preguntas.get(index).getRespuestas().get(1).getTexto());
      this.Respuesta3Button.setText(preguntas.get(index).getRespuestas().get(2).getTexto());
      this.Respuesta4Button.setText(preguntas.get(index).getRespuestas().get(3).getTexto());

    }else {
      showValid("¡SE HA QUEDADO SIN VIDAS! VUELVA A INTENTARLO");
      close(null);
    }
  }
  
  /**
   * Método que comprueba la respuesta de una pregunta
   * @param event
   */
  @FXML
  public void checkButton1(ActionEvent event) {
    if (preguntas.get(index).getRespuestas().get(0).isCorrecta()) {
      usuario.addPuntos(1);
      showValid("¡Respuesta Correcta!");
      cargaPregunta();
    } else {
      this.VIDAS--;
      LVidas.setText(String.valueOf(this.VIDAS));
      showValid("¡Respuesta Incorrecta!");
      cargaPregunta();
    }
  }

  @FXML
  public void checkButton2(ActionEvent event) {
    if (preguntas.get(index).getRespuestas().get(1).isCorrecta()) {
      usuario.addPuntos(1);
      showValid("¡Respuesta Correcta!");
      cargaPregunta();
    } else {
      this.VIDAS--;
      LVidas.setText(String.valueOf(this.VIDAS));
      showValid("¡Respuesta Incorrecta!");
      cargaPregunta();
    }
  }

  @FXML
  public void checkButton3(ActionEvent event) {
    if (preguntas.get(index).getRespuestas().get(2).isCorrecta()) {
      usuario.addPuntos(1);
      showValid("¡Respuesta Correcta!");
      cargaPregunta();
    } else {
      this.VIDAS--;
      LVidas.setText(String.valueOf(this.VIDAS));
      showValid("¡Respuesta Incorrecta!");
      cargaPregunta();
    }
  }

  @FXML
  public void checkButton4(ActionEvent event) {
    if (preguntas.get(index).getRespuestas().get(3).isCorrecta()) {
      usuario.addPuntos(1);
      showValid("¡Respuesta Correcta!");
      cargaPregunta();
    } else {
      this.VIDAS--;
      LVidas.setText(String.valueOf(this.VIDAS));
      showValid("¡Respuesta Incorrecta!");
      cargaPregunta();
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
    alert.setTitle("Información");
    alert.setContentText(text);
    alert.showAndWait();
  }

  @SuppressWarnings("deprecation")
  @FXML
  private void close(ActionEvent event) {
    Stage stage = (Stage) exitButton.getScene().getWindow();
    stage.close();
    UsuarioDAO udao = new UsuarioDAO(usuario);
    udao.save();
    audio.stop();
  }

}
