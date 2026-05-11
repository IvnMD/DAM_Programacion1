package com.ejemplo.repository;

import java.util.List;

import com.ejemplo.model.Cliente;

public interface IClienteRepository {
      boolean create(Cliente cliente);

        Cliente findByDni(String dni);

    List<Cliente> findAll();

    boolean update(Cliente cliente);

    boolean deleteByDni(String dni);

    List<Cliente> findActivos();

    Cliente findByEmail(String email);
}
