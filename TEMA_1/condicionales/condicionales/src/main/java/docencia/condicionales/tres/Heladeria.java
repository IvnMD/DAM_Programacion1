package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 29/09/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Muestra el sabor según opción 1–3.
 *        Variables: opcion (entero).
 *        Reglas (switch):
 * 
 *        1 → Vainilla
 * 
 *        2 → Chocolate
 * 
 *        3 → Fresa
 * 
 *        Otro → Opción no válida
 * 
 *        Ejemplos:
 * 
 *        opcion=1 → Vainilla
 *        opcion=3 → Fresa
 *        opcion=5 → Opción no válida
 * 
 *        Bonus: Añade precios y calcula total.
 */

public class Heladeria {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0;
        int bolas = 0;
        float precio = 0f;
        float total = 0f;
        boolean salidaMenu = false;

        do {
            System.out.println("\nElija un sabor de helado: \n" +
                                "1 → Vainilla - 1,5€ x bola\n" + 
                                "2 → Chocolate 2,50€ por bola\n" + 
                                "3 → Fresa 2,00€ por bola.\n" +
                                "4 → Salir del menú.");
            opcion = sc.nextInt();
            precio = 0;
            switch (opcion) {
                case 1:
                    System.out.println("Ha elegido vainilla");
                    System.out.println("¿Cuantas bolas quieres?");
                    bolas = sc.nextInt();
                    precio = 1.5f * bolas;
                    total += precio;
                    break;
                case 2:
                    System.out.println("Ha elegido chocolate");
                    System.out.println("¿Cuantas bolas quieres?");
                    bolas = sc.nextInt();
                    precio = 2.5f * bolas;
                    total += precio;
                    break;
                
                case 3:
                    System.out.println("Ha elegido fresa");
                    System.out.println("¿Cuantas bolas quieres?");
                    bolas = sc.nextInt();
                    precio = 2f * bolas;
                    total += precio;
                    break;
                case 4: System.out.println("El total a pagar es " + total + "€.");
                    salidaMenu = true;
                    break;
                
                default: System.out.println("Error de entrada, intentelo de nuevo.");
                    break;
            }
        } while (salidaMenu = false);
        System.out.println("Gracias por su visita.");
        sc.close();
    }
}
