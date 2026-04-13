package com.docencia.ficheros.repo.interfaces;

import java.util.List;

import com.docencia.ficheros.model.Cliente;

public interface IClienteRepository {
    public List<Cliente> findAll();
    public Cliente findById(int id);
}
