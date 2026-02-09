package TEMA_1.Repaso.R3;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 03/10/25
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Escribe un método que reemplace todas las ocurrencias de un carácter en una cadena con otro carácter.
 * 
 */

public class Repaso3_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una frase y se sustituira las A por 4: ");
        String frase = sc.nextLine().toLowerCase().trim();
        char sustituto = '4';
        char sustituido = 'a';
        String nuevaFrase = "";

        for (int i = 0; i < frase.length(); i++){
            if (frase.charAt(i) == sustituido){
                nuevaFrase += sustituto;
            } else {
                nuevaFrase += frase.charAt(i);
            }
        }
        System.out.println("Cadena con reemplazo: " + nuevaFrase);

    }

}
