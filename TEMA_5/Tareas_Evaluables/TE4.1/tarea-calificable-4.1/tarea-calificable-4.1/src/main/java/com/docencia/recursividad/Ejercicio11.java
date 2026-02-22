package com.docencia.recursividad;

public class Ejercicio11 {
  /**
   * Suma de elementos
   * 
   */
  public static long sumaArreglo(int[] arreglo) {
    if (arreglo == null || arreglo.length == 0){
      return 0;
    }
    return sumaDesde(arreglo,0);
  }

  private static long sumaDesde(int[] arreglo, int indice){
    if (indice == arreglo.length){
      return 0;
    }
    return arreglo[indice] + sumaDesde(arreglo, indice+1);
  }
}
