package org.docencia;

/**
 * @author Ivan Mesa Dominguez
 * @date 03/10/2025
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Recorre un array de numeros enteros y muestra:
 *        - Los numeros positivos.
 *        - Los numeros negativos.
 *        - Los ceros encontrados
 *        - Determina el mayor y el menor numero del array.
 */


public class Ejercicio4 {
    public static void main(String[] args) {
        
        int[] array = {-5,0,7,3,-2};
        int mayor = array[0];
        int menor = array[0];

        for (int i = 0; i < array.length; i++){
            if (array[i] == 0){
                System.out.println("Cero detectado = " + array[i]);
            }
            if (array[i] < menor) {
                menor = array[i];
            }
            if (array[i]> mayor){
                mayor = array[i];
            }
            if (array[i] < 0){
                System.out.println("Numero negativo detectado = " + array[i]);
            }
            if (array[i] > 0 ){
                System.out.println("Numero positivo detectado = " + array[i]);
            }

        }
        System.out.println("El mayor es = " + mayor);
        System.out.println("El menor es = " + menor);
        
        
    }
}
