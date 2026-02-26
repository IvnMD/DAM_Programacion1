package com.docencia.recursividad;

import java.util.Arrays;

public class Ejercicio18 {
  /**
   * Merge de dos arreglos ordenados
   * TODO: Implementar usando recursividad.
   */
  public static int[] fusionarOrdenados(int[] a, int[] b) {
    return merge(a,0,b,0);
  }

  private static int[] merge (int[] a, int i, int[] b, int j ){
    if (j == a.length){
      int[] subArray = Arrays.copyOfRange(a, j, a.length-1);
      return subArray;
    }
    if (j == b.length){
      int[] subArray = Arrays.copyOfRange(a, i, a.length-1);
      return subArray;
    }
    if (a[i] <= b[j]){
      int[] resultado = a.length[i] + merge(a, i+1, b, j);
      return  resultado;
    }
    // return b.length[j]+merge(a, i, b, j+1);
    return a; //!FAKE, solo para callar acompilador
  }
}
