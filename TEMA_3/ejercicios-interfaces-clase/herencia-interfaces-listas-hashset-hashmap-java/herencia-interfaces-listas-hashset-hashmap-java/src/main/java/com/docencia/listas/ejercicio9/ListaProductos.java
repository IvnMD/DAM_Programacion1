package com.docencia.listas.ejercicio9;

import com.docencia.herencia.ejercicio8.Pago;
import com.docencia.herencia.ejercicio9.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona una lista de {@link Producto} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten productos con nombre nulo o en blanco.
 * - No se permiten precios negativos.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaProductos {

    private final List<Producto> productos = new ArrayList<>();

    public void anadir(Producto producto) {
        validar(producto);
        if (productos.contains(producto)) {
            throw new IllegalArgumentException();
        }
        productos.add(producto);
    }

    public Producto buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public boolean eliminarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return productos.removeIf(productos -> productos.getId().equals(id));
    }

    public void modificar(UUID id, Producto nuevoProducto) {
        validar(nuevoProducto);
        Producto existente = buscarPorId(id);
        if (existente == null) {
            throw new NoSuchElementException();
        }
        if (!existente.equals(nuevoProducto)) {
            throw new IllegalArgumentException();
        }
        int indice = productos.indexOf(existente);
        productos.set(indice, nuevoProducto);
    }

    public List<Producto> listar() {
        return List.copyOf(productos);
    }

    public int tamanio() {
        return productos.size();
    }

    private boolean existeId(UUID id) {
        return productos.stream().anyMatch(p -> p.getId().equals(id));
    }

    private void validar(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (producto.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco");
        }
        if (producto.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }
}
