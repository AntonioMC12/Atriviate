package es.antoniomc.Atriviate.interfaces;

public interface IRespuesta {

  public void setCorrecta(boolean correcta);

  public void setTexto(String question);

  public void setPregunta(IPregunta pregunta);

  public IPregunta getPregunta();

  public double getId();

  public String getTexto();

  public boolean getCorrecta();

}
