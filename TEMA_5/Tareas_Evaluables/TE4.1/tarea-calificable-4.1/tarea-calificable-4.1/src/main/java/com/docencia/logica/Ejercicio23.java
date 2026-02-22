package com.docencia.logica;

public class Ejercicio23 {
  /**
   * Cuenta inversiones
   * Implementar usando lógica tradicional (iterativo).
   */
  public static long contarInversiones(int[] arreglo) {
    if (arreglo == null || arreglo.length == 0){
      throw new IllegalArgumentException();
    }

    long inversion = 0;
    for (int i = 0; i < arreglo.length-1; i++) {
      for (int j = i+1; j < arreglo.length-1; j++) { //! NO DEBERIA SER ARREGLO.LENGTH? SI ES -1 NO COMPARA EL ULTIMO ELEMENTO
        if (arreglo[i]>arreglo[j]){
          inversion++;
        }
      }
    }
    return inversion;
  }
}
/**
 * ¿Qué es exactamente una inversión?
 * 
 * Es una medida de qué tan desordenado está un arreglo. Se cuenta una inversión cada vez que un número mayor aparece antes que uno menor.
 * 
 *     Arreglo [1, 2, 3]: 0 inversiones (perfecto).
 * 
 *     Arreglo [3, 2, 1]: 3 inversiones (3>2, 3>1 y 2>1).
 */
