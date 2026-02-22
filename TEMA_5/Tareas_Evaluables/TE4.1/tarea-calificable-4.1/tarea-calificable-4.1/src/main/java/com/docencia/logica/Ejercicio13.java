package com.docencia.logica;

public class Ejercicio13 {
  /**
   * Índice o -1
   * Implementar usando lógica tradicional (iterativo).
   */
  public static int buscarLineal(int[] arreglo, int objetivo) {
    if (arreglo == null){
      throw  new IllegalArgumentException();
    }
    for (int i = 0; i < arreglo.length; i++) {
      if (arreglo[i] == objetivo){
        return i;
      }
    }
    return -1;
  }
}
