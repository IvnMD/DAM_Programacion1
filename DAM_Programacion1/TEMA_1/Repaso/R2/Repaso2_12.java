import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Escribe un programa que tome tres números y determine cuál es el mayor.
 *
 */

public class Repaso2_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Ingresa el primer número (o 0 para salir): ");
            double numero1 = sc.nextDouble();
            if (numero1 == 0) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.print("Ingresa el segundo número (o 0 para salir): ");
            double numero2 = sc.nextDouble();
            if (numero2 == 0) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.print("Ingresa el tercer número (o 0 para salir): ");
            double numero3 = sc.nextDouble();
            if (numero3 == 0) {
                System.out.println("Saliendo del programa...");
                break;
            }

            double mayor = numero1;

            if (numero2 > mayor) {
                mayor = numero2;
            }
            if (numero3 > mayor) {
                mayor = numero3;
            }

            System.out.println("El número mayor es: " + mayor);
        }

        sc.close();
    }

}
