
package regexfechas;

import java.util.regex.Pattern;

public class Exercise05 {
  // Permite 1 o 2 dígitos en día y mes: 5/7/2023 o 05/07/2023
  private static final Pattern P =
      Pattern.compile("");

  public static boolean isValid(String text) {
    if (text == null || text.isBlank()){
      return false;
    }
    String dia = "(([1-9]|0[1-9])|1[0-9]|2[0-9]|3[0-1])";
    String mes = "((0[1-9]|([1-9]))|1[0-2])";
    String anyo = "[0-9]{4}$";
    String patron = "^" + dia + "/" + mes + "/" + anyo + "$";

    return Pattern.matches(patron,text);
  }
}

