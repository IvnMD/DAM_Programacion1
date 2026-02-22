package com.docencia.recursividad;

public class Ejercicio04 {
  /**
   * Devuelve el n-ésimo Fibonacci
   * TODO: Implementar usando recursividad.
   */
  public static long fibonacci(int n) {
    if (n < 0){
      throw new IllegalArgumentException();
    }
    if (n<=1){
      return n;
    }

    return fibonacci(n-1) + fibonacci(n-2);
  }
}
