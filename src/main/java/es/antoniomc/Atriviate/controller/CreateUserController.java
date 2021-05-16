package es.antoniomc.Atriviate.controller;

import java.io.IOException;
import java.util.List;

import es.antoniomc.Atriviate.App;
import es.antoniomc.Atriviate.model.Usuario;
import es.antoniomc.Atriviate.model.UsuarioDAO;
import es.antoniomc.Atriviate.model.usuarioHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CreateUserController {

  @FXML
  private TextField txtUsuarioNombre;
  @FXML
  private PasswordField txtUsuarioPassword;
  @FXML
  private Button CreateUserButton;

  @FXML
  public void initialize() {
  }

  /**
   * Método que gestiona la correcta insercción de un Usuario en la base de datos.
   * Comprueba que no se repitan tanto el ID como el Nombre, encriptando la contraseña
   * introducida e insertandolo en la base de datos.
   * 
   * @param event
   */
  @FXML
  public void createUser(ActionEvent event) {
    
    Node  source = (Node)  event.getSource(); 
    Stage stage  = (Stage) source.getScene().getWindow();
    
    usuarioHolder holder = usuarioHolder.getInstance();
    String nombre = this.txtUsuarioNombre.getText();
    String password = this.txtUsuarioPassword.getText();

    if (checkFields(nombre, password)) {

      List<String> nombres = UsuarioDAO.getNombres();

      if (!nombres.contains(nombre)) {

        Usuario newuser = new Usuario(nombre, password, 0);
        UsuarioDAO userDAO = new UsuarioDAO(newuser);
        userDAO.save();

        try {
          holder.setUser(new UsuarioDAO(nombre));
          showValid("¡Usuario creado con éxito!");
          App.setRoot("primary");
          stage.close();
          
        } catch (IOException e) {
          e.printStackTrace();
        }
      } else {
        showError("El nombre introducido ya existe");
        this.txtUsuarioNombre.clear();
        this.txtUsuarioPassword.clear();
      }
    } else {
      showError("Has introducido mal algun dato");
      this.txtUsuarioNombre.clear();
      this.txtUsuarioPassword.clear();
    }
  }

  @FXML
  public boolean checkFields(String nombre, String password) {
    return (!this.txtUsuarioNombre.getText().trim().isEmpty() && !this.txtUsuarioPassword.getText().trim().isEmpty());
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
  public void showError(String text) {
    Alert alert = new Alert(AlertType.ERROR);
    
    this.txtUsuarioNombre.clear();
    this.txtUsuarioPassword.clear();
    
    alert.setHeaderText(null);
    alert.setTitle("Error");
    alert.setContentText(text);
    alert.showAndWait();
  }
}
