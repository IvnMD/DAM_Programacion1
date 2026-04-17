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
     * private Long pedidoId;
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
        Connection connection = null;
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        String sql = "SELECT * FROM pedido as pe where pe.id =";
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                long miId = Long.valueOf(id);
                String numero = resultado.getString("numero");
                Long clienteId = resultado.getLong("clienteId");
                String fecha = resultado.getString("fecha");
                String estado = resultado.getString("estado");
                double total = resultado.getDouble("total");
                Pedido pedido = new Pedido(miId, numero, clienteId, fecha, estado, total);
                pedidos.add(pedido);
                return pedidos;
            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos");

        } finally {
            this.closseConnection(connection);
        }
        return pedidos;
    }

    /*
     * private Long id;
     * private String numero;
     * private Long clienteId;
     * private String fecha;
     * private String estado;
     * private double total;
     */
    @Override
    public Pedido findById(Long id) {
        Connection connection = null;
        Pedido pedido = null;
        String sql = "SELECT * FROM pedido as pe where pe.id =";
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                long miId = Long.valueOf(id);
                String numero = resultado.getString("numero");
                Long clienteId = resultado.getLong("clienteId");
                String fecha = resultado.getString("fecha");
                String estado = resultado.getString("estado");
                double total = resultado.getDouble("total");
                pedido = new Pedido(miId, numero, clienteId, fecha, estado, total);

                return pedido;
            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos");

        } finally {
            this.closseConnection(connection);
        }
        return pedido;
    }

    @Override
    public boolean update(Pedido pedido) {
        Connection connection = null;
        String sql = "UPDATE pedido as pe set numero = ?, clienteId = ?, fecha = ?, estado = ?,"
                + " total = ? where pe.id = ?";
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.setString(1, pedido.getNumero());
            sentencia.setLong(2, pedido.getClienteId());
            sentencia.setString(3, pedido.getFecha());
            sentencia.setString(4, pedido.getEstado());
            sentencia.setDouble(5, pedido.getTotal());

            sentencia.setLong(6, pedido.getId());

            sentencia.executeUpdate();

        } catch (Exception e) {
            System.err.println("No se han podido actulizar elementos" + pedido.getId());
            return false;
        } finally {
            this.closseConnection(connection);
        }
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE * FROM pedido as pe where pe.id =" + id;
        return super.deleteById(sql);

    }

}
