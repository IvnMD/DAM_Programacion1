package com.docencia.recursividad;

public class Ejercicio08 {
  /**
   * Cuenta dígitos (0 tiene 1 dígito)
   */
  public static int contarDigitos(int n) {
    n = Math.abs(n);
    if (n < 10){
      return 1;
    }
    return 1 + contarDigitos(n/10);
  }
}
