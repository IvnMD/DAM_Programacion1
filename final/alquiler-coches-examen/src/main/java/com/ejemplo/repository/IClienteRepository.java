package com.ejemplo.repository;

import com.ejemplo.model.Cliente;
import java.util.List;

public interface IClienteRepository {

    boolean create(Cliente cliente);
    List<Cliente> findAll();
    Cliente findByDni(String dni);
    boolean update(Cliente cliente);
    boolean deleteById(String dni);
    List<Cliente> findActivos();
    Cliente findByEmail(String email);



}
