package com.docencia.logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio25 {
  /**
   * Genera permutaciones (recomendado: únicas)
   * Implementar usando lógica tradicional (iterativo).
   */
  public static List<List<Integer>> generarPermutaciones(int[] arreglo) {
    if (arreglo == null || arreglo.length == 0) {
      throw new IllegalArgumentException();
    }

    Arrays.sort(arreglo);
    List<List<Integer>> resultado = new ArrayList<>();

    do {
      List<Integer> permutacionActual = new ArrayList<>();
      for (int num : arreglo) {
        permutacionActual.add(num);
      }
      resultado.add(permutacionActual);

    } while (nextPermutation(arreglo));

    return resultado;
  }

  /**
   * Transforma el arreglo en la siguiente permutación mayor en orden
   * lexicográfico.
   * Basado en el algoritmo de Narayana Pandita.
   * 
   * @param arreglo El arreglo que se modificará "in-place".
   * @return true si se pudo generar una nueva permutación;
   *         false si ya se alcanzó la última (arreglo en orden descendente).
   */
  public static boolean nextPermutation(int[] arreglo) {
    int i = arreglo.length - 2;
    while (i >= 0 && arreglo[i] >= arreglo[i + 1]) {
      i--;
    }
    if (i < 0) {
      return false;
    }
    int j = arreglo.length - 1;
    while (arreglo[j] <= arreglo[i]) {
      j--;
    }
    swap(arreglo, i, j);
    reverse(arreglo, i + 1, arreglo.length - 1);
    return true;
  }

  /**
   * Intercambia las posiciones de dos elementos dentro de un arreglo.
   * @param arreglo El arreglo donde se realizará el intercambio.
   * @param i Índice del primer elemento.
   * @param j Índice del segundo elemento.
   */
  public static void swap(int[] arreglo, int i, int j) {
    int temp = arreglo[i];
    arreglo[i] = arreglo[j];
    arreglo[j] = temp;
  }

  /**
   * Invierte el orden de los elementos en un sub-rango específico del arreglo.
   * Se utiliza para minimizar la parte derecha del arreglo tras un intercambio.
   * @param arreglo El arreglo a modificar.
   * @param inicio Índice donde comienza la inversión.
   * @param fin    Índice donde termina la inversión (incluido el mismo).
   */
  public static void reverse(int[] arreglo, int inicio, int fin) {
    while (inicio < fin) {
      swap(arreglo, inicio, fin);
      inicio++;
      fin--;
    }
  }
}

/**
 * El objetivo es encontrar todas las permutaciones únicas (distintos órdenes)
 * de un conjunto de números. Se basa en el orden lexicográfico (como el orden
 * de las palabras en un diccionario).
 * 
 * Si tenemos [1, 2, 3], la siguiente permutación "mayor" es [1, 3, 2].
 * 
 * La última posible sería [3, 2, 1].
 * 
 * 1. generarPermutaciones(int[] arreglo)
 * 
 * Paso 1: Ordena el arreglo inicial. Esto es vital porque el algoritmo necesita
 * empezar desde la permutación más pequeña (ascendente).
 * 
 * Paso 2: Usa un bucle para capturar el estado del arreglo y transformarlo en
 * el siguiente hasta que no queden más.
 * 
 * Nota de Java: Convierte int[] a List<Integer> porque las listas de Java son
 * más flexibles para devolver resultados que los arreglos fijos.
 * 
 * 2. nextPermutation(int[] arreglo)
 * 
 * Encontrar el pivote (i): Busca de derecha a izquierda el primer número que
 * rompa la racha descendente. Es el punto donde el orden "se puede mejorar".
 * 
 * Buscar el sucesor (j): Busca el número más pequeño a la derecha de i que sea
 * más grande que a[i].
 * 
 * Swap: Intercambia i y j.
 * 
 * Reverse: El trozo a la derecha de i queda en orden descendente después del
 * swap; al invertirlo, lo conviertes en el orden más pequeño posible
 * (ascendente).
 * 
 * 3. swap(int[] arreglo, int i, int j)
 * 
 * Usa una variable temp para evitar que un valor sobrescriba al otro. Es el
 * "cubo vacío" para trasvasar agua entre dos cubos llenos.
 * 
 * 4. reverse(int[] arreglo, int inicio, int fin)
 * 
 * Simplemente da la vuelta a una sección del arreglo. Se usa al final de cada
 * paso para asegurar que la siguiente permutación sea la inmediatamente
 * superior y no una mucho más grande.
 * 
 * Ejemplo visual para tus notas:
 * 
 * Para el arreglo [1, 2, 3]:
 * 
 * Pivote: El 2 es menor que el 3. (i=indice1).
 * 
 * Sucesor: El 3 es el único mayor que 2 a su derecha. (j=indice2).
 * 
 * Swap: Cambiamos 2 por 3 → [1, 3, 2].
 * 
 * Reverse: Invertimos lo que hay tras el 3 (nada relevante aquí).
 * 
 * Resultado: [1, 3, 2].
 */