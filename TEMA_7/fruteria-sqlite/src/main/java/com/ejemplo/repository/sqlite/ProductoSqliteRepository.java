package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.MovimientoStock;
import com.ejemplo.model.Producto;
import com.ejemplo.model.ProductoCatalogo;
import com.ejemplo.repository.IProductoRepository;

public class ProductoSqliteRepository implements IProductoRepository {

    /**
     * CREATE TABLE producto (
     * id INTEGER PRIMARY KEY AUTOINCREMENT,
     * codigo TEXT NOT NULL UNIQUE,
     * nombre TEXT NOT NULL,
     * unidad_medida TEXT NOT NULL CHECK (unidad_medida IN
     * ('kg','unidad','caja','bandeja')),
     * precio_compra REAL NOT NULL CHECK (precio_compra >= 0),
     * precio_venta REAL NOT NULL CHECK (precio_venta > 0),
     * stock_actual REAL NOT NULL DEFAULT 0 CHECK (stock_actual >= 0),
     * stock_minimo REAL NOT NULL DEFAULT 0 CHECK (stock_minimo >= 0),
     * perecedero INTEGER NOT NULL DEFAULT 1 CHECK (perecedero IN (0,1)),
     * activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1)),
     * id_categoria INTEGER NOT NULL,
     * cif_Producto_principal TEXT,
     * FOREIGN KEY (id_categoria) REFERENCES categoria_producto(id),
     * FOREIGN KEY (cif_Producto_principal) REFERENCES Producto(cif)
     * );
     */

    @Override
    public boolean crear(Producto producto) {
String sql = "INSERT INTO producto (codigo, nombre, unidad_medida, "
           + "precio_compra, precio_venta, stock_actual, "
           + "stock_minimo, perecedero, activo, id_categoria, "
           + "cif_proveedor_principal) VALUES (?,?,?,?,?,?,?,?,?,?,?)"; 
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getUnidadMedida());
            ps.setDouble(4, producto.getPrecioCompra());
            ps.setDouble(5, producto.getPrecioVenta());
            ps.setDouble(6, producto.getStockActual());
            ps.setDouble(7, producto.getStockMinimo());
            ps.setInt(8, producto.getPerecedero());
            ps.setInt(9, producto.getActivo());
            ps.setInt(10, producto.getIdCategoria());
            ps.setString(11, producto.getCifProveedorPrincipal());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Producto buscarPorId(Integer id) {
        String sql = "SELECT * FROM producto WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapProducto(rs);
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Producto> listarTodos() {
        String sql = "SELECT * FROM producto ORDER BY id";
        List<Producto> productos = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productos.add(mapProducto(rs));
                }
                return productos;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean actualizar(Producto producto) {
        String sql = "UPDATE producto SET codigo = ?, nombre = ?, unidad_medida = ?, "
                + "precio_compra = ?, precio_venta = ?, stock_actual = ?, "
                + "stock_minimo = ?, perecedero = ?, activo = ?, id_categoria = ?, "
                + "cif_proveedor_principal = ? WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getUnidadMedida());
            ps.setDouble(4, producto.getPrecioCompra());
            ps.setDouble(5, producto.getPrecioVenta());
            ps.setDouble(6, producto.getStockActual());
            ps.setDouble(7, producto.getStockMinimo());
            ps.setInt(8, producto.getPerecedero());
            ps.setInt(9, producto.getActivo());
            ps.setInt(10, producto.getIdCategoria());
            ps.setString(11, producto.getCifProveedorPrincipal());
            ps.setInt(12, producto.getId()); // ✅ WHERE
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean borrarPorId(Integer id) {
        String sql = "DELETE FROM producto WHERE id = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Producto> listarActivos() {
        String sql = "SELECT * FROM producto WHERE activo = 1";
        List<Producto> productos = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productos.add(mapProducto(rs));
                }
                return productos;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Producto> listarPorCategoria(Integer idCategoria) {
        String sql = "SELECT * FROM producto WHERE id_categoria = ?"; // ✅
        List<Producto> productos = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idCategoria); // ✅
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next())
                    productos.add(mapProducto(rs));
                return productos;
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Producto> buscarBajoStock() {
        String sql = "SELECT * FROM producto WHERE stock_actual <= stock_minimo";
        List<Producto> productos = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productos.add(mapProducto(rs));
                }
                return productos;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<ProductoCatalogo> buscarCatalogo() {
        String sql = "SELECT * FROM vwproductoscatalogo ORDER BY nombre";
        List<ProductoCatalogo> catalogo = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    catalogo.add(mapCatalogo(rs));
                }
                return catalogo;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<MovimientoStock> buscarMovimientosPorProducto(Integer idProducto) {
        String sql = "SELECT * FROM movimiento_stock WHERE id_producto = ? ORDER BY fecha DESC";
        List<MovimientoStock> movimientos = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, idProducto);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    movimientos.add(mapMovimiento(rs));
                }
                return movimientos;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * CREATE TABLE producto (
     * id INTEGER PRIMARY KEY AUTOINCREMENT,
     * codigo TEXT NOT NULL UNIQUE,
     * nombre TEXT NOT NULL,
     * unidad_medida TEXT NOT NULL CHECK (unidad_medida IN
     * ('kg','unidad','caja','bandeja')),
     * precio_compra REAL NOT NULL CHECK (precio_compra >= 0),
     * precio_venta REAL NOT NULL CHECK (precio_venta > 0),
     * stock_actual REAL NOT NULL DEFAULT 0 CHECK (stock_actual >= 0),
     * stock_minimo REAL NOT NULL DEFAULT 0 CHECK (stock_minimo >= 0),
     * perecedero INTEGER NOT NULL DEFAULT 1 CHECK (perecedero IN (0,1)),
     * activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1)),
     * id_categoria INTEGER NOT NULL,
     * cif_Producto_principal TEXT,
     * FOREIGN KEY (id_categoria) REFERENCES categoria_producto(id),
     * FOREIGN KEY (cif_Producto_principal) REFERENCES Producto(cif)
     * );
     */
    private Producto mapProducto(ResultSet rs) throws SQLException {
        return new Producto(
                rs.getInt("id"),
                rs.getString("codigo"),
                rs.getString("nombre"),
                rs.getString("unidad_medida"),
                rs.getDouble("precio_compra"),
                rs.getDouble("precio_venta"),
                rs.getDouble("stock_actual"),
                rs.getDouble("stock_minimo"),
                rs.getInt("perecedero"),
                rs.getInt("activo"),
                rs.getInt("id_categoria"),
                rs.getString("cif_proveedor_principal"));
    }

    private ProductoCatalogo mapCatalogo(ResultSet rs) throws SQLException {
        return new ProductoCatalogo(
                rs.getInt("id"),
                rs.getString("codigo"),
                rs.getString("nombre"),
                rs.getString("categoria"),
                rs.getString("unidad_medida"),
                rs.getDouble("precio_compra"),
                rs.getDouble("precio_venta"),
                rs.getDouble("stock_actual"),
                rs.getDouble("stock_minimo"),
                rs.getInt("perecedero"),
                rs.getInt("activo"),
                rs.getString("proveedor_principal"));
    }

    private MovimientoStock mapMovimiento(ResultSet rs) throws SQLException {
        return new MovimientoStock(
                rs.getInt("id"),
                rs.getString("fecha"),
                rs.getInt("id_producto"),
                rs.getString("tipo"),
                rs.getDouble("cantidad"),
                rs.getString("referencia"),
                rs.getString("observaciones"));
    }
}
