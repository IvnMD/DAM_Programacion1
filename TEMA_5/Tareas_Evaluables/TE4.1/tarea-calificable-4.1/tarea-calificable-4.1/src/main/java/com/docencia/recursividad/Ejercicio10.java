package com.docencia.recursividad;

public class Ejercicio10 {
  /**
   * Invierte cadena
   * TODO: Implementar usando recursividad.
   */
  public static String invertirCadena(String texto) {
    if (texto == null) {
      throw new IllegalArgumentException();
    }
    if (texto.isEmpty() || texto.length() == 1){
      return texto;
    }
    char ultimoCaracter = texto.charAt(texto.length()-1);
    String resto = texto.substring(0, texto.length() - 1);
    return ultimoCaracter+ invertirCadena(resto);
  }
}
