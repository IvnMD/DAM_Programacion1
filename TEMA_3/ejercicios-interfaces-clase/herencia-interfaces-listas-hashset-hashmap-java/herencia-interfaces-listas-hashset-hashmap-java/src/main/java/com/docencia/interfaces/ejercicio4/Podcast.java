package com.docencia.interfaces.ejercicio4;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Reproducible.
 */
public class Podcast implements Reproducible {

    private UUID id;
    private String nombre;
    private int episodio;

    public Podcast(UUID id, String nombre, int episodio) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nombre = nombre;
        this.episodio = episodio;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEpisodio() {
        return episodio;
    }

    @Override
    public String reproducir() {
        return "Reproduciendo podcast: " + nombre + " #" + episodio;
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
        Podcast other = (Podcast) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Podcast [id=" + id + ", nombre=" + nombre + ", episodio=" + episodio + "]";
    }

    
}
