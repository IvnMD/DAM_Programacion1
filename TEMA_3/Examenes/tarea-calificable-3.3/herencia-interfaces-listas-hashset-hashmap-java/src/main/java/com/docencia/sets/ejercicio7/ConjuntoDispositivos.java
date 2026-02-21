package com.docencia.sets.ejercicio7;


import com.docencia.herencia.ejercicio7.Dispositivo;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un conjunto de {@link Dispositivo} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoDispositivos {

    private final Set<Dispositivo> set;


    public ConjuntoDispositivos() {
        this.set = new HashSet<>();
    }

    /** Anad... un elemento a la coleccion. */
    public void anadir(Dispositivo elemento) {
        validar(elemento);
        if (set.contains(elemento)) {
            throw new IllegalArgumentException();
        }
        set.add(elemento);
    }

    public Dispositivo buscar(Dispositivo dispositivoBuscar) {
        if (dispositivoBuscar == null) {
            throw new IllegalArgumentException();
        }
        for (Dispositivo dispotivo : set) {
            if (dispotivo.equals(dispositivoBuscar)) {
                return dispotivo;
            }
        }
        return null;

    }

    /** Busca por id. */
    public Dispositivo buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        for (Dispositivo dispotivo : set) {
            if (dispotivo.getId().equals(id)) { // Compara el id directamente
                return dispotivo;
            }
        }
        return null;
    }

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return set.removeIf(dispotivo -> dispotivo.getId().equals(id));

        // Dispositivo existe = buscarPorId(id); //!Metodo igualmente valido
        // if(existe == null){
        // return false;
        // }
        // return set.remove(existe);

    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Dispositivo nuevoElemento) {
        validar(nuevoElemento);
        Dispositivo existente = buscarPorId(id);
        if (existente == null) {
            throw new NoSuchElementException();
        }
        if (!existente.equals(nuevoElemento)) {
            return;
        }
        set.add(nuevoElemento);

    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Dispositivo> listar() {
        return Set.copyOf(set);
    }

    public int tamanio() {
        return set.size();
    }

    private void validar(Dispositivo elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El dispositivo no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getFabricante() == null || elemento.getFabricante().isBlank()) {
            throw new IllegalArgumentException("El fabricante no puede ser nulo o en blanco");
        }
    }

}
