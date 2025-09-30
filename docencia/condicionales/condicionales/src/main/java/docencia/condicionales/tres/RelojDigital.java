package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 29/10/2025
 * @version 1.0
 * @bug No se han encontrado bugs
 * @brief Crea un reloj que devuelva un saludo segun la hora introducida.
 *        Descripción: Muestra saludo según la hora (0–23).
 *        Variables: hora (entero).
 *        Reglas (ejemplo):
 * 
 *        6–11 → Buenos días
 *        12–19 → Buenas tardes
 *        20–23 y 0–5 → Buenas noches
 * 
 *        Ejemplos:
 * 
 *        hora=8 → Buenos días
 *        hora=15 → Buenas tardes
 *        hora=22 → Buenas noches
 * 
 *        Bonus: Valida rango 0–23; si no, error.
 */

public class RelojDigital {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int hora = 0;
        System.out.println("Introduzca que hora es: ");
        hora = sc.nextInt();

        if (hora < 0 || hora > 23){
            System.out.println("Hora fuera de rango. Intentelo de nuevo");
        } else if (hora > 5 && hora < 12){
            System.out.println("Buenos días.");            
        } else if (hora > 11 && hora < 20) {
            System.out.println("Buenas tardes");
        } else if (hora > 19 && hora < 24 || hora >= 0 && hora < 6){
            System.out.println("Buenas noches.");
        }
        sc.close();
    }

}
