/**
 * @author ErTonix12
 * 
 * Clase que contiene la información de un Usuario
 * Atributos:
 * -id
 * -name
 * -points
 */

package es.antoniomc.Atriviate.interfaces;

public interface IUsuario {

  public void setNombre(String name);

  public void setPuntos(double points);

  public String getNombre();

  public double getPuntos();
  
  public String getPassword();

  /**
   * Método que suma puntos a un usuario previo control de errores
   * 
   * @param points
   */
  public void addPuntos(double points);
}
