package com.docencia.expresionesregulares.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexSoloDigitos {

  private static final Pattern PATRON = Pattern.compile("\"^[0-9]+$\"");

  private RegexSoloDigitos() {}

  public static boolean esValido(String texto) {
    Matcher digitos = PATRON.matcher(texto);
    if (digitos.matches()){
      return true;
    } else {
      return false;
    }
    
  }

  public static Pattern patron() {
    if (PATRON == NULL);
    throw new UnsupportedOperationException("TODO");
  }


}
