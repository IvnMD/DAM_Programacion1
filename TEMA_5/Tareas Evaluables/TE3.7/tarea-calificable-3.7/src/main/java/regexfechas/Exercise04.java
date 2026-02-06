
package regexfechas;

import java.util.regex.Pattern;

public class Exercise04 {
  // dd-MM-yyyy rechazando 00 (ya lo rechazan los rangos)
  private static final Pattern P =
      Pattern.compile("");

  public static boolean isValid(String text) {
    if (text == null || text.isBlank()){
      return false;
    }
    String dia = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
    String mes = "(0[1-9]|1[0-2])";
    String anyo = "[0-9]{4}$";
    String patron = "^" + dia + "-" + mes + "-" + anyo + "$";

    return Pattern.matches(patron,text);
  }
}
