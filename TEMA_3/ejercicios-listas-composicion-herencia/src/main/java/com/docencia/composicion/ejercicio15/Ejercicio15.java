package com.docencia.composicion.ejercicio15;

/**
 * Ejercicio 15 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí las clases de dominio, atributos, métodos y relaciones
 * de composición correspondientes al enunciado.
 */
public class Ejercicio15 {
    
    public static void main(String[] args) {
        Producto producto1 = new Producto("Gafas", 20);
        Producto producto2 = new Producto("Bolso", 61);
        Producto producto3 = new Producto("Piedra", 12.74);

        LineaPedido lineaPedido1 = new LineaPedido(producto1, 4);
        LineaPedido lineaPedido2 = new LineaPedido(producto3,1);
        LineaPedido lineaPedido3 = new LineaPedido(producto2, 2);

        Pedido pedido1 = new Pedido();
        pedido1.agregarLinea(producto3, 2);
        pedido1.agregarLinea(producto2,10);
        System.out.println(pedido1);
        
    }

    
}
