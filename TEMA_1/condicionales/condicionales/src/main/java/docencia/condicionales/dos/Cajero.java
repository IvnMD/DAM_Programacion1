package TEMA_1.condicionales.condicionales.src.main.java.docencia.condicionales.dos;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @version 1.0
 * @date 25-09-28
 * @brief Programa que simula un cajero automático con opciones para consultar saldo, depositar y retirar dinero.
 * @version 1.1
 * @bug No se han encontrado bugs.
 */

public class Cajero {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);

        float saldo = 0f;
        int entrada = 0;
        float operacion = 0f;

        do {
            System.out.println("\n===== CAJERO AUTOMÁTICO =====");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            entrada = sc.nextInt();

            switch(entrada) {
                case 1: 
                    System.out.printf("Su saldo actual es: " + saldo);
                    break;

                case 2: 
                    System.out.print("¿Cuánto dinero desea depositar? ");
                    operacion = sc.nextFloat();
                    if (operacion <= 0) {
                        System.out.println("El depósito debe ser mayor a 0.");
                    } else {
                        saldo += operacion;
                        System.out.printf("Depósito realizado. Su nuevo saldo es: " + saldo);
                    }
                    break;

                case 3: 
                    System.out.print("¿Cuánto dinero desea retirar? ");
                    operacion = sc.nextFloat();
                    if (operacion <= 0) {
                        System.out.println("El retiro debe ser mayor a 0.");
                    } else if (operacion > saldo) {
                        System.out.println(" Fondos insuficientes.");
                    } else {
                        saldo -= operacion;
                        System.out.printf("Retiro realizado. Su nuevo saldo es: " + saldo);
                    }
                    break;

                case 4: 
                    System.out.println("Hasta pronto.");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
        } while (entrada != 4);

        sc.close();
    }
}

