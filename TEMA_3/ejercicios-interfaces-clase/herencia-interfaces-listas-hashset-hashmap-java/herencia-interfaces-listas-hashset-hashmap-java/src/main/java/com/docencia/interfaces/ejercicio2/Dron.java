package com.docencia.interfaces.ejercicio2;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Volador.
 */
public class Dron implements Volador {

    private UUID id;
    private String marca;
    private int bateriaMinutos;

    public Dron(UUID id, String marca, int bateriaMinutos) {   
        this.id = id == null ? UUID.randomUUID() : id;
        this.marca = marca;
        this.bateriaMinutos = bateriaMinutos;

 
}

    public UUID getId() { return id; }
    public String getMarca() { return marca; }
    public int getBateriaMinutos() { return bateriaMinutos; }

    @Override
    public int altitudMaxima() {
        return 500;
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
        Dron other = (Dron) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Dron [id=" + id + ", marca=" + marca + ", bateriaMinutos=" + bateriaMinutos + "]";
    }

    
}
