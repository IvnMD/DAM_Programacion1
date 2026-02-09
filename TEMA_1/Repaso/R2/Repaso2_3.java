import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Clasificación de edad: Escribe un programa que solicite la edad de una persona y determine si es 
 *        un niño (0-12), adolescente (13-19), adulto (20-64) o anciano (65 o más).
 * 
 */

public class Repaso2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();

        if (edad >= 0 && edad <= 12) {
            System.out.println("Eres un niño.");
        } else if (edad >= 13 && edad <= 19) {
            System.out.println("Eres un adolescente.");
        } else if (edad >= 20 && edad <= 64) {
            System.out.println("Eres un adulto.");
        } else if (edad >= 65) {
            System.out.println("Eres un anciano.");
        } else {
            System.out.println("Edad no válida.");
        }

        sc.close();
    }


}
