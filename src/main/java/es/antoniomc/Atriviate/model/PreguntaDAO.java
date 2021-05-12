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

  public PreguntaDAO(String categoria, String texto) {
    super(categoria, texto);
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
        this.respuestas = RespuestaDAO.getRespuestasByPregunta(id);
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
          dummy.setRespuestas(RespuestaDAO.getRespuestasByPregunta(rs.getDouble("id")));
          preguntas.add(dummy);
        }
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

    int rs = 0;
    Connection con = conexion.getConexion();

    if (con != null) {
      try {
        PreparedStatement q = con.prepareStatement(consultas.PREGUNTAINSERTUPDATE.getConsulta());
        q.setString(1, this.categoria);
        q.setString(2, this.texto);
        rs = q.executeUpdate();

        for (Respuesta r : this.respuestas) {
          r.setPregunta(this);
          RespuestaDAO rdao = new RespuestaDAO(r);
          rdao.save();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return rs;
  }
  
  public int update() {
    int rs = 0;
    Connection con = conexion.getConexion();

    if (con != null) {
      try {
        PreparedStatement q = con.prepareStatement(consultas.PREGUNTAUPDATE.getConsulta());
        q.setDouble(1, this.id);
        q.setString(2, this.categoria);
        q.setString(3, this.texto);
        q.setDouble(4, this.id);
        rs = q.executeUpdate();

        List<Respuesta> oldRespuestas = RespuestaDAO.getRespuestasByPregunta(this.id);

        for (Respuesta r : respuestas) {
          r.setPregunta(this);
          RespuestaDAO rdao = new RespuestaDAO(r);
          rdao.save();
        }
        for (Respuesta r : oldRespuestas) {
          if (respuestas.indexOf(r) < 0) {
            RespuestaDAO rdao = new RespuestaDAO(r);
            rdao.deleteRespuesta();
          }
        }

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return rs;
  }

}
