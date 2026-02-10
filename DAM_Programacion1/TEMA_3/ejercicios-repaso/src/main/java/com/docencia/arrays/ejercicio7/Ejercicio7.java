package com.docencia.arrays.ejercicio7;

public class Ejercicio7 {
    /**
     * Devuelve true si ambos arrays tienen la misma longitud y mismos valores en cada posición.
     */
    public static boolean sonIguales(int[] a, int[] b) {
        if (a == null || a.length==0 || b ==null || b.length == 0){
            throw new ExceptionInInitializerError();
        }
        if(a.length!=b.length){
            return false;
        }
        for (int i = 0; i < b.length; i++) {
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio7 listo para implementar.");
    }
}
