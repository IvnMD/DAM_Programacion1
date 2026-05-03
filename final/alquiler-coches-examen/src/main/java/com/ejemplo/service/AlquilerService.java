package com.ejemplo.service;

import com.ejemplo.model.Alquiler;
import com.ejemplo.model.Vehiculo;
import com.ejemplo.repository.IAlquilerRepository;
import com.ejemplo.repository.IClienteRepository;
import com.ejemplo.repository.IVehiculoRepository;
import com.ejemplo.repository.sqlite.AlquilerSqliteRepository;
import com.ejemplo.repository.sqlite.ClienteSqliteRepository;
import com.ejemplo.repository.sqlite.VehiculoSqliteRepository;
import com.ejemplo.validation.ValidationUtils;
import java.time.LocalDate;
import java.util.List;

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
          return repository.create(alquiler);
    }


    @Override
    public List<Alquiler> findAll() {
                        return repository.findAll();
    }

    @Override
    public Alquiler findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public boolean cancelById(Integer id) {
        return repository.cancelById(id);
    }

    @Override
    public boolean completeById(Integer id) {
        return repository.completeById(id);
        }

    @Override
    public Alquiler findByCliente(String dniCliente) {
        return repository.findByCliente(dniCliente);
    }

    @Override
    public Alquiler findByVehiculo(Integer idVehiculo) {
      return repository.findByVehiculo(idVehiculo);
    }

    @Override
    public boolean existsActiveRental(String dniCliente, Integer idVehiculo, LocalDate fechaInicio,
            LocalDate fechaFin) {
                return repository.existsActiveRental(dniCliente, idVehiculo, fechaInicio, fechaFin);
            }


}
