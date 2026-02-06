
package regexfechas;

import java.util.regex.Pattern;

public class Exercise06 {
  // dd/MM/yyyy opcionalmente seguido de " HH:mm" (24h)
  private static final Pattern P =
      Pattern.compile("");

  public static boolean isValid(String text) {
    if (text == null || text.isBlank()){
      return false;
    }
    String dia = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
    String mes = "(0[1-9]|1[0-2])";
    String anyo = "[0-9]{4}";
    String horas = "(0[0-9]|1[0-9]|2[0-3])";
    String minutos = "[0-5][0-9]";
    String patron = "^" + dia + "/" + mes + "/" + anyo + "|"+ dia + "/" + mes + "/" + anyo + " " + horas + ":" + minutos +"$";
    return Pattern.matches(patron,text);
  }
}
