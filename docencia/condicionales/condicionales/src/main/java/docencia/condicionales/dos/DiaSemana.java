package docencia.condicionales.dos;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @version 1.0
 * @date 2025-09-28
 * @brief Programa que pide un número del 1 al 7 y muestra el día de la semana correspondiente.
 * @version 1.1
 * @bug No se han encontrado bugs.
 */

 public class DiaSemana {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         String[] semana = {"Lunes", "Martes", "Miércoles", "Jueves" , "Viernes", "Sábado", "Domingo"};
         
         while (true) {
             System.out.print("Ingresa un número (1-7) o 0 para salir: ");
             int dia = sc.nextInt();
             
             if (dia == 0) { 
                 System.out.println("Saliendo del programa...");
                 break; 
             }
             else if (dia < 1 || dia > 7) {
                 System.out.println("ERROR: Ese número no corresponde con un día de la semana.");
             } 
             else {
                 System.out.println("El día es: " + semana[dia - 1]);
             }
         }
 
         sc.close();
     }
 }
 
