package com.ejemplo.service;

import com.ejemplo.model.Clase;
import com.ejemplo.model.ClaseMonitor;
import com.ejemplo.model.ClaseReservaSocio;
import com.ejemplo.repository.IClaseRepository;
import com.ejemplo.utils.Validaciones;

import java.util.ArrayList;
import java.util.List;

import jdk.jshell.execution.Util;

public class ClaseService implements IClaseService {

    private final IClaseRepository repository;

    public ClaseService(IClaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(Clase clase) {
        if (!(Validaciones.validarClase(clase))){
            return false;
        }
        return repository.create(clase);
    }

    @Override
    public Clase findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Clase> findAll() {
        return repository.findAll();
    }

    // @Override
    // public List<ClaseMonitor> findAllCM(){
    //     return repository.findAllCM();
    // }

    @Override
    public boolean update(Clase clase) {
        if (!(Validaciones.validarClase(clase)) || repository.findById(clase.getId()) == null) {
            return false;
        }
        return repository.update(clase);
    }

    @Override
    public boolean deleteById(Integer id) {
        return repository.deleteById(id);
    }

    @Override
    public List<Clase> findDisponibles() {
        List<Clase> resultado = new ArrayList<>();
        for (Clase item : repository.findAll()) {
            if (item.getPlazasDisponibles() > 0) {
                resultado.add(item);
            }
        }
        return resultado;
        
    }

    @Override
    public List<Clase> findByTipo(String tipo) {

    List<Clase> resultado = new ArrayList<>();
        for (Clase item : repository.findAll()) {
            if (item.getTipo() != null && item.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    @Override
    public List<Clase> findByMonitor(Integer idMonitor) {
    List<Clase> resultado = new ArrayList<>();
        for (Clase item : repository.findAll()) {
            if (item.getIdMonitor() != null && item.getIdMonitor().equals(idMonitor)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    @Override
    public List<ClaseMonitor> findClasesConMonitor() {
       List<ClaseMonitor> resultado = new ArrayList<>();
    //    List<Clase> claseBuscar = new ArrayList<>();
    //     for (ClaseMonitor item : repository.findAll()) {
    //         if (item.getClaseId() != null && item.getMonitorNombre() != null) {
    //             resultado.add(item);
    //         }
    //     }
        return resultado;
    }

    @Override
    public List<ClaseReservaSocio> findReservasConSocio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findReservasConSocio'");
    }

}
