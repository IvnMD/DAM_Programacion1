package com.docencia.logica;

public class Ejercicio10 {
  /**
   * Invierte cadena
   * Implementar usando lógica tradicional (iterativo).
   */
  public static String invertirCadena(String texto) {
    if (texto == null){
      throw new IllegalArgumentException();
    }
    if (texto.isEmpty()){
      return texto;
    }

    String cadenaInvertida = "";
    for (int i = texto.length()-1; i >= 0; i--) {
      cadenaInvertida += texto.charAt(i);
    }
    return cadenaInvertida;
  }
}
