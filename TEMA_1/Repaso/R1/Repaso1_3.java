package TEMA_1.Repaso.R1;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Crea una variable char que almacene la primera letra de tu nombre y muéstrala por pantalla.
 * 
 */

public class Repaso1_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce un tu nombre y devolvere la primera letra: ");
        String nombre = sc.next();
        char inicial = nombre.charAt(0);

        System.out.println("La primera letra es: " + inicial);

        sc.close();
    }

}
