

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 03/10/25
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Escribe un método que encuentre la palabra más larga en una oración.
 */


public class Repaso3_12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca una cadena: ");
        String oracion =  sc.nextLine().trim();
        String palabraLarga = "";
        String palabraActual = "";

        for (int i = 0; i <= oracion.length(); i++) {
            if (i < oracion.length() && oracion.charAt(i) != ' ') {
                palabraActual += oracion.charAt(i);
            } else {
                if (palabraActual.length() > palabraLarga.length()) {
                    palabraLarga = palabraActual;
                }
                palabraActual = "";
            }
        }

        System.out.println("Palabra más larga: " + palabraLarga);
        sc.close();
    }


}