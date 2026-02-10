import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 01/10/2025
 * @version 1.0
 * @bug Sin bugs conocidos
 * @brief Declara una variable de tipo float para almacenar el valor de pi (3.1416) y otra para el radio de un círculo. Calcula el área del círculo usando la fórmula Área = pi * radio * radio.
 * 
 */

public class Repaso1_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float pi = 3.1416f;
        System.out.println("\nIntroduce el radio del circulo: ");
        float radio = sc.nextFloat();
        float area = pi * radio * radio;
        System.out.println("El area del circulo es: " + area);
        System.out.println("El perimetro del circulo es: " + (2 * pi * radio) );

        sc.close();
        }


}


