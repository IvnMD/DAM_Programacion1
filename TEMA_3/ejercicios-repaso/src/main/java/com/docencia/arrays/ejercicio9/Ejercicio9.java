package com.docencia.arrays.ejercicio9;

public class Ejercicio9 {
    /**
     * Devuelve un String uniendo con '-' usando for. Si null o vacío, devuelve "".
     */
    public static String concatenarConGuion(String[] palabras) {
        if(palabras == null|| palabras.length == 0){
            return "";
        }
        return String.join("-", palabras);
    }

    

    public static void main(String[] args) {
        System.out.println("Ejercicio9 listo para implementar.");
    }
}
