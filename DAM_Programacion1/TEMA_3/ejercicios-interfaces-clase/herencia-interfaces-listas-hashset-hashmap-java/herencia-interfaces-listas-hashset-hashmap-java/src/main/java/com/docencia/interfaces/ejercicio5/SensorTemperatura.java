package com.docencia.interfaces.ejercicio5;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Medible.
 */
public class SensorTemperatura implements Medible {

    private UUID id;
    private String ubicacion;
    private double celsius;

    public SensorTemperatura(UUID id, String ubicacion, double celsius) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.ubicacion = ubicacion;
        this.celsius = celsius;
    }

    public UUID getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getCelsius() {
        return celsius;
    }

    @Override
    public double medir() {
        return celsius;
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
        SensorTemperatura other = (SensorTemperatura) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "SensorTemperatura [id=" + id + ", ubicacion=" + ubicacion + ", celsius=" + celsius + "]";
    }

}
