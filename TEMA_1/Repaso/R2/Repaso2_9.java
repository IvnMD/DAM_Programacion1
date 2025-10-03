import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Triángulo válido: Escribe un programa que tome tres lados de un triángulo y determine si forma un triángulo válido.
 *
 */

public class Repaso2_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Ingresa el lado A (o 0 para salir): ");
            double a = sc.nextDouble();
            if (a == 0) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.print("Ingresa el lado B (o 0 para salir): ");
            double b = sc.nextDouble();
            if (b == 0) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.print("Ingresa el lado C (o 0 para salir): ");
            double c = sc.nextDouble();
            if (c == 0) {
                System.out.println("Saliendo del programa...");
                break;
            }

            if (a <= 0 || b <= 0 || c <= 0) {
                System.out.println("ERROR: Los lados deben ser positivos.");
            } else if (a + b > c && a + c > b && b + c > a) {
                System.out.println("Los lados forman un triángulo válido.");
            } else {
                System.out.println("Los lados no forman un triángulo válido.");
            }
        }

        sc.close();
    }

}
