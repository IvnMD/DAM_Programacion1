
package regexfechas;

import java.util.regex.Pattern;

public class Exercise08 {
  // Solo fechas de diciembre dd/12/yyyy
  // private static final Pattern P =
  //     Pattern.compile("^(0[1-9]|[12]\\d|3[01])/12/\\d{4}$");

  public static boolean isValid(String text) {
    if (text == null || text.isBlank()){
      return false;
    }
    String dia = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
    String mes = "(12)";
    String anyo = "[0-9]{4}";
    String patron = "^" + dia + "/" + mes + "/" + anyo + "$";

    return Pattern.matches(patron,text);
  }
}
