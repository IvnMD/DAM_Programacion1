package com.docencia.recursividad;

public class Ejercicio09 {
  /**
   * Invierte número (sin String)
   * 
   * Invierte los dígitos de un número entero de forma recursiva.
   * @param n Número entero a invertir.
   * @return El número con sus dígitos en orden inverso, conservando el signo.
   */
  public static int invertirNumero(int n) {
    int signo = (n<0 ? -1 : 1);
    n = Math.abs(n);
    return signo * inv(n, contarDigitos(n));
  }

    /**
     * Cuenta la cantidad de dígitos de un número no negativo.
     *
     * @param n Número no negativo.
     * @return Cantidad de dígitos.
     */
    private static int contarDigitos(long n) {
        if (n < 10) return 1;
        return 1 + contarDigitos(n / 10);
    }

    /**
     * Método auxiliar que invierte los dígitos de n
     * sabiendo que tiene exactamente longitud dígitos.
     *
     * @param n   Número a invertir (no negativo).
     * @param longitud Cantidad de dígitos restantes a procesar.
     * @return El número con sus dígitos invertidos.
     */
    private static int inv(int n, int longitud) {
        if (longitud == 1) return n;

        int ultimo = n % 10;
        return ultimo * (int)Math.pow(10, longitud - 1) + inv(n / 10, longitud - 1);
    }
}
