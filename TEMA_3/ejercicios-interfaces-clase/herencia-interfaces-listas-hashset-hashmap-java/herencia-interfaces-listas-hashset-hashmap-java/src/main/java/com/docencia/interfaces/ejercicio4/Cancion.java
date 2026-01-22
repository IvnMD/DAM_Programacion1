package com.docencia.interfaces.ejercicio4;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Reproducible.
 */
public class Cancion implements Reproducible {

    private UUID id;
    private String titulo;
    private String artista;

    public Cancion(UUID id, String titulo, String artista) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.titulo = titulo;
        this.artista = artista;
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    @Override
    public String reproducir() {
        return "Reproduciendo cancion: " + titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cancion)) {
            return false;
        }
        Cancion cancion = (Cancion) o;
        return Objects.equals(id, cancion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", titulo='" + getTitulo() + "'" +
                ", artista='" + getArtista() + "'" +
                "}";
    }

}
