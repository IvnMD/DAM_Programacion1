package com.docencia.sets.ejercicio5;

import com.docencia.herencia.ejercicio5.Circulo;
import com.docencia.herencia.ejercicio5.Figura;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un conjunto de {@link Figura} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del
 * ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoFiguras {

    private final Set<Figura> set;

    public ConjuntoFiguras() {
        this.set = new HashSet<>();
    }

    /** Anad... un elemento a la coleccion. */
    public void anadir(Figura elemento) {
        validar(elemento);
        if (set.contains(elemento)) {
            throw new IllegalArgumentException();
        }
        set.add(elemento);
    }

    public Figura buscar(Figura figuraBuscar) {
        if (figuraBuscar == null) {
            throw new IllegalArgumentException();
        }
        for (Figura figura : set) {
            if (figura.equals(figuraBuscar)) {
                return figura;
            }
        }
        return null;

    }

    /** Busca por id. */
    public Figura buscarPorId(UUID id) {

        if (id == null) {
            throw new IllegalArgumentException();
        }
        Figura figuraBuscar = new Circulo(id);
        for (Figura figura : set) {
            if (figura.equals(figuraBuscar)) {
                return figura;
            }
        }
        return buscar(figuraBuscar);

    }

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return set.removeIf(figura -> figura.getId().equals(id));

        // Figura existe = buscarPorId(id); //!Metodo igualmente valido
        // if(existe == null){
        // return false;
        // }
        // return set.remove(existe);

    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Figura nuevoElemento) {
        validar(nuevoElemento);
        Figura existente = buscarPorId(id);
        if (existente == null) {
            throw new NoSuchElementException();
        }
        if (!existente.equals(nuevoElemento)) {
            return;
        }
        set.add(nuevoElemento);

    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Figura> listar() {
        return Set.copyOf(set);
    }

    public int tamanio() {
        return set.size();
    }

    private void validar(Figura elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("La figura no puede ser nula");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getColor() == null || elemento.getColor().isBlank()) {
            throw new IllegalArgumentException("El color no puede ser nulo o en blanco");
        }
    }

}
