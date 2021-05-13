package es.antoniomc.Atriviate.model;

import es.antoniomc.Atriviate.interfaces.IUsuario;

public class Usuario implements IUsuario {

  protected double id;
  protected String nombre;
  protected double puntos;
  protected String password;

  public Usuario(double id, String nombre, String password, double puntos) {
    super();
    this.id = id;
    this.nombre = nombre;
    this.password = password;
    this.puntos = puntos;
  }

  public Usuario(String nombre, String password, double puntos) {
    this(-1, nombre, password, puntos);
  }

  public Usuario(String nombre) {
    this(-1, nombre, "", 0);
  }

  public Usuario() {
    this(-1, "", "", 0);
  }

  public double getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPuntos() {
    return puntos;
  }

  public void setPuntos(double puntos) {
    this.puntos = puntos;
  }

  @Override
  public void addPuntos(double points) {
    this.puntos += points;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Usuario [id=" + id + ", nombre=" + nombre + ", puntos=" + puntos + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!getClass().isInstance(obj))
      return false;
    Usuario other = (Usuario) obj;
    if (Double.doubleToLongBits(id) != Double.doubleToLongBits(other.id))
      return false;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    return true;
  }
}
