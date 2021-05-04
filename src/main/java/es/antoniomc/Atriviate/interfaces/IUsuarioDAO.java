/**
 * @author ErTonix12
 * 
 * Clase que guarda los usuarios
 * La clase sigue el patrón singleton
 */
package es.antoniomc.Atriviate.interfaces;

public interface IUsuarioDAO {
  
  /**
   * Método que devuelve true si ha borrado con éxito a un usuario 
   * de la lista de usuarios del repositorio. Pasando como parámetro 
   * la posicion en la que se encuentra en la lista.
   * 
   * @param nombre del usuario
   * @return boolean
   */
  public boolean deleteUsuario(String name);
  
  /**
   * Método que devuelve un usuario en la lista si lo encuentra, 
   * 
   * @param name
   * @return El usuario
   */
  public IUsuario getUsuario(String name);
  
  /**
   * Método para guardar en la base de datos
   * @return
   */
  public int save();
  
  
}
