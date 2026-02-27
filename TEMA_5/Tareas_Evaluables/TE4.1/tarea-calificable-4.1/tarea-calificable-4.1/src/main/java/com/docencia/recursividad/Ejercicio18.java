package com.docencia.recursividad;

import java.util.Arrays;

public class Ejercicio18 {
  /**
   * Merge de dos arreglos ordenados
   * TODO: Implementar usando recursividad.
   */
public static int[] fusionarOrdenados(int[] a, int[] b) {
    return merge(a, 0, b, 0, new int[a.length + b.length], 0);
}

private static int[] merge(int[] a, int i, int[] b, int j, int[] resto, int k) {
    if (i == a.length) {
        if (j == b.length) return resto; 
        resto[k] = b[j];
        return merge(a, i, b, j + 1, resto, k + 1);
    }
    
    if (j == b.length) {
        resto[k] = a[i];
        return merge(a, i + 1, b, j, resto, k + 1);
    }

    if (a[i] <= b[j]) {
        resto[k] = a[i];
        return merge(a, i + 1, b, j, resto, k + 1);
    } else {
        resto[k] = b[j];
        return merge(a, i, b, j + 1, resto, k + 1);
    }
  }
} 