package com.docencia.recursividad;

public class Ejercicio07 {
  /**
   * Suma de dígitos
   */
  public static int sumaDigitos(int n) {
    n = Math.abs(n);
    if(n < 10){
      return n;
    }
    return (n % 10) + sumaDigitos(n/10);
  }
}
