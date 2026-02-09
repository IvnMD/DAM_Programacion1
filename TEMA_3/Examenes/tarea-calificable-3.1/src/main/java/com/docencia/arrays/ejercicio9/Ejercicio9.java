package com.docencia.arrays.ejercicio9;

import java.util.concurrent.ArrayBlockingQueue;
/**
 * @author IvnMD
 * @date 18/12/25
 * @version 1.0.0
 * @brief Ejercicio que solicita devolver un String uniendo con '-' usando for. Si null o vacío, devuelve "".
 */
public class Ejercicio9 {
    // Devuelve un String uniendo con '-' usando for. Si null o vacío, devuelve "".
    
    public static String concatenarConGuion(String[] palabras) {
        if(palabras == null || palabras.length == 0){
            return "";
        }
        String[] copia = new String[palabras.length];
        String palabrasCopia = palabras.toString().trim();
        char iterador= ' ';
        char guion = '-';
        for (int i = 0; i < copia.length; i++) {
            
            

        }
        return palabrasCopia;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio9 listo para implementar.");
    }
}
