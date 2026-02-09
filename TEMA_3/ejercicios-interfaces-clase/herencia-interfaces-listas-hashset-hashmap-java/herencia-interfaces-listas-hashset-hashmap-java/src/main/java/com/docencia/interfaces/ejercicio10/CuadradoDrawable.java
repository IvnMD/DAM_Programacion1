package com.docencia.interfaces.ejercicio10;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Drawable.
 */
public class CuadradoDrawable implements Drawable {

    private UUID id;
    private double lado;
    private String color;

    public CuadradoDrawable(UUID id, double lado, String color) {    
        this.id = id == null ? UUID.randomUUID() : id;
        this.lado = lado;
        this.color = color;
}

    public UUID getId() { return id; }
    public double getLado() { return lado; }
    public String getColor() { return color; }

    @Override
    public String dibujar() {
        return "Cuadrado l=" + lado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CuadradoDrawable other = (CuadradoDrawable) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "CuadradoDrawable [id=" + id + ", lado=" + lado + ", color=" + color + "]";
    }
    
}
