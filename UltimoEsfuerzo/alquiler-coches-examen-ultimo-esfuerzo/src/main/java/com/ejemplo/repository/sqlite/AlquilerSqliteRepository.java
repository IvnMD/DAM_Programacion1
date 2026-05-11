package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Alquiler;
import com.ejemplo.repository.IAlquilerRepository;

public class AlquilerSqliteRepository implements IAlquilerRepository {

  @Override
  public boolean create(Alquiler alquiler) {
    String sql = "INSERT INTO alquiler (dnicliente, idvehiculo, fechainicio, fechafin, estado) VALUES (?,?,?,?,?)";
    try (Connection cn = SQLiteConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql)) {

      ps.setString(1, alquiler.getDniCliente());
      ps.setInt(2, alquiler.getIdVehiculo());
      ps.setString(3, alquiler.getFechaInicio().toString());
      ps.setString(4, alquiler.getFechaFin().toString());
      ps.setString(5, alquiler.getEstado());

      return ps.executeUpdate() == 1;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Alquiler findById(Integer id) {
    String sql = "SELECT * FROM alquiler WHERE id = ?";
    try (Connection cn = SQLiteConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql)) {

      ps.setInt(1, id);

      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return mapAlquiler(rs);
        }
      }
      return null;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Alquiler> findAll() {
    String sql = "SELECT * FROM alquiler";
    List<Alquiler> alquileres = new ArrayList<>();
    try (Connection cn = SQLiteConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        alquileres.add(mapAlquiler(rs));
      }
      return alquileres;
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }

  @Override
  public boolean cancelById(Integer id) {
    String sql = "UPDATE alquiler SET estado = 'CANCELADO' WHERE id = ? AND estado = 'ACTIVO'";
    try (Connection cn = SQLiteConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql)) {

      ps.setInt(1, id);
      return ps.executeUpdate() == 1;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean completeById(Integer id) {
    String sql = "UPDATE alquiler SET estado = 'FINALIZADO' WHERE id = ? AND estado = 'ACTIVO'";
    try (Connection cn = SQLiteConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql)) {

      ps.setInt(1, id);
      return ps.executeUpdate() == 1;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Alquiler> findByCliente(String dniCliente) {
    String sql = "SELECT * FROM alquiler WHERE dnicliente = ?";
    List<Alquiler> alquileres = new ArrayList<>();
    try (Connection cn = SQLiteConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql)) {

      ps.setString(1, dniCliente);

      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          alquileres.add(mapAlquiler(rs));
        }
      }
      return alquileres;
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }

  @Override
  public List<Alquiler> findByVehiculo(Integer idVehiculo) {
    String sql = "SELECT * FROM alquiler WHERE idvehiculo = ?";
    List<Alquiler> alquileres = new ArrayList<>();
    try (Connection cn = SQLiteConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql)) {

      ps.setInt(1, idVehiculo);

      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          alquileres.add(mapAlquiler(rs));
        }
      }
      return alquileres;
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }

  @Override
  public boolean existsActiveRental(String dniCliente, Integer idVehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
    String sql = """
        SELECT 1
        FROM alquiler
        WHERE idvehiculo = ?
          AND estado = 'ACTIVO'
          AND fechainicio < ?
          AND fechafin > ?
        LIMIT 1
        """;

    try (Connection cn = SQLiteConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql)) {

      ps.setInt(1, idVehiculo);
      ps.setString(2, fechaFin.toString());
      ps.setString(3, fechaInicio.toString());

      try (ResultSet rs = ps.executeQuery()) {
        return rs.next();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private Alquiler mapAlquiler(ResultSet rs) throws SQLException {
    return new Alquiler(
        rs.getInt("id"),
        rs.getString("dnicliente"),
        rs.getInt("idvehiculo"),
        LocalDate.parse(rs.getString("fechainicio")),
        LocalDate.parse(rs.getString("fechafin")),
        rs.getString("estado"));
  }
}