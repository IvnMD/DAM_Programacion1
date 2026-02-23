package com.docencia.logica;

public class Ejercicio04 {
  /**
   * Devuelve el n-ésimo Fibonacci
   * Implementar usando lógica tradicional (iterativo).
   */
  public static long fibonacci(int n) {
    if (n < 0){
      throw new IllegalArgumentException();
    }
    long resultado = 0;
    long temporal = 1;
    for (int i = 1; i <= n; i++) {
      long suma = resultado + temporal;
      resultado = temporal;
      temporal = suma;
    }

    return resultado;
  }
}
