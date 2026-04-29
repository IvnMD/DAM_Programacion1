package com.ejemplo.repository.sqlite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ejemplo.model.Proveedor;
import com.ejemplo.repository.IProveedorRepository;

public class ProveedorSqliteRepository implements IProveedorRepository {

    /**
     * CREATE TABLE proveedor (
     * cif TEXT PRIMARY KEY,
     * nombre TEXT NOT NULL,
     * telefono TEXT,
     * email TEXT,
     * ciudad TEXT,
     * activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1)));
     */
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

        /**
     * CREATE TABLE proveedor (
     * cif TEXT PRIMARY KEY,
     * nombre TEXT NOT NULL,
     * telefono TEXT,
     * email TEXT,
     * ciudad TEXT,
     * activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1)));
     */
    private  Proveedor mapProveedor(ResultSet rs) throws SQLException {
        return new Proveedor(
            rs.getString("cif"),
            rs.getString("nombre"),
            rs.getString("telefono"),
            rs.getString("email"),
            rs.getString("ciudad"),
            rs.getInt("activo"));
            
        }
    

}
