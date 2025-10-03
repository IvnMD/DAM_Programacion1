
import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Declara una variable int que contenga tu año de nacimiento. Calcula y
 *        muestra tu edad actual utilizando otra variable para el año actual.
 *
 */
public class Repaso1_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce tu año de nacimiento: ");
        int anioNacimiento = sc.nextInt();

        System.out.println("Introduce el año actual: ");
        int anioActual = sc.nextInt();

        System.out.println("Tu edad actual es: " + (anioActual - anioNacimiento));

        sc.close();
    }

}
