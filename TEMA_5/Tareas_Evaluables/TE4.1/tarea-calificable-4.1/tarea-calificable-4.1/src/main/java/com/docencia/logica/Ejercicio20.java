package com.docencia.logica;

public class Ejercicio20 {
  /**
   * Ordena con merge sort
   * Implementar usando lógica tradicional (iterativo).
   */
    public static int[] mergeSort(int[] arreglo) {
        if (arreglo == null || arreglo.length == 0) {
            throw new IllegalArgumentException();
        }

        int longitud = arreglo.length;
        int ancho = 1;

        while (ancho < longitud) {
            for (int i = 0; i < longitud; i += 2 * ancho) {
                int izq = i;
                int medio = Math.min(i + ancho, longitud);
                int der = Math.min(i + 2 * ancho, longitud);

                fusionar(arreglo, izq, medio, der);
            }
            ancho = 2 * ancho;
        }

        return arreglo;
    }

    private static void fusionar(int[] a, int izq, int medio, int der) {
        int[] temporal = new int[der - izq];
        int i = izq;
        int j = medio;
        int k = 0;

        while (i < medio && j < der) {
            if (a[i] <= a[j]) {
                temporal[k++] = a[i++];
            } else {
                temporal[k++] = a[j++];
            }
        }

        while (i < medio) {
            temporal[k++] = a[i++];
        }

        while (j < der) {
            temporal[k++] = a[j++];
        }

        for (int x = 0; x < temporal.length; x++) {
            a[izq + x] = temporal[x];
        }
    }
}
/**
 *! MERGE SORT(ORDENACION POR MEZCLA): 
 * El método mergeSort ordena un arreglo de enteros usando Merge Sort iterativo, que funciona así:
 *     Divide el arreglo en subarreglos cada vez más grandes.
 * 
 *     En cada pasada, fusiona pares de subarreglos ya ordenados.
 * 
 *     Duplica el tamaño de los subarreglos en cada iteración:
 *     primero de tamaño 1, luego 2, luego 4, luego 8…
 * 
 * Este proceso continúa hasta que el tamaño del subarreglo es mayor o igual a la longitud del arreglo.
 * 
 *! VARIABLES PRINCIPALES:
 *  
 *  - ancho representa el tamaño de los subarreglos que se van a fusionar.
 *  - Comienza en 1 porque un elemento por sí solo ya está ordenado.
 * 
 *! BUCLE PRINCIPAL
 * 
 *  - Se recorre el arreglo en bloques de tamaño 2 * ancho.
 *  - Cada bloque se divide en:
 *      + izquierda: [izq, medio)
 *      + derecha: [medio, der)
 *  - Ambos subarreglos ya están ordenados (por construcción).
 *  - Se fusionan en orden creciente.
 * 
 * Luego se duplica ancho para fusionar subarreglos más grandes.
 *  
 *!  ¿COMO FUNCIONA FUSIONAR?
 
 * Fusiona dos subarreglos ordenados:
 * 
 *  - Izquierda: a[izq ... medio-1]
 *  - Derecha: a[medio ... der-1]
 * 
 * Proceso:
 * 
 *   1.- Se crea un arreglo temporal para almacenar el resultado.
 *   2.- Se comparan elementos de ambos subarreglos.
 *   3.- Se copia el menor al arreglo temporal.
 *   4.- Cuando uno de los subarreglos se agota, se copian los elementos restantes del otro.
 *   5.- Finalmente, se copia el contenido del temporal de vuelta al arreglo original.
*/