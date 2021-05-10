package es.antoniomc.Atriviate.model;

import es.antoniomc.Atriviate.interfaces.IRespuesta;

public class Respuesta implements IRespuesta{
  
  private double id;
  private Pregunta pregunta;
  private String texto;
  private boolean correcta;
  
  
  
  public Respuesta(double id, Pregunta pregunta, String texto, boolean correcta) {
    super();
    this.id = id;
    this.pregunta = pregunta;
    this.texto = texto;
    this.correcta = correcta;
  }
  
  
  public Respuesta(Pregunta pregunta, String texto, boolean correcta) {
    this(-1, pregunta, texto, correcta);
  }
  
  public Respuesta(double id) {
    this(id,null,"",false);
  }
  
  public Pregunta getPregunta() {
    return pregunta;
  }
  public void setPregunta(Pregunta pregunta) {
    this.pregunta = pregunta;
  }
  public String getTexto() {
    return texto;
  }
  public void setTexto(String texto) {
    this.texto = texto;
  }
  public boolean isCorrecta() {
    return correcta;
  }
  public void setCorrecta(boolean correcta) {
    this.correcta = correcta;
  }
  @Override
  public double getId() {
    return this.id;
  }
  @Override
  public String toString() {
    return "Respuesta [id=" + id + ", pregunta=" + pregunta + ", texto=" + texto + ", correcta=" + correcta + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!getClass().isInstance(obj.getClass()))
      return false;
    Respuesta other = (Respuesta) obj;
    if (Double.doubleToLongBits(id) != Double.doubleToLongBits(other.id))
      return false;
    return true;
  }
  
  
}
