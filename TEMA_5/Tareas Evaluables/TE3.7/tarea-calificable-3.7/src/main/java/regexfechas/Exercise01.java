
package regexfechas;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise01 {
  // Encontrar fechas dd/MM/yyyy dentro de un texto
  private static final Pattern P = 
      Pattern.compile(");");
 

  public static List<String> findAll(String text) {
    if (text == null || text.isBlank()){
      return null;
    }
    String[] palabras = text.split(" ");
    List<String> resultado = new ArrayList<>(); 
    String dia = "^(0[0-9]|1[0-9]|2[0-9]3[0-1])";
    String mes = "(0[1-9]|1[0-2])";
    String anyo = "[0-9]{4}";
      String patron = "^" + dia + "/" + mes + "/" + anyo + "$";


    for (String palabra : palabras) {
      palabra = palabra.substring(0, palabra.length()-1);
      boolean esFecha = Pattern.matches(patron, palabra);
      if (esFecha)
        resultado.add(palabra);
    }
    return resultado;
}
}
