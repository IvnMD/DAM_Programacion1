package com.docencia.maps.ejercicio8;

import com.docencia.herencia.ejercicio8.Pago;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un mapa de {@link Pago} usando internamente {@link HashMap}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class MapaPagos {
    private final Map<UUID, Pago> index;



    public MapaPagos(){
        index = new HashMap<>();
    }

    /** Anad... un elemento a la coleccion. */
    public void anadir(Pago elemento) {
        validar(elemento);
        //! Si existe, salgo, si no añado
        Pago existe = buscarPorId(elemento.getId());
        if(existe != null){
            throw new IllegalArgumentException();
        }
        // if(index.containsValue(elemento)){   //? Metodo alternativo
        //     throw new IllegalArgumentException();
        // }
        index.put(elemento.getId(), elemento);
    }

    /** Busca por id. */
    public Pago buscarPorId(UUID id) {
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
    public void modificar(UUID id, Pago nuevoElemento) {
        Pago elemento = buscarPorId(id);
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
    public java.util.Set<Pago> listar() {
        return Set.copyOf(index.values());
    }

    public int tamanio() {
        return index.size();
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
