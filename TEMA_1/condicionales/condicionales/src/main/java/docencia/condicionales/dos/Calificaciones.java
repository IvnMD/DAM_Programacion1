package docencia.condicionales.dos;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @version 1.0
 * @date 25-09-28
 * @brief Programa que pide una calificación y muestra su descripción.
 * @version 1.1
 * @bug No se han encontrado bugs.
 */

public class Calificaciones {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada;

        do {
            System.out.print("Ingresa una calificación (A, B, C, D) o X para salir: ");
            entrada = sc.nextLine().toLowerCase().trim();

            switch (entrada) {
                case "a":
                    System.out.println("Excelente");
                    break;
                case "b":
                    System.out.println("Notable");
                    break;
                case "c":
                    System.out.println("Aprobado");
                    break;
                case "d":
                    System.out.println("Reprobado");
                    break;                                        
                case "x":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Calificación desconocida");
                    break;
            }

        } while (!entrada.equals("x"));

        sc.close();  
    }
}

