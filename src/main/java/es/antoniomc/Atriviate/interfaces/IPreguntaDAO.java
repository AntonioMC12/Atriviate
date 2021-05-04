/**
 * @author ErTonix12
 * 
 * Clase que guarda las preguntas en una lista de preguntas
 * La clase sigue el patrón singleton 
 */

package es.antoniomc.Atriviate.interfaces;

import java.util.List;

public interface IPreguntaDAO  extends IPregunta{
  
  /**
   * Método que devuelve true si la pregunta se ha insertado en la lista correctamente
   * 
   * @param question
   * @return booelan
   */
  public boolean addPregunta(IPregunta question);
  
  /**
   * Método que devuelve true si la pregunta se ha eliminado de la lista correctamente
   * 
   * @param posicion de la pregunta en la lista
   * @return booelan
   */
  public boolean deletePregunta(int position);
  
  /**
   * Método que devuelve la lista de todas las preguntas
   * 
   * 
   * @return Lista de preguntas
   */
  public List<IPregunta> getPreguntas();
  
  /**
   * Método que filtra las preguntas por categoría y las devuelve en una lista de preguntas.
   * 
   * @param category
   * @return lista de preguntas.
   */
  public List<IPregunta> getPreguntasByCategory(String category);
  
  /**
   * Método que guarda o actualiza una entrada en la base de datos.
   */
  public void save();
}
