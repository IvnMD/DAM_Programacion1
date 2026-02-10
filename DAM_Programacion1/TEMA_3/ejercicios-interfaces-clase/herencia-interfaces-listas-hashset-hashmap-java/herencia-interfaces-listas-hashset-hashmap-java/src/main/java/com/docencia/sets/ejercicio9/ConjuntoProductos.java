package com.docencia.sets.ejercicio9;


import com.docencia.herencia.ejercicio9.Producto;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un conjunto de {@link Producto} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoProductos {

    private final Set<Producto> set;


    public ConjuntoProductos() {
        this.set = new HashSet<>();
    }

    /** Anad... un elemento a la coleccion. */
    public void anadir(Producto elemento) {
        validar(elemento);
        if (set.contains(elemento)) {
            throw new IllegalArgumentException();
        }
        set.add(elemento);
    }

    public Producto buscar(Producto productosBuscar) {
        if (productosBuscar == null) {
            throw new IllegalArgumentException();
        }
        for (Producto producto : set) {
            if (producto.equals(productosBuscar)) {
                return producto;
            }
        }
        return null;

    }

    /** Busca por id. */
    public Producto buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        for (Producto producto : set) {
            if (producto.getId().equals(id)) { // Compara el id directamente
                return producto;
            }
        }
        return null;
    }

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return set.removeIf(producto -> producto.getId().equals(id));

        // Producto existe = buscarPorId(id); //!Metodo igualmente valido
        // if(existe == null){
        // return false;
        // }
        // return set.remove(existe);

    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Producto nuevoElemento) {
        validar(nuevoElemento);
        Producto existente = buscarPorId(id);
        if (existente == null) {
            throw new NoSuchElementException();
        }
        if (!existente.equals(nuevoElemento)) {
            return;
        }
        set.add(nuevoElemento);

    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Producto> listar() {
        return Set.copyOf(set);
    }

    public int tamanio() {
        return set.size();
    }
    private void validar(Producto elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getNombre() == null || elemento.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco");
        }
        if (elemento.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

}
