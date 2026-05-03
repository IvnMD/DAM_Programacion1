package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Alquiler;
import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IAlquilerRepository;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlquilerSqliteRepository implements IAlquilerRepository {



/**
 * CREATE TABLE alquiler (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    dni_cliente TEXT NOT NULL,
    id_alquiler INTEGER NOT NULL,
    fecha_inicio TEXT NOT NULL,
    fecha_fin TEXT NOT NULL,
    estado TEXT NOT NULL CHECK (estado IN ('ACTIVO','CANCELADO','FINALIZADO')),
    FOREIGN KEY (dni_cliente) REFERENCES cliente(dni),
    FOREIGN KEY (id_alquiler) REFERENCES alquiler(id)
);
 */





    @Override
    public boolean create(Alquiler alquiler) {
        String sql = "INSERT INTO alquiler (id, dni_cliente, id_alquiler, fecha_inicio, fecha_fin,"
            + "estado) VALUES (?,?,?,?,?,?)";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, alquiler.getId());
            ps.setString(2, alquiler.getDniCliente());
            ps.setInt(3, alquiler.getIdVehiculo());
            ps.setString(3, alquiler.getFechaInicio());
            ps.setString(4, alquiler.getFechaFin());
            ps.setString(5, alquiler.getEstado());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Alquiler> findAll() {
        String sql = "SELECT * FROM alquiler";
        List<Alquier> alquiler = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    alquiler.add(mapAlquiler(rs));
                }
                return new ArrayList<>();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Alquiler findById(Integer id) {
        String sql = " SELECT * FROM alquiler WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapAlquiler(rs);
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean update(Alquiler alquiler) {
        String sql ="UPDATE alquiler SET dni_cliente = ?, id_vehiculo= ?, fecha_inicio = ?, fecha_fin = ?, estado = ? WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, alquiler.getDniCliente());
            ps.setInt(2, alquiler.getIdVehiculo());
            ps.setDate(3, alquiler.getFechaInicio());
            ps.setDate(4, alquiler.getFechaFin());
            ps.setString(5, alquiler.getEstado());

            ps.setIn(6, alquiler.getId());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean cancelById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelById'");
    }

    @Override
    public boolean completeById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'completeById'");
    }

    @Override
    public Alquiler findByCliente(String dni_cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCliente'");
    }

    @Override
    public Alquiler findByalquiler(Integer id_alquiler) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByalquiler'");
    }

    @Override
    public boolean existsActiveRental(String dniCliente, Integer idalquiler, LocalDate fechaInicio,
            LocalDate fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsActiveRental'");
    }

    @Override
    public Alquiler findByVehiculo(Integer id_vehiculo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByVehiculo'");
    }
    
    private Alquiler mapAlquiler (ResultSet rs) throws SQLException{
        return new Alquiler(
            rs.getInt("id"),
            rs.getString("dni_cliente"),
            rs.getInt("id_alquiler"),
            rs.getString("fecha_inicio"),
            rs.getString("fecha_fin"),
            rs.getString("estado")
        );
    }

 }
