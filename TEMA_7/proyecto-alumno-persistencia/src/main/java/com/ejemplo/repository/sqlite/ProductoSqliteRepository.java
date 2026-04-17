package com.ejemplo.repository.sqlite;

import java.util.List;

import com.ejemplo.model.Producto;
import com.ejemplo.repository.IProductoRepository;

public class ProductoSqliteRepository extends SQLiteConnectionManager implements IProductoRepository {


    

    public ProductoSqliteRepository() {
        super(rutaDB);
    }

    @Override
    public boolean create(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<Producto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Producto findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE * FROM producto as pr where pr.id =" + id;
        return super.deleteById(sql);

    }
    
}
