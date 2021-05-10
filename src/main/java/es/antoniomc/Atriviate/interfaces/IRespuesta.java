package es.antoniomc.Atriviate.interfaces;

import es.antoniomc.Atriviate.model.Pregunta;

public interface IRespuesta {

  public void setCorrecta(boolean correcta);

  public void setTexto(String question);

  public void setPregunta(Pregunta pregunta);

  public IPregunta getPregunta();

  public double getId();

  public String getTexto();

  public boolean isCorrecta();

}
