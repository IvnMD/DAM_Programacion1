package docencia.condicionales.uno;

import java.util.Scanner;

/**
 * @author I.Mesa
 * @date 24/09/25
 * @class Semaforo
 *        Pide por pantalla un color (string)
 *        y devuelve una mensaje por pantalla segun la respuesta recibida.
 */

public class Semaforo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingresa el color del semáforo: ");
    String color = sc.nextLine().toLowerCase().trim();

    if (color.equals("rojo")) {

      System.out.println("¡Alto! Ni se te ocurra moverte.");

    }
    else if (color.equals("amarillo")) {

      System.out.println("Prepárate… ¡pero no corras!");

    }
    else if (color.equals("verde")) {

      System.out.println("¡Avanza como un rayo!");

    }
    else {

      System.out.println("Ese color no existe en un semáforo… ¿arcoíris?");

    }

    sc.close();
  }
}
