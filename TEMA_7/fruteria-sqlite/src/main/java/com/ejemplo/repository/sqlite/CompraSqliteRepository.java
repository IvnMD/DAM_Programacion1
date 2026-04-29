package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Compra;
import com.ejemplo.model.CompraDetalle;
import com.ejemplo.repository.ICompraRepository;

public class CompraSqliteRepository implements ICompraRepository {

    /**
     * rs.getInt("id"),
     * rs.getString("fecha"),
     * rs.getString("numero_factura"),
     * rs.getString("cif_proveedor"),
     * rs.getDouble("subtotal"),
     * rs.getDouble("iva"),
     * rs.getDouble("total"),
     * rs.getString("estado"),
     * rs.getString("observaciones"));
     */

    @Override
    public boolean crear(Compra compra) {
        String sql = "INSERT INTO compra (fecha, numero_factura, cif_proveedor,"
                + "subtotal, iva, total, estado, observaciones) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, compra.getFecha());
            ps.setString(2, compra.getNumeroFactura());
            ps.setString(3, compra.getCifProveedor());
            ps.setDouble(4, compra.getSubtotal());
            ps.setDouble(5, compra.getIva());
            ps.setDouble(6, compra.getTotal());
            ps.setString(7, compra.getEstado());
            ps.setString(8, compra.getObservaciones());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Compra buscarPorId(Integer id) {
        String sql = "SELECT * FROM compra WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapCompra(rs);
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Compra> listarTodos() {
        String sql = "SELECT * FROM compra ORDER BY id";
        List<Compra> compras = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    compras.add(mapCompra(rs));
                }
                return compras;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean actualizar(Compra compra) {
        String sql = "UPDATE compra SET fecha = ?, numero_factura = ?, cif_proveedor = ?,"
                + "subtotal = ?, iva = ?, total = ?, estado = ?, observaciones = ? WHERE id = ? ";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, compra.getFecha());
            ps.setString(2, compra.getNumeroFactura());
            ps.setString(3, compra.getCifProveedor());
            ps.setDouble(4, compra.getSubtotal());
            ps.setDouble(5, compra.getIva());
            ps.setDouble(6, compra.getTotal());
            ps.setString(7, compra.getEstado());
            ps.setString(8, compra.getObservaciones());

            ps.setInt(9, compra.getId());
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean borrarPorId(Integer id) {
        String sql = "DELETE FROM compra WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Compra> buscarPorProveedor(String cifProveedor) {
        String sql = "SELECT * FROM compra WHERE cif_proveedor = ?";
        List<Compra> compras = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cifProveedor);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    compras.add(mapCompra(rs));
                }
                return compras;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Compra buscarPorNumeroFactura(String numeroFactura) {
        String sql = "SELECT * FROM compra WHERE numero_factura = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, numeroFactura);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapCompra(rs);
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<CompraDetalle> buscarDetallesPorCompra(Integer idCompra) {
        String sql = "SELECT * FROM compra WHERE idCompra = ?";
        List<CompraDetalle> detalles = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    detalles.add(mapDetalle(rs));
                }
                return detalles;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    private Compra mapCompra(ResultSet rs) throws SQLException {
        return new Compra(
                rs.getInt("id"),
                rs.getString("fecha"),
                rs.getString("numero_factura"),
                rs.getString("cif_proveedor"),
                rs.getDouble("subtotal"),
                rs.getDouble("iva"),
                rs.getDouble("total"),
                rs.getString("estado"),
                rs.getString("observaciones"));
    }

    private CompraDetalle mapDetalle(ResultSet rs) throws SQLException {
        return new CompraDetalle(
                rs.getInt("id"),
                rs.getInt("id_compra"),
                rs.getInt("id_producto"),
                rs.getDouble("cantidad"),
                rs.getDouble("precio_unitario"),
                rs.getDouble("descuento"),
                rs.getDouble("total_linea"));
    }

}
