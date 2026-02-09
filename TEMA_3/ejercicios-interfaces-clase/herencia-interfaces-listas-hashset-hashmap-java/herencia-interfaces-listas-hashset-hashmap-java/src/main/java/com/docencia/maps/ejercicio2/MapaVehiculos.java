package com.docencia.maps.ejercicio2;


import com.docencia.herencia.ejercicio2.Vehiculo;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un mapa de {@link Vehiculo} usando internamente {@link HashMap}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class MapaVehiculos {
    private final Map<UUID, Vehiculo> index;


    public MapaVehiculos(){
        index = new HashMap<>();
    }

    /** Anad... un elemento a la coleccion. */
    public void anadir(Vehiculo elemento) {
        validar(elemento);
        //! Si existe, salgo, si no añado
        Vehiculo existe = buscarPorId(elemento.getId());
        if(existe != null){
            throw new IllegalArgumentException();
        }
        // if(index.containsValue(elemento)){   //? Metodo alternativo
        //     throw new IllegalArgumentException();
        // }
        index.put(elemento.getId(), elemento);
    }

    /** Busca por id. */
    public Vehiculo buscarPorId(UUID id) {
        boolean existe = index.containsKey(id);
        if (id == null) {
            throw new IllegalArgumentException();
        }
            if (!existe){
                return null;
            }
        return index.get(id);
    }
    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        index.remove(id); 
        return true;
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Vehiculo nuevoElemento) {
        Vehiculo elemento = buscarPorId(id);
        if (elemento == null){
            throw new NoSuchElementException();
        }
        validar(nuevoElemento);
        if(!elemento.equals(nuevoElemento)){
            throw new IllegalArgumentException();
        }
        index.replace(id, nuevoElemento);
        // index.replace(id, persona, nuevoElemento);
    }

    /** Devuelve una copia inmutable del conjunto. */
    public java.util.Set<Vehiculo> listar() {
        return Set.copyOf(index.values());
    }

    public int tamanio() {
        return index.size();
    }
    
    private void validar(Vehiculo elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El vehiculo no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getMarca() == null || elemento.getMarca().isBlank()) {
            throw new IllegalArgumentException("La marca no puede ser nula o en blanco");
        }
        if (elemento.getModelo() == null || elemento.getModelo().isBlank()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o en blanco");
        }
    }

}
