package  TEMA_1.Repaso.R1; 

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Declara una variable de tipo boolean que indique si una persona es mayor de edad (true o false). Asigna un valor y muéstralo por pantalla.
 */

public class Repaso1_4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce tu edad y te dire si eres mayor de edad: ");
        int edad = sc.nextInt();
        boolean esMayorDeEdad = edad >= 18;

        System.out.println("¿Eres mayor de edad? " + esMayorDeEdad);

        sc.close();
    }

}
