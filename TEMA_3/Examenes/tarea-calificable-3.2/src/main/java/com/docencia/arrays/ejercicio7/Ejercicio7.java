package com.docencia.arrays.ejercicio7;
/**
 * @author IvnMD
 * @date 09/01/26
 * @version 1.0.0
 * @brief Devuelve true si ambos arrays tienen la misma longitud y mismos valores en cada posicion.
 */

public class Ejercicio7 {
/**
 * Funcion que compara dos arrays
 * @param array1 primer array
 * @param array2 primer array
 * @return Devuelve true si ambos arrays tienen la misma longitud y mismos valores en cada posicion.
 */
    public static boolean sonIguales(int[] array1, int[] array2) {
        if (array1 == null || array2 == null){
        return false;
        }
        if (array1.length != array2.length){
            return false;
        }
        for (int i = 0; i < array2.length; i++) {
            if (array1[i] != array2[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Ejercicio7 listo para implementar.");
    }
}
