import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Escribe un programa que calcule el área de un rectángulo. 
 *        Usa dos variables de tipo int para la base y la altura.
 */

public class Repaso1_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la base del rectángulo:");
        int base = sc.nextInt();

        System.out.println("Introduce la altura del rectángulo:");
        int altura = sc.nextInt();

        int area = base * altura;

        System.out.println("El área del rectángulo es: " + area);

        sc.close();
    }

}
