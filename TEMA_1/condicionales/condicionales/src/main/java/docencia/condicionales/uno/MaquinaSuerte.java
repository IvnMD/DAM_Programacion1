package docencia.condicionales.uno;

import java.util.Scanner;

/**
 * @author I.Mesa
 * @date 24/09/25
 * @class MaquinaSuerte
 *        Pregunta al usuario por pantalla un numero y segun la respuesta
 *        devuelve una frase divertida.
 */

public class MaquinaSuerte {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // System.out.println("Ingresa un numero y recibe tu predicción.");
        // int numero = sc.nextInt();

        // if (numero == 1) {
        //     System.out.println("Hoy encontrarás una galleta… ¡y será deliciosa!");
        // }
        // else if (numero == 2){
        //     System.out.println("Un pato te mirará raro en la calle."); 
        // }
        // else if (numero == 3) {
        //     System.out.println("Tendrás suerte… si compartes tu comida.");
        // }
        // else {
        //     System.out.println("Número misterioso: ¡prepárate para lo inesperado!");
        // }


        System.out.println("Ingresa un numero y recibe tu predicción.");
        String numero = sc.nextLine();

        if (numero.equals("1")) {
            System.out.println("Hoy encontrarás una galleta… ¡y será deliciosa!");
        }
        else if (numero.equals("2")){
            System.out.println("Un pato te mirará raro en la calle."); 
        }
        else if (numero.equals("3")) {
            System.out.println("Tendrás suerte… si compartes tu comida.");
        }
        else {
            System.out.println("Número misterioso: ¡prepárate para lo inesperado!");
        }

        
        sc.close();
    }
}
