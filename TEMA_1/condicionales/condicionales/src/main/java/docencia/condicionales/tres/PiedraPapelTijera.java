package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @version 1.0
 * @date 2025-09-28
 * @brief Programa que juega a piedra, papel o tijera contra el usuario.
 * * @bug No se han encontrado bugs.
 * Descripción: Dos jugadores eligen entre piedra, papel o tijeras.
 * Variables: jugador1, jugador2 (string).
 * Reglas:
 * 
 * Empate si jugador1 == jugador2
 * Tijeras gana a Papel; Papel gana a Piedra; Piedra gana a Tijeras.
 * Ejemplos:
 * 
 * jugador1=piedra, jugador2=papel → Gana jugador 2
 * jugador1=tijeras, jugador2=papel → Gana jugador 1
 * jugador1=papel, jugador2=papel → Empate
 * Bonus: Acepta mayúsculas/minúsculas y sin tildes.
 */

public class PiedraPapelTijera {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String jugador1 = "";
        String jugador2 = "";
        System.out.println("Jugador 1, elige piedra, papel o tijeras: ");

        jugador1 = sc.nextLine().toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        System.out.println("Jugador 2, elige piedra, papel o tijeras: ");
        jugador2 = sc.nextLine().toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");

        if (jugador1.equals(jugador2)) {
            System.out.println("Empate.");
        } else if (jugador1.equals("tijeras") && jugador2.equals("papel") || jugador1.equals("papel") && jugador2.equals("piedra") || jugador1.equals("piedra") && jugador2.equals("tijeras")) {
            System.out.println("Gana el jugador 1.");
        } else if (jugador2.equals("tijeras") && jugador1.equals("papel") || jugador2.equals("papel") && jugador1.equals("piedra") || jugador2.equals("piedra") && jugador1.equals("tijeras")) {
            System.out.println("Gana el jugador 2.");
        } else {
            System.out.println("Entrada no válida. Por favor, elige piedra, papel o tijeras.");
        }
    sc.close();

    }
}
