
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
    String[] array = new String[3];
    List<String> resultado = new ArrayList<>(); 
    String dia = "^(0[0-9]|1[0-9]|2[0-9]3[0-1])";
    String mes = "(0[1-9]|1[0-2])";
    String anyo = "[0-9]{4}";
      String patron = "^" + dia + "/" + mes + "/" + anyo + "$";

    if (Pattern.matches(patron,text)){
      resultado.add(text);
      }
    array = text.split("-");


    return resultado;
}
}
