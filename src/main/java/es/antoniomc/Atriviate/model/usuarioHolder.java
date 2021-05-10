package es.antoniomc.Atriviate.model;

public class usuarioHolder {

  private Usuario usuario;
  private final static usuarioHolder INSTANCE = new usuarioHolder();

  private usuarioHolder() {
  }

  public static usuarioHolder getInstance() {
    return INSTANCE;
  }

  public void setUser(Usuario u) {
    this.usuario = u;
  }

  public Usuario getUser() {
    return this.usuario;

  }
}
