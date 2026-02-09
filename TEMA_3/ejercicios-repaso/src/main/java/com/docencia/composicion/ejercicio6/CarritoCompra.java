package com.docencia.composicion.ejercicio6;


import java.util.ArrayList;
import java.util.List;


public class CarritoCompra {
    private final List<LineaCarrito> lineas = new ArrayList<>();

    public void anadirLinea(Producto producto, int cantidad) {
    if (producto == null || cantidad <= 0 || producto.getPrecio() < 0) {
        return; 
    }
    lineas.add(new LineaCarrito(producto, cantidad));
}


    public double calcularTotal(double porcentajeIva) {
        double base = 0.0;
        double iva = 1 + (porcentajeIva/100);
        for (LineaCarrito lineaCarrito : lineas) {
            base += lineaCarrito.getImporte();
        }
        return base * iva;
    }

    public List<LineaCarrito> getLineas() {
        return new ArrayList<>(lineas);
    }
}
