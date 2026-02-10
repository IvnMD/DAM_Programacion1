package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 29/08/25
 * @version 1.0
 * @bug Sin bugs detectados
 * @brief Genera un número aleatorio y dice si eres suertudo.
 *        Variables: n (entero), suertudo (boolean).
 *        Reglas:
 * 
 *        Si n % 7 == 0 → ¡Eres suertudo! else Sigue intentando
 * 
 *        Ejemplos:
 * 
 *        n=14 → ¡Eres suertudo!
 *        n=29 → Sigue intentando
 * 
 *        Bonus: Da pistas: “cerca” si n % 7 == 1 o 6.
 */

public class AdivinaSuerte {
  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);

    int numero = 0;
    boolean suertudo = false;

    do {
      System.out.println("Introduce un numero: ");
      numero = sc.nextInt();

      if (numero % 7 == 0) {
        System.out.println("¡Eres suertudo!.");
        suertudo = true;
      } else if ((numero % 7 == 1)|| (numero % 7 == 6)){
        System.out.println("Cerca.");
      } else  {
        System.out.println("Sigue intentando.");
      }
    }  while (suertudo == false);
    sc.close();
  }
}
