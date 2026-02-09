package TEMA_1.Repaso.R3;

/**
 * @author Ivan Mesa
 * @date 03/10/25
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Implementa un método que busque si un número específico está presente en un array.
 */

public class Repaso3_5 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int objetivo = 3;
        boolean encontrado = false;

        for (int i = 0; i < array.length; i++){
            if (objetivo == array[i]){
                encontrado = true;
            }
        }
        System.out.println(encontrado);
    }

}
