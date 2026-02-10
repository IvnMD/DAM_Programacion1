package com.docencia.interfaces.ejercicio8;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Notificable.
 */
public class SmsNotifier implements Notificable {

    private UUID id;
    private String numero;
    private String proveedor;

    public SmsNotifier(UUID id, String numero, String proveedor) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.numero = numero;
        this.proveedor = proveedor;
    }

    public UUID getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getProveedor() {
        return proveedor;
    }

    @Override
    public boolean notificar(String mensaje) {
        return mensaje != null && !mensaje.isBlank() && numero != null && numero.length() >= 6;
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
        SmsNotifier other = (SmsNotifier) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "SmsNotifier [id=" + id + ", numero=" + numero + ", proveedor=" + proveedor + "]";
    }

}
