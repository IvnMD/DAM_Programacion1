package com.docencia.logica;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio26 {
  /**
   * Genera combinaciones de k
   * Implementar usando lógica tradicional (iterativo).
   */
  /**
     * Genera todas las combinaciones posibles de tamaño k a partir de un arreglo dado.
     * Utiliza un enfoque iterativo basado en índices crecientes (algoritmo de diccionario).
     * @param arreglo El conjunto de elementos originales.
     * @param k El tamaño de los subconjuntos deseados.
     * @return Una lista de listas, donde cada lista interna es una combinación única.
     * @throws IllegalArgumentException si el arreglo es nulo o k es negativo.
     */
  public static List<List<Integer>> generarCombinaciones(int[] arreglo, int k) {
    if (arreglo == null || arreglo.length == 0 || k < 0) {
      throw new IllegalArgumentException();
    }

    List<List<Integer>> resultado = new ArrayList<>();
    
    if (k == 0) {
      resultado.add(new ArrayList<>());
      return resultado;
    }

    if (k > arreglo.length) {
      return resultado;
    }

    int[] idx = new int[k];
    for (int i = 0; i < k; i++) {
      idx[i] = i;
    }

    while (true) {
      List<Integer> subconjunto = new ArrayList<>();
      for (int i : idx) {
        subconjunto.add(arreglo[i]);
      }
      resultado.add(subconjunto);

      int i = k - 1;
      while (i >= 0 && idx[i] == arreglo.length - k + i) {
        i--;
      }
      if (i < 0)
        break;

      idx[i]++;
      for (int j = i + 1; j < k; j++) {
        idx[j] = idx[j - 1] + 1;
      }
    }

    return resultado;
  }
}
/*  1. Inicialización: Se crean 'k' índices apuntando a las primeras posiciones [0, 1, ..., k-1].
    2. Lógica del Odómetro: El algoritmo intenta incrementar el índice más a la derecha (i = k-1). 
      Si ese índice alcanza su límite (arreglo.length - k + i), se mueve hacia la izquierda 
      para encontrar un índice que aún pueda crecer.
    3. Reseteo: Cuando un índice a la izquierda se incrementa, todos los índices a su derecha 
      se reinician a valores consecutivos (idx[j] = idx[j-1] + 1) para asegurar que 
      la combinación sea la siguiente menor posible.
    4. Condición de Parada: Cuando el índice en la posición 0 alcanza su límite máximo, 
      significa que se han generado todas las combinaciones.
    5. Complejidad: O(C(n, k)), donde C es el coeficiente binomial. Es mucho más eficiente 
      que el Bitmask porque no genera subconjuntos de tamaños distintos a k.
*/