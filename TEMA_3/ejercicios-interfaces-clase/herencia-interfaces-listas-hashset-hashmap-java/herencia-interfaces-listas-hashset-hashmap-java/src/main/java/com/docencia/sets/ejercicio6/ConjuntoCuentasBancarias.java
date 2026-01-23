package com.docencia.sets.ejercicio6;

import com.docencia.herencia.ejercicio5.Circulo;
import com.docencia.herencia.ejercicio5.CuentaBancaria;
import com.docencia.herencia.ejercicio6.CuentaAhorro;
import com.docencia.herencia.ejercicio6.CuentaBancaria;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un conjunto de {@link CuentaBancaria} usando internamente
 * {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del
 * ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoCuentasBancarias {

    private final Set<CuentaBancaria> set;

    public ConjuntoCuentasBancarias() {
        this.set = new HashSet<>();
    }

    /** Anad... un elemento a la coleccion. */
    public void anadir(CuentaBancaria elemento) {
        validar(elemento);
        if (set.contains(elemento)) {
            throw new IllegalArgumentException();
        }
        set.add(elemento);
    }

    public CuentaBancaria buscar(CuentaBancaria cuentaBuscar) {
        if (cuentaBuscar == null) {
            throw new IllegalArgumentException();
        }
        for (CuentaBancaria cuenta : set) {
            if (cuenta.equals(cuentaBuscar)) {
                return cuenta;
            }
        }
        return null;

    }

    /** Busca por id. */
    public CuentaBancaria buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        for (CuentaBancaria cuenta : set) {
            if (cuenta.getId().equals(id)) { // Compara el id directamente
                return cuenta;
            }
        }
        return null;
    }

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return set.removeIf(cuenta -> cuenta.getId().equals(id));

        // CuentaBancaria existe = buscarPorId(id); //!Metodo igualmente valido
        // if(existe == null){
        // return false;
        // }
        // return set.remove(existe);

    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, CuentaBancaria nuevoElemento) {
        validar(nuevoElemento);
        CuentaBancaria existente = buscarPorId(id);
        if (existente == null) {
            throw new NoSuchElementException();
        }
        if (!existente.equals(nuevoElemento)) {
            return;
        }
        set.add(nuevoElemento);

    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<CuentaBancaria> listar() {
        return Set.copyOf(set);
    }

    public int tamanio() {
        return set.size();
    }

    private void validar(CuentaBancaria elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("La cuenta no puede ser nula");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getTitular() == null || elemento.getTitular().isBlank()) {
            throw new IllegalArgumentException("El titular no puede ser nulo o en blanco");
        }
        if (elemento.getSaldo() < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
    }

}
