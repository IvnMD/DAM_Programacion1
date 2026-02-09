
import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Escribe un programa que solicite un número y determine si es divisible
 * por 3 y 5.
 *
 */
public class Repaso2_11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Ingresa un número (o 0 para salir): ");
            int num = sc.nextInt();

            if (num == 0) {
                System.out.println("Saliendo del programa...");
                break;
            } else if (num < 0) {
                System.out.println("ERROR: El número no puede ser negativo.");
            } else {
                if (num % 3 == 0 && num % 5 == 0) {
                    System.out.println(num + " es divisible por 3 y 5.");
                } else {
                    System.out.println(num + " no es divisible por 3 y 5.");
                }
            }
        }

        sc.close();
    }

}
