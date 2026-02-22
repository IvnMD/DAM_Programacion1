package com.docencia.logica;

public class Ejercicio18 {
  /**
   * Merge de dos arreglos ordenados
   * Implementar usando lógica tradicional (iterativo).
   */
  public static int[] fusionarOrdenados(int[] a, int[] b) {
    if (a == null || b == null || a.length == 0 || b.length == 0){
      throw new IllegalArgumentException();
    }

    int i = 0;
    int j = 0;
    int k = 0;
    int[] resultado = new int [a.length + b.length];
    while (i < a.length || j < b.length){
      if (j == b.length || i < a.length && a[i] <= b[j]){
        resultado[k] = a[i];
        i++;
      } else {
        resultado[k] = b[j];
        j++;
      }
      k++;
    }
    return resultado;
  }
}
