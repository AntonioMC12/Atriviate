package es.antoniomc.Atriviate.model;

import es.antoniomc.Atriviate.interfaces.IRespuestaDAO;

public class RespuestaDAO extends Respuesta implements IRespuestaDAO {

  public RespuestaDAO(double id, Pregunta pregunta, String texto, boolean correcta) {
    super(id, pregunta, texto, correcta);
    // TODO Auto-generated constructor stub
  }

  @Override
  public boolean addRespuesta(Respuesta respuesta) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean deleteRespuesta(double id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean readRespuesta(double id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void save() {
    // TODO Auto-generated method stub
    
  }

}
