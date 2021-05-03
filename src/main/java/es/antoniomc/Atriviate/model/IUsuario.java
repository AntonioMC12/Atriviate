/**
 * @author ErTonix12
 * 
 * Clase que contiene la información de un Usuario
 * Atributos:
 * -id
 * -name
 * -points
 */

package es.antoniomc.Atriviate.model;

public interface IUsuario {
  
  public void setId(double id);
  public void setName(String name);
  public void setPoints(double points);
  public double getId();
  public String getName();
  public double getPoints();
}
