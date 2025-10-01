package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @version 1.0
 * @date 2025-09-28
 * @brief Programa que genera un número secreto y permite al usuario adivinarlo.
 * * @bug No se han encontrado bugs.
 */

public class NumeroSecreto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroSecreto = 42;
        int numeroUsuario = 0;

        System.out.println("Intenta adivinar el número secreto (entre 1 y 100).");
        while (numeroUsuario != numeroSecreto) {
            System.out.print("Introduce tu número: ");
            numeroUsuario = sc.nextInt();

            if (numeroUsuario < 1 || numeroUsuario > 100) {
                System.out.println("ERROR: El número debe estar entre 1 y 100.");
            } else if (numeroUsuario < numeroSecreto) {
                System.out.println("Demasiado bajo.");
            } else if (numeroUsuario > numeroSecreto) {
                System.out.println("Demasiado alto.");
            } else {
                System.out.println("¡Acertaste!");
            }
        }
        sc.close();
    }

}
