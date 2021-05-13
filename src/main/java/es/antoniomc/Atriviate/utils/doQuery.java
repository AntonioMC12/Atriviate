package es.antoniomc.Atriviate.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class doQuery {

  public static double getIdAutoIncrement() {
    double getIdAutoIncrement = 0;

    Connection con = conexion.getConexion();
    if (con != null) {
      Statement st;
      try {
        st = con.createStatement();
        ResultSet rs = st.executeQuery(consultas.GETIDAUTOINCREMENT.getConsulta());
        while (rs.next()) {
          getIdAutoIncrement = rs.getDouble("AUTO_INCREMENT");
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return getIdAutoIncrement;
  }
}
