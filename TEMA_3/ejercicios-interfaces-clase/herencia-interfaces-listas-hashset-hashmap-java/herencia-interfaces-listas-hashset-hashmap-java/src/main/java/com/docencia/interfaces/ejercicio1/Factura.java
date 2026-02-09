package com.docencia.interfaces.ejercicio1;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Pagable.
 */
public class Factura implements Pagable {

    private UUID id;
    private double base;
    private double iva;

    public Factura(UUID id, double base, double iva) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.base = base;
        this.iva = iva;
    }

    public UUID getId() { return id; }
    public double getBase() { return base; }
    public double getIva() { return iva; }

    @Override
    public double total() {
        return base + (base * iva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Factura other = (Factura) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Factura [id=" + id + ", base=" + base + ", iva=" + iva + "]";
    }

    

    
}
