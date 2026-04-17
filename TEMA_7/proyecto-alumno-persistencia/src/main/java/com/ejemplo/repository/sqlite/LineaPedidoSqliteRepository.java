package com.ejemplo.repository.sqlite;

import java.util.List;

import com.ejemplo.model.LineaPedido;
import com.ejemplo.repository.ILineaPedidoRepository;

public class LineaPedidoSqliteRepository  extends SQLiteConnectionManager implements ILineaPedidoRepository {

    LineaPedidoSqliteRepository() {
        super(rutaDB);
        //TODO Auto-generated constructor stub
    }
    LineaPedidoSqliteRepository(String rutaDB) {
        super(rutaDB);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(LineaPedido lineaPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<LineaPedido> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public LineaPedido findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(LineaPedido lineaPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE * FROM linea_pedido as pe where pe.id =" + id;
        return super.deleteById(sql);

    }

   }
