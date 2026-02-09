import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Escribe un programa que convierta grados Celsius a Fahrenheit. Usa variables de tipo double para los cálculos.
 * 
 */

public class Repaso1_7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce los grados Celsius: ");
        double celsius = sc.nextDouble();

        double fahrenheit = (celsius * 9/5) + 32;

        System.out.println(celsius + " grados Celsius son " + fahrenheit + " grados Fahrenheit.");
        sc.close();
    }

}
