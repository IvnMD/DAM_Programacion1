package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    boolean create(Cliente cliente);

        Cliente findByDni(String dni);

    List<Cliente> findAll();

    boolean update(Cliente cliente);

    boolean deleteByDni(String dni);

    List<Cliente> findActivos();

    Cliente findByEmail(String email);
}
