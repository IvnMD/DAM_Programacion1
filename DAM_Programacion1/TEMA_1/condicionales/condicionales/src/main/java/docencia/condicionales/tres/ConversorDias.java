package docencia.condicionales.tres;

import java.util.Scanner;

/**
* @author Ivan Mesa
* @date 29/08/2025
* @version 1.0
* @bug Sin bugs conocidos
* @brief De número 1–7 a día de la semana.
*        Variables: n (entero).
*        Reglas:
*
*        1→Lunes, 2→Martes, …, 7→Domingo Ejemplos:
*        n=1 → Lunes
*        n=6 → Sábado
*        n=8 → Valor inválido
*       
*        Bonus: Acepta 0→Domingo si estás en modo
*        calendario clásico.
*
*/

public class ConversorDias {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int dia = 0;
       System.out.println("Introduce un número del 1 al 7 (0 para domingo): ");
        dia = sc.nextInt();

       switch (dia) {
           case 1: System.out.println("Lunes");
               break;
           case 2: System.out.println("Martes");
               break;
           case 3: System.out.println("Miercoles");
               break;
           case 4: System.out.println("Jueves");
               break;
           case 5: System.out.println("Viernes");
               break;
           case 6: System.out.println("Sabado");
               break;
           case 7:
           case 0:
           System.out.println("Domingo");
               break;           
      
           default: System.out.println("Valor invalido.");
               break;
       }
       sc.close();
   }

}
