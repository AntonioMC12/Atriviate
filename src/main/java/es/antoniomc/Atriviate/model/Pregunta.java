package es.antoniomc.Atriviate.model;

import java.util.List;

import es.antoniomc.Atriviate.interfaces.IPregunta;

public class Pregunta implements IPregunta {

  private double id;
  private String categoria;
  protected List<Respuesta> respuestas;
  private String texto;

  public Pregunta(double id, String categoria, List<Respuesta> respuestas, String texto) {
    super();
    this.id = id;
    this.categoria = categoria;
    this.respuestas = respuestas;
    this.texto = texto;
  }
  
  public Pregunta(String categoria, List<Respuesta> respuestas, String texto) {
    this(-1,categoria,respuestas,texto);
  }
  
  public Pregunta(double id) {
    this(id,"",null,"");
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public List<Respuesta> getRespuestas() {
    return respuestas;
  }

  public void setRespuestas(List<Respuesta> respuestas) {
    this.respuestas = respuestas;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  @Override
  public double getId() {
    return this.id;
  }

  @Override
  public boolean addRespuesta(Respuesta respuesta) {
    boolean addRespuesta = false;
    if (this.respuestas.add(respuesta)) {
      addRespuesta = true;
    }
    return addRespuesta;
  }

  @Override
  public boolean deleteRespuesta(double id) {
    boolean deleteRespuesta = false;

    Respuesta dummy = new Respuesta(id);
    if (this.respuestas.contains(dummy)) {
      this.respuestas.remove(dummy);
      deleteRespuesta = true;
    }

    return deleteRespuesta;
  }

  @Override
  public String toString() {
    return "Pregunta [id=" + id + ", categoria=" + categoria + ", respuestas=" + respuestas + ", texto=" + texto + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!getClass().isInstance(obj.getClass()))
      return false;
    Pregunta other = (Pregunta) obj;
    if (Double.doubleToLongBits(id) != Double.doubleToLongBits(other.id))
      return false;
    return true;
  }

}
