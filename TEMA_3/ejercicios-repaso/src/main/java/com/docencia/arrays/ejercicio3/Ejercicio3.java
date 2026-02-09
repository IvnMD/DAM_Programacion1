package com.docencia.arrays.ejercicio3;

public class Ejercicio3 {
    /**
     * Cuenta cuántos elementos del array son pares.
     */
    public static int contarPares(int[] numeros) {
        if (numeros == null || numeros.length==0) {
            return 0;
        }
        int resultado = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]%2 == 0) {
                resultado++;
            }
        }
        return resultado   ;
        
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio3 listo para implementar.");
    }

}