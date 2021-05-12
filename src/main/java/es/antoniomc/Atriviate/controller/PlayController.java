package es.antoniomc.Atriviate.controller;

import java.util.List;

import es.antoniomc.Atriviate.model.Pregunta;
import es.antoniomc.Atriviate.model.PreguntaDAO;
import es.antoniomc.Atriviate.model.Usuario;
import es.antoniomc.Atriviate.model.usuarioHolder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

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
  public void initialize() {
    usuarioHolder holder = usuarioHolder.getInstance();
    Usuario usuario = holder.getUser();
    List<Pregunta> preguntas = PreguntaDAO.getPreguntas();
  }

}
