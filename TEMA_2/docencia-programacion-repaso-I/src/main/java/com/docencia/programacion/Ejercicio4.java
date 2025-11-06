package com.docencia.programacion;

/**
 * @author IvnMD
 * @since 06/11/25
 * @version 1.0.0
 * @brief Operaciones basicas de rectangulo: area y perimetro.
 */

public class Ejercicio4 {
    public static int area(int base, int height) {
        if (base <= 0 || height <=0){
            return 0;
        }
        int resultado = base * height;
        return resultado;
    }

    public static int perimeter(int base, int height) {
        // TODO implementar
        return -1;
    }
}
