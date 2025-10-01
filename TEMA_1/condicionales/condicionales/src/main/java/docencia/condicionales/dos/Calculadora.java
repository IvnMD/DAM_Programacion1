package TEMA_1.condicionales.condicionales.src.main.java.docencia.condicionales.dos;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @version 1.0
 * @date 25-09-28
 * @brief Programa que simula una calculadora básica con operaciones de suma, resta, multiplicación y división.
 * @version 1.1
 * @bug No se han encontrado bugs.
 */

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operacion;

        do {
            System.out.println("\n===== CALCULADORA =====");
            System.out.println("Operaciones disponibles: +  -  *  / ");
            System.out.println("Escribe X para salir.");
            System.out.print("Elige una operación: ");
            operacion = sc.nextLine().trim();

            if (operacion.equalsIgnoreCase("x")) {
                System.out.println("Saliendo de la calculadora...");
                break;
            }

            System.out.print("Introduce el primer número: ");
            float numero1 = sc.nextFloat();

            System.out.print("Introduce el segundo número: ");
            float numero2 = sc.nextFloat();
            sc.nextLine(); // limpiar buffer

            switch (operacion) {
                case "+":
                    System.out.println("Resultado: " + (numero1 + numero2));
                    break;
                case "-":
                    System.out.println("Resultado: " + (numero1 - numero2));
                    break;
                case "*":
                    System.out.println("Resultado: " + (numero1 * numero2));
                    break;
                case "/":
                    if (numero2 == 0) {
                        System.out.println("⚠ Error: No se puede dividir entre cero.");
                    } else {
                        System.out.println("Resultado: " + (numero1 / numero2));
                    }
                    break;
                default:
                    System.out.println("⚠ Operación inválida.");
                    break;
            }

        } while (true);

        sc.close();
    }
}

