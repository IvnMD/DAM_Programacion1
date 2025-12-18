package com.docencia.composicion.ejercicio1;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Tarea {
    private final String descripcion;
    private boolean completada;

    public Tarea(){
        this.descripcion = "";
    };

    public Tarea(String descripcion) {
        this.descripcion = descripcion.trim().toLowerCase();
        this.completada = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void marcarCompletada() {
        this.completada = true;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tarea)) {
            return false;
        }
        Tarea tarea = (Tarea) o;
        return Objects.equals(descripcion, tarea.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion);
    }


    @Override
    public String toString() {
        return "{" +
            " descripcion='" + getDescripcion() + "'" +
            ", completada='" + isCompletada() + "'" +
            "}";
    }

    
}
