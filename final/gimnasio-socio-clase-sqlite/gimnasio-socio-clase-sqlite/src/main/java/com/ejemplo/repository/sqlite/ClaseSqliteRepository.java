package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Clase;
import com.ejemplo.model.ClaseMonitor;
import com.ejemplo.model.ClaseReservaSocio;
import com.ejemplo.repository.IClaseRepository;

public class ClaseSqliteRepository extends SQLiteConnectionManager implements IClaseRepository {

    public ClaseSqliteRepository() {

    }

    @Override
    public boolean create(Clase clase) {
        String sql = "INSERT INTO clase (nombre, tipo, horario, cupo_maximo,"
                + " plazas_disponibles, activa, id_monitor) VALUES (?,?,?,?,?,?,?)";
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, clase.getNombre());
            ps.setString(2, clase.getTipo());
            ps.setString(3, clase.getHorario());
            ps.setInt(4, clase.getCupoMaximo());
            ps.setInt(5, clase.getPlazasDisponibles());
            ps.setInt(6, clase.getActiva());
            ps.setInt(7, clase.getIdMonitor());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            System.err.println("Error al crear clase");
            return false;
        }

    }

    @Override
    public Clase findById(Integer id) {
        String sql = "SELECT * FROM clase WHERE id = ?";
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapClase(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar clase con id " + id + ": " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Clase> findAll() {
        String sql = "SELECT * FROM clase";
        List<Clase> clases = new ArrayList<>();
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                clases.add(mapClase(rs));
            }
            return clases;

        } catch (Exception e) {
            System.err.println("Error al listar todas las clases");
            return new ArrayList<>();
        }
    }

    @Override
    public boolean update(Clase clase) {
        String sql = "UPDATE clase SET nombre = ?, tipo = ?, horario = ?, cupo_maximo = ?,"
                + "plazas_disponibles = ?, activa = ?, id_monitor = ? where id = ?";
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, clase.getNombre());
            ps.setString(2, clase.getTipo());
            ps.setString(3, clase.getHorario());
            ps.setInt(4, clase.getCupoMaximo());
            ps.setInt(5, clase.getPlazasDisponibles());
            ps.setInt(6, clase.getActiva());
            ps.setInt(7, clase.getIdMonitor());

            ps.setInt(8, clase.getId());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            System.err.println("Error al crear clase");
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        String sql = "DELETE FROM clase WHERE id = ?";
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            System.err.println("Error al buscal al cliente con id " + id);
            return false;
        }

    }

    @Override
    public List<Clase> findDisponibles() {
        String sql = "SELECT * FROM clase WHERE plazas_disponibles > 0";
        List<Clase> clases = new ArrayList<>();
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                clases.add(mapClase(rs));
            }
            return clases;
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    @Override
    public List<Clase> findByTipo(String tipo) {
        String sql = "SELECT * FROM clase WHERE tipo = ?";
        List<Clase> clases = new ArrayList<>();
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, tipo); // primero el parámetro
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clases.add(mapClase(rs));
                }
            }
            return clases;
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    @Override
    public List<Clase> findByMonitor(Integer idMonitor) {
        String sql = "SELECT * FROM clase WHERE id_monitor = ?";
        List<Clase> clases = new ArrayList<>();
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, idMonitor); // primero el parámetro
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clases.add(mapClase(rs));
                }
            }
            return clases;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<ClaseMonitor> findClasesConMonitor() {
        String sql = """
                SELECT c.id AS id_clase,
                       c.nombre AS clase_nombre,
                       c.tipo AS tipo,
                       m.nombre AS monitor_nombre,
                       m.especialidad AS especialidad
                FROM clase c
                INNER JOIN monitor m ON c.id_monitor = m.id
                """;
        List<ClaseMonitor> resultado = new ArrayList<>();

        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                resultado.add(mapClaseMonitor(rs));
            }
            return resultado;
        } catch (SQLException e) {
            System.err.println("Error al listar socios con reservas: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<ClaseReservaSocio> findReservasConSocio() {
        String sql = """
                SELECT r.id       AS reservaId,
                       c.id       AS claseId,
                       c.nombre   AS claseNombre,
                       s.id       AS socioId,
                       s.nombre   AS socioNombre,
                       r.estado   AS estadoReserva
                FROM reserva r
                INNER JOIN clase c ON r.id_clase = c.id
                INNER JOIN socio s ON r.id_socio = s.id
                ORDER BY r.id
                """;

        List<ClaseReservaSocio> resultado = new ArrayList<>();
        try (Connection cn = getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                resultado.add(mapClaseReservaSocio(rs));
            }
            return resultado;
        } catch (SQLException e) {
            System.err.println("Error al listar reservas con socio: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private Clase mapClase(ResultSet rs) throws SQLException {
        return new Clase(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("tipo"),
                rs.getString("horario"),
                rs.getInt("cupo_maximo"),
                rs.getInt("plazas_disponibles"),
                rs.getInt("activa"),
                rs.getInt("id_monitor"));
    }

    // private final Integer claseId;
    // private final String claseNombre;
    // private final String tipo;
    // private final String monitorNombre;
    // private final String especialidad;

    private ClaseMonitor mapClaseMonitor(ResultSet rs) throws SQLException {
        return new ClaseMonitor(
                rs.getInt("id_clase"),
                rs.getString("clase_nombre"),
                rs.getString("tipo"),
                rs.getString("monitor_nombre"),
                rs.getString("especialidad"));
    }

    // private final Integer reservaId;
    // private final Integer claseId;
    // private final String claseNombre;
    // private final Integer socioId;
    // private final String socioNombre;
    // private final String estadoReserva;

    private ClaseReservaSocio mapClaseReservaSocio(ResultSet rs) throws SQLException {
        return new ClaseReservaSocio(
                rs.getInt("reservaId"),
                rs.getInt("claseId"),
                rs.getString("claseNombre"),
                rs.getInt("socioId"),
                rs.getString("socioNombre"),
                rs.getString("estadoReserva"));
    }
}
