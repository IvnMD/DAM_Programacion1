package com.ejemplo.repository;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.Vehiculo;
import java.util.List;

public interface IVehiculoRepository {
    boolean create(Vehiculo vehiculo);
    List<Vehiculo> findAll();
    Vehiculo findById(Integer id);
    boolean update(Vehiculo vehiculo);
    boolean deleteById(Integer id);
    List <Vehiculo> findByTipo(String tipo);
}
