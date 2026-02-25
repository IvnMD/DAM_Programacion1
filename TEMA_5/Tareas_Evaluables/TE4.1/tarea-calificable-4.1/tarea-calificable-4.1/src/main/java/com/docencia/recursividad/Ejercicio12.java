package com.docencia.recursividad;

public class Ejercicio12 {
  /**
   * Máximo elemento
   */
  public static int maximoArreglo(int[] arreglo) {
      if (arreglo == null || arreglo.length == 0){
      return 0;
    }
    return maxDesde(arreglo, 0);
  }

  private static int maxDesde(int[] arreglo, int indice){
    if (indice == arreglo.length-1){
      return arreglo[indice];
    }
    int maximo = maxDesde(arreglo, indice+1);
    return Math.max(arreglo[indice], maximo);
  }
}
