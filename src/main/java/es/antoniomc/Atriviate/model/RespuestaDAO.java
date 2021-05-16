package es.antoniomc.Atriviate.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.antoniomc.Atriviate.interfaces.IRespuestaDAO;
import es.antoniomc.Atriviate.utils.conexion;
import es.antoniomc.Atriviate.utils.consultas;

public class RespuestaDAO extends Respuesta implements IRespuestaDAO {

  public RespuestaDAO(double id, Pregunta pregunta, String texto, boolean correcta) {
    super(id, pregunta, texto, correcta);
    // TODO Auto-generated constructor stub
  }

  public RespuestaDAO(Pregunta pregunta, String texto, boolean correcta) {
    this(-1, pregunta, texto, correcta);
  }

  public RespuestaDAO(String texto, boolean correcta) {
    this(-1, null, texto, correcta);
  }

  public RespuestaDAO() {
    super();
  }

  public RespuestaDAO(Respuesta respuesta) {
    this.id = respuesta.id;
    this.pregunta = respuesta.pregunta;
    this.texto = respuesta.texto;
    this.correcta = respuesta.correcta;
  }

  public RespuestaDAO(double id) {
    super();
    Connection con = conexion.getConexion();
    // Stament
    if (con != null) {
      try {
        Statement st = con.createStatement();
        String q = consultas.RESPUESTAGETBYID.getConsulta() + id;
        ResultSet rs = st.executeQuery(q);
        while (rs.next()) {
          this.id = rs.getInt("id");
          this.texto = rs.getString("texto");
          this.correcta = rs.getBoolean("correcta");

          this.pregunta = new PreguntaDAO(rs.getDouble("pregunta"));
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  /**
   * Método que devuelve una lista de respuestas según la respusta que 
   * le hayamos pasado como parámetro.
   * 
   * @param id de la pregunta
   * @return Lista de respuestas.
   */
  public static List<Respuesta> getRespuestasByPregunta(double id) {
    List<Respuesta> respuestas = new ArrayList<>();

    Connection con = conexion.getConexion();
    if (con != null) {
      try {
        PreparedStatement q = con.prepareStatement(consultas.RESPUESTAGETBYPREGUNTA.getConsulta());
        q.setDouble(1, id);
        ResultSet rs = q.executeQuery();
        while (rs.next()) {
          Respuesta r = new Respuesta();
          r.setId(rs.getDouble("id"));
          r.setTexto(rs.getString("texto"));
          r.setCorrecta(rs.getBoolean("correcta"));

          Pregunta p = new Pregunta();
          p.setId(rs.getDouble("id_pregunta"));
          p.setCategoria(rs.getString("categoria"));
          p.setTexto(rs.getString("texto"));

          r.setPregunta(p);
          respuestas.add(r);
        }

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return respuestas;
  }

  /**
   * Método para borrar una respuesta de la base de datos
   */
  @Override
  public int deleteRespuesta() {
    int deleteRespuesta = -1;

    Connection con = conexion.getConexion();
    if (con != null) {
      try {
        Statement st = con.createStatement();
        String q = consultas.RESPUESTADELETE.getConsulta() + this.id;
        deleteRespuesta = st.executeUpdate(q);
        this.id = -1;
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }

    return deleteRespuesta;
  }

  /**
   * Método para guardas las respuestas en la base de datos.
   */
  @Override
  public int save() {
    int save = -1;
    
    Connection con = conexion.getConexion();
    if(this.pregunta == null) {
      this.pregunta = new Pregunta();
    }
    if(con != null) {
      try {
        PreparedStatement q = con.prepareStatement(consultas.RESPUESTAINSERTUPDATE.getConsulta());
        q.setString(1, this.texto);
        q.setBoolean(2, this.correcta);
        q.setDouble(3, this.pregunta!=null?this.pregunta.id:0);
        q.setString(4, this.texto);
        q.setBoolean(5, this.correcta);
        q.setDouble(6, this.pregunta!=null?this.pregunta.id:0);
        save = q.executeUpdate();
        
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return save;
  }

}
