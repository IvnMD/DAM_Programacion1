package com.docencia.herencia.ejercicio2;

import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Vehiculo {

    private UUID id;
    private String marca;
    private String modelo;

    public Vehiculo (UUID id){
        this.id = id == null ? UUID.randomUUID() : id; 
    }

    protected Vehiculo(UUID id, String marca, String modelo) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public UUID getId() { return id; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract int ruedas();

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
        Vehiculo other = (Vehiculo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + "]";
    }

    
}
