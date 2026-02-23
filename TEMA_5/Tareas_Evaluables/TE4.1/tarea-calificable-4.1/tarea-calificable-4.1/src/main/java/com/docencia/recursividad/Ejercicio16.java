package com.docencia.recursividad;

public class Ejercicio16 {
  /**
   * Elimina c
   *
   * @param texto Cadena de texto.
   * @param c     Carácter a eliminar de la cadena.
   * @return Una nueva cadena sin ninguna ocurrencia de c.
  */
  public static String eliminarCaracter(String texto, char c) {
    if(texto.isEmpty()){
      return "";
    }
    char caracter = texto.charAt(0);
    if (caracter == c){

      return eliminarCaracter(texto.substring(1), c);
    }
    return caracter + eliminarCaracter(texto.substring(1), c);
  }
}
