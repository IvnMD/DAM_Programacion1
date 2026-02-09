package com.docencia.composicion.ejercicio9;


import java.util.ArrayList;
import java.util.List;


public class LineaInventario {
    private final Producto producto;
    private int cantidad;

    public LineaInventario(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        if (producto == null){
            throw new IllegalArgumentException();
        }
        return producto;
    }

    public int getCantidad() {
        if (cantidad <= 0){
            throw new IllegalArgumentException();
        }
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
