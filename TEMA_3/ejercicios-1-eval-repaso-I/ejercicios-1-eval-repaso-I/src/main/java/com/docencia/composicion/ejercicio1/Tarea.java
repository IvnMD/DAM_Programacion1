package com.docencia.composicion.ejercicio1;
import java.util.Objects;

public class Tarea {
    private final String descripcion;
    private boolean completada;


    public Tarea(String descripcion) {
        this.descripcion = descripcion.trim();
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


    public Tarea(String descripcion, boolean completada) {
        this.descripcion = descripcion;
        this.completada = completada;
    }

    public boolean getCompletada() {
        return this.completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, completada);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarea other = (Tarea) obj;
        return Objects.equals(descripcion.toLowerCase(), other.descripcion.toLowerCase());
    }



    
}
