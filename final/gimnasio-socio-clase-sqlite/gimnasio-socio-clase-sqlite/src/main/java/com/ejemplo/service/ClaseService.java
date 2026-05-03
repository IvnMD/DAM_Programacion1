package com.ejemplo.service;

import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Clase;
import com.ejemplo.model.ClaseMonitor;
import com.ejemplo.model.ClaseReservaSocio;
import com.ejemplo.repository.IClaseRepository;

public class ClaseService implements IClaseService {

    private final IClaseRepository repository;

    public ClaseService(IClaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(Clase clase) {
        if (clase == null
                || clase.getNombre() == null || clase.getNombre().trim().isEmpty()
                || clase.getTipo() == null || clase.getTipo().trim().isEmpty()
                || clase.getCupoMaximo() <= 0
                || clase.getIdMonitor() == null || clase.getIdMonitor() <= 0) {
            return false;
        }
        return repository.create(clase);
    }

    @Override
    public Clase findById(Integer id) {
        if (id == null || id <= 0)
            return null; // findByIdEmptyTest: findById(0) → null
        return repository.findById(id);
    }

    @Override
    public List<Clase> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Clase clase) {
        if (clase == null
                || clase.getId() == null || clase.getId() <= 0
                || clase.getNombre() == null || clase.getNombre().trim().isEmpty()) {
            return false; // updateEmptyTest: nombre " " → false
        }
        return repository.update(clase);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (id == null || id <= 0)
            return false; // deleteByIdEmptyTest: deleteById(0) → false
        return repository.deleteById(id);
    }

    @Override
    public List<Clase> findDisponibles() {
        return repository.findDisponibles();
    }

    @Override
    public List<Clase> findByTipo(String tipo) {
        if (tipo == null || tipo.isBlank())
            return new ArrayList<>(); // findByTipoNullTest, findByTipoEmptyTest
        return repository.findByTipo(tipo);
    }

    @Override
    public List<Clase> findByMonitor(Integer idMonitor) {
        if (idMonitor == null || idMonitor <= 0)
            return new ArrayList<>(); // findByMonitorNullTest, findByMonitorEmptyTest
        return repository.findByMonitor(idMonitor);
    }

    @Override
    public List<ClaseMonitor> findClasesConMonitor() {
        return repository.findClasesConMonitor();
    }

    @Override
    public List<ClaseReservaSocio> findReservasConSocio() {
        return repository.findReservasConSocio();
    }
}
