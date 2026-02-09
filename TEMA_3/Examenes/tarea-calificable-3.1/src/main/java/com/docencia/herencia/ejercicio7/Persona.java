package com.docencia.herencia.ejercicio7;

/**
 * @author IvnMD
 * @date 18/12/25
 * @version 1.0.0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que construye una persona
 */
public abstract class Persona {
    private final String nombre;
    
    /**
     * Constructor vacio/ por defecto. (inicializado al ser final)
     */
    public Persona() {
        this.nombre = "";
    }

    /**
     * Constructor parametrico
     */
    protected Persona(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter
     * @return nombre de la persona
     */
    public String getNombre() {
        if (nombre == null || nombre.isBlank()) {
            return "";
        }
        return nombre;
    }


    public abstract String descripcionRol();

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        return Objects.equals(nombre, other.nombre);
    }

    
}
