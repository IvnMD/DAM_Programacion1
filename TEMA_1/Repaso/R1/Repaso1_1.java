package TEMA_1.Repaso.R1;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Declara una variable entera para almacenar tu edad
 *        y muestra su valor por pantalla.
 */

public class Repaso1_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int edad = 0;
        System.out.println("Introduce tu edad. \n");
        edad = sc.nextInt();

        System.out.println("Tu edad es " + edad);

        sc.close();
    }

}
