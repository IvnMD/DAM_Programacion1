import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Declara una variable de tipo String para almacenar una dirección de correo electrónico. Muéstrala en la consola.
 * 
 */

public class Repaso1_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una dirección de correo electrónico:");
        String email = sc.nextLine();

        System.out.println("La dirección de correo electrónico es: " + email);
        sc.close();
    }

}
