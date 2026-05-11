package com.ejemplo.service;

import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Vehiculo;
import com.ejemplo.repository.IVehiculoRepository;
import com.ejemplo.repository.sqlite.VehiculoSqliteRepository;
import com.ejemplo.validation.ValidationUtils;

public class VehiculoService implements IVehiculoService {
    private final IVehiculoRepository repository;

    public VehiculoService() {
        this.repository = new VehiculoSqliteRepository();
    }

    @Override
    public boolean create(Vehiculo vehiculo) {
        if (!ValidationUtils.isValidVehiculo(vehiculo)) {
            return false;
        }
        return repository.create(vehiculo);
    }

    @Override
    public Vehiculo findById(Integer id) {
        if (!ValidationUtils.isValidId(id)) {
            return null;
        }
        return repository.findById(id);
    }

    @Override
    public List<Vehiculo> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Vehiculo vehiculo) {
        if (!ValidationUtils.isValidVehiculo(vehiculo)) {
            return false;
        }
        return repository.update(vehiculo);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (!ValidationUtils.isValidId(id)) {
            return false;
        }
        return repository.deleteById(id);
    }

    @Override
    public List<Vehiculo> findByTipo(String tipo) {
        if (!ValidationUtils.isValidTipoVehiculo(tipo)) {
            return new ArrayList<>();
        }
        return repository.findByTipo(tipo);
    }

}
