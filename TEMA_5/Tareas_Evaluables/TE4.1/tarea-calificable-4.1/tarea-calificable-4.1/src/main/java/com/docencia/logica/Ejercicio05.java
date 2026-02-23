package com.docencia.logica;

public class Ejercicio05 {
  /**
   * MCD por Euclides
   * Implementar usando lógica tradicional (iterativo).
   */
  public static int mcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);

    while (b !=0){
      int resto = a%b;
      a = b;
      b=resto;
    }
    return a;
  }
}
