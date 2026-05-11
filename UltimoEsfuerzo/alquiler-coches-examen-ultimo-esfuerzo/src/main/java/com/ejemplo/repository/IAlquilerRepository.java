package com.ejemplo.repository;

import java.time.LocalDate;
import java.util.List;

import com.ejemplo.model.Alquiler;

public interface IAlquilerRepository {
       boolean create(Alquiler alquiler);

    Alquiler findById(Integer id);

    List<Alquiler> findAll();

    boolean cancelById(Integer id);

    boolean completeById(Integer id);

    List<Alquiler> findByCliente(String dniCliente);

    List<Alquiler> findByVehiculo(Integer idVehiculo);

    boolean existsActiveRental(String dniCliente, Integer idVehiculo, LocalDate fechaInicio, LocalDate fechaFin);
}
