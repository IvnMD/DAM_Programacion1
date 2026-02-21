package com.docencia.herencia.ejercicio9;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Producto {

    private UUID id;
    private String nombre;
    private double precio;

    protected Producto(UUID id, String nombre, double precio) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract String categoria();

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Producto))
            return false;
        Producto other = (Producto) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
    }
}
