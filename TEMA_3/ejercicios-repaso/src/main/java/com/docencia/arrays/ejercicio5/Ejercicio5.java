package com.docencia.arrays.ejercicio5;

public class Ejercicio5 {
    /**
     * Devuelve el indice de objetivo o -1 si no esta.
     * @param numeros array de numeros
     * @param objetivo numero a buscar en el array
     */
    public static int indiceDe(int[] numeros, int objetivo) {
        if(numeros == null || numeros.length==0){
            return -1;
        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == objetivo){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio5 listo para implementar.");
    }
}
