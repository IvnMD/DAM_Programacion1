package docencia.condicionales.tres;


import java.util.Scanner;

public class MontanyaRusa {

    /**
     * Descripción: Determina si una persona puede subir a la atracción según su
     * edad y altura. Variables sugeridas: edad (entero), altura (float,
     * metros), puedeSubir (boolean). Reglas:
     *
     * - Puede subir si `edad >= 12` **y** `altura >= 1.40`. - Si no cumple
     * ambos, no puede subir. Bonus: Muestra mensajes distintos si falla por
     * edad, por altura o por ambas.
     *
     * @author Ivan Mesa
     * @param args
     * @date 28/09/2025
     * @version 1.0
     * @bug No se han encontrado bugs.
     * @brief Programa que pide la altura y edad del usuario y determina si
     * puede subir a la montaña rusa.
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float altura = 0f;
        int edad;

        System.out.println("Introduce tu altura en cm: ");
        altura = sc.nextFloat();
        System.out.println("Introduce tu edad: ");
        edad = sc.nextInt();

        if (edad >= 12 && altura >= 140) {
            System.out.println("Puedes subir a la montaña rusa.");
        } else {
            if (edad < 12 && altura < 140) {
                System.out.println("No puedes subir a la montaña rusa por tu edad y altura.");
            } else if (edad < 12) {
                System.out.println("No puedes subir a la montaña rusa por tu edad.");
            } else {
                System.out.println("No puedes subir a la montaña rusa por tu altura.");
            }
        }
        sc.close();
    }

}
