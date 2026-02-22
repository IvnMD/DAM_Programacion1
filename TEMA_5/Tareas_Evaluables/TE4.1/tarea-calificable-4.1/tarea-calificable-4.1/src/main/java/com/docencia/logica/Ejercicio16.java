package com.docencia.logica;

public class Ejercicio16 {
  /**
   * Elimina c
   * Implementar usando lógica tradicional (iterativo).
   */
  public static String eliminarCaracter(String texto, char c) {
    if (texto == null){
      throw new IllegalArgumentException();
    }
    if (texto.isEmpty()){
      return texto;
    }
    String resultado = "";
    for (char caracter : texto.toCharArray()) {
      if (caracter != c){
        resultado +=caracter;
      }
    }
    return resultado;
  }
}
