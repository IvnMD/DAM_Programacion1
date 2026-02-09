package com.docencia.composicion.ejercicio15;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Pedido {

    final private List<LineaPedido> pedido;

    public Pedido(){
        pedido = new ArrayList<>();
    }

    public Pedido(List<LineaPedido> pedido){
        this.pedido = pedido;
    }

    public void agregarLinea(Producto producto, int cantidad){
        if (producto == null || cantidad <= 0){
            return;
        }
        pedido.add(new LineaPedido(producto, cantidad));
    }

    public double calcularTotal(){
        double total = 0.0;
        for (LineaPedido lineaPedido : pedido) {
            // Se utiliza el getter de LineaPedido para acceder a la cantidad
            int cantidad = lineaPedido.getCantidad(); 
            
            // Se utiliza el getter de Producto (a través de LineaPedido) para acceder al precio
            double precio = lineaPedido.getProducto().getPrecio();
            
            total += precio * cantidad;
        }
        return total;
    }

    public double totalConDescuento(double porcentaje){
        double total = calcularTotal();
        if (porcentaje <= 0 ){
            return total;
        }
        if (porcentaje >= 100) {
            return 0.0;
        }
        return total * (1- (porcentaje/100.0));

    }
    
    public void getPedido(List<LineaPedido> pedido){
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pedido)) {
            return false;
        }
        Pedido pedido = (Pedido) o;
        return Objects.equals(pedido, pedido.pedido);
    }

    @Override
    public int hashCode() {
        return super.hashCode()(pedido);
    }


    @Override
    public String toString() {
        return "{" +
            " pedido='" + getPedido() + "'" +
            "}";
    }

    
}
