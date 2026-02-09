package com.docencia.clases.ejerciciosClases.Programa2;

public class Programa2 {

    public static void main(String[] args) {
        
        Producto producto1 = new Producto("A123", 10.0f);
        System.out.println("Producto 1 = " + producto1);
        Producto producto2 = new Producto("A123", 12.0f); 
        System.out.println("Producto 2 = " + producto2);
        if (producto1.equals(producto2)){
            System.out.println("Somos iguales");
        }
        producto2.setCodigo("B999");
        System.out.println("Producto2 despues del cambio =" + producto2);
        if (!producto1.equals(producto2)){
            System.out.println("Somos diferentes");
        }

        
    }

}
