package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.util.List;

import com.ejemplo.model.Inventario;
import com.ejemplo.repository.IInventarioRepository;

public class InventarioSqliteRepository extends SQLiteConnectionManager implements IInventarioRepository {


    InventarioSqliteRepository() {
        super(rutaDB);
        // TODO Auto-generated constructor stub
    }

    InventarioSqliteRepository(String rutaDB) {
        super(rutaDB);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(Inventario inventario) {
       /*
        Connection connection = null;
        try {

            connection = this.getConnection();

            PreparedStatement sentencia = connection.prepareStatement("INSERT INTO cliente(id, nif, nombre, email, telefono, ciudad, pais, activo)"
                            + " values(?,?,?,?,?,?,?,?)");
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
            System.err.println("No se ha podido almacenar el cliente " + cliente.getId());
            return false;
        } finally {
            this.closseConnection(connection);
        }*/

        try {
              Connection connection = this.getConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return true;
    }

    @Override
    public List<Inventario> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Inventario findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(Inventario inventario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE * FROM inventario as inv where inv.id =" + id;
        return super.deleteById(sql);

    }
}
