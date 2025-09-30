package docencia.condicionales.uno;

import java.util.Scanner;

/**
 * @author I.Mesa
 * @date 24/09/25
 * @class AdivinaAnimal
 *        Realiza al usuario una serie de preguntas con si o no 
 *        como respuesta y segun lo que responda le hace preguntas por
 *        pantalla por para tratar de adivinar el animal en el que piensa.
 */

public class AdivinaAnimal {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Tiene alas? (sí/no): ");
        String alas = sc.nextLine().toLowerCase();

        if (alas.equals("si") || alas.equals("sí") ) {
            System.out.println("Podría ser un pájaro… ¡o un dragón!");
        }
        else {
            System.out.print("¿Vive en el agua? (sí/no): ");
            String agua = sc.nextLine().toLowerCase();

            if (agua.equals("si") || agua.equals("sí") ){
                System.out.println("Seguro que eres un pez, o una sirena secreta.");
            }
            else {
                System.out.println("Mmm... tal vez un perro travieso.");
            }
        }

        
        sc.close();
    }
}
