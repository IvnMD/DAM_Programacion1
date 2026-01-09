package com.docencia.composicion.ejercicio9;


import java.util.ArrayList;
import java.util.List;


public class Inventario {
    private final List<LineaInventario> lineas = new ArrayList<>();

    public void anadirStock(String nombreProducto, int cantidad) {
        if (nombreProducto == null || nombreProducto.isBlank()){
            return;
        }
        if (cantidad <= 0){
            return;
        }
        lineas.add(new LineaInventario(new Producto(nombreProducto), cantidad));
    }

    public boolean retirarStock(String nombreProducto, int cantidad) {
        if(nombreProducto == null || nombreProducto.isBlank()){
            return false;
        }
        for (LineaInventario lineaInventario : lineas) {
            if (nombreProducto.trim().toLowerCase().equals(nombreProducto.trim().toLowerCase())){
                lineaInventario.setCantidad(lineaInventario.getCantidad()-cantidad);
            }
        }
        return true;
    }

    public int stockDe(String nombreProducto) {
        if (nombreProducto == null || nombreProducto.isBlank()){
            return 0;
        }
        int resultado = 0;
        for (LineaInventario lineaInventario : lineas) {
            if (nombreProducto.trim().toLowerCase().equals(nombreProducto.trim().toLowerCase())){
                resultado += lineaInventario.getCantidad();
            }
            if (!nombreProducto.trim().toLowerCase().equals(nombreProducto.trim().toLowerCase())){
                return 0;
            }
        
        }
        return resultado;
    }

    public int totalUnidades() {
        int total = 0;
            for (LineaInventario lineaInventario : lineas) {
                total += lineaInventario.getCantidad();
            }
        return total;
    }

    public List<LineaInventario> getLineas() {
        return new ArrayList<>(lineas);
    }
}
