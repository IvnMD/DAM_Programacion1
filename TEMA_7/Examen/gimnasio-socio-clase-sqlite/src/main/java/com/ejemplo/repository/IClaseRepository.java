package com.ejemplo.repository;

import com.ejemplo.model.Clase;
import com.ejemplo.model.ClaseMonitor;
import com.ejemplo.model.ClaseReservaSocio;

import java.util.List;

public interface IClaseRepository {

    boolean create(Clase clase);
    List<Clase> findAll();
    Clase findById(Integer id);
    boolean update(Clase clase);
    boolean deleteById(Integer id);
}
