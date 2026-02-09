package com.docencia.composicion.ejercicio9;


import java.util.ArrayList;
import java.util.List;


public class Producto {
    private final String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("");
        }
        return nombre.trim().toLowerCase();
    }
}
