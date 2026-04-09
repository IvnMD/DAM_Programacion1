package com.examen.profesores.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Objects;

/**
 * Representa un profesor del sistema.
 * La identidad logica del profesor viene dada por su id.
 */
public class Profesor {

    @JacksonXmlProperty(isAttribute = true)
    private String id;
    private String nombre;
    private String departamento;
    private boolean activo;

    public Profesor() {
        // Constructor vacio para Jackson.
    }

    /**
     * Constructor por identificador unico de profesor
     * @param id identificador unico de profesor
     */
    public Profesor(String id) {
        this.id = id;
    }

    /**
     * Crea un nuevo profesor activo.
     *
     * @param id identificador unico del profesor
     * @param nombre nombre del profesor
     * @param departamento departamento del profesor
     */
    public Profesor(String id, String nombre, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.activo = true;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profesor profesor)) return false;
        return Objects.equals(id, profesor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id='" + id + "'" +
                ", nombre='" + nombre + "'" +
                ", departamento='" + departamento + "'" +
                ", activo=" + activo +
                '}';
    }
}
