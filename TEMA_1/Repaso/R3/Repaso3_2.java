package TEMA_1.Repaso.R3;


/**
 * @author Ivan Mesa
 * @date 03/10/25
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Crea un método que tome un array de enteros y devuelva el valor mínimo y máximo en el array.
 */

public class Repaso3_2 {
    public static void main(String[] args) {
        
        int[] enteros = {3, 7, 2, 8};
        int maximo = enteros[0];
        int minimo = enteros[0];
        
        for (int i = 1; i < enteros.length; i++){
            if (maximo < enteros[i]){
                maximo = enteros[i];
            }
            if (minimo > enteros[i]){
                minimo = enteros[i];
            }
        }
        System.out.println("El maximo es " + maximo + " y el minimo es " + minimo);
    }

}
