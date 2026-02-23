package com.docencia.logica;

public class Ejercicio22 {
  /**
   * Potencia rápida O(log exp)
   * Implementar usando lógica tradicional (iterativo).
   */
  public static long potenciaRapida(long base, int exponente) {
    if (base == 0 || exponente < 0){
      throw new IllegalArgumentException();
    }
    long resultado = 1;
    while(exponente>0){
      if (exponente % 2 != 0){
        resultado *= base;
      }
      base *= base;
      exponente = exponente/2;
    }
    return resultado;
  }
}
/**
 * Si calculas 3^13:
 * 
 *     En lugar de hacer 13 multiplicaciones, tu código hace solo 4 iteraciones.
 * 
 *     Reduce drásticamente el tiempo de cómputo conforme el exponente crece.
 */