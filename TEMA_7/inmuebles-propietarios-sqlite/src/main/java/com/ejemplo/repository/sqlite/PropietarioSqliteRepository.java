package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Propietario;
import com.ejemplo.repository.IPropietarioRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PropietarioSqliteRepository extends SQLiteConnectionManager implements IPropietarioRepository {

    public PropietarioSqliteRepository() {
        super(rutaDb);
    }

    @Override
    public boolean create(Propietario propietario) {
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("INSERT INTO propietario (dni, nombre, email, telefono, ciudad, activo) "
                            + " values (?,?,?,?,?,?)");
            sentencia.setString(1, propietario.getDni());
            sentencia.setString(2, propietario.getNombre());
            sentencia.setString(3, propietario.getEmail());
            sentencia.setString(4, propietario.getTelefono());
            sentencia.setString(5, propietario.getCiudad());
            sentencia.setBoolean(6, propietario.isActivo());
            sentencia.execute();
        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el propietario:" + propietario.getDni());
            return false;
        } finally {
            this.closeConnection(connection);
        }
        return true;
    }

    @Override
    public List<Propietario> findAll() {
        Connection connection = null;
        ArrayList<Propietario> propietarios = new ArrayList<Propietario>();
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM propietario");
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {

                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                String ciudad = resultado.getString("ciudad");
                boolean miActivo = resultado.getInt("activo") == 1;
                Propietario propietario = new Propietario(dni, nombre, email, telefono, ciudad, miActivo);
                propietarios.add(propietario);

            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener elementos propietario");
            return new ArrayList<Propietario>();
        } finally {
            this.closeConnection(connection);
        }
        return propietarios;
    }

    @Override
    public Propietario findById(String dni) {
        Connection connection = null;
        Propietario propietario = null;
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM propietario WHERE dni = ?");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {

                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                String ciudad = resultado.getString("ciudad");
                int activo = resultado.getInt("activo");
                boolean miActivo = Boolean.valueOf(String.valueOf(activo));
                propietario = new Propietario(dni, nombre, email, telefono, ciudad, miActivo);
                return propietario;

            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener Propietario por DNI");
            return null;
        } finally {
            this.closeConnection(connection);
        }
        return propietario;
    }

    @Override
    public boolean update(Propietario propietario) {
        Connection connection = null;
        String sql = "UPDATE propietario SET nombre=?, email=?, telefono=?, ciudad=?, activo=?" +
                " WHERE dni=?";
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setString(1, propietario.getNombre());
            sentencia.setString(2, propietario.getEmail());
            sentencia.setString(3, propietario.getTelefono());
            sentencia.setString(4, propietario.getCiudad());
            sentencia.setInt(5, propietario.isActivo() ? 1 : 0);
            sentencia.setString(6, propietario.getDni());
            // ! QUIZAS REORGANIZAR

            sentencia.execute();
        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el propietario:" + propietario.getDni());
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
            String sql = "DELETE FROM propietario WHERE dni = ?";
            PreparedStatement sentencia = connection.prepareStatement(sql);

            sentencia.setString(1, dni);
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("No se han eliminar");
            return false;
        } finally {
            this.closeConnection(connection);
        }
    }
}
