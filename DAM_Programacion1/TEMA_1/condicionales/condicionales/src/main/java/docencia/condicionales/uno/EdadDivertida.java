package docencia.condicionales.uno;

import java.util.Scanner;


/**
 * @author I.Mesa
 * @date 24/09/25
 * @class EdadDivertida
 *        Pide por pantalla un dato de tipo entero (la edad del usuario)
 *        y devuelve una mensaje por pantalla segun la respuesta recibida.
 */


public class EdadDivertida {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingresa tu edad: ");
    int edad = sc.nextInt();

    if (edad < 5) {

      System.out.println("Eres un bebé genio con el tecaldo.");

    } else if (edad < 13) {

      System.out.println("¡Cuidado! Podrías estar en la fase gamer pro.");

    } else if (edad < 20) {

      System.out.println("Adolescente detectado: nivel experto en memes.");

    } else if (edad < 60) {

      System.out.println("Adulto en misión: sobrevivir al café diario.");

    } else {

      System.out.println("¡Leyenda viva! Sabes más que Google.");

    }

    sc.close();
  }
}
