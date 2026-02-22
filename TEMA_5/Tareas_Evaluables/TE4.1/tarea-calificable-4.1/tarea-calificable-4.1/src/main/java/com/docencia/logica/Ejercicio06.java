package com.docencia.logica;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio06 {
  /**
   * Devuelve [n, n-1, ..., 0]
   * Implementar usando lógica tradicional (iterativo).
   */
  public static List<Integer> cuentaRegresiva(int n) {
    if (n<0){
      throw new IllegalArgumentException();
    }
    List <Integer> resultado = new ArrayList<>();
    for (int i = n; i >= 0; i--) {
      resultado.add(i);
    }
    return resultado;
  }
}
