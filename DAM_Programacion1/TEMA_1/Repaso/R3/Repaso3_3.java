package TEMA_1.Repaso.R3;


/**
 * @author Ivan Mesa
 * @date 03/10/25
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Implementa un método que calcule el promedio de los valores en un array de enteros.
 */

public class Repaso3_3 {
    public static void main(String[] args) {
        
        int[] enteros = {4, 8, 10};
        int contador = 1;
        int promedio = enteros[0];

        for (int i = 1; i < enteros.length; i++){
            promedio += enteros[i];
            contador++;
        }
        promedio /= contador;
        System.out.println("El promedio es " + promedio);
    }

}

// public class Ejercicio3 {
//     public static void main(String[] args) {
//         int[] array = {4, 8, 10};
//         int suma = 0;
        
//         for (int i = 0; i < array.length; i++) {
//             suma += array[i];
//         }
        
//         double media = (double) suma / array.length;
//         System.out.println("Media del array: " + media);
//     }
// }
