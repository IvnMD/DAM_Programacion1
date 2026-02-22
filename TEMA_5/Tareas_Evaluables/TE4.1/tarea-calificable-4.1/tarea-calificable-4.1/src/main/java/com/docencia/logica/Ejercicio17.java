package com.docencia.logica;

public class Ejercicio17 {
  /**
   * ¿Ordenado asc?
   * Implementar usando lógica tradicional (iterativo).
   */
  public static boolean estaOrdenadoAsc(int[] arreglo) {
    if (arreglo == null || arreglo.length == 0){
      throw new IllegalArgumentException();
    }

    if (arreglo.length < 2){
      return true;
    }

    for (int i = 0; i <= arreglo.length-2; i++) {
      if (arreglo[i] > arreglo[i+1]){
        return false;
      }
    }
    return true;
  }
}
