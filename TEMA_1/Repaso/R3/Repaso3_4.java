package TEMA_1.Repaso.R3;

/**
 * @author Ivan Mesa
 * @date 03/10/25
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Escribe un método que reciba un array de enteros y devuelva otro array con los elementos en orden inverso.
 */

public class Repaso3_4 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] inverso = new int [array1.length];
        
        for (int i = 0; i < array1.length; i++){
            inverso [i] = array1[array1.length -1 - i];
        }
        System.out.println("El invertido es: ");
        for (int j = 0; j < inverso.length; j++){
            System.out.println(inverso[j] + " ");
        }
    }

}
