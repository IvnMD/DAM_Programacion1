package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Socio;
import com.ejemplo.model.SocioReserva;
import com.ejemplo.repository.ISocioRepository;

public class SocioSqliteRepository extends SQLiteConnectionManager implements ISocioRepository {

    public SocioSqliteRepository() {
    }

    @Override
    public boolean create(Socio socio) {
        String sql = "INSERT INTO socio (dni, nombre, email, telefono, plan, "
                + "activo) VALUES (?,?,?,?,?,?)";
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getEmail());
            ps.setString(4, socio.getTelefono());
            ps.setString(5, socio.getPlan());
            ps.setInt(6, socio.getActivo());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            System.err.println("Error al crear socio");
            return false;
        }

    }

    @Override
    public Socio findById(Integer id) {
        String sql = "SELECT * FROM socio WHERE id = ?";
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapSocio(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar socio por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Socio> findAll() {
        String sql = "SELECT * FROM socio";
        List<Socio> socios = new ArrayList<>();
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                socios.add(mapSocio(rs));
            }
            return socios;
        } catch (Exception e) {
            System.err.println("Error al listar todos los socios");
            return new ArrayList<>();
        }
    }

    @Override
    public boolean update(Socio socio) {
        String sql = "UPDATE socio SET dni = ?, nombre = ?, email = ?, telefono = ?, plan = ?, activo = ? where id = ?";
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getEmail());
            ps.setString(4, socio.getTelefono());
            ps.setString(5, socio.getPlan());
            ps.setInt(6, socio.getActivo());

            ps.setInt(7, socio.getId());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            System.err.println("Error al crear socio");
            return false;
        }

    }

    @Override
    public boolean deleteById(Integer id) {
        String sql = "DELETE FROM socio WHERE id = ?";
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            System.err.println("Error al buscar socio por ID: " + e.getMessage());
            return false;
        }

    }

    @Override
    public List<Socio> findActivos() {
        String sql = "SELECT * FROM socio WHERE activo = 1";
        List<Socio> socios = new ArrayList<>();
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                socios.add(mapSocio(rs));
            }
            return socios;
        } catch (Exception e) {
            System.err.println("Error al listar todos los socios");
            return new ArrayList<>();
        }
    }

    @Override
    public List<Socio> findByPlan(String plan) {
        String sql = "SELECT * FROM socio WHERE plan = ?";
        List<Socio> socios = new ArrayList<>();
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, plan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                socios.add(mapSocio(rs));
            }
            return socios;
        } catch (Exception e) {
            System.err.println("Error al listar todos los socios");
            return new ArrayList<>();
        }
    }

    @Override
    public List<SocioReserva> findSociosConReservas() {
        String sql = "SELECT s.id AS socioId, "
                + "    s.nombre AS socioNombre, "
                + "    r.id AS reservaId, "
                + "    r.estado AS estadoReserva, "
                + "    r.id_clase AS idClase "
                + "FROM socio s "
                + "INNER JOIN reserva r ON s.id = r.id_socio";
        List<SocioReserva> resultado = new ArrayList<>();

        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                resultado.add(mapSocioReserva(rs));
            }
            return resultado;
        } catch (SQLException e) {
            System.err.println("Error al listar socios con reservas: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private Socio mapSocio(ResultSet rs) throws SQLException {
        return new Socio(
                rs.getInt("id"),
                rs.getString("dni"),
                rs.getString("nombre"),
                rs.getString("email"),
                rs.getString("telefono"),
                rs.getString("plan"),
                rs.getInt("activo"));

    }

    private SocioReserva mapSocioReserva(ResultSet rs) throws SQLException {
        return new SocioReserva(
                rs.getInt("socioId"),
                rs.getString("socioNombre"),
                rs.getInt("reservaId"),
                rs.getString("estadoReserva"),
                rs.getInt("idClase"));
    }

}
