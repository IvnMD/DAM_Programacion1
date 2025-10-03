// package TEMA_1.Repaso.R1;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Declara tres variables enteras, asigna valores a cada una y calcula su promedio.
 * 
 */

public class Repaso1_6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce el primer numero: ");
        int numero1 = sc.nextInt();

        System.out.println("Introduce el segundo numero: ");
        int numero2 = sc.nextInt();

        System.out.println("Introduce el tercer numero: ");
        int numero3 = sc.nextInt();

        System.out.println("El promedio es: " + (numero1 + numero2 + numero3) / 3.0);
        sc.close();
    }
}
