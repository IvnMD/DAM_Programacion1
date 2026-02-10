package com.docencia.arrays.ejercicio4;

public class Ejercicio4 {
    /**
     * Devuelve un nuevo array con los elementos en orden inverso (sin modificar el original).
     */
    public static int[] invertir(int[] numeros) {
        if (numeros == null || numeros.length==0){
            throw new IllegalArgumentException();
        }
        int[] inverso = new int[numeros.length];
        for (int i = 0; i < inverso.length; i++) {
            inverso [i] = numeros[numeros.length-1-i];
        }
        return inverso;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio4 listo para implementar.");
    }
}
