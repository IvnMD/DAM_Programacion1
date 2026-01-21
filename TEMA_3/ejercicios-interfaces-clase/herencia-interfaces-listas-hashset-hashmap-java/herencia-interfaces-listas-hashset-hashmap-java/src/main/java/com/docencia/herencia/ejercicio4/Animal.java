package com.docencia.herencia.ejercicio4;

import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Animal {

    private UUID id;
    private String nombre;

    protected Animal(UUID id, String nombre) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nombre = nombre;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract String sonido();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;

        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", nombre=" + nombre + "]";
    }

    

    
}
