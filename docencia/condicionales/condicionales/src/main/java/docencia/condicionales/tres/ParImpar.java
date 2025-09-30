package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @version 1.0
 * @date 2025-09-28
 * @brief Programa que pide un número al usuario y determina si es par o impar.
 * @bug No se han encontrado bugs.
 *
 * Descripción: Determina si un número es par o impar. Variables: numero
 * (entero). Reglas:
 *
 * - Un número es par si `numero % 2 == 0`. - Si no, es impar. Bonus: Distingue
 * también si es múltiplo de 4 o de 3.
 */
public class ParImpar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero = 0;
        System.out.println("Introduce un número entero: ");
        numero = sc.nextInt();

        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " es par.");
            if (numero % 4 == 0) {
                System.out.println("Además, es múltiplo de 4.");
            }
            if (numero % 3 == 0) {
                System.out.println("Además, es múltiplo de 3.");
            }
        } else {
            System.out.println("El número " + numero + " es impar.");
            if (numero % 3 == 0) {
                System.out.println("Además, es múltiplo de 3.");
            }
            if (numero % 4 == 0) {
                System.out.println("Además, es múltiplo de 4.");
            }
        }
        sc.close();
    }
}
