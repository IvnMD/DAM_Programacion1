package com.ejemplo.repository;

import com.ejemplo.model.Alquiler;
import com.ejemplo.model.Cliente;
import com.ejemplo.model.Vehiculo;

import java.time.LocalDate;
import java.util.List;

public interface IAlquilerRepository {
        boolean create(Alquiler alquiler);
    List<Alquiler> findAll();
    Alquiler findById(Integer id);
    boolean update(Alquiler alquiler);
    boolean cancelById(Integer id);
    boolean completeById(Integer id);
    Alquiler findByCliente(String dni_cliente);
    Alquiler findByVehiculo(Integer id_vehiculo);
    boolean existsActiveRental(String dniCliente, Integer idVehiculo, LocalDate fechaInicio,
            LocalDate fechaFin);
    Alquiler findByalquiler(Integer id_alquiler);
}
