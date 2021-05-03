/**
 * @author ErTonix12
 * 
 * Clase que contiene los parámetros que debe tener una pregunta
 * para el clásico juego del trivial.
 * Cuyos atributos son:
 * -category
 * -id
 * -wronAnswer
 * -rightAnswer
 * -question
 */

package es.antoniomc.Atriviate.model;

import java.util.List;

public interface IPregunta {
  
  public void setCategory(String category);
  public void setId(double id);
  public void setWrongAnswer(List<String> list);
  public void setRigthAnswer(String answer);
  public void setQuestion(String question);
  public String getCategory();
  public double getId();
  public List<String> getWrongAnswer();
  public String getRigthAnswer();
  public String getQuestion();
  
  /**
   * Método que devuelve true si se añade correctamente una pregunta
   * pasada por parámetro.
   * 
   * @param answer
   * @return boolean
   */
  public boolean addWrongAnswer(String answer);
  
  /**
   * Método que devuelve true si consige borrarse una pregunta de la lista
   * pasandose como parámetro la posición de la pregunta a borrar.
   * 
   * @param position
   * @return boolean
   */
  public boolean deleteWrongAnswer(int position);
  
  /**
   * Se busca con expresiones regulares en la lista de preguntas y devuelve
   * la posición de la primera coincidencia
   * 
   * @param text
   * @return posición de la primera coincidencia.
   */
  public int searchWrongAnswer(String text);
  
}
