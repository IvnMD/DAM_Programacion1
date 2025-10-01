package docencia.condicionales.dos;

import java.util.Scanner;


/**
 * @author Ivan Mesa
 * @version 1.0
 * @date 25-09-28
 * @brief Programa que convierte entre diferentes unidades de medida.
 * @version 1.1
 * @bug No se han encontrado bugs.
 */
public class ConversorUnidades {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {

            System.out.println(
                "Introduce a qué unidad quieres convertir: \n" +
                " 1 - Km a Mi\n" +
                " 2 - Mi a Km\n" +
                " 3 - ºC a ºF\n" +
                " 4 - ºF a ºC\n" + 
                " 0 - Salir\n"
                );
            
            opcion = sc.nextInt();

            if (opcion == 0) {
                System.out.println("Saliendo del programa.");
                break;
            }

            System.out.print("Introduce un número: ");
            float numero = sc.nextFloat();

            switch (opcion) {
                case 1:
                    System.out.printf("La distancia %.2f Km equivale a %.2f Mi%n", numero, numero * 0.621371);
                    break;

                case 2:
                    System.out.printf("La distancia %.2f Mi equivale a %.2f Km%n", numero, numero * 1.60934);
                    break;

                case 3:
                    System.out.printf("La temperatura %.2f ºC equivale a %.2f ºF%n", numero, (numero * 9/5) + 32);
                    break;

                case 4:
                    System.out.printf("La temperatura %.2f ºF equivale a %.2f ºC%n", numero, (numero - 32) * 5/9);
                    break;

                default:
                    System.out.println("⚠ Entrada no válida, intenta de nuevo.");
                    break;
            }

        } while (true);

        sc.close();
    }
}
