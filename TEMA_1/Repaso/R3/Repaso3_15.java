package TEMA_1.Repaso.R3;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 03/10/25
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Crea un método que cuente el número de palabras en una cadena.
 * 
 */

public class Repaso3_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una frase y contaré las palabras: ");
        String frase = sc.nextLine().toLowerCase().trim();
        char espacio = ' ';
        int contador = 1;
        // boolean inicioPalabra = true;

        for (int i = 0; i < frase.length(); i++){
            if (espacio == frase.charAt(i)){
                contador++;
            }
        }
        System.out.println("El total de palabras es " + contador);
    }

}
