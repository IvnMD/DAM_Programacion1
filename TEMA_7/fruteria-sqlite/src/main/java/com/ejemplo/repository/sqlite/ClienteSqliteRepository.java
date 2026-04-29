package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;

public class ClienteSqliteRepository implements IClienteRepository {

    @Override
    public boolean crear(Cliente cliente) {
        String sql = "INSERT INTO cliente(dni,nombre,telefono,email,ciudad,activo) VALUES(?,?,?,?,?,?)";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getCiudad());
            ps.setInt(6, cliente.getActivo());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Cliente buscarPorId(String dni) {
        String sql = "SELECT * FROM cliente WHERE dni = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM cliente ORDER BY nombre";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientes.add(map(rs));
                }
                return clientes;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean actualizar(Cliente cliente) {

        String sql = "UPDATE cliente SET nombre = ?, telefono = ?, email = ?, ciudad = ?, activo = ? WHERE dni = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getCiudad());
            ps.setInt(5, cliente.getActivo());
            ps.setString(6, cliente.getDni());
            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean borrarPorDni(String dni) {
        String sql = "DELETE FROM cliente WHERE dni = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, dni);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Cliente> buscarActivos() {
        String sql = "SELECT * FROM cliente WHERE activo = 1";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientes.add(map(rs));
                }
                return clientes;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Cliente> buscarPorCiudad(String ciudad) {
        String sql = "SELECT * FROM cliente WHERE ciudad = ?";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
                    ps.setString(1, ciudad);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientes.add(map(rs));
                }
                return clientes;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Cliente buscarPorEmail(String email) {
        String sql = "SELECT * FROM cliente WHERE email = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

    private Cliente map(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getString("dni"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("email"),
                rs.getString("ciudad"),
                rs.getInt("activo"));
    }
}
