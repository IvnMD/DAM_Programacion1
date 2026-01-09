package com.docencia.composicion.ejercicio8;


import java.util.ArrayList;
import java.util.List;


public class Alumno {
    private final String nombre;

    public Alumno(String nombre) {
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException();
        }
        this.nombre = nombre.trim().toLowerCase();
    }

    public String getNombre() {
        
        return nombre;
    }
}
