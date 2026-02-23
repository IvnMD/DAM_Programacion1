package com.docencia.logica;

public class Ejercicio09 {
  /**
   * Invierte número (sin String)
   * Implementar usando lógica tradicional (iterativo).
   */
  public static int invertirNumero(int n) {
    int signo = (n<0 ? -1 : 1);
    n = Math.abs(n);
    int resultado = 0;
    while(n>0){
      resultado = resultado*10 + (n%10);
      n = n/10;
    }
    return signo * resultado;
  }
}
