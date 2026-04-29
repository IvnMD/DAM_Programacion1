package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Venta;
import com.ejemplo.model.VentaDetalle;
import com.ejemplo.model.VentaResumen;
import com.ejemplo.repository.IVentaRepository;

public class VentaSqliteRepository implements IVentaRepository {

    @Override
    public boolean crear(Venta venta) {
        String sql = "INSERT INTO venta (fecha, ticket, dni_cliente, metodo_pago, "
                   + "subtotal, descuento_total, iva, total, estado) "
                   + "VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection cn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, venta.getFecha());
            ps.setString(2, venta.getTicket());
            ps.setString(3, venta.getDniCliente());
            ps.setString(4, venta.getMetodoPago());
            ps.setDouble(5, venta.getSubtotal());
            ps.setDouble(6, venta.getDescuentoTotal());
            ps.setDouble(7, venta.getIva());
            ps.setDouble(8, venta.getTotal());
            ps.setString(9, venta.getEstado());
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Venta buscarPorId(Integer id) {
        String sql = "SELECT * FROM venta WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapVenta(rs);
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Venta> listarTodos() {
        String sql = "SELECT * FROM venta ORDER BY id";
        List<Venta> ventas = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) ventas.add(mapVenta(rs));
                return ventas;
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean actualizar(Venta venta) {
        String sql = "UPDATE venta SET fecha = ?, ticket = ?, dni_cliente = ?, metodo_pago = ?, "
                   + "subtotal = ?, descuento_total = ?, iva = ?, total = ?, "
                   + "estado = ? WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, venta.getFecha());
            ps.setString(2, venta.getTicket());
            ps.setString(3, venta.getDniCliente());
            ps.setString(4, venta.getMetodoPago());
            ps.setDouble(5, venta.getSubtotal());
            ps.setDouble(6, venta.getDescuentoTotal());
            ps.setDouble(7, venta.getIva());
            ps.setDouble(8, venta.getTotal());
            ps.setString(9, venta.getEstado());
            ps.setInt(10, venta.getId());     
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean borrarPorId(Integer id) {
        String sql = "DELETE FROM venta WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Venta> buscarPorCliente(String dniCliente) {
        String sql = "SELECT * FROM venta WHERE dni_cliente = ?";
        List<Venta> ventas = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, dniCliente);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) ventas.add(mapVenta(rs));
                return ventas;
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Venta buscarPorTicket(String ticket) {
        String sql = "SELECT * FROM venta WHERE ticket = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, ticket);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapVenta(rs);
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<VentaDetalle> buscarDetallesPorVenta(Integer idVenta) {
        String sql = "SELECT * FROM venta_detalle WHERE id_venta = ?";
        List<VentaDetalle> detalles = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) detalles.add(mapDetalle(rs));
                return detalles;
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<VentaResumen> buscarResumenVentas() {
        String sql = "SELECT * FROM vw_resumen_ventas ORDER BY fecha DESC";
        List<VentaResumen> resumen = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) resumen.add(mapResumen(rs));
                return resumen;
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


    private Venta mapVenta(ResultSet rs) throws SQLException {
        return new Venta(
            rs.getInt("id"),
            rs.getString("fecha"),
            rs.getString("ticket"),
            rs.getString("dni_cliente"),
            rs.getString("metodo_pago"),
            rs.getDouble("subtotal"),
            rs.getDouble("descuento_total"),
            rs.getDouble("iva"),
            rs.getDouble("total"),
            rs.getString("estado")
        );
    }

    private VentaDetalle mapDetalle(ResultSet rs) throws SQLException {
        return new VentaDetalle(
            rs.getInt("id"),
            rs.getInt("id_venta"),
            rs.getInt("id_producto"),
            rs.getDouble("cantidad"),
            rs.getDouble("precio_unitario"),
            rs.getDouble("descuento"),
            rs.getDouble("total_linea")
        );
    }

    private VentaResumen mapResumen(ResultSet rs) throws SQLException {
        return new VentaResumen(
            rs.getInt("id"),
            rs.getString("ticket"),
            rs.getString("fecha"),
            rs.getString("cliente"),
            rs.getString("metodo_pago"),
            rs.getDouble("total"),
            rs.getString("estado")
        );
    }
}