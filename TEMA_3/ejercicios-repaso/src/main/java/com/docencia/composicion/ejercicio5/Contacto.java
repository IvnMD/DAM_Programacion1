package com.docencia.composicion.ejercicio5;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Contacto {
    private final String nombre;
    private final String telefono;


    public Contacto(){
        nombre ="";
        telefono="";
    }

    // public Contacto(String telefono){
    //     this.nombre = "";
    //     this.telefono = telefono;
    // }

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre.trim();
        this.telefono = telefono.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contacto other = (Contacto) obj;
        return Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
    }

    @Override
    public String toString() {
        return "Contacto [nombre=" + nombre + ", telefono=" + telefono + "]";
    }

    

    
}
