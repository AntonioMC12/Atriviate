package es.antoniomc.Atriviate.utils;

public enum consultas {

  USUARIOGETBYNOMBRE("SELECT id,nombre,password,puntos FROM Usuario WHERE nombre="),
  
  USUARIOINSERTUPDATE("INSERT INTO Usuario (nombre, password, puntos)" + "VALUES (?,?,?)" + "ON DUPLICATE KEY UPDATE puntos=?"),
  
  USUARIOSELECTNOMBRE("SELECT nombre FROM Usuario"),
  
  USUARIOSELECTALL("SELECT id,nombre,password,puntos FROM Usuario"),
  
  PREGUNTAGETBYID("SELECT id, categoria, texto FROM Pregunta WHERE id = "),
  
  PREGUNTADELETE("DELETE FROM Pregunta WHERE id ="),
  
  PREGUNTASELECTALL("SELECT id, categoria, texto FROM Pregunta"),
  
  PREGUNTAINSERTUPDATE("INSERT INTO Pregunta (categoria, texto) VALUES (?,?)"),

  PREGUNTAUPDATE("UPDATE Pregunta SET id=?,categoria=?,texto=? WHERE id=?"),
  
  RESPUESTAGETBYID("SELECT id, texto, correcta, id_pregunta as pregunta FROM Respuesta WHERE id = "),
  
  RESPUESTAGETBYPREGUNTA("SELECT r.id, r.texto, r.correcta, r.id_pregunta, p.id, p.categoria, p.texto FROM Respuesta r, Pregunta p WHERE r.id_pregunta = p.id AND r.id_pregunta =?"),
  
  RESPUESTADELETE("DELETE FROM Respuesta WHERE id ="),
  
  RESPUESTAINSERTUPDATE("INSERT INTO Respuesta (texto,correcta,id_pregunta) VALUES (?,?,?) ON DUPLICATE KEY UPDATE texto=?,correcta=?,id_pregunta=?"),
  
  GETIDAUTOINCREMENT("SELECT `AUTO_INCREMENT` "
      + "FROM  INFORMATION_SCHEMA.TABLES "
      + "WHERE TABLE_SCHEMA = 'Atriviate' "
      + "AND   TABLE_NAME   = 'Pregunta'");
  
  
  private String consulta;

  consultas(String consulta) {
    this.consulta = consulta;
  }

  public String getConsulta() {
    return this.consulta;
  }
}
