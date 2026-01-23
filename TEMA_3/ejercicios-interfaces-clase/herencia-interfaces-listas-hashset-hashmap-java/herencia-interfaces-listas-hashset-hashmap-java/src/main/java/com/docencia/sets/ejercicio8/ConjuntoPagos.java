package com.docencia.sets.ejercicio8;

import com.docencia.herencia.ejercicio8.Pago;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un conjunto de {@link Pago} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoPagos {

    private final Set<Pago> set;


    public ConjuntoPagos() {
        this.set = new HashSet<>();
    }

    /** Anad... un elemento a la coleccion. */
    public void anadir(Pago elemento) {
        validar(elemento);
        if (set.contains(elemento)) {
            throw new IllegalArgumentException();
        }
        set.add(elemento);
    }

    public Pago buscar(Pago PagosBuscar) {
        if (PagosBuscar == null) {
            throw new IllegalArgumentException();
        }
        for (Pago pago : set) {
            if (pago.equals(PagosBuscar)) {
                return pago;
            }
        }
        return null;

    }

    /** Busca por id. */
    public Pago buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        for (Pago pago : set) {
            if (pago.getId().equals(id)) { // Compara el id directamente
                return pago;
            }
        }
        return null;
    }

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return set.removeIf(pago -> pago.getId().equals(id));

        // Pago existe = buscarPorId(id); //!Metodo igualmente valido
        // if(existe == null){
        // return false;
        // }
        // return set.remove(existe);

    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Pago nuevoElemento) {
        validar(nuevoElemento);
        Pago existente = buscarPorId(id);
        if (existente == null) {
            throw new NoSuchElementException();
        }
        if (!existente.equals(nuevoElemento)) {
            return;
        }
        set.add(nuevoElemento);

    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Pago> listar() {
        return Set.copyOf(set);
    }

    public int tamanio() {
        return set.size();
    }
    private void validar(Pago elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El pago no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getImporte() <= 0) {
            throw new IllegalArgumentException("El importe debe ser mayor que cero");
        }
    }

}
