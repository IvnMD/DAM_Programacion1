package com.docencia.programacion;

/**
 * @author IvnMD
 * @since 06/11/25
 * @version 1.0.0
 * @brief Operaciones basicas de rectangulo: area y perimetro.
 */

public class Ejercicio4 {
    /**
     * Calcula el area de un rectangulo.
     * @param base Base del rectangulo.
     * @param height Altura del rectangulo.
     * @return Area del rectangulo. Si la base o la altura son menores o iguales a 0, devuelve 0.
     */
    public static int area(int base, int height) {
        if (base <= 0 || height <=0){
            return 0;
        }
        int resultado = base * height;
        return resultado;
    }
    /**
     * Calcula el perimetro de un rectangulo.
     * @param base Base
     * @param height Altura
     * @return Perimetro del rectangulo. Si la base o la altura son menores a 0, devuelve 0.
     */
    public static int perimeter(int base, int height) {
<<<<<<< HEAD
            if (base < 0 || height < 0){
            return 0;
        }
        return (base*2+height*2);
=======
        if (base <= 0 || height <=0){
            return 0;
        }
        // int resultado = base * height;
        return (base * height) * 2;
>>>>>>> 3071fa5 (Espero que esto no se suba)
    }
}
