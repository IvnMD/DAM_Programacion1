package TEMA_1.Repaso.R3;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 03/10/25
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Implementa un método que determine si una cadena es un palíndromo (se
 *        lee igual al revés).
 * 
 */

public class Repaso3_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una palabra y descubre si es un palindromo: ");
        String palabra = sc.nextLine();
        boolean esPalindromo = true;

        for (int i = 0; i < palabra.length() / 2; i++){
            if (palabra.charAt(i) != palabra.charAt(palabra.length() -1 - i)){
                esPalindromo = false;
                break;
            }
        }

        System.out.println("¿Es palindromo? " + esPalindromo);

    }

}
