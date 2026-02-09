package com.docencia.listas.ejercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.docencia.herencia.ejercicio8.Pago;

/**
 * Gestiona una lista de {@link Pago} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten pagos con importe menor o igual a cero.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaPagos {

    private final List<Pago> pagos = new ArrayList<>();

    public void anadir(Pago pago) {
        validar(pago);
        if(pagos.contains(pago)){
            throw new IllegalArgumentException();
        }
        pagos.add(pago);
    }

    public Pago buscarPorId(UUID id) {
        if (id == null){
            throw new IllegalArgumentException();
        }
        for (Pago pago : pagos) {
            if(pago.getId().equals(id)){
                return pago;
            }
        }
        return null;
    }

    public boolean eliminarPorId(UUID id) {
        if (id == null){
            throw new IllegalArgumentException();
        }
        return pagos.removeIf(pagos -> pagos.getId().equals(id));
    }

    public void modificar(UUID id, Pago nuevoPago) {
        validar(nuevoPago);
        Pago existente = buscarPorId(id);
        if (existente == null){throw new NoSuchElementException();}
        if (!existente.equals(nuevoPago)){
            throw new IllegalArgumentException();
        }
        int indice = pagos.indexOf(existente);
        pagos.set(indice, nuevoPago);
    }

    public List<Pago> listar() {
        return List.copyOf(pagos);
    }

    public int tamanio() {
        return pagos.size();
    }

    private boolean existeId(UUID id) {
        return pagos.stream().anyMatch(p -> p.getId().equals(id));
    }

    private void validar(Pago pago) {
        if (pago == null) {
            throw new IllegalArgumentException("El pago no puede ser nulo");
        }
        if (pago.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (pago.getImporte() <= 0) {
            throw new IllegalArgumentException("El importe debe ser mayor que cero");
        }
    }
}
