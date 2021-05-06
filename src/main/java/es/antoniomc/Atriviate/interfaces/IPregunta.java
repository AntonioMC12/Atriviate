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

package es.antoniomc.Atriviate.interfaces;

import java.util.List;

public interface IPregunta {

  public void setCategoria(String category);

  public void setTexto(String question);

  public void setRespuestas(List<IRespuesta> respuestas);

  public String getCategoria();

  public double getId();

  public String getTexto();

  public List<IRespuesta> getRespuestas();

  /**
   * Método que devuelve true si se añade correctamente una pregunta pasada por
   * parámetro.
   * 
   * @param answer
   * @return boolean
   */
  public boolean addRespuesta(IRespuesta respuesta);

  /**
   * Método que devuelve true si consige borrarse una pregunta de la lista
   * pasandose como parámetro la posición de la pregunta a borrar.
   * 
   * @param position
   * @return boolean
   */
  public boolean deleteRespuesta(double id);
}