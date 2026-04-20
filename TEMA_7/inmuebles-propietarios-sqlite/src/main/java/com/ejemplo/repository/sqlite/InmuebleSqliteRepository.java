package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Inmueble;
import com.ejemplo.repository.IInmuebleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class InmuebleSqliteRepository extends SQLiteConnectionManager implements IInmuebleRepository {

    public InmuebleSqliteRepository() {
        super(rutaDb);
    }

    @Override
    public boolean create(Inmueble inmueble) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<Inmueble> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Inmueble findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(Inmueble inmueble) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
