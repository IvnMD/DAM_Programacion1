package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;
import com.ejemplo.repository.sqlite.ClienteSqliteRepository;

import java.util.ArrayList;
import java.util.List;

public class ClienteService implements IClienteService {

    private final IClienteRepository repository;


    public ClienteService() {
        this.repository = new ClienteSqliteRepository();
    }


    @Override
    public boolean crear(Cliente cliente) {
        if (!validar(cliente) || repository.findById(cliente.getDni()) != null) {
            return false;
        }
        return repository.create(cliente);
    }


    @Override
    public Cliente buscarPorDni(String dni) {
        return repository.findById(dni);
    }


    @Override
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }


    @Override
    public boolean actualizar(Cliente cliente) {
        if (!validar(cliente) || repository.findById(cliente.getDni()) == null) {
            return false;
        }
        return repository.update(cliente);
    }


    @Override
    public boolean eliminar(String dni) {
        return repository.deleteById(dni);
    }


    @Override
    public List<Cliente> listarActivos() {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente item : repository.findAll()) {
            if (item.isActivo()) {
                resultado.add(item);
            }
        }
        return resultado;
    }


    @Override
    public List<Cliente> buscarPorCiudad(String ciudad) {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente item : repository.findAll()) {
            if (item.getCiudad() != null && item.getCiudad().equalsIgnoreCase(ciudad)) {
                resultado.add(item);
            }
        }
        return resultado;
    }


    @Override
    public int contarActivos() {
        return listarActivos().size();
    }


     private boolean validar(Cliente cliente) {
        return cliente != null && cliente.getDni() != null && cliente.getNombre() != null && !cliente.getNombre().trim().isEmpty();
    }

    
}
