package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 29/09/2025
 * @version 1.0
 * @Bugs No hay bugs conocidos
 * @Brief Según letra G, PG, R, devuelve explicación. 
 * Variables:clasificacion (string). 
 * Reglas (ejemplo):
 * G→Apta para todos 
 * PG→Guía paternal sugerida 
 * R→Restringida 
 * Otro→Clasificación no reconocida
 * 
 *  Ejemplos:
 * 
 *  clas='G' → Apta para todos clas='NC-17' → Clasificación no reconocida
 * 
 *  Bonus: Acepta minúsculas y espacios.
 */
public class Peliculas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la clasificación de la película (G, PG, R): ");
        String clasificacion = sc.nextLine().trim().toUpperCase();

        switch (clasificacion) {
            case "G":
                System.out.println("Apta para todos");
                break;
            case "PG":
                System.out.println("Guía paternal sugerida");
                break;
            case "R":
                System.out.println("Restringida");
                break;
            default:
                System.out.println("Clasificación no reconocida");
                break;
        }
        sc.close();

    }
}
