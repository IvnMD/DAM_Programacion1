package com.docencia.composicion.ejercicio15;
import java.util.Objects;

public class LineaPedido {

    private Producto producto;
    private int cantidad;

    /**
     * Constructor vacio
     */
    public LineaPedido(){};
    /**
     * Constructor parametrico
     * @param producto producto en la linea de pedido
     * @param cantidad catidad de productor pedido
     */
    public LineaPedido(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }


    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LineaPedido)) {
            return false;
        }
        LineaPedido lineaPedido = (LineaPedido) o;
        return Objects.equals(producto, lineaPedido.producto) && cantidad == lineaPedido.cantidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto, cantidad);
    }

    @Override
    public String toString() {
        return "{" +
            " producto='" + getProducto() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            "}";
    }
    

}
