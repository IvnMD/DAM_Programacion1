package docencia.condicionales.tres;

import java.util.Scanner;

/**
* @autor Ivan Mesa
* @date 29/09/2025
* @version 1.0
* @Bugs No hay bugs conocidos
* @Brief Ejecuta operación + - * / sobre dos números.
*        Variables: a, b (float/int), op (char/string).
*        Reglas:
*
*        op='+' → a+b
*        op='-' → a-b
*        op='*' → a*b
*        op='/' → si b!=0 entonces a/b else Error: división por cero
*
*        Ejemplos:
*
*        a=8, b=2, op='+' → 10
*        a=8, b=0, op='/' → Error: división por cero Bonus: Añade
*        exponenciación ^ y módulo %
*/

public class MiniCalculadora {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);

   float numero1 = 0, numero2 = 0;
   String operacion;

    System.out.println("Introduce el primer número: ");
    numero1 = sc.nextFloat();
    System.out.println("Introduce el segundo número: ");
    numero2 = sc.nextFloat();
    System.out.println("Introduce la operación (+, -, *, /, ^, %): ");
    operacion = sc.nextLine();


    switch (operacion) {
        case "+":
            System.out.println("Resultado: " + (numero1 + numero2));
            break;
        case "-":
            System.out.println("Resultado: " + (numero1 - numero2));
            break;
        case "*":
            System.out.println("Resultado: " + (numero1 * numero2));
            break;
        case "/":
            if (numero2 != 0) {
                System.out.println("Resultado: " + (numero1 / numero2));
            } else {
                System.out.println("Error: división por cero");
            }
            break;
        case "^":
            System.out.println("Resultado: " + Math.pow(numero1, numero2));
            break;
        case "%":
            if (numero2 != 0) {
                System.out.println("Resultado: " + (numero1 % numero2));
            } else {
                System.out.println("Error: módulo por cero");
            }
            break;
        default:
            System.out.println("Operación no válida");
            break;
    }
 }

}
