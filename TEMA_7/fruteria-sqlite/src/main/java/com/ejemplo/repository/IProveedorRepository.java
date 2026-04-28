package com.ejemplo.repository;

import java.util.List;

import com.ejemplo.model.*;

public interface IProveedorRepository {
    boolean crear(Proveedor proveedor);
    Proveedor buscarPorCif(String cif);
    List<Proveedor> listarTodos();
    boolean actualizar(Proveedor proveedor);
    boolean borrarPorCif(String cif);
    List<Proveedor> listarActivos();
    List<Proveedor> buscarPorCiudad(String ciudad);
    Proveedor buscarPorEmail(String email);
}
