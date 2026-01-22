package com.docencia.maps.ejercicio1;

import com.docencia.herencia.ejercicio1.Persona;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

import javax.swing.JPopupMenu.Separator;

/**
 * Gestiona un mapa de {@link Persona} usando internamente {@link HashMap}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class MapaPersonas {
    private final Map<UUID, Persona> index;

    public MapaPersonas(){
        index = new HashMap<>();
    }

    /** Anad... un elemento a la coleccion. */
    public void anadir(Persona elemento) {
        validar(elemento);
        //! Si existe, salgo, si no añado
        Persona existe = buscarPorId(elemento.getId());
        if(existe != null){
            throw new IllegalArgumentException();
        }
        // if(index.containsValue(elemento)){   //? Metodo alternativo
        //     throw new IllegalArgumentException();
        // }
        index.put(elemento.getId(), elemento);
    }

    /** Busca por id. */
    public Persona buscarPorId(UUID id) {
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
    public void modificar(UUID id, Persona nuevoElemento) {
        Persona persona = buscarPorId(id);
        if (persona == null){
            throw new NoSuchElementException();
        }
        validar(nuevoElemento);
        if(!persona.equals(nuevoElemento)){
            throw new IllegalArgumentException();
        }
        index.replace(id, nuevoElemento);
        // index.replace(id, persona, nuevoElemento);
    }

    /** Devuelve una copia inmutable del conjunto. */
    public java.util.Set<Persona> listar() {
        return Set.copyOf(index.values());
    }

    public int tamanio() {
        return index.size();
    }
    private void validar(Persona elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("La persona no puede ser nula");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getNombre() == null || elemento.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco");
        }
        if (elemento.getEdad() < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
    }

}
