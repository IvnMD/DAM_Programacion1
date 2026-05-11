package com.ejemplo.service;

import com.ejemplo.model.Vehiculo;
import java.util.List;

public interface IVehiculoService {
    boolean create(Vehiculo vehiculo);

    Vehiculo findById(Integer id);

    List<Vehiculo> findAll();

    boolean update(Vehiculo vehiculo);

    boolean deleteById(Integer id);

    List<Vehiculo> findByTipo(String tipo);
}
