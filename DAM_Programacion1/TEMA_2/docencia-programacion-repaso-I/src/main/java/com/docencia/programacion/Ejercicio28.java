package com.docencia.programacion;
/**
 * @author IvnMD
 * @date 07/11/25
 * @version 1.0.0
 * @brief Clase para representar un punto en 2D y calcular suma, magnitud y distancia
 */
public class Ejercicio28 {
    private final double x;
    private final double y;

    // Constructor vacío: usa valores por defecto
    public Ejercicio28() {
        this(0, 0); // llama al constructor con parámetros
    }
    /**
     * Constructor con parámetros
     * @param x Coordenada x
     * @param y Coordenada y
     */
    public Ejercicio28(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Funcion que suma dos vectores
     * @param other Segundos parametros del vector
     * @return Suma de ambos vectores
     */
    public Ejercicio28 add(Ejercicio28 other) {
        Ejercicio28 suma = new Ejercicio28(this.x + other.x, this.y + other.y);
        return suma;
    }
    /**
     * Funcion que calcula el modulo de un vector
     * @return Modulo del vector
     */
    public double magnitude() {
        double resultado = Math.sqrt((Math.pow(x,2)) + Math.pow(y,2));
        return resultado;
    }
    /**
     * Funcion que calcula la distancia entre dos vectores
     * @param other Segundo vector a introducir
     * @return Distancia entre ambos vectores
     */
    public double distanceTo(Ejercicio28 other) {
        Ejercicio28 resta = new Ejercicio28(this.x - other.x, this.y - other.y);
        return resta.magnitude();
    }
    /**
     * Getter de X
     * @return Devuelve el valor de X
     */
    public double getX() {
        return this.x;
    }
    /**
     * Getter de Y
     * @return Devuelve Y
     */
    public double getY() {
        return this.y;
    }
}
