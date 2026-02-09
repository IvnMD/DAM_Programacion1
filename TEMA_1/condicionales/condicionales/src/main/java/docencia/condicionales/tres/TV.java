package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @autor Ivan Mesa
 * @date 29/09/2025
 * @version 1.0
 * @Bugs No hay bugs conocidos
 * @Brief Descripción: Dado un canal, muestra su categoría. 
 * Variables: canal (entero). 
 * Reglas (ejemplo):
 * 
 *  5→Deportes, 7→Noticias, 11→Películas, default→No configurado
 * 
 *  Ejemplos:
 * 
 *  canal=5 → Deportes canal=2 → No configurado
 * 
 *  Bonus: Añade guía de horarios (estructura de datos).
 */
public class TV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int canal = 0;
        String[] guiaHorarios = new String[12];

        guiaHorarios[5] = "5:00 - 6:00 Fútbol\n6:00 - 7:00 Baloncesto\n7:00 - 8:00 Tenis";
        guiaHorarios[7] = "5:00 - 6:00 Noticias Internacionales\n6:00 - 7:00 Noticias Locales\n7:00 - 8:00 Documentales";
        guiaHorarios[11] = "5:00 - 6:30 Película A\n6:30 - 8:00 Película B";

        System.out.println("Introduce un canal (número entero): ");
        canal = sc.nextInt();

        switch (canal) {
            case 5:
                System.out.println("Deportes.");
                System.out.println("Guía de horarios:\n" + guiaHorarios[5]);
                break;
            case 7:
                System.out.println("Noticias.");
                System.out.println("Guía de horarios:\n" + guiaHorarios[7]);
                break;
            case 11:
                System.out.println("Peliculas.");
                System.out.println("Guía de horarios:\n" + guiaHorarios[11]);
                break;
            default:
                System.out.println("No configurado.");
                break;
        }

        sc.close();
    }

}
