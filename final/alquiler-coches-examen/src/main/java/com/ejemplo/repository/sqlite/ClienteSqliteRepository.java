package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteSqliteRepository implements IClienteRepository {


    @Override
    public boolean create(Cliente cliente) {
        String sql = "INSERT INTO cliente (dni_cliente, nombre, telefono, email, activo) VALUES (?,?,?,?,?)";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Cliente findByDni(String dni) {
        String sql = " SELECT * FROM cliente WHERE dni = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapCliente(rs);
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Cliente> findAll() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientes.add(mapCliente(rs));
                }
                return new ArrayList<>();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean update(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre = ?, telefono= ?, email = ?, activo = ?) WHERE dni = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getEmail());

            ps.setString(4, cliente.getDni());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteById(String dni) {
        String sql = " DELETE * FROM cliente WHERE dni = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, dni);
           return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
        
    }


    @Override
    public List<Cliente> findActivos() {
        String sql = "SELECT * FROM cliente WHERE activos = 1";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientes.add(mapCliente(rs));
                }
                return new ArrayList<>();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Cliente findByEmail(String email) {{
        String sql = " SELECT * FROM cliente WHERE email = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapCliente(rs);
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    }


        private Cliente mapCliente (ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getString("dni_cliente"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("email"),
                rs.getInt("activo"));
    }
}
