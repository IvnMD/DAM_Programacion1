package com.ejemplo.service;

import com.ejemplo.model.Vehiculo;
import com.ejemplo.repository.IVehiculoRepository;
import com.ejemplo.repository.sqlite.VehiculoSqliteRepository;
import com.ejemplo.validation.ValidationUtils;
import java.util.List;

public class VehiculoService implements IVehiculoService {
    private final IVehiculoRepository repository;

    public VehiculoService() { this.repository = new VehiculoSqliteRepository(); }

    @Override
    public boolean create(Vehiculo vehiculo) {
        return repository.create(vehiculo);
    }

    @Override
    public Vehiculo findById(Integer id) {
        //   if (!ValidationUtils.isValidId(id)){
        //     return null;
        // }
        return repository.findById(id);
    }

    @Override
    public List<Vehiculo> findAll() {
                        return repository.findAll();
    }

    @Override
    public boolean update(Vehiculo vehiculo) {
       return repository.update(vehiculo);

    }

    @Override
    public boolean deleteById(Integer id) {
             return repository.deleteById(id);
    }

    @Override
    public List<Vehiculo> findByTipo(String tipo) {
          if (!ValidationUtils.isValidTipoVehiculo(tipo)){
            return null;
        }
        return repository.findByTipo(tipo);
    }

    
}
