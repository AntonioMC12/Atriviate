package es.antoniomc.Atriviate.utils;

public enum consultas {

  USUARIOGETBYNOMBRE("SELECT id,nombre,password,puntos FROM Usuario WHERE nombre="),
  
  USUARIOINSERTUPDATE("INSERT INTO Usuario (nombre, password, puntos)" + "VALUES (?,?,?)" + "ON DUPLICATE KEY UPDATE puntos=?"),
  
  USUARIOSELECTNOMBRE("SELECT nombre FROM Usuario"),
  
  PREGUNTAGETBYID("SELECT id, categoria, texto FROM Pregunta WHERE ID = "),
  
  PREGUNTADELETE("DELETE FROM Pregunta WHERE ID ="),
  
  PREGUNTASELECTALL("SELECT id, categoria, texto FROM Pregunta"),
  
  PREGUNTAINSERTUPDATE("INSERT INTO Pregunta (categoria, texto)" + "VALUES (?,?)" + "ON DUPLICATE KEY UPDATE categoria=?, texto=?");

  private String consulta;

  consultas(String consulta) {
    this.consulta = consulta;
  }

  public String getConsulta() {
    return this.consulta;
  }
}
