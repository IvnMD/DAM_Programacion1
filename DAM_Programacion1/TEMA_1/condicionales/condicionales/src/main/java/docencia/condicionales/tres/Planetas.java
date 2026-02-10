package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * @autor Ivan Mesa
 * @date 29/09/2025
 * @version 1.0
 * @Bugs No hay bugs conocidos
 * @Brief De número 1–8 a nombre del planeta (desde el Sol). Variables:
 * n(entero). Reglas (ejemplo):
 *
 * 1→Mercurio, 2→Venus, 3→Tierra, 4→Marte, 5→Júpiter, 6→Saturno, 7→Urano,
 * 8→Neptuno
 *
 *  *Ejemplos:
 *
 *  *n=3 → Tierra n=5 → Júpiter n=9 → Valor inválido
 *
 *  *Bonus: Añade datos rápidos (anillos, tipo, etc.).
 */
public class Planetas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int numero = 0;
    
        System.out.println("Introduce un número del 1 al 8: ");
        numero = sc.nextInt();
    
        switch (numero) {
        case 1:
            System.out.println("Mercurio: Planeta más cercano al Sol, sin atmósfera significativa.");
            break;
        case 2:
            System.out.println("Venus: Segundo planeta desde el Sol, con una densa atmósfera de dióxido de carbono.");
            break;
        case 3:
            System.out.println("Tierra: Nuestro hogar, el tercer planeta desde el Sol, con agua líquida y vida.");
            break;
        case 4:
            System.out.println("Marte: El planeta rojo, cuarto desde el Sol, conocido por su superficie rocosa y polvo.");
            break;
        case 5:
            System.out.println("Júpiter: El gigante gaseoso más grande del sistema solar, quinto desde el Sol, con una gran mancha roja.");
            break;
        case 6:
            System.out.println("Saturno: Sexto planeta desde el Sol, famoso por sus impresionantes anillos compuestos de hielo y roca.");
            break;
        case 7:
            System.out.println("Urano: Séptimo planeta desde el Sol, un gigante helado con un eje de rotación muy inclinado.");
            break;
        case 8:
            System.out.println("Neptuno: Octavo planeta desde el Sol, un gigante helado conocido por sus fuertes vientos y su color azul intenso.");
            break;
        default:
            System.out.println("Valor inválido. Por favor, introduce un número entre 1 y 8.");
            break;
        }
    
        sc.close();
    }

}
