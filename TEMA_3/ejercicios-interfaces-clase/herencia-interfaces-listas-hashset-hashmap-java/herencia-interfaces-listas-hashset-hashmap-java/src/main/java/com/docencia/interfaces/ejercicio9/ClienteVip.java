package com.docencia.interfaces.ejercicio9;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Descontable.
 */
public class ClienteVip implements Descontable {

    private UUID id;
    private double porcentaje;
    private String nivel;

    public ClienteVip(UUID id, double porcentaje, String nivel) {    
        this.id = id == null ? UUID.randomUUID() : id;
        this.porcentaje = porcentaje;
        this.nivel = nivel;
}

    public UUID getId() { return id; }
    public double getPorcentaje() { return porcentaje; }
    public String getNivel() { return nivel; }

    @Override
    public double aplicarDescuento(double precio) {
        return precio - (precio * porcentaje);
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
        ClienteVip other = (ClienteVip) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "ClienteVip [id=" + id + ", porcentaje=" + porcentaje + ", nivel=" + nivel + "]";
    }

    
}
