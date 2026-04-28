package com.ejemplo.service;

import java.util.List;

import com.ejemplo.model.*;
import com.ejemplo.repository.*;
import com.ejemplo.repository.sqlite.*;
import com.ejemplo.validation.ValidationUtils;

public class ClienteService implements IClienteService {
    private final IClienteRepository repository;
    public ClienteService() { this.repository = new ClienteSqliteRepository(); }
    @Override
    public boolean create(Cliente cliente) {
        if (cliente == null){
            return false;
        }
        if (!ValidationUtils.isValidCliente(cliente)){
            return false;
        }
        return repository.crear(cliente);
    }
    @Override
    public Cliente findByDni(String dni) {
        if (!ValidationUtils.isValidDni(dni)){
            return null;
        }
        return repository.buscarPorId(dni);
        
    }
    @Override
    public List<Cliente> findAll() {
        return repository.listarTodos();
        
    }
    @Override
    public boolean update(Cliente cliente) {
        if (!ValidationUtils.isValidCliente(cliente)){
            return false;
        }

        return repository.actualizar(cliente);
        
    }
    @Override
    public boolean deleteByDni(String dni) {
        if (!ValidationUtils.isValidDni(dni)){
            return false;
        }
        return repository.borrarPorDni(dni);    
    }

    @Override
    public List<Cliente> findActivos() {
        return repository.buscarActivos();
        
    }
    @Override
    public List<Cliente> findByCiudad(String ciudad) {
      if (!ValidationUtils.isValidCiudad(ciudad)){
        return null;
      }
       return repository.buscarPorCiudad(ciudad); 
    }
    @Override
    public Cliente findByEmail(String email) {
        if (!ValidationUtils.isValidEmail(email)){
            return null;
        }
        return repository.buscarPorEmail(email);
    }

   }
