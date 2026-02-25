package com.docencia.recursividad;

public class Ejercicio01 {
  /**
   * Calcula n!
   * Calcula el factorial de un número n.
   * @param n Número entero no negativo.
   * @return El factorial de n.
   * @throws IllegalArgumentException si n es negativo.
   */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        if (n <= 1) { //! No es necesario poner <= 1 porque el resultado es igual a == 1 y nos ahorramos una llamada al sistema
            return 1;
        }
        
        return n * factorial(n - 1);
    }
}
