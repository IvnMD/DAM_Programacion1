package R1.TEMA_1;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Declara una variable de tipo String que almacene tu nombre completo. Muestra por pantalla el nombre.
 * 
 */

public class Repaso1_5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce tu nombre completo: ");
        String nombreCompleto = sc.nextLine();

        System.out.println("Tu nombre completo es: " + nombreCompleto);

        sc.close();

    }
}
