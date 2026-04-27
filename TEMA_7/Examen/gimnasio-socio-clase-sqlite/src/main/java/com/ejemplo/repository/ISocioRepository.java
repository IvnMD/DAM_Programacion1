package com.ejemplo.repository;

import java.util.List;

import com.ejemplo.model.Socio;

public interface ISocioRepository {
    
    boolean create(Socio socio);
    List<Socio> findAll();
    Socio findById(Integer id);
    boolean update(Socio socio);
    boolean deleteById(Integer id);
}
