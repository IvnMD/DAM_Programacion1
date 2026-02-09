package com.docencia.programacion;

public class Ejercicio9 {
    /**
     * Funcion que calcula el valor absoluto
     * @param x Valor de entrada (tipo int)
     * @return Valor absoluto
     */
    public static int absValue(int x) {
        return Math.abs(x);
    }
    /**
     * Funcion que calculo el maximo de dos numero
     * @param a Primer valor de entrada
     * @param b Segundo valor de entrada
     * @return Devuelve el valor mas alto de los dos valores introducidos
     */
    public static int maxOfTwo(int a, int b) {
        // if (a<b){
        //     return a;  //! Metodo de picar codigo
        // }
        //     return b;

        return Math.max(a,b);
    }
    /**
     * Metodo que calcula la distancia entre dos puntos
     * @param x1 Posicion en el eje X del punto 1
     * @param y1 Posicion en el eje y del punto 1
     * @param x2 Posicion en el eje X del punto 2
     * @param y2 Posicion en el eje y del punto 2
     * @return Distancia entre los dos puntos en un plano 2D
     */
    public static double distance2D(double x1, double y1, double x2, double y2) {
        double Distancia = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
        return Distancia;
    }
}
