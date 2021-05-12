package es.antoniomc.Atriviate.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import es.antoniomc.Atriviate.model.Usuario;
import es.antoniomc.Atriviate.model.UsuarioDAO;

public class RankingController {
  
  @FXML
  private Button closeButton;
  @FXML
  private TableView<Usuario> tableUsuario;
  @FXML
  private TableColumn<Usuario, String> tableColumnNombreUsuario;
  @FXML
  private TableColumn<Usuario, String> tableColumnPuntosUsuario;
  
  @FXML
  public void initialize() {
    ObservableList<Usuario> usuarios = FXCollections.observableArrayList(UsuarioDAO.getUsuarios());
    this.tableUsuario.setItems(usuarios);
    this.tableColumnNombreUsuario.setCellValueFactory(new PropertyValueFactory<Usuario,String>("nombre"));
    this.tableColumnPuntosUsuario.setCellValueFactory(new PropertyValueFactory<Usuario,String>("puntos"));
  }
  
  @FXML
  private void close(ActionEvent event){
    // get a handle to the stage
    Stage stage = (Stage) closeButton.getScene().getWindow();
    // do what you have to do
    stage.close();
  }
}
