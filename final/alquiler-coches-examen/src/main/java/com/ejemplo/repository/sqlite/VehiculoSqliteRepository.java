package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.Vehiculo;
import com.ejemplo.repository.IVehiculoRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoSqliteRepository implements IVehiculoRepository {

    /**
     * CREATE TABLE vehiculo (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    marca TEXT NOT NULL,
    modelo TEXT NOT NULL,
    tipo TEXT NOT NULL CHECK (tipo IN ('ECONOMICO','SUV','PREMIUM')),
    disponible INTEGER NOT NULL CHECK (disponible IN (0,1))
);
     */

    @Override
    public boolean create(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculo (id, marca, modelo, tipo, disponible) VALUES (?,?,?,?,?)";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, vehiculo.getId());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setString(4, vehiculo.getTipo());
            ps.setInt(4, vehiculo.getDisponible());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Vehiculo> findAll() {
        String sql = "SELECT * FROM vehiculo";
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    vehiculos.add(map(rs));
                }
                return new ArrayList<>();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Vehiculo findById(Integer id) {
        String sql = " SELECT * FROM vehiculo WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
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
    public boolean update(Vehiculo vehiculo) {
        String sql = "UPDATE vehiculo SET marca = ?. modelo= ?, tipo = ?, disponible = ?) WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getTipo());
            ps.setInt(4, vehiculo.getDisponible());

            ps.setInt(5, vehiculo.getId());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {

        String sql = " DELETE * FROM cliente WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
           return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Vehiculo> findByTipo(String tipo) {
        String sql = " SELECT * FROM vehiculo WHERE tipo = ?";
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    vehiculos.add(map(rs));
                }
                return new ArrayList<>();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    


    private Vehiculo map(ResultSet rs) throws SQLException {
        return new Vehiculo(
                rs.getInt("id"),
                rs.getString("marca"),
                rs.getString("modelo"),
                rs.getString("tipo"),
                rs.getInt("disponible"));
    }
}
