package es.antoniomc.Atriviate.utils;

public enum consultas {
  USUARIOGETBYNOMBRE("SELECT id,nombre,password,puntos FROM Usuario WHERE nombre="),
  USUARIOINSERTUPDATE(
      "INSERT INTO Usuario (nombre, password, puntos)" + "VALUES (?,?,?)" + "ON DUPLICATE KEY UPDATE puntos=?"),
  USUARIOSELECTNOMBRE("SELECT nombre FROM Usuario");

  private String consulta;

  consultas(String consulta) {
    this.consulta = consulta;
  }

  public String getConsulta() {
    return this.consulta;
  }
}
