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
        this.x = 0.0;
        this.y = 0.0;
    }

    public Ejercicio28 add(Ejercicio28 other) {
        Ejercicio28 suma = new Ejercicio28(this.x + other.x, this.y + other.y);
        return suma;
    }

    public double magnitude() {
        double resultado = Math.sqrt(x * x + y * y);
        return resultado;
    }

    public double distanceTo(Ejercicio28 other) {
        Ejercicio28 resta = new Ejercicio28(this.x - other.x, this.y - other.y);
        return resta.magnitude();
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
