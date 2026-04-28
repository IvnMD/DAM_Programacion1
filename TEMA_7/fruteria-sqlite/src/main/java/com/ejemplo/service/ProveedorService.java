package com.ejemplo.service;

import java.util.List;

import com.ejemplo.model.*;
import com.ejemplo.repository.*;
import com.ejemplo.repository.sqlite.*;
import com.ejemplo.validation.ValidationUtils;

public class ProveedorService implements IProveedorService {
    private final IProveedorRepository repository;
    public ProveedorService() { this.repository = new ProveedorSqliteRepository(); }
    @Override
    public boolean create(Proveedor proveedor) {
        if (!ValidationUtils.isValidProveedor(proveedor)){
            return false;
        }
        return repository.crear(proveedor);
        
    }
    @Override
    public Proveedor findByCif(String cif) {
        if (!ValidationUtils.isValidCif(cif)){
            return null;
        }
        return repository.buscarPorCif(cif);
        
    }
    @Override
    public List<Proveedor> findAll() {
 
        return repository.listarTodos();
    }
    @Override
    public boolean update(Proveedor proveedor) {
        if (!ValidationUtils.isValidProveedor(proveedor)){
            return false;
        }
        return repository.actualizar(proveedor);
    }

    @Override
    public boolean deleteByCif(String cif) {
        if (!ValidationUtils.isValidCif(cif)){
            return false;
        }
        return repository.borrarPorCif(cif);
    }
    @Override
    public List<Proveedor> findActivos() {
        return repository.listarActivos();
        
    }
    @Override
    public List<Proveedor> findByCiudad(String ciudad) {
        if (!ValidationUtils.isValidCiudad(ciudad)){
            return null;
        }
        return repository.buscarPorCiudad(ciudad);
        
    }
    @Override
    public Proveedor findByEmail(String email) {
        if (!ValidationUtils.isValidEmail(email)){
            return null;
        }
        return repository.buscarPorEmail(email);
    }


}
