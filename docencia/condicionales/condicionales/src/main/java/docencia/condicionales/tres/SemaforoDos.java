package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 29/09/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Dado un color del semáforo, dice qué hacer.
 *        Variables: color (string).
 *        Reglas:
 * 
 *        rojo → Detener
 *        amarillo → Precaución
 *        verde → Avanzar
 * 
 *        Ejemplos:
 * 
 *        color=rojo → Detener
 *        color=amarillo → Precaución
 *        color=verde → Avanzar
 * 
 *        Bonus: Acepta abreviaturas r/a/v y valida entradas no válidas.
 * 
 */

public class SemaforoDos {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        
        String color = "";
        System.out.println("Introduce de que color está el semaforo: ");
        color = sc.nextLine().toLowerCase().trim();

        switch (color){
            case "rojo":
            case "r":
            System.out.println("Detener.");
            break;
            case "verde": 
            case "v": 
            System.out.println("Avanzar");
            break;
            case "amarillo":
            case "a":
            System.out.println("Precaucion.");
            break;
            default: System.out.println("Entrada no valida");
        }
        sc.close();

    }

}
