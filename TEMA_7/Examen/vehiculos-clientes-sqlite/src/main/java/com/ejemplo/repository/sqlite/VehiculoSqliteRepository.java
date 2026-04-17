package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.Vehiculo;
import com.ejemplo.repository.IVehiculoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehiculoSqliteRepository extends SQLiteConnectionManager implements IVehiculoRepository {

    public VehiculoSqliteRepository() {
        super(rutaDb);
    }
    /**    private Long id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private Integer anio;
    private Integer kilometros;
    private Double precio;
    private boolean vendido;
    private String dniCliente; */
    @Override
    public boolean create(Vehiculo vehiculo) {
           Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("INSERT INTO vehiculo (id, matricula, marca, modelo, color, anio,"
                                     +" kilometros, precio, vendido, dniCliente) "
                            + " values (?,?,?,?,?,?,?,?,?,?)");
            sentencia.setLong(1, vehiculo.getId());
            sentencia.setString(2, vehiculo.getMatricula());
            sentencia.setString(3, vehiculo.getMarca());
            sentencia.setString(4, vehiculo.getModelo());
            sentencia.setString(5, vehiculo.getColor());
            sentencia.setInt(6, vehiculo.getAnio());
            sentencia.setInt(7, vehiculo.getKilometros());
            sentencia.setDouble(8, vehiculo.getPrecio());

            sentencia.setBoolean(9, vehiculo.isVendido());

             sentencia.setString(10, vehiculo.getDniCliente());

            sentencia.execute();
        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el cliente:" + vehiculo.getId());
            return false;
        } finally {
            this.closeConnection(connection);
        }
        return true;
    }

    @Override
    public List<Vehiculo> findAll() {
        Connection connection = null;
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        try {
            connection = this.getConnection();
            String sql = "SELECT * FROM vehiculo";
            PreparedStatement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                long miId = Long.valueOf(id);
                String matricula = resultado.getString("matricula");
                String marca = resultado.getString("marca");
                String modelo = resultado.getString("modelo");
                String color = resultado.getString("color");
                // int anio = resultado.getInt("anio");
                Integer anio = Integer.valueOf("anio");
                Integer kilometros = Integer.valueOf("kilometros");
                double precio = resultado.getDouble("precio");
                int vendido = resultado.getInt("vendido");
                boolean miVendido = Boolean.valueOf(String.valueOf(vendido));
                String dniCliente = resultado.getString("dniCliente");
                Vehiculo vehiculo = new Vehiculo(miId, matricula, marca, modelo, color, anio, kilometros, precio, miVendido, dniCliente);
                vehiculos.add(vehiculo);
            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos vehiculo");
            return null;
        } finally {
            this.closeConnection(connection);
        }
        return vehiculos;
    }

    @Override
    public Vehiculo findById(Long id) {
         Connection connection = null;
        Vehiculo vehiculo = null;
        try {
            connection = this.getConnection();
            String sql = "SELECT * FROM vehiculo as ve where ve.id ="+id;
            PreparedStatement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                
                String matricula = resultado.getString("matricula");
                String marca = resultado.getString("marca");
                String modelo = resultado.getString("modelo");
                String color = resultado.getString("color");
                // int anio = resultado.getInt("anio");
                Integer anio = Integer.valueOf("anio");
                Integer kilometros = Integer.valueOf("kilometros");
                double precio = resultado.getDouble("precio");
                int vendido = resultado.getInt("vendido");
                boolean miVendido = Boolean.valueOf(String.valueOf(vendido));
                String dniCliente = resultado.getString("dniCliente");
                vehiculo = new Vehiculo(id, matricula, marca, modelo, color, anio, kilometros, precio, miVendido, dniCliente);
                return vehiculo;
            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener vehiculo" + vehiculo.getId());
            return null;
        } finally {
            this.closeConnection(connection);
        }
        return vehiculo;
    }

    @Override
    public boolean update(Vehiculo vehiculo) {
            Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("UPDATE INTO vehiculo as ve matricula = ?, marca = ?, modelo = ?, color = ?, anio = ?,"
                                     +" kilometros = ?, precio = ?, vendido = ?, dniCliente = ? where ve.id = ?");
            sentencia.setLong(1, vehiculo.getId());
            sentencia.setString(2, vehiculo.getMatricula());
            sentencia.setString(3, vehiculo.getMarca());
            sentencia.setString(4, vehiculo.getModelo());
            sentencia.setString(5, vehiculo.getColor());
            sentencia.setInt(6, vehiculo.getAnio());
            sentencia.setInt(7, vehiculo.getKilometros());
            sentencia.setDouble(8, vehiculo.getPrecio());

            sentencia.setBoolean(9, vehiculo.isVendido());

             sentencia.setString(10, vehiculo.getDniCliente());

            sentencia.execute();
        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el cliente:" + vehiculo.getId());
            return false;
        } finally {
            this.closeConnection(connection);
        }
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = null;
        try {
            connection = this.getConnection();
            String sql = "delete FROM vehiculo as ve where ve.id ="+id;
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("No se han eliminar");
            return false;
        } finally {
            this.closeConnection(connection);
        }
    }
    

    
}
