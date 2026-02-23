
package regexfechas;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Exercise10 {
  // dd/MM/yyyy con año >= 2000 (2000..2099)
  private static final Pattern P =
      Pattern.compile("");

  public static boolean isValid(String text) {
    if (text == null || text.isBlank()){
      return false;
    }
    text = text.trim();
    String dia = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
    String mes = "(0[1-9]|1[0-2])";
    String anyo = "20[0-9]{2}$";
    String patron = "^" + dia + "/" + mes + "/" + anyo + "$";
    // String patron = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])/(0[1-9]|1[0-2])/20[0-9]{2}$";

    return Pattern.matches(patron,text);
  }
}
