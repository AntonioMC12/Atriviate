package es.antoniomc.Atriviate.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class conexion {

  private static Connection con;
  // Esto debe ir en un XML
  private final static String SERVER = xmlReader.getConectionInfo("server");
  private final static String DATABASE = xmlReader.getConectionInfo("database");
  private final static String USERNAME = xmlReader.getConectionInfo("user");
  private final static String PASSWORD = xmlReader.getConectionInfo("password");

  public static void conecta() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(SERVER + "/" + DATABASE, USERNAME, PASSWORD);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      con = null;
      e.printStackTrace();
    }
  }

  public static Connection getConexion() {
    if (con == null) {
      conecta();
    }
    return con;
  }

  public static List<String[]> ejecutaSelect(String query) {
    List<String[]> resultado = new ArrayList<>();
    getConexion();
    try {
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);
      ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
      int ncolumns = rsmd.getColumnCount();
      while (rs.next()) {
        String[] fila = new String[ncolumns];
        int i = 1;
        while (i <= ncolumns) {
          fila[i - 1] = rs.getString(i);
          i++;
        }
        resultado.add(fila);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return resultado;
  }

}