package com.docencia.expresiones.ejercicio6;

import java.util.regex.Pattern;

/**
 * 6) DETECTAR PALABRA REPETIDA CONSECUTIVA
 *    - Detectar si existe una palabra repetida inmediatamente (ej: "hola hola"),
 *      usando grupos y backreferences.
 *    Válidos:   "hola hola", "qué qué", "test test"
 *    Inválidos: "hola adiós hola", "holahola", "hola  adiós" 
 */
public class Ejercicio06 {


  /**
   * Devuelve true si existe al menos una palabra repetida consecutivamente.
   */
  public static boolean hasConsecutiveRepeatedWord(String text) {
    if (text == null || text.isBlank()) {
      return false;
    }

    String expReg = "(?i).*\\b([a-zZA-ZáéíóúÁÉÍÓÚñÑüÜ]+)\\s+\\1\\b.*";
    //! \b           -> Límite de palabra (para que no coincida "hola" dentro de "holahola")
    //? ([a-zA-ZáéíóúÁÉÍÓÚ]+) -> Grupo 1: captura una palabra completa
    //! \s+          -> Uno o más espacios en blanco
    //? \1           -> Referencia al Grupo 1 (la misma palabra exacta)
    //! \b           -> Otro límite de palabra
    //? Ponemos .* al principio y al final para que Pattern.matches coincida con toda la cadena
    return Pattern.matches(expReg, text);
  }
}