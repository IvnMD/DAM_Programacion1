package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteSqliteRepository extends SQLiteConnectionManager implements IClienteRepository {

    public ClienteSqliteRepository() {
        super(rutaDb);
    }

    /**
     * private String dni;
     * private String nombre;
     * private String email;
     * private String telefono;
     * private String ciudad;
     * private boolean activo;
     */
    @Override
    public boolean create(Cliente cliente) {
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("INSERT INTO cliente (dni, nombre, email, telefono, ciudad, activo) "
                            + " values (?,?,?,?,?,?)");
            sentencia.setString(1, cliente.getDni());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getEmail());
            sentencia.setString(4, cliente.getTelefono());
            sentencia.setString(5, cliente.getCiudad());
            sentencia.setBoolean(6, cliente.isActivo());
            sentencia.execute();
        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el cliente:" + cliente.getDni());
            return false;
        } finally {
            this.closeConnection(connection);
        }
        return true;
    }
    /**
     * private String dni;
     * private String nombre;
     * private String email;
     * private String telefono;
     * private String ciudad;
     * private boolean activo;
     */
    @Override
    public List<Cliente> findAll() {
        Connection connection = null;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM cliente");
            ResultSet resultado = sentencia.executeQuery();
            // Cliente 100|00000000Z|Cliente Demo|demo@demo.com|600000000|Madrid|Espana|1
            // linea.split("|")
            // int id = Integer.parseInt("rows[0]");
            while (resultado.next()) {

                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                String ciudad = resultado.getString("ciudad");
                int activo = resultado.getInt("activo");
                boolean miActivo = Boolean.valueOf(String.valueOf(activo));
                Cliente cliente = new Cliente(dni, nombre, email, telefono, ciudad, miActivo);
                clientes.add(cliente);

            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos cliente");
            return new ArrayList<Cliente>();
        } finally {
            this.closeConnection(connection);
        }
        return clientes;
    }

    @Override
    public Cliente findById(String dni) {
        Connection connection = null;
        Cliente cliente = null;
        try {
            connection = this.getConnection();
            String sql = "SELECT * FROM cliente as ci where ci.id ="+dni;
            PreparedStatement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {

                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                String ciudad = resultado.getString("ciudad");
                int activo = resultado.getInt("activo");
                boolean miActivo = Boolean.valueOf(String.valueOf(activo));
                cliente = new Cliente(dni, nombre, email, telefono, ciudad, miActivo);
                return cliente;

            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener cliente por id");
            return null;
        } finally {
            this.closeConnection(connection);
        }
        return cliente;
    }

    @Override
    public boolean update(Cliente cliente) {
        Connection connection = null;
        String sql = "UPDATE cliente as ci nombre = ?, email = ?,"
        +" telefono = ?, ciudad = ?, activo = ? where ci.id = ?";
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = 
            connection.prepareStatement(sql);
            sentencia.setString(1, cliente.getDni());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getEmail());
            sentencia.setString(4, cliente.getTelefono());
            sentencia.setString(5, cliente.getCiudad());
            sentencia.setBoolean(6, cliente.isActivo());
            // sentencia.setString(8, cliente.getDni());  //! QUIZAS REORGANIZAR
            sentencia.execute();
        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el cliente:"+cliente.getDni());
            return false;
        } finally {
            this.closeConnection(connection);
        }
        return true;
    }

    @Override
    public boolean deleteById(String dni) {
        Connection connection = null;
        try {
            connection = this.getConnection();
            String sql = "DELETE FROM cliente as ci where ci.id ="+dni;
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
