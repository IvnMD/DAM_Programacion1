package com.docencia.logica;

public class Ejercicio11 {
  /**
   * Suma de elementos
   * Implementar usando lógica tradicional (iterativo).
   */
  public static long sumaArreglo(int[] arreglo) {
    if (arreglo == null) {
        return 0;
    }
    long suma = 0;
    for (int i : arreglo) {
      suma += i;
    }
    return suma;
  }
}
