package es.antoniomc.Atriviate.controller;

import es.antoniomc.Atriviate.model.Usuario;
import es.antoniomc.Atriviate.model.usuarioHolder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
}
