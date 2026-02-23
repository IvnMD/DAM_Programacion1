package com.docencia.logica;

public class Ejercicio19 {
  /**
   * Búsqueda binaria
   * Implementar usando lógica tradicional (iterativo).
   */
  public static int busquedaBinaria(int[] arregloOrdenado, int objetivo) {
    if (arregloOrdenado == null || arregloOrdenado.length == 0){
      throw new IllegalArgumentException();
    }
    int bajo = 0;
    int alto = arregloOrdenado.length-1;
    while( bajo <= alto){
      int medio = (bajo + alto)/2; //! Tambien posible medio = bajo + ((alto-bajo)/2)). Mejor para arrays muy grandes.
      if (arregloOrdenado[medio] == objetivo){
        return  medio;
      }
      if (arregloOrdenado[medio]<objetivo){
        bajo = medio +1;
      } else {
        alto = medio-1;
      }
    }
    return -1;
  }
}
