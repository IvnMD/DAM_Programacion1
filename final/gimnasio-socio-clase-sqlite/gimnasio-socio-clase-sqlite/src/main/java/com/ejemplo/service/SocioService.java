package com.ejemplo.service;

import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Socio;
import com.ejemplo.model.SocioReserva;
import com.ejemplo.repository.ISocioRepository;
import com.ejemplo.repository.sqlite.SocioSqliteRepository;

public class SocioService implements ISocioService {

      private final ISocioRepository repository;

    public SocioService() {
        this.repository = new SocioSqliteRepository();
    }

    @Override
    public boolean create(Socio socio) {
        if (socio == null
            || socio.getDni() == null || socio.getDni().trim().isEmpty()
            || socio.getNombre() == null || socio.getNombre().trim().isEmpty()
            || socio.getPlan() == null || socio.getPlan().trim().isEmpty()) {
            return false;
        }
        return repository.create(socio);
    }

    @Override
    public Socio findById(Integer id) {
        if (id == null || id <= 0) return null;   // findByIdEmptyTest: findById(0) → null
        return repository.findById(id);
    }

    @Override
    public List<Socio> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Socio socio) {
        if (socio == null
            || socio.getId() == null || socio.getId() <= 0
            || socio.getNombre() == null || socio.getNombre().trim().isEmpty()) {
            return false;
        }
        return repository.update(socio);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (id == null || id <= 0) return false;   // deleteByIdEmptyTest: deleteById(0) → false
        return repository.deleteById(id);
    }

    @Override
    public List<Socio> findActivos() {
        return repository.findActivos();
    }

    @Override
    public List<Socio> findByPlan(String plan) {
        if (plan == null || plan.isBlank()) return new ArrayList<>();   // devuelve lista vacía, no null
        return repository.findByPlan(plan);
    }

    @Override
    public List<SocioReserva> findSociosConReservas() {
        return repository.findSociosConReservas();
    }
}

