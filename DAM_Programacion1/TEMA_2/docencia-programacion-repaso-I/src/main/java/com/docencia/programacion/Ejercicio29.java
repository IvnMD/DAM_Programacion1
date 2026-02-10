package com.docencia.programacion;
/**
 * @author
 * @since 07/11/25
 * @version 1.0.0
 * @brief Producto con nombre, precio, stock y valor total de stock.
 */
public class Ejercicio29 {
    private final String name;
    private final double price;
    private int stock;

    /**
     * Constructor vacio
     */
    public Ejercicio29 () {
        this("", 0.0, 0);
    };
    /**
     * Constructor parametrico
     * @param name Nombre del producto
     * @param price Precio del producto
     * @param stock Stock actual del producto
     */
    public Ejercicio29(String name, double price, int stock) {

        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    /**
     * Funcion que suma unidades al stock
     * @param delta Entero de entrada
     */
    public void addStock(int delta) {
        this.stock += delta;
    }
    /**
     * Funcion que elimina stock
     * @param delta Entero de entrada
     * @return En caso de delta > stock, no hace nada y devuelve false. 
     *         En caso de delta <= stock, resta delta a stock y devuelve true.
     */
    public boolean removeStock(int delta) {
        if (delta > stock){
            return false;
        }
        else {
        this.stock -= delta;
        return true;
        }
        
    }
    /**
     * Funcion que calcula el valor total del stock
     * @return Multiplicacion del precio por el numero de unidades en stock
     */
    public double getStockValue() {
        double suma = this.price*this.stock;
        return suma;
    }
    /**
     * Getter de nombre
     * @return nombre
     */
    public String getName() {
        return this.name;
    }
    /**
     * Getter de precio
     * @return precio
     */
    public double getPrice() {
        return this.price;
    }
    /**
     * Getter de stock
     * @return devuelve el total del stock
     */
    public int getStock() {
        return this.stock;
    }
}
