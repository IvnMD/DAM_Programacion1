
package regexfechas;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise07 {
  // Extraer día, mes y año desde dd/MM/yyyy
  private static final Pattern P =
      Pattern.compile("");

  public static int[] extract(String text) {
    if (text == null || text.isBlank()){
      return null;
    }
    String dia = "(0[1-9]|1[0-9]|2[0-9]3[0-1])";
    String mes = "(0[1-9]|1[0-2])";
    String anyo = "[0-9]{4}";
    String patron = "^" + dia + "/" + mes + "/" + anyo + "$";
    String[] arrayFecha = text.split("/");    
    int[] resultado = new int[3];
    resultado [0] = Integer.parseInt(arrayFecha[0]);
    resultado [1] = Integer.parseInt(arrayFecha[1]);
    resultado [2] = Integer.parseInt(arrayFecha[2]);


    return resultado;
  }
}
