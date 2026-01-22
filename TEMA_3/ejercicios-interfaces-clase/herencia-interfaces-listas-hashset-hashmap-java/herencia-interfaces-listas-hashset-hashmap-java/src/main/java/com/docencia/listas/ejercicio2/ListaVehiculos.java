package com.docencia.listas.ejercicio2;

import com.docencia.herencia.ejercicio2.Coche;
import com.docencia.herencia.ejercicio2.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona una lista de {@link Vehiculo} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten vehiculos con marca/modelo nulos o en blanco.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaVehiculos {

    private final List<Vehiculo> vehiculos = new ArrayList<>();

    public void anadir(Vehiculo vehiculo) {
        validar(vehiculo);
        if (vehiculos.contains(vehiculo)){
            throw new IllegalArgumentException();
        }
        vehiculos.add(vehiculo);
    }

    public Vehiculo buscarPorId(UUID id) {
        if (id == null){
            throw new IllegalArgumentException();
        }
        for (Vehiculo vehiculo : vehiculos) {
            if(vehiculo.getId().equals(id)){
                return vehiculo;
            }
        }
        Vehiculo vehiculo = new Coche (id);
        int posicion = vehiculos.indexOf(vehiculo);
        if(posicion < 0){
            return null;
        }
        return vehiculos.get(posicion);
    }

    public boolean eliminarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return vehiculos.removeIf(vehiculo -> vehiculo.getId().equals(id));
    }

    public void modificar(UUID id, Vehiculo nuevoVehiculo) {
        validar(nuevoVehiculo);
        Vehiculo existente = buscarPorId(id);
        if (existente == null){
            throw new NoSuchElementException();
        }
        if(!existente.equals(nuevoVehiculo)){
            throw new IllegalArgumentException();
        }
        int indice = vehiculos.indexOf(existente);
        vehiculos.set(indice, nuevoVehiculo);
            
    }

    public List<Vehiculo> listar() {
        return List.copyOf(vehiculos);
    }

    public int tamanio() {
        int resultado = 0;
        resultado = vehiculos.size();

        return resultado;
    }

    private boolean existeId(UUID id) {
        return vehiculos.stream().anyMatch(v -> v.getId().equals(id));
    }

    private void validar(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehiculo no puede ser nulo");
        }
        if (vehiculo.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (vehiculo.getMarca() == null || vehiculo.getMarca().isBlank()) {
            throw new IllegalArgumentException("La marca no puede ser nula o en blanco");
        }
        if (vehiculo.getModelo() == null || vehiculo.getModelo().isBlank()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o en blanco");
        }
    }
}
