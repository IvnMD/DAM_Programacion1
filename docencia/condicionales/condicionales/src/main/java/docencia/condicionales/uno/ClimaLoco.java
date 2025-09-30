package docencia.condicionales.uno;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @version 1.0
 * @date 2024-06-10
 * @brief Programa que pide el clima y muestra un mensaje divertido según el clima.
 * @version 1.1
 * @bug No se han encontrado bugs.
 */

public class ClimaLoco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa el clima: ");
        String clima = sc.nextLine().toLowerCase().trim();

        if (clima.equals("soleado")) {
            System.out.println("¡Ponte gafas de sol y a disfrutar!");
        } else if (clima.equals("lluvioso")) {
            System.out.println("¡Saca tu paraguas, hoy cantamos bajo la lluvia!");
        } else if (clima.equals("nevando")) {
            System.out.println("¡Hora de hacer un muñeco de nieve!");
        } else {
            System.out.println("Clima misterioso... ¿acaso viene una tormenta intergaláctica?");
        }

        sc.close();
    }
}
