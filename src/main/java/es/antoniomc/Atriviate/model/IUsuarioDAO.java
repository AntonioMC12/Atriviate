/**
 * @author ErTonix12
 * 
 * Clase que guarda los usuarios
 * La clase sigue el patrón singleton
 */
package es.antoniomc.Atriviate.model;

public interface IUsuarioDAO extends IUsuario {
  
  /**
   * Método que devuelve true si ha borrado con éxito a un usuario 
   * de la lista de usuarios del repositorio. Pasando como parámetro 
   * la posicion en la que se encuentra en la lista.
   * 
   * @param id
   * @return boolean
   */
  public boolean deleteUser(double position);
  
  /**
   * Método que devuelve la posición de un usuario en la lista si lo encuentra, 
   * en caso contrario devuelve -1. Se pasa como parámetro el nombre del usuario.
   * 
   * @param name
   * @return la posicion en la lista y -1 si no está.
   */
  public double searchUser(String name);
  
  /**
   * Método que suma puntos a un usuario previo control de errores
   * 
   * @param points
   */
  public void addPoints(double points);
  
  /**
   * Método para guardar en la base de datos
   * @return
   */
  public int save();
  
  
}
