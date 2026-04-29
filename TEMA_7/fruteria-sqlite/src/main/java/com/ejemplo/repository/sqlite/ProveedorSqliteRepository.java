package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Proveedor;
import com.ejemplo.repository.IProveedorRepository;

public class ProveedorSqliteRepository implements IProveedorRepository {

    /**
     * CREATE TABLE proveedor (
     * cif TEXT PRIMARY KEY,
     * nombre TEXT NOT NULL,
     * telefono TEXT,
     * email TEXT,
     * ciudad TEXT,
     * activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1)));
     */
    @Override
    public boolean crear(Proveedor proveedor) {
        String sql = "INSERT INTO proveedor (cif, nombre, telefono, email, ciudad, activo) VALUES (?,?,?,?,?,?)";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, proveedor.getCif());
            ps.setString(2, proveedor.getNombre());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getEmail());
            ps.setString(5, proveedor.getCiudad());
            ps.setInt(6, proveedor.getActivo());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Proveedor buscarPorCif(String cif) {
        String sql = "SELECT * FROM proveedor WHERE cif = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cif);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapProveedor(rs);
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Proveedor> listarTodos() {
        String sql = "SELECT * FROM proveedor ORDER BY nombre";
        List<Proveedor> proveedores = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    proveedores.add(mapProveedor(rs));
                }
                return proveedores;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean actualizar(Proveedor proveedor) {
        String sql = "UPDATE proveedor SET nombre = ?, telefono = ?, email = ?, ciudad = ?, activo = ? WHERE cif = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getTelefono());
            ps.setString(3, proveedor.getEmail());
            ps.setString(4, proveedor.getCiudad());
            ps.setInt(5, proveedor.getActivo());
            ps.setString(6, proveedor.getCif());
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean borrarPorCif(String cif) {
        String sql = "DELETE FROM proveedor WHERE cif = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cif);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Proveedor> listarActivos() {
        String sql = "SELECT * FROM proveedor WHERE activo = 1";
        List<Proveedor> proveedores = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    proveedores.add(mapProveedor(rs));
                }
                return proveedores;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Proveedor> buscarPorCiudad(String ciudad) {
        String sql = "SELECT * FROM proveedor WHERE ciudad = ?";
        List<Proveedor> proveedores = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, ciudad);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    proveedores.add(mapProveedor(rs));
                }
                return proveedores;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Proveedor buscarPorEmail(String email) {
        String sql = "SELECT * FROM proveedor WHERE email = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapProveedor(rs);
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * CREATE TABLE proveedor (
     * cif TEXT PRIMARY KEY,
     * nombre TEXT NOT NULL,
     * telefono TEXT,
     * email TEXT,
     * ciudad TEXT,
     * activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1)));
     */
    private Proveedor mapProveedor(ResultSet rs) throws SQLException {
        return new Proveedor(
                rs.getString("cif"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("email"),
                rs.getString("ciudad"),
                rs.getInt("activo"));

    }

}
