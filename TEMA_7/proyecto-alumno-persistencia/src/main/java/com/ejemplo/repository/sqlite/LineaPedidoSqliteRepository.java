package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.LineaPedido;
import com.ejemplo.repository.ILineaPedidoRepository;

public class LineaPedidoSqliteRepository extends SQLiteConnectionManager implements ILineaPedidoRepository {

    LineaPedidoSqliteRepository() {
        super(rutaDB);
        
    }

    LineaPedidoSqliteRepository(String rutaDB) {
        super(rutaDB);
        
    }

    /*
     * private Long id;
     * private Long pedidoId;
     * private Long productoId;
     * private int cantidad;
     * private double precioUnitario;
     * private double subtotal;
     */
    @Override
    public boolean create(LineaPedido lineaPedido) {
        Connection connection = null;
        try {

            connection = this.getConnection();

            PreparedStatement sentencia = connection.prepareStatement(
                    "INSERT INTO linea_pedido(id, pedidoId, productoId, cantidad, precioUnitario, subtotal)"
                            + " values(?,?,?,?,?,?)");
            sentencia.setLong(1, lineaPedido.getId());
            sentencia.setLong(2, lineaPedido.getPedidoId());
            sentencia.setLong(3, lineaPedido.getProductoId());
            sentencia.setInt(4, lineaPedido.getCantidad());
            sentencia.setDouble(5, lineaPedido.getPrecioUnitario());
            sentencia.setDouble(6, lineaPedido.getSubtotal());

            sentencia.execute();

        } catch (Exception e) {
            System.err.println("No se ha podido almacenar la linea de pedido " + lineaPedido.getId());
            return false;
        } finally {
            this.closseConnection(connection);
        }
        return true;
    }

    /*
     * private Long id;
     * private Long pedidoId;
     * private Long productoId;
     * private int cantidad;
     * private double precioUnitario;
     * private double subtotal;
     */
    @Override
    public List<LineaPedido> findAll() {
        Connection connection = null;
        ArrayList<LineaPedido> lineaPedidos = new ArrayList<LineaPedido>();
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM linea_pedido");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                long miId = Long.valueOf(id);
                long pedidoId = resultado.getLong("nif");
                Long productoId = resultado.getLong("nombre");
                int cantidad = resultado.getInt("cantidad");
                double precioUnitario = resultado.getDouble("precioUnitario");
                double subtotal = resultado.getDouble("subtotal");
                LineaPedido lineaPedido = new LineaPedido(miId, pedidoId, productoId, cantidad, precioUnitario,
                        subtotal);
                lineaPedidos.add(lineaPedido);
            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos");
            return new ArrayList<LineaPedido>();
        } finally {
            this.closseConnection(connection);
        }
        return lineaPedidos;
    }

    /*
     * private Long id;
     * private Long pedidoId;
     * private Long productoId;
     * private int cantidad;
     * private double precioUnitario;
     * private double subtotal;
     */
    @Override
    public LineaPedido findById(Long id) {
        Connection connection = null;
        LineaPedido lineaPedido = null;
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM linea_pedido as lp where lp.id =");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                long miId = Long.valueOf(id);
                long pedidoId = resultado.getLong("nif");
                Long productoId = resultado.getLong("nombre");
                int cantidad = resultado.getInt("cantidad");
                double precioUnitario = resultado.getDouble("precioUnitario");
                double subtotal = resultado.getDouble("subtotal");
                lineaPedido = new LineaPedido(miId, pedidoId, productoId, cantidad, precioUnitario, subtotal);
                return lineaPedido;
            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos");

        } finally {
            this.closseConnection(connection);
        }
        return lineaPedido;
    }

    /*
     * private Long id;
     * private Long pedidoId;
     * private Long productoId;
     * private int cantidad;
     * private double precioUnitario;
     * private double subtotal;
     */
    @Override
    public boolean update(LineaPedido lineaPedido) {
        Connection connection = null;
        String sql = "UPDATE cliente as ci set pedidoId = ?, productoId = ?, cantidad = ?, precioUnitario = ?,"
                + " ciudad = ?, pais = ?, activo = ? where ci.id = ?";
        try {

            connection = this.getConnection();

            PreparedStatement sentencia = connection.prepareStatement(
                    "INSERT INTO linea_pedido(pedidoId, productoId, cantidad, precioUnitario, subtotal)"
                            + " values(?,?,?,?,?,?)");
            sentencia.setLong(1, lineaPedido.getId());
            sentencia.setLong(2, lineaPedido.getPedidoId());
            sentencia.setLong(3, lineaPedido.getProductoId());
            sentencia.setInt(4, lineaPedido.getCantidad());
            sentencia.setDouble(5, lineaPedido.getPrecioUnitario());
            sentencia.setDouble(6, lineaPedido.getSubtotal());

            sentencia.execute();

        } catch (Exception e) {
            System.err.println("No se ha podido almacenar la linea de pedido " + lineaPedido.getId());
            return false;
        } finally {
            this.closseConnection(connection);
        }
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE * FROM linea_pedido as pe where pe.id =" + id;
        return super.deleteById(sql);

    }

}
