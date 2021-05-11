/**
 * @author ErTonix12
 * 
 * Clase que guarda las preguntas en una lista de preguntas
 * La clase sigue el patrón singleton 
 */

package es.antoniomc.Atriviate.interfaces;

import java.util.List;

import es.antoniomc.Atriviate.model.Pregunta;

public interface IPreguntaDAO  extends IPregunta{
  
  /**
   * Método que devuelve true si la pregunta se ha eliminado de la lista correctamente
   * 
   * @param 
   * @return booelan
   */
  public int deletePregunta();
  
  
  /**
   * Método que devuelve la lista de todas las preguntas
   * 
   * 
   * @return Lista de preguntas
   *
  public List<Pregunta> getPreguntas();
  */
  
  /**
   * Método que filtra las preguntas por categoría y las devuelve en una lista de preguntas.
   * 
   * @param category
   * @return lista de preguntas.
   */
  public List<Pregunta> getPreguntasByCategory(String category);
  
  /**
   * Método que guarda o actualiza una entrada en la base de datos.
   */
  public int save();
}
