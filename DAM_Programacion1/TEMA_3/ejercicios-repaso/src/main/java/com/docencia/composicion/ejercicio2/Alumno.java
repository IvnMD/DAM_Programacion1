package com.docencia.composicion.ejercicio2;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa un alumno con su nombre.
 */
public class Alumno {
    private final String nombre;

    /**
     * Constructor por defecto/vacio
     */
    public Alumno() {
        this.nombre = "";
    }
    /**
     * Contrusctor parametrico
     * @param nombre del alumno
     */
    public Alumno(String nombre) {
        this.nombre = nombre.trim();
    }

    /**
     * Getter del nombre
     * @return nombre del alumno
     */
    public String getNombre() {
        return nombre;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }


    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            "}";
    }


}
