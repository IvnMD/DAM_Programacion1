package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @autor Ivan Mesa
 * @date 29/09/2025
 * @version 1.0
 * @Bugs No hay bugs conocidos
 * @Brief De número 1–12 a nombre del mes. 
 * Variables: mes (entero). 
 * Reglas:
 * 
 *  1→Enero, …, 12→Diciembre
 * 
 *  Ejemplos:
 * 
 *  mes=4 → Abril mes=13 → Valor inválido
 * 
 *  Bonus: Devuelve también la estación del año (según hemisferio).
 */
public class MesesAnyo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mes = 0;

        System.out.println("Introduce un número de mes (1-12): ");
        mes = sc.nextInt();

        switch (mes) {
            case 1:
                System.out.println("Enero - Invierno en el hemisferio norte, Verano en el hemisferio sur");
                break;
            case 2:
                System.out.println("Febrero - Invierno en el hemisferio norte, Verano en el hemisferio sur");
                break;
            case 3:
                System.out.println("Marzo - Primavera en el hemisferio norte, Otoño en el hemisferio sur");
                break;
            case 4:
                System.out.println("Abril - Primavera en el hemisferio norte, Otoño en el hemisferio sur");
                break;
            case 5:
                System.out.println("Mayo - Primavera en el hemisferio norte, Otoño en el hemisferio sur");
                break;
            case 6:
                System.out.println("Junio - Verano en el hemisferio norte, Invierno en el hemisferio sur");
                break;
            case 7:
                System.out.println("Julio - Verano en el hemisferio norte, Invierno en el hemisferio sur");
                break;
            case 8:
                System.out.println("Agosto - Verano en el hemisferio norte, Invierno en el hemisferio sur");
                break;
            case 9:
                System.out.println("Septiembre - Otoño en el hemisferio norte, Primavera en el hemisferio sur");
                break;
            case 10:
                System.out.println("Octubre - Otoño");
                break;
            case 11:
                System.out.println("Noviembre - Otoño");
                break;
            case 12:
                System.out.println("Diciembre - Invierno");
                break;
            default:
                System.out.println("Valor inválido: Introduce un número entre 1 y 12.");
                break;
        }

        sc.close();

    }

}
