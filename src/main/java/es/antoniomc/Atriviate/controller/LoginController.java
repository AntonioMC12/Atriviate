package es.antoniomc.Atriviate.controller;

import java.net.URL;
import java.util.ResourceBundle;

import es.antoniomc.Atriviate.model.UsuarioDAO;
import es.antoniomc.Atriviate.utils.encoder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

  @FXML
  private TextField txtUsuarioNombre;
  @FXML
  private PasswordField txtUsuarioPassword;
  @FXML
  private Button LoginButton;

  @FXML
  public void initialize(URL url, ResourceBundle rb) {
  }

  @FXML
  public void Login(ActionEvent event) {
    Alert alert = new Alert(AlertType.ERROR);

    String nombre = this.txtUsuarioNombre.getText();
    String pass = this.txtUsuarioPassword.getText();

    if (checkFields(nombre, pass)) {
      System.out.println("Check In correcto!");
    } else {
      this.txtUsuarioNombre.clear();
      this.txtUsuarioPassword.clear();
      alert.setHeaderText(null);
      alert.setTitle("Error");
      alert.setContentText("Has introducido mal algun dato");
      alert.showAndWait();
    }

  }

  @FXML
  public boolean checkFields(String nombre, String pass) {
    boolean check = false;

    if (nombre != null && nombre != "" && pass != null && pass != "") {
      UsuarioDAO usuario = new UsuarioDAO(nombre);
      if (usuario != null && usuario.getPassword() != null && usuario.getId() != -1) {
        check = encoder.matchPass(pass, usuario.getPassword());
      }
    }
    return check;
  }
}
