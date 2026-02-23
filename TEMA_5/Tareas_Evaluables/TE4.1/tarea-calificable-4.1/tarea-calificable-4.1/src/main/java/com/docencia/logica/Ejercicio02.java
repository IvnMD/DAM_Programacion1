package com.docencia.logica;

public class Ejercicio02 {
  /**
   * Calcula base^exponente (exponente >= 0)
   * Implementar usando lógica tradicional (iterativo).
   */
  public static long potencia(long base, int exponente) {
    if (exponente < 0) {
      throw new IllegalArgumentException();
    }
    long resultado = 1;
    for (int i = 1; i <= exponente; i++) {
      resultado *= base;
    }
    return resultado;
  }

}
