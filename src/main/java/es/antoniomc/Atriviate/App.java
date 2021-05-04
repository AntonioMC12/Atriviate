package es.antoniomc.Atriviate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import es.antoniomc.Atriviate.model.Usuario;
import es.antoniomc.Atriviate.model.UsuarioDAO;

import es.antoniomc.Atriviate.utils.encoder;

/**
 * JavaFX App
 */
public class App extends Application {

  private static Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    scene = new Scene(loadFXML("primary"), 640, 480);
    stage.setScene(scene);
    stage.show();
  }

  public static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    return fxmlLoader.load();
  }

  public static void main(String[] args) {
    // launch();
    Usuario test = new UsuarioDAO("Antonio");
    System.out.println(test);
    String password = "abcd1234";
    try {
      String hash = encoder.encrypt(password);
      System.out.println("La contraseña encriptada es:" + "\n" + hash);
      String hash2 = encoder.encrypt(password);
      if(hash.equals(hash2)) {
        System.out.println("La contraseña coincide");
      }
    } catch (NoSuchAlgorithmException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}