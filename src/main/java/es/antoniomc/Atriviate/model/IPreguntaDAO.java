/**
 * @author ErTonix12
 * 
 * Clase que guarda las preguntas en una lista de preguntas
 * La clase sigue el patrón singleton 
 */

package es.antoniomc.Atriviate.model;

import java.util.List;

public interface IPreguntaDAO  extends IPregunta{
  
  public void setListaPreguntas(List<IPregunta> lista);
  
  /**
   * Método que devuelve la única instancia de la clase o si no existe, crea la instancia
   * 
   * @return instancia de la clase
   */
  
  /**
   * Método que devuelve true si la pregunta se ha insertado en la lista correctamente
   * 
   * @param question
   * @return booelan
   */
  public boolean addQuestion(IPregunta question);
  
  /**
   * Método que devuelve true si la pregunta se ha eliminado de la lista correctamente
   * 
   * @param posicion de la pregunta en la lista
   * @return booelan
   */
  public boolean deleteQuestion(int position);
  
  /**
   * Método que devuelve la posicion de la pregunta en el array si la encuentra
   * 
   * @param question que será utilizado como expresion regular para buscar en las preguntas
   * @return posicion de la pregunta, -1 si no la encuentra.
   */
  public int searchQuestion(String question);
  
  /**
   * Método que filtra las preguntas por categoría y las devuelve en una lista de preguntas.
   * 
   * @param category
   * @return lista de preguntas.
   */
  public List<IPregunta> getQuestionsByCategory(String category);
  
  public void save();
  public void load();
}
