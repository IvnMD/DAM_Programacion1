package com.ejemplo.repository;

import java.util.List;

import com.ejemplo.model.*;

public interface IClienteRepository {
    boolean crear(Cliente cliente);
    Cliente buscarPorId(String dni);
    List<Cliente> listarTodos();
    boolean actualizar(Cliente cliente);
    boolean borrarPorDni(String dni);
    List<Cliente> buscarActivos();
    List<Cliente> buscarPorCiudad(String ciudad);
    Cliente buscarPorEmail(String email);
}
