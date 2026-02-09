package org.docencia;

import java.util.Scanner;

/**
 * @author Ivan Mesa Dominguez
 * @date 03/10/2025
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Preguntar de que figura geometrica quieres calcular el area, te preguntará los datos necesarios para hacerlo
 *  y devolverá el resultado.
 * 
 * FORMULAS: 
 * 
 * Círculo: π * radio^2
 * Cuadrado: lado^2
 * Triángulo: (base * altura) / 2
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


            System.out.println("Introduce de que figura geometrica quieres calcular el area:\n"+
                            "1 - Circulo\n" + 
                            "2 - Cuadrado\n" + 
                            "3 - Triangulo\n" );
        int eleccion = sc.nextInt();
        float area = 0.0f;

        switch (eleccion) {
            case 1:
                float pi = 3.14f;
                System.out.println("Introduce el radio: ");
                float radio = sc.nextFloat();
                area = pi * (radio * radio); //π * radio^2
                System.out.println("El area del circulo es: " + area);
                break;
            case 2:
                System.out.println("Introduce el lado: ");
                float lado = sc.nextFloat();
                area = lado * lado;
                System.out.println("El area del cuadrado es: " + area);
                break;

            case 3:
                System.out.println("Introduce la altura: ");
                float altura = sc.nextFloat();
                System.out.println("Introduce la base: ");
                float base = sc.nextFloat();
                area = (base * altura) / 2;
                System.out.println("El area del triaungulo es: " + area);
                break;
        } 
        sc.close();
    }
}
