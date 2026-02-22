package com.docencia.recursividad;

public class Ejercicio05 {
  /**
   * MCD por Euclides
   */
  public static int mcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    if (b==0){
      return a;
    }

    return mcd(b, a%b);
  }
}
