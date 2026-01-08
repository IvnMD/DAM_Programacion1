package com.docencia.arrays.ejercicio10;

public class Ejercicio10 {
    /**
     * Devuelve un nuevo array donde los negativos se sustituyen por 0.
     */
    public static int[] normalizarNegativos(int[] numeros) {
        if(numeros == null || numeros.length==0){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i]<0){
                numeros[i] = 0;
            }
        }
        return numeros;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio10 listo para implementar.");
    }
}
