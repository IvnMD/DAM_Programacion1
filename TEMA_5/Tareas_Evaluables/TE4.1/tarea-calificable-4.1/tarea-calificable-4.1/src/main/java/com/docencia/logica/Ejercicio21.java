package com.docencia.logica;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ejercicio21 {
  /**
   * Ordena con quick sort
   * Implementar usando lógica tradicional (iterativo).
   */
  public static int[] quickSort(int[] arreglo) {
    if (arreglo == null || arreglo.length == 0) {
      throw new IllegalArgumentException();
    }
    Deque<Integer> pila = new ArrayDeque<>();
    pila.push(0);
    pila.push(arreglo.length - 1);
    while (!pila.isEmpty()) {
      int bajo = pila.pop();
      int alto = pila.pop();

      int particion = particionar(arreglo, bajo, alto);

      if (particion - 1 > bajo) {
        pila.push(bajo);
        pila.push(particion - 1);
      }

      if (particion + 1 < alto) {
        pila.push(particion + 1);
        pila.push(alto);
      }
    }
    return arreglo;
  }

  private static int particionar(int[] arreglo, int bajo, int alto) {
    int pivote = arreglo[alto];
    int i = bajo;

    for (int j = bajo; j < alto; j++) {
      if (arreglo[j] <= pivote) {
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
        i++;
      }
    }

    int temp = arreglo[i];
    arreglo[i] = arreglo[alto];
    arreglo[alto] = temp;

    return i;
  }
}
/**
 *! QUICK SORT (ORDENAMIENTO RAPIDO): 
 * El QuickSort es como organizar una biblioteca usando el principio de "divide
 * y vencerás". Es uno de los algoritmos más rápidos porque, en lugar de
 * comparar todos con todos, toma decisiones drásticas para reducir el trabajo.
 * 
 * Aquí tienes los 3 conceptos clave para entenderlo:
 * 1. El Pivote (El Juez)
 * 
 * Imagina que tienes un montón de cartas desordenadas. Eliges una carta al azar
 * (normalmente la última o la primera). Esa carta es el pivote. Su única misión
 * es servir de referencia.
 * 2. La Partición (El caos ordenado)
 * 
 * Recorres el resto de las cartas y haces dos grupos:
 * 
 * A la izquierda, pones todas las que son menores que el pivote.
 * 
 * A la derecha, pones todas las que son mayores que el pivote.
 * 
 * En este momento, no importa si el grupo de la izquierda está ordenado entre
 * sí. Lo único que importa es que el pivote ya está en su lugar definitivo.
 * Nunca más se moverá de ahí.
 * 3. La Pila de Rangos (En la versión iterativa)
 * 
 * Como en el ejercicio que acabamos de hacer no usamos recursividad, usamos una
 * pila para recordar qué grupos nos quedan por ordenar:
 * 
 * Metemos el rango completo (desde 0 hasta el final).
 * 
 * Sacamos un rango, buscamos el pivote y particionamos.
 * 
 * Si a la izquierda del pivote quedaron cartas desordenadas, metemos ese nuevo
 * rango a la pila.
 * 
 * Si a la derecha quedaron cartas, también metemos ese rango.
 * 
 * Repetimos hasta que la pila esté vacía.
 */