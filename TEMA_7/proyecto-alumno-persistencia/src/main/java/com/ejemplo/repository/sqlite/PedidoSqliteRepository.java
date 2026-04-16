package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Pedido;
import com.ejemplo.repository.IPedidoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoSqliteRepository extends SQLiteConnectionManager implements IPedidoRepository {

    public PedidoSqliteRepository() {
        super(rutaDB);
    }

    /**
     * private Long id;
     * private String numero;
     * private Long clienteId;
     * private String fecha;
     * private String estado;
     * private double total;
     */

    @Override
    public boolean create(Pedido pedido) {
        try {
            Connection connection = this.getConnection();

            PreparedStatement sentencia = connection.prepareStatement(
                    "INSERT INTO pedido(id, numero, cliente_id, fecha, estado, total)"
                            + " values(?,?,?,?,?,?)");
            sentencia.setLong(1, pedido.getId());
            sentencia.setString(2, pedido.getNumero());
            sentencia.setLong(3, pedido.getClienteId());
            sentencia.setString(4, pedido.getFecha());
            sentencia.setString(5, pedido.getEstado());
            sentencia.setDouble(6, pedido.getTotal());

            return sentencia.execute();
        } catch (Exception e) {
            System.err.println("Nose ha podido almacenar el pedido: " + pedido.getId());
            return false;
        }

    }

    @Override
    public List<Pedido> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Pedido findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(Pedido pedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE * FROM pedido as pe where pe.id =" + id;
        return super.deleteById(sql);

    }

}
