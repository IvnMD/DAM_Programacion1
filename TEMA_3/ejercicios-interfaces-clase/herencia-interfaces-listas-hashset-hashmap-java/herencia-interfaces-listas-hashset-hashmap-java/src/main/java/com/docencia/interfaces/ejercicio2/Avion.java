package com.docencia.interfaces.ejercicio2;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Volador.
 */
public class Avion implements Volador {

    private UUID id;
    private String modelo;
    private int motores;

    public Avion(UUID id, String modelo, int motores) { 
        this.id = id == null ? UUID.randomUUID() : id;
        this.modelo = modelo;
        this.motores = motores;
}

    public UUID getId() { return id; }
    public String getModelo() { return modelo; }
    public int getMotores() { return motores; }

    @Override
    public int altitudMaxima() {
        return 12000;
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
        Avion other = (Avion) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Avion [id=" + id + ", modelo=" + modelo + ", motores=" + motores + "]";
    }

    

}
