package com.docencia.arrays.ejercicio6;

public class Ejercicio6 {
    /**
     * Devuelve la media entera (suma/longitud). Si es null o vacío, devuelve 0.
     */
    public static int mediaEntera(int[] numeros) {
        if(numeros == null || numeros.length==0){
            return 0;
        }
        int resultado = 0;
        for (int i = 0; i < numeros.length; i++) {
            resultado += numeros[i];
        }
        return resultado/numeros.length;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio6 listo para implementar.");
    }
}
