package com.docencia.sets.ejercicio1;

import com.docencia.herencia.ejercicio1.Alumno;
import com.docencia.herencia.ejercicio1.Persona;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un conjunto de {@link Persona} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoPersonas {

    private final Set<Persona> set;

    public ConjuntoPersonas(){
        this.set = new HashSet<>();
    }

    /** Anad... un elemento a la coleccion. */
    public void anadir(Persona elemento) {
        validar(elemento);
        if(set.contains(elemento)){
            throw new IllegalArgumentException();
        }
        set.add(elemento);
    }

    public Persona buscar(Persona personaBuscar) {
            if (personaBuscar == null) {
                throw new IllegalArgumentException();
            }
            for (Persona persona : set){
                if(persona.equals(personaBuscar)){
                    return persona;
                }
            }
        return null;
        
        
    }



    /** Busca por id. */
public Persona buscarPorId(UUID id) {
    
    if (id == null) {
            throw new IllegalArgumentException();
        }
        Persona personaBuscar = new Alumno(id);
        for (Persona persona : set){
            if(persona.equals(personaBuscar)){
                return persona;
            }
        }
    return buscar(personaBuscar);
        
        
}

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return set.removeIf(persona -> persona.getId().equals(id));

        
        //  Persona existe = buscarPorId(id); //!Metodo igualmente valido
        //     if(existe == null){
        //         return false;
        //     }
        //     return set.remove(existe);
         
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Persona nuevoElemento) {
        validar(nuevoElemento);
        Persona existente = buscarPorId(id);
        if (existente == null){
            throw new NoSuchElementException();
        }
        if(!existente.equals(nuevoElemento)){
            return;
        }
        set.add(nuevoElemento);

    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Persona> listar() {
        return Set.copyOf(set);
    }

    public int tamanio() {
        return set.size();
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
