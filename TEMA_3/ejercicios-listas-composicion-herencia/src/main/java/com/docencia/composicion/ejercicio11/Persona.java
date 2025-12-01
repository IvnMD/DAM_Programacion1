package com.docencia.composicion.ejercicio11;

import java.util.Objects;

public class Persona {

    private String nombre;
    private int edad;
    private Direccion direccion;

    public Persona(){}

    public Persona(String nombre, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, direccion);
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
        return Objects.equals(nombre, other.nombre) && edad == other.edad && Objects.equals(direccion, other.direccion);
    }

    @Override
    public String toString() {
        return "La persona se llama " + nombre + ", tiene " + edad + " años de edad y vive en " + direccion;
    }

    

    
    



    

    


}
