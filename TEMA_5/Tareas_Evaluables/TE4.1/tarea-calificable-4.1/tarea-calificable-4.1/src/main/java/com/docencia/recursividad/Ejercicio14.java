package com.docencia.recursividad;

public class Ejercicio14 {
  /**
   * ¿Es palíndromo?
   * 
   *
   * @param texto Cadena de texto a evaluar, no nula.
   * @return true si la cadena es palíndromo, false si no.

   */

  public static boolean esPalindromo(String texto) {
    return palabra(texto, 0, texto.length()-1);
  }

  private static boolean palabra(String texto, int i, int j){
    if ( i >= j){
      return true;
    }
    if (texto.charAt(i) != texto.charAt(j)){
      return false;
    }
    return palabra(texto, i+1, j-1);
  }
}
