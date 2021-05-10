package es.antoniomc.Atriviate.model;

import java.util.List;

import es.antoniomc.Atriviate.interfaces.IPregunta;
import es.antoniomc.Atriviate.interfaces.IPreguntaDAO;

public class PreguntaDAO extends Pregunta implements IPreguntaDAO {

  public PreguntaDAO(String categoria, List<Respuesta> respuestas, String texto) {
    super(categoria, respuestas, texto);
  }
  
  public PreguntaDAO(double id) {
    super(id,"",null,"");
  }
  
  public PreguntaDAO(Pregunta pregunta) {
    this.respuestas = pregunta.respuestas;
    this.id = pregunta.id;
    this.categoria = pregunta.categoria;
    this.texto = pregunta.texto;
  }

  @Override
  public boolean addPregunta(IPregunta question) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean deletePregunta(int position) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public List<Pregunta> getPreguntas() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Pregunta> getPreguntasByCategory(String category) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void save() {
    // TODO Auto-generated method stub
    
  }

}
