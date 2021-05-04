package es.antoniomc.Atriviate.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class encoder {
  
  public static String encrypt(String texto) throws NoSuchAlgorithmException {
    String encrypt = "";
    
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hash = digest.digest(texto.getBytes(StandardCharsets.UTF_8));
    encrypt = new String(hash,StandardCharsets.UTF_8);
    
    return encrypt;
  }

}
