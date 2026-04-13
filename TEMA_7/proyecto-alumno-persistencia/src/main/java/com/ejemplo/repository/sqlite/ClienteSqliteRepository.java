package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteSqliteRepository extends SQLiteConnectionManager implements IClienteRepository {

    public ClienteSqliteRepository(String rutaDB) {
        super(rutaDB);
    }

    private SQLiteConnectionManager connectionManager;

    @Override
    public boolean create(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<Cliente> findAll() {
        Connection connection = null;
        Cliente clientes = new ArrayList<>();
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM cliente");
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            // ! 100|00000000Z|Cliente Demo|demo@demo.com|600000000|Madrid|Espana|1
            // ! linea.split("|")
            // ! rows [0] = Integer
            // ! rows [4] = Integer
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
            return new ArrayList<Cliente>();
        } finally {
            try {
                if (connection != null) {
                    if (!connection.isClosed()) {
                        connection.close();
                    }
                }
            } catch (Exception e) {
                System.err.println("Se ha producido un error en la conexion (connection)");
            }

        }
        return clientes;

    }

    @Override
    public Cliente findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
