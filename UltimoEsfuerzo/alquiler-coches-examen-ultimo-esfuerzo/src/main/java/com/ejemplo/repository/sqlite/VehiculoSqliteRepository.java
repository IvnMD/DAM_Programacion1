package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Vehiculo;
import com.ejemplo.repository.IVehiculoRepository;

public class VehiculoSqliteRepository implements IVehiculoRepository {

  @Override
  public boolean create(Vehiculo vehiculo) {
    String sql = "INSERT INTO vehiculo (marca, modelo, tipo, disponible) VALUES (?,?,?,?)";
    try (Connection cn = SQLiteConnectionManager.getConnection();
  PreparedStatement ps = cn.prepareStatement(sql)){
        ps.setString(1, vehiculo.getMarca());
        ps.setString(2, vehiculo.getModelo());
        ps.setString(3,vehiculo.getTipo());
        ps.setInt(4, vehiculo.getDisponible());

        return ps.executeUpdate() == 1;
      } catch (Exception e) {
       throw new RuntimeException(e);
      }
  }

  @Override
  public Vehiculo findById(Integer id) {
    String sql = "SELECT * FROM vehiculo WHERE id = ?";
    try (Connection cn = SQLiteConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return mapVehiculo(rs);
        }
      }
      return null;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Vehiculo> findAll() {
    String sql = "SELECT * FROM vehiculo";
    List<Vehiculo> vehiculos = new ArrayList<>();
    try (Connection cn = SQLiteConnectionManager.getConnection();
  PreparedStatement ps = cn.prepareStatement(sql)){
        try(ResultSet rs = ps.executeQuery()){
          while(rs.next()){
            vehiculos.add(mapVehiculo(rs));
          }
        }
        return vehiculos;
    } catch (Exception e) {
        return new ArrayList<>();
    }
    
  }

  @Override
  public boolean update(Vehiculo vehiculo) {
    String sql = "UPDATE vehiculo SET marca = ?, modelo = ?, tipo = ?, disponible = ?";
    try (Connection cn = SQLiteConnectionManager.getConnection();
  PreparedStatement ps = cn.prepareStatement(sql)){
        ps.setString(1, vehiculo.getMarca());
        ps.setString(2, vehiculo.getModelo());
        ps.setString(3,vehiculo.getTipo());
        ps.setInt(4, vehiculo.getDisponible());

        return ps.executeUpdate() == 1;
      } catch (Exception e) {
       throw new RuntimeException(e);
      }
  }

  @Override
  public boolean deleteById(Integer id) {
    String sql = "DELETE FROM vehiculo WHERE id = ?";
    try (Connection cn = SQLiteConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql)) {
      ps.setInt(1, id);
      return ps.executeUpdate() == 1;

    } catch (Exception e) {
      throw new RuntimeException();
    }
  }

  @Override
  public List<Vehiculo> findByTipo(String tipo) {
    String sql = "SELECT * FROM vehiculo WHERE tipo = ?";
    List<Vehiculo> vehiculos = new ArrayList<>();
    try (Connection cn = SQLiteConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql)) {
      ps.setString(1, tipo);
        try(ResultSet rs = ps.executeQuery()){
          while(rs.next()){
            vehiculos.add(mapVehiculo(rs));
          }
        }
        return vehiculos;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
    
  public Vehiculo mapVehiculo (ResultSet rs) throws SQLException{
    return new Vehiculo(
      rs.getInt("id"),
      rs.getString("marca"),
      rs.getString("modelo"),
      rs.getString("tipo"),
      rs.getInt("disponible"));
  }
}
