import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief  Escribe un programa que tome dos números y determine si son iguales. 
 *         Si son iguales, imprime "Es un cuadrado".
 *
 */

public class Repaso2_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Ingresa el primer número (o 0 para salir): ");
            double num1 = sc.nextDouble();
            if (num1 == 0) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.print("Ingresa el segundo número (o 0 para salir): ");
            double num2 = sc.nextDouble();
            if (num2 == 0) {
                System.out.println("Saliendo del programa...");
                break;
            }

            if (num1 == num2) {
                System.out.println("Es un cuadrado.");
            } else {
                System.out.println("No son iguales.");
            }
        }

        sc.close();
    }

}
