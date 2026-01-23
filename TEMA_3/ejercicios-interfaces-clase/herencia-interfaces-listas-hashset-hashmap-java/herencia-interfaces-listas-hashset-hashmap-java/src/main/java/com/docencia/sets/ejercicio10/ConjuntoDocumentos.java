package com.docencia.sets.ejercicio10;

import com.docencia.herencia.ejercicio10.Documento;


import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un conjunto de {@link Documento} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoDocumentos {

    private final Set<Documento> set;


    public ConjuntoDocumentos() {
        this.set = new HashSet<>();
    }

    /** Anad... un elemento a la coleccion. */
    public void anadir(Documento elemento) {
        validar(elemento);
        if (set.contains(elemento)) {
            throw new IllegalArgumentException();
        }
        set.add(elemento);
    }

    public Documento buscar(Documento documentoBuscar) {
        if (documentoBuscar == null) {
            throw new IllegalArgumentException();
        }
        for (Documento documento : set) {
            if (documento.equals(documentoBuscar)) {
                return documento;
            }
        }
        return null;

    }

    /** Busca por id. */
    public Documento buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        for (Documento documento : set) {
            if (documento.getId().equals(id)) { // Compara el id directamente
                return documento;
            }
        }
        return null;
    }

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return set.removeIf(documento -> documento.getId().equals(id));

        // Documento existe = buscarPorId(id); //!Metodo igualmente valido
        // if(existe == null){
        // return false;
        // }
        // return set.remove(existe);

    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Documento nuevoElemento) {
        validar(nuevoElemento);
        Documento existente = buscarPorId(id);
        if (existente == null) {
            throw new NoSuchElementException();
        }
        if (!existente.equals(nuevoElemento)) {
            return;
        }
        set.add(nuevoElemento);

    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Documento> listar() {
        return Set.copyOf(set);
    }

    public int tamanio() {
        return set.size();
    }
    private void validar(Documento elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El documento no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getTitulo() == null || elemento.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El titulo no puede ser nulo o en blanco");
        }
    }

}
