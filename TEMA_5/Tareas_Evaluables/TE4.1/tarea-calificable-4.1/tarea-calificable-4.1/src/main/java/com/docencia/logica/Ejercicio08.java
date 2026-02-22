package com.docencia.logica;

public class Ejercicio08 {
  /**
   * Cuenta dígitos (0 tiene 1 dígito)
   * Implementar usando lógica tradicional (iterativo).
   */
  public static int contarDigitos(int n) {
    n = Math.abs(n);
    if (n < 10) {
      return 1;
    }
    int resultado = 0;
    while (n > 0) {
      resultado = resultado + 1;
      n /= 10;
    }
    return resultado;
  }
}
