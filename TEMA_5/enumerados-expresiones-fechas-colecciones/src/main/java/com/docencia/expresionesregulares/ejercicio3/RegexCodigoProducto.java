package com.docencia.expresionesregulares.ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexCodigoProducto {

  private static final Pattern PATRON = Pattern.compile("\"^[A-Z]{3}-[0-9]{4}$\"");

  private RegexCodigoProducto() {}

  public static boolean esValido(String texto) {
    // if (texto == null || texto.isBlank()){
    //   return false;
    // }
    // String copia = texto.toUpperCase();
    // if (!(copia.equals(texto))) {
    //   return false;
    // }
    // String[] arrayTexto = texto.split("-");
    // if (arrayTexto.length != 2){
    //   return false;
    // }
    // if (arrayTexto[0].length() !=3 ){
    //   return false;
    // }
    // if (arrayTexto[1].length() != 4) {
    //   return false;
    // }
   
    return Pattern.matches("^[A-Z]{3}-[0-9]{4}$", texto);
  }

  public static Pattern patron() {
    return Pattern.compile("^[A-Z]{3}-[0-9]{4}$");
  }


}
