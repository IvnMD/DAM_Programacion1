package com.docencia.logica;

public class Ejercicio01 {
  /**
   * Calcula n!
   * Implementar usando lógica tradicional (iterativo).
   */
  public static long factorial(int n) {
    if (n < 0) {
        throw new IllegalArgumentException();
    }
    long resultado = 1;
    for (int i = 1; i <= n; i++) {
      resultado *= i;
    }
    return resultado;
  }
}
