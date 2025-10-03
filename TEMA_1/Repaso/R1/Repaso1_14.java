import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Declara dos variables de tipo boolean: una que indique si una persona 
 * tiene licencia de conducir y otra si posee un vehículo. Muestra ambas variables.
 */

public class Repaso1_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Tienes licencia de conducir? (si/no):");
        String respuestaLicencia = sc.nextLine().toLowerCase();
        boolean tieneLicencia = false;
        if (respuestaLicencia.equals("si")) {
            tieneLicencia = true;
        } else {
            tieneLicencia = false;
        }

        System.out.println("¿Posees un vehículo? (si/no):");
        boolean poseeVehiculo = false;
        String respuestaVehiculo = sc.nextLine().toLowerCase();
        if (respuestaVehiculo.equals("si")) {
            poseeVehiculo = true;
        } else {
            poseeVehiculo = false;
        }

        System.out.println("Tiene licencia de conducir: " + tieneLicencia);
        System.out.println("Posee un vehículo: " + poseeVehiculo);

        sc.close();
    }

}
