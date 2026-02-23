
package regexfechas;

import java.util.regex.Pattern;

public class Exercise02 {
  // dd-mes-yyyy (mes en español, case-insensitive)
  // Acepta septiembre/setiembre.
  private static final Pattern P =
      Pattern.compile("");

  public static boolean isValid(String text) {
    if (text == null || text.isBlank()){
      return false;
    }
    String dia = "^(0[1-9]|1[0-9]|2[0-9]3[0-1])$\"";
    String mes = "^(0[1-9]|1[0-2])$";
    String anyo = "^20[0-9]{2}$";
    String patron = "^" + dia + "/" + mes + "/" + anyo + "$";

    // String mesEscrito;

    // return Pattern.matches(patron,text);
    return false;
  }
}
