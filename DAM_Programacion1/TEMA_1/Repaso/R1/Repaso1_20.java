import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Crea un programa que intercambie los valores de dos variables enteras.
 * Por ejemplo, si la variable a vale 5 y b vale 10, después del intercambio a debería valer 10 y b 5.
 */

public class Repaso1_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el valor de a: ");
        int numeroA = sc.nextInt();

        System.out.print("Introduce el valor de b: ");
        int  numeroB = sc.nextInt();

        // Intercambio de valores usando una variable temporal
        int temporal = numeroA;
        numeroA = numeroB;
        numeroB = temporal;

        System.out.println("Después del intercambio:");
        System.out.println("a = " + numeroA);
        System.out.println("b = " + numeroB);

        sc.close();
    }

}
