package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.Proveedor;
import com.ejemplo.repository.IProveedorRepository;

public class ProveedorSqliteRepository extends SQLiteConnectionManager implements IProveedorRepository {

    ProveedorSqliteRepository() {
        super(rutaDB);
    }

    ProveedorSqliteRepository(String rutaDB) {
        super(rutaDB);
        // TODO Auto-generated constructor stub
    }

    private SQLiteConnectionManager connectionManager;

    @Override
    public boolean create(Proveedor proveedor) {
        Connection connection = null;
        String sql = "INSERT INTO cliente(id, nif, nombre, email, telefono, ciudad, pais, activo values(?,?,?,?,?,?,?,?)";
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.setString(1, proveedor.getCodigo());
            sentencia.setString(2, proveedor.getNombre());
            sentencia.setString(3, proveedor.getContacto());
            sentencia.setString(4, proveedor.getEmail());
            sentencia.setString(5, proveedor.getPais());

            sentencia.setLong(6, proveedor.getId());

            sentencia.executeUpdate();

        } catch (Exception e) {
            System.err.println("No se han podido crear elementos" + proveedor.getId());
            return false;
        } finally {
            this.closseConnection(connection);
        }
        return true;
    }

    @Override
    public List<Proveedor> findAll() {
        Connection connection = null;
        ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
        String sql = "SELECT * FROM proveedores";
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                long miId = Long.valueOf(id);
                String nombre = resultado.getString("nombre");
                String codigo = resultado.getString("codigo");
                String contacto = resultado.getString("contacto");
                String email = resultado.getString("email");
                String pais = resultado.getString("pais");

                Proveedor proveedor = new Proveedor(miId, codigo, nombre, contacto, email, pais);

                proveedores.add(proveedor);
            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos");
            return new ArrayList<Proveedor>();
        } finally {
            this.closseConnection(connection);
        }
        return proveedores;
    }

    @Override
    public Proveedor findById(Long id) {
        Connection connection = null;
        Proveedor proveedor = null;
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("SELECT * FROM proveedor as prov where prov.id =");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                long miId = Long.valueOf(id);
                String nombre = resultado.getString("nombre");
                String codigo = resultado.getString("codigo");
                String contacto = resultado.getString("contacto");
                String email = resultado.getString("email");
                String pais = resultado.getString("pais");

                proveedor = new Proveedor(miId, codigo, nombre, contacto, email, pais);

                return proveedor;
            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos");

        } finally {
            this.closseConnection(connection);
        }
        return proveedor;
    }

    @Override
    public boolean update(Proveedor proveedor) {
        Connection connection = null;
        String sql = "UPDATE proveedor as prov set codigo = ?, nombre = ?, contacto = ?, email = ?, pais = ?, where prov.id = ?";
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.setString(1, proveedor.getCodigo());
            sentencia.setString(2, proveedor.getNombre());
            sentencia.setString(3, proveedor.getContacto());
            sentencia.setString(4, proveedor.getEmail());
            sentencia.setString(5, proveedor.getPais());

            sentencia.setLong(6, proveedor.getId());

            sentencia.executeUpdate();

        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos" + proveedor.getId());
            return false;
        } finally {
            this.closseConnection(connection);
        }
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE * FROM proveedor as prov where prov.id =" + id;
        return super.deleteById(sql);

    }

}
