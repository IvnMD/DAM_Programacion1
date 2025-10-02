package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 29/09/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Simula opciones básicas de un cajero. 
 * Variables: saldo (float), op (entero), monto (float). 
 * Reglas:
 * 1→Ver saldo 
 * 2→Depositar: saldo += monto 
 * 3→Retirar: si monto <= saldo entonces saldo -= monto 
 * else Error: fondos insuficientes Otro→Opción no válida
 * 
 * Ejemplos:
 * 
 * saldo=100, op=1 → Saldo: 100 saldo=100, op=2, monto=50 → Saldo: 150
 * saldo=100, op=3, monto=200 → Error: fondos insuficientes
 *
 */
public class CajeroDos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        float saldo = 1000.0f;
        int operacion = 0;
        do {
        System.out.println("\nBienvenido al cajero automático\n" +
                        "Seleccione una opción:\n" +
                        "1. Ver saldo\n" +
                        "2. Depositar\n" +
                        "3. Retirar\n" +
                        "4. Salir\n");
        operacion = sc.nextInt();
        float total;

        switch (operacion) {
            case 1:
                System.out.printf("Su saldo actual es: %.2f\n", saldo);
                break;
            case 2:
                System.out.print("Ingrese el total a depositar: ");
                total = sc.nextFloat();
                if (total <= 0) {
                    System.out.println("El total a depositar debe ser mayor que cero.");
                } else {
                    saldo += total;
                    System.out.printf("Depósito exitoso. Su nuevo saldo es: %.2f\n", saldo);
                }
                break;
            case 3:
                System.out.print("Ingrese el total a retirar: ");
                total = sc.nextFloat();
                if (total <= 0) {
                    System.out.println("El total a retirar debe ser mayor que cero.");
                } else if (total > saldo) {
                    System.out.println("Fondos insuficientes.");
                } else {
                    saldo -= total;
                    System.out.printf("Retiro exitoso. Su nuevo saldo es: %.2f\n", saldo);
                }
                break;
            case 4:
                System.out.println("Gracias por usar el cajero automático.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
        } while (operacion != 4);
        sc.close();

    }

}
