import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Escribe un programa que tome una calificación (0-100) y muestre la letra correspondiente: 
 *         A (90-100), B (80-89), C (70-79), D (60-69), F (0-59).
 * 
 */

public class Repaso2_5 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una calificación (0-100): ");
        int calificacion = sc.nextInt();

        if (calificacion >= 90 && calificacion <= 100) {
            System.out.println("Tu calificación es: A");
        } else if (calificacion >= 80 && calificacion < 90) {
            System.out.println("Tu calificación es: B");
        } else if (calificacion >= 70 && calificacion < 80) {
            System.out.println("Tu calificación es: C");
        } else if (calificacion >= 60 && calificacion < 70) {
            System.out.println("Tu calificación es: D");
        } else if (calificacion >= 0 && calificacion < 60) {
            System.out.println("Tu calificación es: F");
        } else {
            System.out.println("Calificación no válida.");
        }

        sc.close();
    }

}
