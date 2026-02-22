package com.docencia.recursividad;

public class Ejercicio03 {
  /**
   * Suma 1..n
   */
  public static long sumaHastaN(int n) {
    if ( n<0){
      throw new IllegalArgumentException();
    }
    if (n == 0){
      return 0;
    }

    return n + sumaHastaN(n-1);
  }
}
