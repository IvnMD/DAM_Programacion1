package com.docencia.expresionesregulares.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexSoloDigitos {

  private static final Pattern PATRON = Pattern.compile("\"^[0-9]+$\"");

  private RegexSoloDigitos() {
  }
  /**
   * Funcion que comprueba validez del patron
   * @param texto Patron a comprobar
   * @return true o false
   */
  public static boolean esValido(String texto) {
    String patron = "^[0-9]+$";
    return Pattern.matches(patron, texto);



  }
  /**
   * 
   * @return
   */
  public static Pattern patron() {
    return Pattern.compile("^[0-9]+$");
  }


}
