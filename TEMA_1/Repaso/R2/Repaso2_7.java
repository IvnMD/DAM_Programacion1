import java.util.Scanner;   

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Escribe un programa que tome un número del 1 al 12 y muestre el nombre del mes correspondiente
 *
 */

public class Repaso2_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        while (true) {
            System.out.print("Ingresa un número (1-12) o 0 para salir: ");
            int mes = sc.nextInt();

            if (mes == 0) {
                System.out.println("Saliendo del programa...");
                break;
            } else if (mes < 1 || mes > 12) {
                System.out.println("ERROR: Ese número no corresponde con un mes del año.");
            } else {
                System.out.println("El mes es: " + meses[mes - 1]);
            }
        }

        sc.close();
    }

}
