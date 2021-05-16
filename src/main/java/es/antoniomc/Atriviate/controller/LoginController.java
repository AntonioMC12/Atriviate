package es.antoniomc.Atriviate.controller;

import java.io.IOException;

import es.antoniomc.Atriviate.App;
import es.antoniomc.Atriviate.model.UsuarioDAO;
import es.antoniomc.Atriviate.model.usuarioHolder;
import es.antoniomc.Atriviate.utils.encoder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController {

  @FXML
  private TextField txtUsuarioNombre;
  @FXML
  private PasswordField txtUsuarioPassword;
  @FXML
  private Button LoginButton;
  @FXML
  private Button CreateUserButton;
  @FXML
  private Button closeButton;

  @FXML
  public void initialize() {
  }

  /**
   * Método que comprueba los datos de los usuarios para el correcto logeo en la aplicación
   * haciendo una consulta en la base de datos para comprar que existe y la veracidad de la
   * información introducida.
   * 
   * @param event
   */
  @FXML
  public void Login(ActionEvent event) {

    String nombre = this.txtUsuarioNombre.getText();
    String pass = this.txtUsuarioPassword.getText();
    usuarioHolder holder = usuarioHolder.getInstance();

    if (checkFields(nombre, pass)) {
      UsuarioDAO usuario = new UsuarioDAO(nombre);
      holder.setUser(usuario);
      
      try {
        App.setRoot("primary");
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else {
      showError("Has introducido mal algún dato");
    }
  }

  /**
   * Método que se encarga de la creación de un usuario con la
   * información introducida, comprobando que no esté previamente
   * insertado en la base de datos.
   * 
   * @param event
   */
  @FXML
  public void createUser(ActionEvent event) {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreateUser.fxml"));
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
  
  /**
   * Método que comprueba que los datos del usuario que se va a logear 
   * estén bien introducidos y se encuentren en la base de datos y en tal caso
   * comprobar la contraseña del mismo.
   * 
   * @param nombre Nombre del usuario a logear
   * @param pass   Contraseña del usuario a logear encriptada
   * @return       True si el logea se ha realizado correctamente.
   */
  @FXML
  public boolean checkFields(String nombre, String pass) {
    boolean check = false;

    if (!this.txtUsuarioNombre.getText().trim().isEmpty() && !this.txtUsuarioPassword.getText().trim().isEmpty()) {
      UsuarioDAO usuario = new UsuarioDAO(nombre);
      if (usuario != null && usuario.getPassword() != null && usuario.getId() != -1) {
        check = encoder.matchPass(pass, usuario.getPassword());
      }
    }
    return check;
  }

  @FXML
  public void showError(String text) {
    Alert alert = new Alert(AlertType.ERROR);
    this.txtUsuarioNombre.clear();
    this.txtUsuarioPassword.clear();
    alert.setHeaderText(null);
    alert.setTitle("Error");
    alert.setContentText(text);
    alert.showAndWait();
  }
  
  @FXML
  private void close(ActionEvent event){
    Stage stage = (Stage) closeButton.getScene().getWindow();
    stage.close();
  }

}
