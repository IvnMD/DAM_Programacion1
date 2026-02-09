package com.docencia.interfaces.ejercicio10;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Drawable.
 */
public class CirculoDrawable implements Drawable {

    private UUID id;
    private double radio;
    private String color;

    public CirculoDrawable(UUID id, double radio, String color) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.radio = radio;
        this.color = color;
    }

    public UUID getId() {
        return id;
    }

    public double getRadio() {
        return radio;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String dibujar() {
        return "Circulo r=" + radio;
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
        CirculoDrawable other = (CirculoDrawable) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "CirculoDrawable [id=" + id + ", radio=" + radio + ", color=" + color + "]";
    }
    
}
