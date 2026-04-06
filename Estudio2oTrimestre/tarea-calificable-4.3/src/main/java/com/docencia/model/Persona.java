package com.docencia.model;

import java.time.LocalDate;
import java.util.Objects;

import com.docencia.util.Validaciones;

abstract public class Persona {
    private final int id;
    private String nombre;

    /**
     * Constructor vacio o por defecto
     */
    protected Persona() {
        this.id = 0;
    }

    /**
     * Constructor por identificador unico
     * 
     * @param id id unico de la persona
     */
    protected Persona(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID invalido");
        }
        this.id = id;
    }
    /**
     * Constructor parametrico
     * @param id identificador unico de la persona
     * @param nombre de la persona
     */
    protected Persona(int id, String nombre) {
        this.id = id;
        setNombre(nombre);
    }


    // Setters y getters 

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre no valido");
        }
        nombre = nombre.trim();
        if (nombre.length() < 5) {
            throw new IllegalArgumentException("Nombre demasiado corto");
        }
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return id == persona.id;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + "]";
    }

    

}
