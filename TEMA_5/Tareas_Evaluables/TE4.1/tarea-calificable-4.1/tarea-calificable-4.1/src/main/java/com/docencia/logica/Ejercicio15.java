package com.docencia.logica;

public class Ejercicio15 {
  /**
   * Ocurrencias de c
   * Implementar usando lógica tradicional (iterativo).
   */
  public static int contarCaracter(String texto, char c) {
    if (texto == null){
      throw new IllegalArgumentException();
    }
    int contador = 0;
    for (char caracter : texto.toCharArray()) {
      if (caracter == c){
        contador++;
      }
    }
    return contador;
  }
}
