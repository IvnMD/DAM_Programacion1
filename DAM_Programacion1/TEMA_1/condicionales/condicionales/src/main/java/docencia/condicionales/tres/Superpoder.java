package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @autor Ivan Mesa
 * @date 29/09/2025
 * @version 1.0
 * @Bugs No hay bugs conocidos
 * @Brief Devuelve el poder elegido 1–3.
 * 
 * Variables: op (entero). 
 * Reglas:
 * 
 *  1→Volar, 2→Invisibilidad, 3→Superfuerza, otro→Desconocido

 *  Ejemplos:

 *  op=2 → Invisibilidad op=5 → Desconocido
 *
 */
public class Superpoder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        System.out.println("Elige un superpoder (1: Volar, 2: Invisibilidad, 3: Superfuerza): ");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Has elegido Volar");
                break;
            case 2:
                System.out.println("Has elegido Invisibilidad.");
                break;
            case 3:
                System.out.println("Has elegido Superfuerza.");
                break;
            default:
                System.out.println("Desconocido: Opción no válida.");
                break;
        }

        sc.close();
    }

}
