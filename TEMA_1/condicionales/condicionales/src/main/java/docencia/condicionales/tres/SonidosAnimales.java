package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @autor Ivan Mesa
 * @date 29/09/2025
 * @version 1.0
 * @Bugs No hay bugs conocidos
 * @Brief Muestra el sonido de un animal dado. 
 * Variables: animal (string). 
 * Reglas:
 * 
 *  perro→Guau, gato→Miau, vaca→Muuu, otros→Desconocido
 * 
 *  Ejemplos:
 * 
 *  animal=perro → Guau animal=pollo → Desconocido
 * 
 *  Bonus: Acepta sinónimos (can, felino).
 */
public class SonidosAnimales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String animal;

        System.out.println("Introduce un animal (perro, gato, vaca): ");
        animal = sc.nextLine().toLowerCase();

        switch (animal) {
            case "perro":
            case "can":
                System.out.println("Guau");
                break;
            case "gato":
            case "felino":
                System.out.println("Miau");
                break;
            case "vaca":
                System.out.println("Muuu");
                break;
            default:
                System.out.println("Desconocido");
                break;
        }

        sc.close();
    }

}
