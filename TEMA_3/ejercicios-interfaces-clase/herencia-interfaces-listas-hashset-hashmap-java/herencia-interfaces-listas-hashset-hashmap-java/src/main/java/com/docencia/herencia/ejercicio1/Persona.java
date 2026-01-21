package com.docencia.herencia.ejercicio1;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Persona {

    private UUID id;
    private String nombre;
    private int edad;

    protected Persona(UUID id, String nombre, int edad) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nombre = nombre;
        this.edad = edad;

        getNombre();
        getEdad();
    }

    public UUID getId() { 
        if (id == null){
            throw new IllegalArgumentException();
        }
        
        return id; }
        
    public String getNombre() { 
        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException();
        }
        return nombre; 
    }
    public int getEdad() {
        if(edad <= 0){
            throw new IllegalArgumentException();
        }
        return edad;
    }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract String rol();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
    }

    




}
