package com.docencia.arrays.ejercicio8;

public class Ejercicio8 {
    /**
     * Cuenta cuántas veces aparece 'valor' en el array.
     */
    public static int contarOcurrencias(int[] numeros, int valor) {
        if(numeros == null || numeros.length==0){
            return -1;
        }
        int resultado = 0;
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] == valor){
            resultado++;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio8 listo para implementar.");
    }
}
