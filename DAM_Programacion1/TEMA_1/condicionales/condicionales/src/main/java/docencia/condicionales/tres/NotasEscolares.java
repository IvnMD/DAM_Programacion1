package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @version 1.0
 * @date 2025-09-28
 * @brief Programa que pide las notas de un estudiante y determina si ha
 * aprobado o no.
 * @bug No se han encontrado bugs.
 * 
 * Descripción: Clasifica una nota (0–10) en categorías.
 * Variables: nota (float o entero), categoria (string).
 * Reglas (ejemplo):
 * 
 *  nota < 5 → Suspenso
 *  5 <= nota < 7 → Aprobado
 *  7 <= nota < 9 → Notable
 *  9 <= nota <= 10 → Sobresaliente
 * Bonus: Valida que la nota esté entre 0 y 10; si no, error.
 */


public class NotasEscolares {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float nota = 0.0f;
        System.out.println("Introduce la nota del estudiante (0-10): ");
        nota = sc.nextFloat();

        if(nota < 0 || nota > 10){
            System.out.println("ERROR: La nota debe estar entre 0 y 10.");
        } else if(nota < 5){
            System.out.println("Suspenso");
        } else if(nota < 7){
            System.out.println("Aprobado");
        } else if(nota < 9){
            System.out.println("Notable");
        } else {
            System.out.println("Sobresaliente");
        }
        
        sc.close();
    }
}
