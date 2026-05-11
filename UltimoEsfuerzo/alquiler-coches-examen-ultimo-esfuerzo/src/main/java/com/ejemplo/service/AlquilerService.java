package com.ejemplo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Alquiler;
import com.ejemplo.repository.IAlquilerRepository;
import com.ejemplo.repository.IClienteRepository;
import com.ejemplo.repository.IVehiculoRepository;
import com.ejemplo.repository.sqlite.AlquilerSqliteRepository;
import com.ejemplo.repository.sqlite.ClienteSqliteRepository;
import com.ejemplo.repository.sqlite.VehiculoSqliteRepository;
import com.ejemplo.validation.ValidationUtils;

public class AlquilerService implements IAlquilerService {
    private final IAlquilerRepository repository;
    private final IClienteRepository clienteRepository;
    private final IVehiculoRepository vehiculoRepository;

    public AlquilerService() {
        this.repository = new AlquilerSqliteRepository();
        this.clienteRepository = new ClienteSqliteRepository();
        this.vehiculoRepository = new VehiculoSqliteRepository();
    }

    @Override
    public boolean create(Alquiler alquiler) {
        if (!ValidationUtils.isValidAlquiler(alquiler)){
            return false;
        }
        return repository.create(alquiler);
    }

    @Override
    public Alquiler findById(Integer id) {
        if (!ValidationUtils.isValidId(id)) {
            return null;
        }
        return repository.findById(id);
    }

    @Override
    public List<Alquiler> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean cancelById(Integer id) {
        if (!ValidationUtils.isValidId(id)) {
            return false;
        }
        return repository.cancelById(id);
    }

    @Override
    public boolean completeById(Integer id) {
                if (!ValidationUtils.isValidId(id)) {
            return false;
        }
        
        return repository.completeById(id);
    }

    @Override
    public List<Alquiler> findByCliente(String dniCliente) {
        if(!ValidationUtils.isValidDni(dniCliente)){
            return new ArrayList<>();
        }
        return repository.findByCliente(dniCliente);
    }

    @Override
    public List<Alquiler> findByVehiculo(Integer idVehiculo) {
        if(!ValidationUtils.isValidId(idVehiculo)){
            return new ArrayList<>();
        }
        return repository.findByVehiculo(idVehiculo);
    }

    @Override
    public boolean existsActiveRental(String dniCliente, Integer idVehiculo, LocalDate fechaInicio,
            LocalDate fechaFin) {
        return repository.existsActiveRental(dniCliente, idVehiculo, fechaInicio, fechaFin);
    }

}
