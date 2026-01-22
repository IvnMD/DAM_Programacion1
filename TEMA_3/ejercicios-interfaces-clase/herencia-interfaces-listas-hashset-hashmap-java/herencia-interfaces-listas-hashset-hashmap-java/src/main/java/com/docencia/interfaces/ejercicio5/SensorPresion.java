package com.docencia.interfaces.ejercicio5;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Medible.
 */
public class SensorPresion implements Medible {

    private UUID id;
    private String ubicacion;
    private double kpa;

    public SensorPresion(UUID id, String ubicacion, double kpa) { 
                this.id = id == null ? UUID.randomUUID() : id;
                this.ubicacion = ubicacion;
                this.kpa = kpa;
}

    public UUID getId() { return id; }
    public String getUbicacion() { return ubicacion; }
    public double getKpa() { return kpa; }

    @Override
    public double medir() {
        return kpa;
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
        SensorPresion other = (SensorPresion) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "SensorPresion [id=" + id + ", ubicacion=" + ubicacion + ", kpa=" + kpa + "]";
    }


    

}
