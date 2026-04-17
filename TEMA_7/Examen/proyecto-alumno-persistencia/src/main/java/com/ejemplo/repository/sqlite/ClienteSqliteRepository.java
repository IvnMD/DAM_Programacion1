package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteSqliteRepository extends SQLiteConnectionManager implements IClienteRepository {

    private static String  rutaDB = "src/main/resources/data/sqlite/demo.db";

    public ClienteSqliteRepository(String rutaDB) {
        super(rutaDB);
    }

    public ClienteSqliteRepository() {
        super(rutaDB);
    }

    @Override
    public boolean create(Cliente cliente) {
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = 
            connection.prepareStatement("INSERT INTO cliente (id, nif, nombre, email, telefono, ciudad, pais, activo) "
            +" values (?,?,?,?,?,?,?,?)");
            sentencia.setLong(1, cliente.getId());
            sentencia.setString(2, cliente.getNif());
            sentencia.setString(3, cliente.getNombre());
            sentencia.setString(4, cliente.getEmail());
            sentencia.setString(5, cliente.getTelefono());
            sentencia.setString(6, cliente.getCiudad());
            sentencia.setString(7, cliente.getPais());
            sentencia.setBoolean(8, cliente.isActivo());
            sentencia.execute();
        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el cliente:"+cliente.getId());
            return false;
        } finally {
            this.closseConnection(connection);
        }
        return true;
    }

    @Override
    public List<Cliente> findAll() {
        Connection connection = null;
        ArrayList<Cliente> clientes =new ArrayList<Cliente>();
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM cliente");
            ResultSet resultado = sentencia.executeQuery();
            //Cliente 100|00000000Z|Cliente Demo|demo@demo.com|600000000|Madrid|Espana|1
            //linea.split("|")
            // int id =  Integer.parseInt("rows[0]");
            while (resultado.next()) {
                int id = resultado.getInt("id");
                long miId = Long.valueOf(id);
                String nif = resultado.getString("nif");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                String ciudad = resultado.getString("ciudad");
                String pais = resultado.getString("pais");
                int activo = resultado.getInt("activo");
                boolean miActivo = Boolean.valueOf(String.valueOf(activo));
                Cliente cliente = new Cliente(miId, nif, nombre, email, telefono, ciudad, pais, miActivo);
                clientes.add(cliente);

            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos");
            return new ArrayList<Cliente>();
        } finally {
            this.closseConnection(connection);
        }
        return clientes;
    }

    @Override
    public Cliente findById(Long id) {
        Connection connection = null;
        Cliente cliente = null;
        try {
            connection = this.getConnection();
            String sql = "SELECT * FROM cliente as ci where ci.id ="+id;
            PreparedStatement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String nif = resultado.getString("nif");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                String ciudad = resultado.getString("ciudad");
                String pais = resultado.getString("pais");
                int activo = resultado.getInt("activo");
                boolean miActivo = Boolean.valueOf(String.valueOf(activo));
                cliente = new Cliente(id, nif, nombre, email, telefono, ciudad, pais, miActivo);
                return cliente;

            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos");
            return null;
        } finally {
            this.closseConnection(connection);
        }
        return cliente;
    }

    @Override
    public boolean update(Cliente cliente) {
        Connection connection = null;
        String sql = "UPDATE cliente as ci nif = ?, nombre = ?, email = ?,"
        +" telefono = ?, ciudad = ?, pais = ?, activo = ? where ci.id= ?";
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = 
            connection.prepareStatement(sql);
            sentencia.setString(1, cliente.getNif());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getEmail());
            sentencia.setString(4, cliente.getTelefono());
            sentencia.setString(5, cliente.getCiudad());
            sentencia.setString(6, cliente.getPais());
            sentencia.setBoolean(7, cliente.isActivo());
            sentencia.setLong(8, cliente.getId());
            sentencia.execute();
        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el cliente:"+cliente.getId());
            return false;
        } finally {
            this.closseConnection(connection);
        }
        return true;

    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = null;
        try {
            connection = this.getConnection();
            String sql = "delete FROM cliente as ci where ci.id ="+id;
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("No se han eliminar");
            return false;
        } finally {
            this.closseConnection(connection);
        }
    }

}
