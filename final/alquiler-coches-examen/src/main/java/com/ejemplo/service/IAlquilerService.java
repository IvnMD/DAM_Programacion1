package com.ejemplo.service;

import com.ejemplo.model.Alquiler;
import java.time.LocalDate;
import java.util.List;

public interface IAlquilerService {

    boolean create(Alquiler alquiler);

    Alquiler findById(Integer id);

    List<Alquiler> findAll();

    boolean cancelById(Integer id);

    boolean completeById(Integer id);

    Alquiler findByCliente(String dniCliente);

    Alquiler findByVehiculo(Integer idVehiculo);

    boolean existsActiveRental(String dniCliente, Integer idVehiculo, LocalDate fechaInicio, LocalDate fechaFin);
}
