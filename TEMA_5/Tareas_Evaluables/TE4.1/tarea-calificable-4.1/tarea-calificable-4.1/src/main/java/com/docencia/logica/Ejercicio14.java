package com.docencia.logica;

public class Ejercicio14 {
  /**
   * ¿Es palíndromo?
   * Implementar usando lógica tradicional (iterativo).
   */
  public static boolean esPalindromo(String texto) {
    if (texto == null){
      throw new IllegalArgumentException();
    }
    if ( texto.isEmpty()){
      return true;
    }
    int i = 0;
    int j = texto.length()-1;
    while (i<j){
      if (texto.charAt(i) != texto.charAt(j)){
        return false;
      }
      i++;
      j--;
    }
    
    return true;
  }
}
