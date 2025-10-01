package TEMA_1.Repaso.R1;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Declara 1 variable de tipo double para almacenar el precio de un
 *        productos. Muestra su valor.
 */

public class Repaso1_2 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        float numero = 0f;
        System.out.println("Introduce el precio del producto: \n");
        numero = sc.nextFloat();

        System.out.println("El precio del producto es " + numero);

        sc.close();
    }

}
