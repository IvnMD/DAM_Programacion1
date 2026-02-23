package com.docencia.recursividad;

public class Ejercicio17 {
  /**
   * ¿Ordenado asc?
   */
  public static boolean estaOrdenadoAsc(int[] arreglo) {
    if (arreglo == null){
      return false;
    }
    if (arreglo.length == 0){
      return true;
    }
    return ordDesde(arreglo, 0);
  }

  private static boolean ordDesde(int[] arreglo, int indice){
    if (indice >= arreglo.length-1){
      return true;
    }
    if (arreglo[indice] > arreglo [indice+1]){
      return false;
    }
    return ordDesde(arreglo, indice+1);
  }
}
