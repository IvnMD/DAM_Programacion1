package com.docencia.composicion.ejercicio4;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Usuario {
    private final String nombre;

    public Usuario(){
        nombre = "";
    }

    public Usuario(String nombre) {
        this.nombre = nombre.trim();
    }

    public String getNombre() {
        return nombre;
    }

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
        Usuario other = (Usuario) obj;
        return Objects.equals(nombre, other.nombre);
    }

    

    
}
