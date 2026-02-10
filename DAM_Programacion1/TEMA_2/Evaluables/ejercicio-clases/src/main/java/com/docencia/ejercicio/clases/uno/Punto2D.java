package com.docencia.ejercicio.clases.uno;

import java.util.Objects;
/**
 * Clase Pundo2D
 * @author Ivan Mesa Dominguez
 * @since 24/10/25
 * @version 1.0
 * @brief Declaracion de una clase que declara puntos en espcios bidimensionales
 */

public class Punto2D {
    private double x;
    private double y;
    /**
     * Constructor vacio
     */
    public Punto2D() {
    
    }
    /**
     * Constructor parametrico
     * @param x punto X
     * @param y punto Y
     */
    public Punto2D(double x, double y) {
        this.x = x;
        this.y = y;

    }
    /**
     * Getters y Setters de los atributos
     * 
     */
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    /**
     * Metodo equals para comparar entre instancias de la clase
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Punto2D)) {
            return false;
        }
        Punto2D punto2D = (Punto2D) o;
        return x == punto2D.x && y == punto2D.y;
    }
    /**
     * Metodo hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Metodo toString() para poder imprimir el contenido de las clases y no su direccion de memoria. 
     */    
    @Override
    public String toString() {
        return "(" +
            " x=" + getX()  +
            ", y=" + getY() +
            ")";
    }
    
}

