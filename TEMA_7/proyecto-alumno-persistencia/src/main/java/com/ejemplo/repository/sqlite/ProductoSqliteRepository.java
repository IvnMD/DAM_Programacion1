package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Producto;
import com.ejemplo.model.Producto;
import com.ejemplo.repository.IProductoRepository;

public class ProductoSqliteRepository extends SQLiteConnectionManager implements IProductoRepository {

    public ProductoSqliteRepository() {
        super(rutaDB);
    }


    @Override
    public boolean create(Producto producto) {
        Connection connection = null;
        String sql = "INSERT INTO producto(id, sku, nombre, categoria, precio, stock, activo) values(?,?,?,?,?,?,?,?)";
        try {

            connection = this.getConnection();

            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setLong(1, producto.getId());
            sentencia.setString(2, producto.getSku());
            sentencia.setString(3, producto.getNombre());
            sentencia.setString(4, producto.getCategoria());
            sentencia.setDouble(5, producto.getPrecio());
            sentencia.setInt(6, producto.getStock());
            sentencia.setBoolean(7, producto.isActivo());

            sentencia.execute();

        } catch (Exception e) {
            System.err.println("No se ha podido crear el producto " + producto.getId());
            return false;
        } finally {
            this.closseConnection(connection);
        }
        return true;
    }
    /*
     * private Long id;
     * private String sku;
     * private String nombre;
     * private String categoria;
     * private double precio;
     * private int stock;
     * private boolean activo;
     */
    @Override
    public List<Producto> findAll() {
     Connection connection = null;
        ArrayList<Producto> Productos = new ArrayList<Producto>();
        String sql = "SELECT * FROM Productos";
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                long miId = Long.valueOf(id);
                String sku = resultado.getString("sku");
                String nombre = resultado.getString("nombre");
                String categoria = resultado.getString("categoria");
                double precio = resultado.getDouble("precio");
                int stock = resultado.getInt("stock");
                int activo = resultado.getInt("activo");
                boolean miActivo = Boolean.valueOf(String.valueOf(activo));
                Producto Producto = new Producto(miId, sku, nombre, categoria, precio, stock, miActivo);
                Productos.add(Producto);
            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos");
            return new ArrayList<Producto>();
        } finally {
            this.closseConnection(connection);
        }
        return Productos;
    }

    @Override
    public Producto findById(Long id) {
    Connection connection = null;
        ArrayList<Producto> Productos = new ArrayList<Producto>();
        Producto producto = null;
        String sql = "SELECT * FROM Productos as pr where pr.id =";
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                long miId = Long.valueOf(id);
                String sku = resultado.getString("sku");
                String nombre = resultado.getString("nombre");
                String categoria = resultado.getString("categoria");
                double precio = resultado.getDouble("precio");
                int stock = resultado.getInt("stock");
                int activo = resultado.getInt("activo");
                boolean miActivo = Boolean.valueOf(String.valueOf(activo));
                producto = new Producto(miId, sku, nombre, categoria, precio, stock, miActivo);
                
                return producto;
            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener producto");
        } finally {
            this.closseConnection(connection);
        }
        return producto;
    }

    @Override
    public boolean update(Producto producto) {
        Connection connection = null;
        String sql = "UPDATE Producto as pr set id = ?, sku = ?, nombre = ?, categoria = ?,"
                + " precio = ?, stock = ?, activo = ? where pr.id = ?";
        try {

            connection = this.getConnection();

            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setLong(1, producto.getId());
            sentencia.setString(2, producto.getSku());
            sentencia.setString(3, producto.getNombre());
            sentencia.setString(4, producto.getCategoria());
            sentencia.setDouble(5, producto.getPrecio());
            sentencia.setInt(6, producto.getStock());
            sentencia.setBoolean(7, producto.isActivo());

            sentencia.executeUpdate();

        } catch (Exception e) {
            System.err.println("No se ha podido actualizar el producto " + producto.getId());
            return false;
        } finally {
            this.closseConnection(connection);
        }
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE * FROM producto as pr where pr.id =" + id;
        return super.deleteById(sql);

    }

}
