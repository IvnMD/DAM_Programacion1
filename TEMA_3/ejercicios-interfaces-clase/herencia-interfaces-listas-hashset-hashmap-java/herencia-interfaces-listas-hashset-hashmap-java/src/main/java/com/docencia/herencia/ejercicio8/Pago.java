package com.docencia.herencia.ejercicio8;

import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Pago {

    private UUID id;
    private double importe;

    protected Pago(UUID id, double importe) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.importe = importe;
    }

    public UUID getId() { return id; }
    public double getImporte() { return importe; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract boolean requiereValidacion();

    
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

        if (!(obj instanceof Pago))
            return false;
        Pago other = (Pago) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pago [id=" + id + ", importe=" + importe + "]";
    }

    
}
