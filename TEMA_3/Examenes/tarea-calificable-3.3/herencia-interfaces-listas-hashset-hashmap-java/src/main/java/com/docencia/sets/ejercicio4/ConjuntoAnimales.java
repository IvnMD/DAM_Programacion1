package com.docencia.sets.ejercicio4;

import com.docencia.herencia.ejercicio4.Animal;
import com.docencia.herencia.ejercicio4.Perro;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un conjunto de {@link Animal} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoAnimales {

    private final Set<Animal> set;

    public ConjuntoAnimales(){
        this.set = new HashSet<>();
    }

    /** Anad... un elemento a la coleccion. */
    public void anadir(Animal elemento) {
        validar(elemento);

        if(set.contains(elemento)){
            throw new IllegalArgumentException();
        }
        set.add(elemento);
    }

    public Animal buscar(Animal animalBuscar) {
            if (animalBuscar == null) {
                throw new IllegalArgumentException();
            }
            for (Animal animal : set){
                if(animal.equals(animalBuscar)){
                    return animal;
                }
            }
        return null;
        
        
    }



    /** Busca por id. */
public Animal buscarPorId(UUID id) {
    
    if (id == null) {
            throw new IllegalArgumentException();
        }
        Animal animalBuscar = new Perro(id);
        for (Animal animal : set){
            if(animal.equals(animalBuscar)){
                return animal;
            }
        }
    return buscar(animalBuscar);
        
        
}

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return set.removeIf(animal -> animal.getId().equals(id));

        
        //  Animal existe = buscarPorId(id); //!Metodo igualmente valido
        //     if(existe == null){
        //         return false;
        //     }
        //     return set.remove(existe);
         
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Animal nuevoElemento) {
        validar(nuevoElemento);
        Animal existente = buscarPorId(id);
        if (existente == null){
            throw new NoSuchElementException();
        }
        if(!existente.equals(nuevoElemento)){
            return;
        }
        set.add(nuevoElemento);

    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Animal> listar() {
        return Set.copyOf(set);
    }

    public int tamanio() {
        return set.size();
    }

    private void validar(Animal elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El animal no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getNombre() == null || elemento.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco");
        }
    }

}
