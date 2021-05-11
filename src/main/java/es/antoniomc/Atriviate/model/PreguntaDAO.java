package es.antoniomc.Atriviate.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.antoniomc.Atriviate.interfaces.IPreguntaDAO;
import es.antoniomc.Atriviate.utils.conexion;
import es.antoniomc.Atriviate.utils.consultas;

public class PreguntaDAO extends Pregunta implements IPreguntaDAO {

  public PreguntaDAO(String categoria, List<Respuesta> respuestas, String texto) {
    super(categoria, respuestas, texto);
  }

  public PreguntaDAO(Pregunta pregunta) {
    this.respuestas = pregunta.respuestas;
    this.id = pregunta.id;
    this.categoria = pregunta.categoria;
    this.texto = pregunta.texto;
  }

  public PreguntaDAO(double id) {
    super();
    
    Connection con = conexion.getConexion();
    
    if (con != null) {
      try {
        Statement st = con.createStatement();
        String q = consultas.PREGUNTAGETBYID.getConsulta() + "'" + id + "'";
        ResultSet rs = st.executeQuery(q);
        while (rs.next()) {
          this.id = rs.getDouble("id");
          this.categoria = rs.getString("categoria");
          this.texto = rs.getString("texto");
        }
        // setear respuestas
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public int deletePregunta() {

    int rs = 0;
    Connection con = conexion.getConexion();

    if (con != null) {
      try {
        Statement st = con.createStatement();
        String q = consultas.PREGUNTADELETE.getConsulta() + "'" + this.id + "'";
        rs = st.executeUpdate(q);
        this.id = -1;
        this.categoria = "";
        this.texto = "";
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return rs;
  }


  public static List<Pregunta> getPreguntas() {
    
    List<Pregunta> preguntas = new ArrayList<>();
    Connection con = conexion.getConexion();
    
    if (con != null) {
      try {
        Statement st = con.createStatement();
        String q = consultas.PREGUNTASELECTALL.getConsulta();
        ResultSet rs = st.executeQuery(q);
        while (rs.next()) {
          Pregunta dummy = new Pregunta();
          dummy.setId(rs.getDouble("id"));
          dummy.setCategoria(rs.getString("categoria"));
          dummy.setTexto(rs.getString("texto"));
          preguntas.add(dummy);
        }
        // setear respuestas
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return preguntas;
  }

  @Override
  public List<Pregunta> getPreguntasByCategory(String category) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int save() {
    
    int rs=0;
    Connection con = conexion.getConexion();
    
    if (con != null) {
      try {
        PreparedStatement q=con.prepareStatement(consultas.PREGUNTAINSERTUPDATE.getConsulta());
        q.setString(1, this.categoria);
        q.setString(2, this.texto);
        q.setString(3, this.categoria);
        q.setString(4, this.texto);
        rs =q.executeUpdate();
        
        /*
        //Actualizar mis respuestas
        
        //respuesatas en la BBDD
        List<Libro> obrasantiguas=LibroDAO.getLibrosByAutor(this.dni);
        
        //Recorro las actuales para actualizar
        for(Libro l:misobras) {
          l.setMiautor(this);  //<--- IMPORTANTE
          LibroDAO ldao=new LibroDAO(l);
          ldao.guardar();
        }
        //Recorro y busco aquellas que est�n en la
        //BBDD y no en mi lista
        for(Libro l:obrasantiguas) {
          if(misobras.indexOf(l)<0) {
            LibroDAO ldao=new LibroDAO(l);
            ldao.eliminar();
          }
        }
        */
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return rs;

  }

}
