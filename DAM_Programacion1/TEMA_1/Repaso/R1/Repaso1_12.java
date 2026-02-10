import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Declara una variable de tipo short para almacenar la cantidad de días en un año (365). 
 * Asigna el valor y muéstralo por pantalla.
 */

public class Repaso1_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        short diasAnyo = 365;
        System.out.println("La cantidad de dias en un año es: " + diasAnyo);
        
        sc.close();
    }

}
