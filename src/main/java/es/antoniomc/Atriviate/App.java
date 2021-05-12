package es.antoniomc.Atriviate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import es.antoniomc.Atriviate.model.PreguntaDAO;
import es.antoniomc.Atriviate.model.RespuestaDAO;



/**
 * JavaFX App
 */
public class App extends Application {

  private static Scene scene;
  public static Stage rootstage;

  @Override
  public void start(Stage stage) throws IOException {
    scene = new Scene(loadFXML("Login"), 640, 480);
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
    //launch();
    // la contraseña de paco es 1234abc   
    // la contraseña de test es test
    /*
     * ##PRUEBA USUARIODAO
    UsuarioDAO test1 = new UsuarioDAO("Yisus","1234abc",0);
    if(test1.save()!=-1) {
      System.out.println("Guardado correcto!");
    }
    
    
    Usuario test = new UsuarioDAO("Yisus");
    if(encoder.matchPass("1234abc", test.getPassword())) {
      System.out.println("La contraseña coincide!");
    }else {
      System.out.println("No coincide");
    }
    */
    
    //PreguntaDAO test1 = new PreguntaDAO(1);
    //System.out.println(PreguntaDAO.getPreguntas().toString());
    //PreguntaDAO test = new PreguntaDAO("test",null,"prueba guardar");
    //test.save();
    //RespuestaDAO test = new RespuestaDAO(1);
    //System.out.println(test);
    
    PreguntaDAO testP = new PreguntaDAO(4);
    System.out.println(testP);
    RespuestaDAO testR = new RespuestaDAO(testP,"test de respuesta",false);
    System.out.println(testR);
    testR.save();
    System.out.println(RespuestaDAO.getRespuestasByPregunta(4).toString());
    
    
  }
}