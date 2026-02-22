package com.docencia.logica;

public class Ejercicio12 {
  /**
   * Máximo elemento
   * Implementar usando lógica tradicional (iterativo).
   */
  public static int maximoArreglo(int[] arreglo) {
    if(arreglo == null || arreglo.length == 0){
      throw new IllegalArgumentException();
    }
    int maximo = arreglo[0];
    for (int i = 1; i < arreglo.length; i++) {
      if (arreglo[i] > maximo){
        maximo = arreglo[i];
      }
    }
    return maximo;
  }
}
