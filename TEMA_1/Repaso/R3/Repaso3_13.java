package TEMA_1.Repaso.R3;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 03/10/25
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Crea un método que invierta el contenido de una cadena.
 * 
 */

public class Repaso3_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una frase y la invertire: ");
        String fraseIntro = sc.nextLine().trim();
        String nuevaFrase = "";

        for (int i = fraseIntro.length()-1; i >= 0 ; i--){
            nuevaFrase += fraseIntro.charAt(i);
        }

        System.out.println("Resultado: \n" + nuevaFrase);
        sc.close();
    }


}
