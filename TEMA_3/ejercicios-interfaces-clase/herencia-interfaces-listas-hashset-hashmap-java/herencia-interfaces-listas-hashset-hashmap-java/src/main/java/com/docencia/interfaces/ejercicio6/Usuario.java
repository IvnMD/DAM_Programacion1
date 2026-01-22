package com.docencia.interfaces.ejercicio6;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Autenticable.
 */
public class Usuario implements Autenticable {

    private UUID id;
    private String nombre;
    private String hash;

    public Usuario(UUID id, String nombre, String hash) { 
        this.id = id == null ? UUID.randomUUID() : id;
        this.nombre = nombre;
        this.hash = hash;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public String getHash() { return hash; }

    @Override
    public boolean autenticar(String clave) {
        return clave != null && clave.equals(hash);
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
        Admin other = (Admin) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Admin [id=" + id + ", nombre=" + nombre + ", hash=" + hash + "]";
    }
}
