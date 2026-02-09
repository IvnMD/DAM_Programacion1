import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Declara dos variables de tipo int y realiza una división entre ambas. 
 *        Muestra el resultado de la división entera y el resto.
 */

public class Repaso1_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer número (dividendo):");
        int dividendo = sc.nextInt();

        System.out.println("Introduce el segundo número (divisor):");
        int divisor = sc.nextInt();

        if (divisor != 0) {
            int division = dividendo / divisor;
            int resto = dividendo % divisor;

            System.out.println("El resultado de la división entera es: " + division);
            System.out.println("El resto de la división es: " + resto);
        } else if (divisor == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
        }

        sc.close();
    }
    

}
