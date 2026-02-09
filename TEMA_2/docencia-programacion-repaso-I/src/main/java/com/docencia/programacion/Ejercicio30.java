package com.docencia.programacion;
/**
 * @author IvnMD
 * @since 07/11/25
 * @version 1.0.0
 * @bugs No bugs known
 * @brief Inventario que contiene varios productos y permite buscar por nombre y sumar el valor total.
 */
public class Ejercicio30 {
    private final Ejercicio29[] products;

    /**
     * Constructor vacío que inicializa el inventario con un tamaño fijo.
     */
    public Ejercicio30() {
        this.products = new Ejercicio29[2]; 
    }
    /**
     * Constructor parametrico 
     * @param products Productos que vamos a introducir en el inventario
     */
    public Ejercicio30(Ejercicio29[] products) {
        this.products = products;
    }

    public double getTotalStockValue() {
        return this.products.getStockValue() + other.getStockValue();
    }

    public Ejercicio29 findByName(String name) {
        // TODO implementar
        return null;
    }
}
