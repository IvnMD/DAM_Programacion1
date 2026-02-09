import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Declara una variable de tipo long para almacenar un valor numérico grande, como la población mundial. Asigna un valor y muéstralo por pantalla.
 * 
 */

public class Repaso1_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long poblacionMundial = 8000000000L; // Aproximadamente 8 mil millones
        System.out.println("La poblacion mundial es: " + poblacionMundial);
        sc.close();
    }
}