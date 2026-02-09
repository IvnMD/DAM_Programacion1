package org.docencia;

import java.util.Scanner;

/**
 * @author Ivan Mesa Dominguez
 * @date 03/10/2025
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Preguntar por un numero entero y decidir si es positivo, negativo o
 * cero. Mostrar el dia de la semana correspondiente (1 a 7) Si es 8 o mas,
 * devolver mensaje de error
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero: \n");
        int numero = sc.nextInt();
        String[] diasSemana = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};

        if (numero == 0) {
            System.out.println("Piensa un nuevo numero viajero del tiempo");
        } else if (numero > 7) {
            System.out.println("El numero es positivo. ¡Ese día no existe, viajero del tiempo!");
        } else if (numero < -0) {
            System.out.println("El numero es negativo, viajero del tiempo");
        } else if (numero > 0 && numero < 8) {
            System.out.println("El numero es positivo y es " + diasSemana[numero - 1]);
        }
        sc.close();
    }

}
