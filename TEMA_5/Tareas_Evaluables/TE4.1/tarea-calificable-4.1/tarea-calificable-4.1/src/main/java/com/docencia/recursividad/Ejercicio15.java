package com.docencia.recursividad;

public class Ejercicio15 {
  /**
   * Ocurrencias de c
   */
  public static int contarCaracter(String texto, char c) {
    if (texto.isEmpty()){
      return 0;
    }
    int suma = (texto.charAt(0) == c ? 1 : 0);
    return suma + contarCaracter(texto.substring(1), c);
  }
}
