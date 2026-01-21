package com.docencia.herencia.ejercicio5;

import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Figura {

    private UUID id;
    private String color;

    protected Figura(UUID id, String color) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.color = color;
    }

    public UUID getId() { return id; }
    public String getColor() { 
        if (color == null || color.isBlank()){
            throw new IllegalArgumentException();
        }
        return color; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract double area();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Figura other = (Figura) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Figura [id=" + id + ", color=" + color + "]";
    }

    
}
