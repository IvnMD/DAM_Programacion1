package com.ejemplo.repository;

import java.util.List;

import com.ejemplo.model.Vehiculo;

public interface IVehiculoRepository {
    boolean create(Vehiculo vehiculo);

    Vehiculo findById(Integer id);

    List<Vehiculo> findAll();

    boolean update(Vehiculo vehiculo);

    boolean deleteById(Integer id);

    List<Vehiculo> findByTipo(String tipo);
}
