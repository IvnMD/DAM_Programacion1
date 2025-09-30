package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @version 1.0
 * @date 2025-09-28
 * @brief Programa que calcula la propina en un restaurante.
 * @bug No se han encontrado bugs. 
 * 
 * Descripción: Calcula la propina y el total a pagar. 
 * Variables: cuenta (float), porcentaje (entero/float), propina, total. 
 * Reglas:
 *
 * propina = cuenta * porcentaje / 100 total = cuenta + propina
 * 
 * Bonus: Redondea a 2 decimales y permite dividir entre n amigos.
 */
public class Propinas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float cuenta = 0f;
        float porcentaje = 0f;
        float propina = 0f;
        float total = 0f;
        int amigos = 1;

        System.out.println("Introduce el total de la cuenta: ");
        cuenta = sc.nextFloat();
        System.out.println("Introduce el porcentaje de propina: ");
        porcentaje = sc.nextFloat();
        System.out.println("¿Entre cuántas personas se va a dividir la cuenta? (1 si no se divide): ");
        amigos = sc.nextInt();
        propina = cuenta * porcentaje / 100;
        total = cuenta + propina;
        System.out.printf("La propina es: %.2f\n", propina);
        System.out.printf("El total a pagar es: %.2f\n", total);
        if (amigos > 1) {
            System.out.printf("Cada persona debe pagar: %.2f\n", total / amigos);
        }
        sc.close();
    }

}
