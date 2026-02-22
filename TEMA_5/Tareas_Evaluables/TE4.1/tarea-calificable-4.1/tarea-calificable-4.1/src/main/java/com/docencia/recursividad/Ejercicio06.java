package com.docencia.recursividad;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio06 {
  /**
   * Devuelve [n, n-1, ..., 0]
   * 
   * Genera una lista con una cuenta regresiva desde n hasta 0.
   * Utiliza una función auxiliar recursiva para construir la lista.
   * @param n El número inicial de la cuenta.
   * @return Una lista de enteros [n, n-1, ..., 0].
   * @throws IllegalArgumentException si n es negativo.
   */
  public static List<Integer> cuentaRegresiva(int n) {
    if (n < 0) {
      throw new IllegalArgumentException();
    }
    return helper(n);
  }

  private static List<Integer> helper(int i) {
    List<Integer> resultado = new ArrayList<>();

    if (i == 0) {
      resultado.add(0);
      return resultado;
    }

    resultado.add(i);
    resultado.addAll(helper(i - 1));
    return resultado;
  }
}
