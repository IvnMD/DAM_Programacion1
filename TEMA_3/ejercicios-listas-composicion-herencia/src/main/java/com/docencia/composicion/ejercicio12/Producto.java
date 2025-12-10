package com.docencia.composicion.ejercicio12;
import java.util.Objects;

public class Producto {
    private String nombre;
    private double precio;

    /**
     * Constructor vacio/por defecto
     */
    public Producto(){}

    /**
     * Constructor con parámetros
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     */
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Getters y Setters
     */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Métodos sobrescritos de la clase Object
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre) && precio == producto.precio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", precio='" + getPrecio() + "'" +
            "}";
    }
    



}
