package com.docencia.interfaces.ejercicio9;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Descontable.
 */
public class Cupon implements Descontable {

    private UUID id;
    private double importe;
    private String codigo;

    public Cupon(UUID id, double importe, String codigo) {  
        this.id = id == null ? UUID.randomUUID() : id;
        this.importe = importe;
        this.codigo = codigo;
}

    public UUID getId() { return id; }
    public double getImporte() { return importe; }
    public String getCodigo() { return codigo; }

    @Override
    public double aplicarDescuento(double precio) {
        return Math.max(0.0, precio - importe);
    }

    @Override
    public String toString() {
        return "Cupon [id=" + id + ", importe=" + importe + ", codigo=" + codigo + "]";
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
        Cupon other = (Cupon) obj;
        return Objects.equals(id, other.id);
    }

    
}
