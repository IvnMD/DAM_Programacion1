package com.ejemplo.repository.sqlite;

import com.ejemplo.model.*;
import com.ejemplo.repository.IProveedorRepository;
import java.sql.*;
import java.util.*;

public class ProveedorSqliteRepository implements IProveedorRepository {

    @Override
    public boolean crear(Proveedor proveedor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public Proveedor buscarPorCif(String cif) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorCif'");
    }

    @Override
    public List<Proveedor> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    @Override
    public boolean actualizar(Proveedor proveedor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public boolean borrarPorCif(String cif) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarPorCif'");
    }

    @Override
    public List<Proveedor> listarActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarActivos'");
    }

    @Override
    public List<Proveedor> buscarPorCiudad(String ciudad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorCiudad'");
    }

    @Override
    public Proveedor buscarPorEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorEmail'");
    }

    

}
