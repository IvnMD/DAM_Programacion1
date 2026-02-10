package com.docencia.composicion.ejercicio6;


import java.util.ArrayList;
import java.util.List;


public class Producto {
    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        if(nombre==null||nombre.isBlank())
        {
            throw new IllegalArgumentException();
        }
        this.nombre=nombre;
        this.precio=precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
