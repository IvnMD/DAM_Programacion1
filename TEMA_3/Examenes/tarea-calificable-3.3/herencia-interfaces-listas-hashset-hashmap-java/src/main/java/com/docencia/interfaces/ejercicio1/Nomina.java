package com.docencia.interfaces.ejercicio1;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Pagable.
 */
public class Nomina implements Pagable {

    private UUID id;
    private double bruto;
    private double retencion;

    public Nomina(UUID id, double bruto, double retencion) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.bruto = bruto;
        this.retencion = retencion;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    public void setBruto(double bruto) {
        if (bruto <= 0){
            throw new IllegalArgumentException();
        }
        this.bruto = bruto;
    }

    public void setRetencion(double retencion) {
        this.retencion = retencion;
    }

    public double getBruto() {
        return bruto;
    }

    public double getRetencion() {
        return retencion;
    }

    @Override
    public double total() {
        return bruto - (bruto * retencion);
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
        Nomina other = (Nomina) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Nomina [id=" + id + ", bruto=" + bruto + ", retencion=" + retencion + "]";
    }

}
