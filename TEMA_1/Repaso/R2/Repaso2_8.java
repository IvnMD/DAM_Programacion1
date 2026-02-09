
import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Escribe un programa que pida el ingreso anual de una persona y calcule
 * el impuesto a pagar (10% si el ingreso es menor a 50,000, 20% si es mayor o
 * igual a 50,000).
 */
public class Repaso2_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Ingresa tu ingreso anual (o 0 para salir): ");
            double ingreso = sc.nextDouble();

            if (ingreso == 0) {
                System.out.println("Saliendo del programa...");
                break;
            } else if (ingreso < 0) {
                System.out.println("ERROR: El ingreso no puede ser negativo.");
            } else {
                double impuesto;
                if (ingreso < 50000) {
                    impuesto = ingreso * 0.10;
                } else {
                    impuesto = ingreso * 0.20;
                }
                System.out.printf("El impuesto a pagar es: %.2f%n", impuesto);
            }
        }

        sc.close();
    }

}
