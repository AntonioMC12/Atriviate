package es.antoniomc.Atriviate.utils;

import org.mindrot.jbcrypt.BCrypt;

public class encoder {

  public static String encrypt(String texto) {
    return BCrypt.hashpw(texto, BCrypt.gensalt());
  }

  public static boolean matchPass(String plainPassword, String hashedPassword) {
    return BCrypt.checkpw(plainPassword, hashedPassword);
  }
}
