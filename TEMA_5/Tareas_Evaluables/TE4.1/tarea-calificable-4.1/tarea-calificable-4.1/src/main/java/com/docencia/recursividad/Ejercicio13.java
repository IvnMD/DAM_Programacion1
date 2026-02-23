package com.docencia.recursividad;

public class Ejercicio13 {
  /**
   * Índice o -1
   */
  public static int buscarLineal(int[] arreglo, int objetivo) {
    return buscarDesde(arreglo, objetivo, 0);
  }

  private static int buscarDesde(int[] arreglo, int objetivo, int indice){
    if (indice == arreglo.length){
      return -1;
    }
    if (arreglo[indice] == objetivo){
      return indice;
    }
    return buscarDesde(arreglo, objetivo, indice+1);
  }
}
