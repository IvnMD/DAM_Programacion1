package com.docencia.ejercicio.clases.cinco;

import java.util.Objects;

public class Estudiante {
    private String dni;
    private String nombre;
    /**
     * Constructor vacio
     */
    public Estudiante(){};
    /**
     * Constructor parametrico
     * @param dni
     * @param nombre
     */
    public Estudiante(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;

    }
    /**
     * Setter/Getters
     *
     */
    public String getDni() { return dni; }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Estudiante)) {
            return false;
        }
        Estudiante estudiante = (Estudiante) o;
        return Objects.equals(dni.toLowerCase(), estudiante.dni.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni.toLowerCase());
    }

    @Override
    public String toString() {
        return
              getDni() + " - " 
             + getNombre() ;
    }

}

