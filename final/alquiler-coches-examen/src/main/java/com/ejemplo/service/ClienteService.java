package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;
import com.ejemplo.repository.sqlite.ClienteSqliteRepository;
import com.ejemplo.validation.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class ClienteService implements IClienteService {
    private final IClienteRepository repository;

    public ClienteService() { this.repository = new ClienteSqliteRepository(); }

    @Override
    public boolean create(Cliente cliente) {
        // if(!ValidationUtils.isValidCliente())
        return repository.create(cliente);
    }

    @Override
    public Cliente findByDni(String dni) {
        if (!ValidationUtils.isValidDni(dni)){
            return null;
        }
        return repository.findByDni(dni);
        
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Cliente cliente) {
        
        return repository.update(cliente);
    }

    @Override
    public boolean deleteByDni(String dni) {
        return repository.deleteById(dni);
    }

    @Override
    public List<Cliente> findActivos() {
             List<Cliente> resultado = new ArrayList<>();
        for (Cliente item : repository.findAll()) {
            if (item.isActivo()) {
                resultado.add(item);
            }
        }
        return resultado;
    }


    @Override
    public Cliente findByEmail(String email) {
        if (!ValidationUtils.isValidEmail(email)){
            return null;
        }
        return repository.findByEmail(email);
    }

    
}
