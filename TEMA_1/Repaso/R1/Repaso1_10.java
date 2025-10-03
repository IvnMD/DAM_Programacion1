import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Crea una variable de tipo byte para almacenar un número del 0 al 127. Asigna un valor y muéstralo por pantalla.
 * 
 */

public class Repaso1_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        byte numero = 0;
        System.out.println("Introduce un numero del 0 al 127. \n");
        numero = sc.nextByte();

        System.out.println("El numero es " + numero);

        sc.close();
    }

}
