package org.docencia;

import java.util.Scanner;

/**
 * @author Ivan Mesa Dominguez
 * @date 03/10/2025
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief El programa deberá: 
 * . Preguntar tu nombre, edad y ciudad. 
 * . Devolver un mensaje digno de una tarjeta de presentación digital:
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.println("\nIntroduce tu edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.println("\nIntroduce tu ciudad de residencia ");
        String ciudad = sc.nextLine();
        
        System.out.println("Hola " + nombre + ", tienes " + edad + " años y vives en " + ciudad + ".");
        
        sc.close();
    }
}