package TEMA_1.Repaso.R3;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 03/10/25
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Crea un método que tome un array de enteros y devuelva la suma de todos sus elementos.
 */

public class Repaso3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] enteros = {1,2,3,4,5,6,7,8,9,10};
        int totalSuma = enteros[0];
        
        for (int i = 1; i < enteros.length; i++){
            totalSuma += enteros[i];
        }
        System.out.println("El total de la suma del array es " + totalSuma);
        sc.close();
    }

}
