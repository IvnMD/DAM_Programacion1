package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 29/09/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Se introduce un año y se calcula si fue bisiesto o no.
 *        Variables: anio (entero).
 *        Reglas estándar:
 * 
 *        Es bisiesto si (anio % 4 == 0 y anio % 100 != 0) o (anio % 400 == 0).
 * 
 *        Ejemplos:
 * 
 *        anio=2000 → Bisiesto
 *        anio=1900 → No bisiesto
 *        anio=2024 → Bisiesto
 * 
 *        Bonus: Mensaje especial si es múltiplo de 400.
 */

public class Bisiesto {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);

		int anyo = 0;

		System.out.println("Introduce el año: ");
		anyo = sc.nextInt();

		if (anyo % 4 == 0 && anyo % 100 !=0) {
			System.out.println("Es bisiesto.");
		} else if (anyo % 400 ==0) {
			System.out.println("Es bisiesto y ademas es multiplo de 400");
		} 
		else {
			System.out.println("No bisiesto.");
		}
		sc.close();
	}
}
