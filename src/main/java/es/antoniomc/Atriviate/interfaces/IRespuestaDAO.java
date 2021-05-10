package es.antoniomc.Atriviate.interfaces;

import es.antoniomc.Atriviate.model.Respuesta;

public interface IRespuestaDAO {
  /**
   * Método que devuelve true si la respuesta se ha insertado en la lista
   * correctamente
   * 
   * @param respuesta
   * @return booelan
   */
  public boolean addRespuesta(Respuesta respuesta);

  /**
   * Método que devuelve true si la respuesta se ha eliminado de la lista
   * correctamente
   * 
   * @param id de la respuesta
   * @return booelan
   */
  public boolean deleteRespuesta(double id);

  /**
   * Método que devuelve la respuesta y sus atributos 
   * 
   * @param id
   * @return true si se ha ejecutado correctamente
   */
  public boolean readRespuesta(double id);

  /**
   * Método que guarda o actualiza una entrada en la base de datos.
   */
  public void save();
}
