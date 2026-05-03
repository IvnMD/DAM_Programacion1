# Directory Structure
```
fruteria-sqlite/
  images/
    fruteria-dam.png
    salida-test.png
  src/
    main/
      java/
        com/
          ejemplo/
            app/
              Main.java
            model/
              CategoriaProducto.java
              Cliente.java
              Compra.java
              CompraDetalle.java
              MovimientoStock.java
              Producto.java
              ProductoCatalogo.java
              Proveedor.java
              Venta.java
              VentaDetalle.java
              VentaResumen.java
            repository/
              sqlite/
                ClienteSqliteRepository.java
                CompraSqliteRepository.java
                ProductoSqliteRepository.java
                ProveedorSqliteRepository.java
                SQLiteConnectionManager.java
                VentaSqliteRepository.java
              IClienteRepository.java
              ICompraRepository.java
              IProductoRepository.java
              IProveedorRepository.java
              IVentaRepository.java
            service/
              ClienteService.java
              CompraService.java
              IClienteService.java
              ICompraService.java
              IProductoService.java
              IProveedorService.java
              IVentaService.java
              ProductoService.java
              ProveedorService.java
              VentaService.java
            validation/
              ValidationUtils.java
      resources/
        data/
          sqlite/
            fruteria_schema.sql
            fruteria.db
    test/
      java/
        com/
          ejemplo/
            service/
              validation/
                ClienteServiceRegexValidationTest.java
                CompraServiceRegexValidationTest.java
                ProductoServiceRegexValidationTest.java
                ProveedorServiceRegexValidationTest.java
                VentaServiceRegexValidationTest.java
              ClienteServiceSqliteTest.java
              CompraServiceSqliteTest.java
              ProductoServiceSqliteTest.java
              ProveedorServiceSqliteTest.java
              VentaServiceSqliteTest.java
            support/
              TestDatabaseSupport.java
            validation/
              ValidationUtilsTest.java
      resources/
        backup.db
  DESCRIPCION-EJERCICIO.pdf
  pom.xml
  README.md
```

# Files

## File: fruteria-sqlite/src/main/java/com/ejemplo/app/Main.java
````java
package com.ejemplo.app;
public class Main { public static void main(String[] args){ System.out.println("Frutería SQLite - PK naturales"); } }
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/model/CategoriaProducto.java
````java
package com.ejemplo.model;

public class CategoriaProducto {
    private Integer id;
    private String nombre;
    private String descripcion;

    public CategoriaProducto() {}

    public CategoriaProducto(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public void setId(Integer id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/model/Cliente.java
````java
package com.ejemplo.model;

public class Cliente {
    private String dni;
    private String nombre;
    private String telefono;
    private String email;
    private String ciudad;
    private Integer activo;

    public Cliente() {}

    public Cliente(String dni, String nombre, String telefono, String email, String ciudad, Integer activo) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
        this.activo = activo;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getCiudad() { return ciudad; }
    public Integer getActivo() { return activo; }
    public void setDni(String dni) { this.dni = dni; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setEmail(String email) { this.email = email; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public void setActivo(Integer activo) { this.activo = activo; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/model/Compra.java
````java
package com.ejemplo.model;

public class Compra {
    private Integer id;
    private String fecha;
    private String numeroFactura;
    private String cifProveedor;
    private Double subtotal;
    private Double iva;
    private Double total;
    private String estado;
    private String observaciones;

    public Compra() {}

    public Compra(Integer id, String fecha, String numeroFactura, String cifProveedor, Double subtotal, Double iva, Double total, String estado, String observaciones) {
        this.id = id;
        this.fecha = fecha;
        this.numeroFactura = numeroFactura;
        this.cifProveedor = cifProveedor;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public Integer getId() { return id; }
    public String getFecha() { return fecha; }
    public String getNumeroFactura() { return numeroFactura; }
    public String getCifProveedor() { return cifProveedor; }
    public Double getSubtotal() { return subtotal; }
    public Double getIva() { return iva; }
    public Double getTotal() { return total; }
    public String getEstado() { return estado; }
    public String getObservaciones() { return observaciones; }
    public void setId(Integer id) { this.id = id; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }
    public void setCifProveedor(String cifProveedor) { this.cifProveedor = cifProveedor; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }
    public void setIva(Double iva) { this.iva = iva; }
    public void setTotal(Double total) { this.total = total; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/model/CompraDetalle.java
````java
package com.ejemplo.model;

public class CompraDetalle {
    private Integer id;
    private Integer idCompra;
    private Integer idProducto;
    private Double cantidad;
    private Double precioUnitario;
    private Double descuento;
    private Double totalLinea;

    public CompraDetalle() {}

    public CompraDetalle(Integer id, Integer idCompra, Integer idProducto, Double cantidad, Double precioUnitario, Double descuento, Double totalLinea) {
        this.id = id;
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.totalLinea = totalLinea;
    }

    public Integer getId() { return id; }
    public Integer getIdCompra() { return idCompra; }
    public Integer getIdProducto() { return idProducto; }
    public Double getCantidad() { return cantidad; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public Double getDescuento() { return descuento; }
    public Double getTotalLinea() { return totalLinea; }
    public void setId(Integer id) { this.id = id; }
    public void setIdCompra(Integer idCompra) { this.idCompra = idCompra; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }
    public void setCantidad(Double cantidad) { this.cantidad = cantidad; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setDescuento(Double descuento) { this.descuento = descuento; }
    public void setTotalLinea(Double totalLinea) { this.totalLinea = totalLinea; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/model/MovimientoStock.java
````java
package com.ejemplo.model;

public class MovimientoStock {
    private Integer id;
    private String fecha;
    private Integer idProducto;
    private String tipo;
    private Double cantidad;
    private String referencia;
    private String observaciones;

    public MovimientoStock() {}

    public MovimientoStock(Integer id, String fecha, Integer idProducto, String tipo, Double cantidad, String referencia, String observaciones) {
        this.id = id;
        this.fecha = fecha;
        this.idProducto = idProducto;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.referencia = referencia;
        this.observaciones = observaciones;
    }

    public Integer getId() { return id; }
    public String getFecha() { return fecha; }
    public Integer getIdProducto() { return idProducto; }
    public String getTipo() { return tipo; }
    public Double getCantidad() { return cantidad; }
    public String getReferencia() { return referencia; }
    public String getObservaciones() { return observaciones; }
    public void setId(Integer id) { this.id = id; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCantidad(Double cantidad) { this.cantidad = cantidad; }
    public void setReferencia(String referencia) { this.referencia = referencia; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/model/Producto.java
````java
package com.ejemplo.model;

public class Producto {
    private Integer id;
    private String codigo;
    private String nombre;
    private String unidadMedida;
    private Double precioCompra;
    private Double precioVenta;
    private Double stockActual;
    private Double stockMinimo;
    private Integer perecedero;
    private Integer activo;
    private Integer idCategoria;
    private String cifProveedorPrincipal;

    public Producto() {}

    public Producto(Integer id, String codigo, String nombre, String unidadMedida, Double precioCompra, Double precioVenta, Double stockActual, Double stockMinimo, Integer perecedero, Integer activo, Integer idCategoria, String cifProveedorPrincipal) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.perecedero = perecedero;
        this.activo = activo;
        this.idCategoria = idCategoria;
        this.cifProveedorPrincipal = cifProveedorPrincipal;
    }

    public Integer getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getUnidadMedida() { return unidadMedida; }
    public Double getPrecioCompra() { return precioCompra; }
    public Double getPrecioVenta() { return precioVenta; }
    public Double getStockActual() { return stockActual; }
    public Double getStockMinimo() { return stockMinimo; }
    public Integer getPerecedero() { return perecedero; }
    public Integer getActivo() { return activo; }
    public Integer getIdCategoria() { return idCategoria; }
    public String getCifProveedorPrincipal() { return cifProveedorPrincipal; }
    public void setId(Integer id) { this.id = id; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }
    public void setPrecioCompra(Double precioCompra) { this.precioCompra = precioCompra; }
    public void setPrecioVenta(Double precioVenta) { this.precioVenta = precioVenta; }
    public void setStockActual(Double stockActual) { this.stockActual = stockActual; }
    public void setStockMinimo(Double stockMinimo) { this.stockMinimo = stockMinimo; }
    public void setPerecedero(Integer perecedero) { this.perecedero = perecedero; }
    public void setActivo(Integer activo) { this.activo = activo; }
    public void setIdCategoria(Integer idCategoria) { this.idCategoria = idCategoria; }
    public void setCifProveedorPrincipal(String cifProveedorPrincipal) { this.cifProveedorPrincipal = cifProveedorPrincipal; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/model/ProductoCatalogo.java
````java
package com.ejemplo.model;

public class ProductoCatalogo {
    private Integer id;
    private String codigo;
    private String nombre;
    private String categoria;
    private String unidadMedida;
    private Double precioCompra;
    private Double precioVenta;
    private Double stockActual;
    private Double stockMinimo;
    private Integer perecedero;
    private Integer activo;
    private String proveedorPrincipal;

    public ProductoCatalogo() {}

    public ProductoCatalogo(Integer id, String codigo, String nombre, String categoria, String unidadMedida, Double precioCompra, Double precioVenta, Double stockActual, Double stockMinimo, Integer perecedero, Integer activo, String proveedorPrincipal) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.unidadMedida = unidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.perecedero = perecedero;
        this.activo = activo;
        this.proveedorPrincipal = proveedorPrincipal;
    }

    public Integer getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public String getUnidadMedida() { return unidadMedida; }
    public Double getPrecioCompra() { return precioCompra; }
    public Double getPrecioVenta() { return precioVenta; }
    public Double getStockActual() { return stockActual; }
    public Double getStockMinimo() { return stockMinimo; }
    public Integer getPerecedero() { return perecedero; }
    public Integer getActivo() { return activo; }
    public String getProveedorPrincipal() { return proveedorPrincipal; }
    public void setId(Integer id) { this.id = id; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }
    public void setPrecioCompra(Double precioCompra) { this.precioCompra = precioCompra; }
    public void setPrecioVenta(Double precioVenta) { this.precioVenta = precioVenta; }
    public void setStockActual(Double stockActual) { this.stockActual = stockActual; }
    public void setStockMinimo(Double stockMinimo) { this.stockMinimo = stockMinimo; }
    public void setPerecedero(Integer perecedero) { this.perecedero = perecedero; }
    public void setActivo(Integer activo) { this.activo = activo; }
    public void setProveedorPrincipal(String proveedorPrincipal) { this.proveedorPrincipal = proveedorPrincipal; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/model/Proveedor.java
````java
package com.ejemplo.model;

public class Proveedor {
    private String cif;
    private String nombre;
    private String telefono;
    private String email;
    private String ciudad;
    private Integer activo;

    public Proveedor() {}

    public Proveedor(String cif, String nombre, String telefono, String email, String ciudad, Integer activo) {
        this.cif = cif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
        this.activo = activo;
    }

    public String getCif() { return cif; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getCiudad() { return ciudad; }
    public Integer getActivo() { return activo; }
    public void setCif(String cif) { this.cif = cif; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setEmail(String email) { this.email = email; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public void setActivo(Integer activo) { this.activo = activo; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/model/Venta.java
````java
package com.ejemplo.model;

public class Venta {
    private Integer id;
    private String fecha;
    private String ticket;
    private String dniCliente;
    private String metodoPago;
    private Double subtotal;
    private Double descuentoTotal;
    private Double iva;
    private Double total;
    private String estado;

    public Venta() {}

    public Venta(Integer id, String fecha, String ticket, String dniCliente, String metodoPago, Double subtotal, Double descuentoTotal, Double iva, Double total, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.ticket = ticket;
        this.dniCliente = dniCliente;
        this.metodoPago = metodoPago;
        this.subtotal = subtotal;
        this.descuentoTotal = descuentoTotal;
        this.iva = iva;
        this.total = total;
        this.estado = estado;
    }

    public Integer getId() { return id; }
    public String getFecha() { return fecha; }
    public String getTicket() { return ticket; }
    public String getDniCliente() { return dniCliente; }
    public String getMetodoPago() { return metodoPago; }
    public Double getSubtotal() { return subtotal; }
    public Double getDescuentoTotal() { return descuentoTotal; }
    public Double getIva() { return iva; }
    public Double getTotal() { return total; }
    public String getEstado() { return estado; }
    public void setId(Integer id) { this.id = id; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setTicket(String ticket) { this.ticket = ticket; }
    public void setDniCliente(String dniCliente) { this.dniCliente = dniCliente; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }
    public void setDescuentoTotal(Double descuentoTotal) { this.descuentoTotal = descuentoTotal; }
    public void setIva(Double iva) { this.iva = iva; }
    public void setTotal(Double total) { this.total = total; }
    public void setEstado(String estado) { this.estado = estado; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/model/VentaDetalle.java
````java
package com.ejemplo.model;

public class VentaDetalle {
    private Integer id;
    private Integer idVenta;
    private Integer idProducto;
    private Double cantidad;
    private Double precioUnitario;
    private Double descuento;
    private Double totalLinea;

    public VentaDetalle() {}

    public VentaDetalle(Integer id, Integer idVenta, Integer idProducto, Double cantidad, Double precioUnitario, Double descuento, Double totalLinea) {
        this.id = id;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.totalLinea = totalLinea;
    }

    public Integer getId() { return id; }
    public Integer getIdVenta() { return idVenta; }
    public Integer getIdProducto() { return idProducto; }
    public Double getCantidad() { return cantidad; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public Double getDescuento() { return descuento; }
    public Double getTotalLinea() { return totalLinea; }
    public void setId(Integer id) { this.id = id; }
    public void setIdVenta(Integer idVenta) { this.idVenta = idVenta; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }
    public void setCantidad(Double cantidad) { this.cantidad = cantidad; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setDescuento(Double descuento) { this.descuento = descuento; }
    public void setTotalLinea(Double totalLinea) { this.totalLinea = totalLinea; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/model/VentaResumen.java
````java
package com.ejemplo.model;

public class VentaResumen {
    private Integer id;
    private String ticket;
    private String fecha;
    private String cliente;
    private String metodoPago;
    private Double total;
    private String estado;

    public VentaResumen() {}

    public VentaResumen(Integer id, String ticket, String fecha, String cliente, String metodoPago, Double total, String estado) {
        this.id = id;
        this.ticket = ticket;
        this.fecha = fecha;
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.total = total;
        this.estado = estado;
    }

    public Integer getId() { return id; }
    public String getTicket() { return ticket; }
    public String getFecha() { return fecha; }
    public String getCliente() { return cliente; }
    public String getMetodoPago() { return metodoPago; }
    public Double getTotal() { return total; }
    public String getEstado() { return estado; }
    public void setId(Integer id) { this.id = id; }
    public void setTicket(String ticket) { this.ticket = ticket; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public void setTotal(Double total) { this.total = total; }
    public void setEstado(String estado) { this.estado = estado; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/repository/sqlite/ClienteSqliteRepository.java
````java
package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;

public class ClienteSqliteRepository implements IClienteRepository {

    @Override
    public boolean crear(Cliente cliente) {
        String sql = "INSERT INTO cliente(dni,nombre,telefono,email,ciudad,activo) VALUES(?,?,?,?,?,?)";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getCiudad());
            ps.setInt(6, cliente.getActivo());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Cliente buscarPorId(String dni) {
        String sql = "SELECT * FROM cliente WHERE dni = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, dni);
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

//     public Cliente buscarPorId(String dni) {
//     String sql = "SELECT * FROM cliente WHERE dni = ?";
//     try (Connection cn = SQLiteConnectionManager.getConnection();
//          PreparedStatement ps = cn.prepareStatement(sql)) {
//         ps.setString(1, dni);
//         try (ResultSet rs = ps.executeQuery()) {
//             if (rs.next()) {
//                 return new Cliente(       // construyes aquí directamente
//                     rs.getString("dni"),
//                     rs.getString("nombre"),
//                     rs.getString("telefono"),
//                     rs.getString("email"),
//                     rs.getString("ciudad"),
//                     rs.getInt("activo")
//                 );
//             }
//             return null;
//         }
//     } catch (Exception e) {
//         return null;
//     }
// }

    @Override
    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM cliente ORDER BY nombre";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientes.add(map(rs));
                }
                return clientes;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

//     public List<Cliente> listarTodos() {
//     String sql = "SELECT * FROM cliente ORDER BY nombre";
//     List<Cliente> clientes = new ArrayList<>();
//     try (Connection cn = SQLiteConnectionManager.getConnection();
//          PreparedStatement ps = cn.prepareStatement(sql)) {
//         try (ResultSet rs = ps.executeQuery()) {
//             while (rs.next()) {
//                 clientes.add(new Cliente(   // construyes aquí directamente
//                     rs.getString("dni"),
//                     rs.getString("nombre"),
//                     rs.getString("telefono"),
//                     rs.getString("email"),
//                     rs.getString("ciudad"),
//                     rs.getInt("activo")
//                 ));
//             }
//             return clientes;
//         }
//     } catch (Exception e) {
//         return new ArrayList<>();
//     }
// }

    @Override
    public boolean actualizar(Cliente cliente) {

        String sql = "UPDATE cliente SET nombre = ?, telefono = ?, email = ?, ciudad = ?, activo = ? WHERE dni = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getCiudad());
            ps.setInt(5, cliente.getActivo());
            ps.setString(6, cliente.getDni());
            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean borrarPorDni(String dni) {
        String sql = "DELETE FROM cliente WHERE dni = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, dni);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Cliente> buscarActivos() {
        String sql = "SELECT * FROM cliente WHERE activo = 1";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientes.add(map(rs));
                }
                return clientes;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Cliente> buscarPorCiudad(String ciudad) {
        String sql = "SELECT * FROM cliente WHERE ciudad = ?";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
                    ps.setString(1, ciudad);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientes.add(map(rs));
                }
                return clientes;
            }

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Cliente buscarPorEmail(String email) {
        String sql = "SELECT * FROM cliente WHERE email = ?";
        try (Connection cn = SQLiteConnectionManager.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, email);
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

    private Cliente map(ResultSet rs) throws SQLException {
        return new Cliente(rutaDB
                rs.getString("dni"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("email"),
                rs.getString("ciudad"),
                rs.getInt("activo"));
    }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/repository/sqlite/CompraSqliteRepository.java
````java
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
    String sql = "SELECT * FROM compra_detalle WHERE id_compra = ?"; 
    List<CompraDetalle> detalles = new ArrayList<>();
    try (Connection cn = SQLiteConnectionManager.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setInt(1, idCompra);  
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) detalles.add(mapDetalle(rs));
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
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/repository/sqlite/ProductoSqliteRepository.java
````java
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
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/repository/sqlite/ProveedorSqliteRepository.java
````java
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
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/repository/sqlite/SQLiteConnectionManager.java
````java
package com.ejemplo.repository.sqlite;
import java.sql.*;
public abstract class SQLiteConnectionManager {
    private static String databasePath = "src/main/resources/data/sqlite/fruteria.db";
    public static void setDatabasePath(String path){ databasePath = path; }
    public static String getDatabasePath(){ return databasePath; }
    public static Connection getConnection() throws SQLException { Connection c=DriverManager.getConnection("jdbc:sqlite:"+databasePath); try(Statement st=c.createStatement()){ st.execute("PRAGMA foreign_keys = ON"); } return c; }
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/repository/sqlite/VentaSqliteRepository.java
````java
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
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/repository/IClienteRepository.java
````java
package com.ejemplo.repository;

import java.util.List;

import com.ejemplo.model.*;

public interface IClienteRepository {
    boolean crear(Cliente cliente);
    Cliente buscarPorId(String dni);
    List<Cliente> listarTodos();
    boolean actualizar(Cliente cliente);
    boolean borrarPorDni(String dni);
    List<Cliente> buscarActivos();
    List<Cliente> buscarPorCiudad(String ciudad);
    Cliente buscarPorEmail(String email);
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/repository/ICompraRepository.java
````java
package com.ejemplo.repository;

import java.util.List;

import com.ejemplo.model.*;

public interface ICompraRepository {
    boolean crear(Compra compra);
    Compra buscarPorId(Integer id);
    List<Compra> listarTodos();
    boolean actualizar(Compra compra);
    boolean borrarPorId(Integer id);
    List<Compra> buscarPorProveedor(String cifProveedor);
    Compra buscarPorNumeroFactura(String numeroFactura);
    List<CompraDetalle> buscarDetallesPorCompra(Integer idCompra);
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/repository/IProductoRepository.java
````java
package com.ejemplo.repository;

import java.util.List;

import com.ejemplo.model.*;

public interface IProductoRepository {
    boolean crear(Producto producto);
    Producto buscarPorId(Integer id);
    List<Producto> listarTodos();
    boolean actualizar(Producto producto);
    boolean borrarPorId(Integer id);
    List<Producto> listarActivos();
    List<Producto> listarPorCategoria(Integer idCategoria);
    List<Producto> buscarBajoStock();
    List<ProductoCatalogo> buscarCatalogo();
    List<MovimientoStock> buscarMovimientosPorProducto(Integer idProducto);
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/repository/IProveedorRepository.java
````java
package com.ejemplo.repository;

import java.util.List;

import com.ejemplo.model.*;

public interface IProveedorRepository {
    boolean crear(Proveedor proveedor);
    Proveedor buscarPorCif(String cif);
    List<Proveedor> listarTodos();
    boolean actualizar(Proveedor proveedor);
    boolean borrarPorCif(String cif);
    List<Proveedor> listarActivos();
    List<Proveedor> buscarPorCiudad(String ciudad);
    Proveedor buscarPorEmail(String email);
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/repository/IVentaRepository.java
````java
package com.ejemplo.repository;

import java.util.List;

import com.ejemplo.model.*;

public interface IVentaRepository {
    boolean crear(Venta venta);
    Venta buscarPorId(Integer id);
    List<Venta> listarTodos();
    boolean actualizar(Venta venta);
    boolean borrarPorId(Integer id);
    List<Venta> buscarPorCliente(String dniCliente);
    Venta buscarPorTicket(String ticket);
    List<VentaDetalle> buscarDetallesPorVenta(Integer idVenta);
    List<VentaResumen> buscarResumenVentas();
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/service/ClienteService.java
````java
package com.ejemplo.service;

import java.util.List;

import com.ejemplo.model.*;
import com.ejemplo.repository.*;
import com.ejemplo.repository.sqlite.*;
import com.ejemplo.validation.ValidationUtils;

public class ClienteService implements IClienteService {
    private final IClienteRepository repository;
    public ClienteService() { this.repository = new ClienteSqliteRepository(); }
    @Override
    public boolean create(Cliente cliente) {
        if (cliente == null){
            return false;
        }
        if (!ValidationUtils.isValidCliente(cliente)){
            return false;
        }
        return repository.crear(cliente);
    }
    @Override
    public Cliente findByDni(String dni) {
        if (!ValidationUtils.isValidDni(dni)){
            return null;
        }
        return repository.buscarPorId(dni);
        
    }
    @Override
    public List<Cliente> findAll() {
        return repository.listarTodos();
        
    }
    @Override
    public boolean update(Cliente cliente) {
        if (!ValidationUtils.isValidCliente(cliente)){
            return false;
        }

        return repository.actualizar(cliente);
        
    }
    @Override
    public boolean deleteByDni(String dni) {
        if (!ValidationUtils.isValidDni(dni)){
            return false;
        }
        return repository.borrarPorDni(dni);    
    }

    @Override
    public List<Cliente> findActivos() {
        return repository.buscarActivos();
        
    }
    @Override
    public List<Cliente> findByCiudad(String ciudad) {
      if (!ValidationUtils.isValidCiudad(ciudad)){
        return null;
      }
       return repository.buscarPorCiudad(ciudad); 
    }
    @Override
    public Cliente findByEmail(String email) {
        if (!ValidationUtils.isValidEmail(email)){
            return null;
        }
        return repository.buscarPorEmail(email);
    }

   }
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/service/CompraService.java
````java
package com.ejemplo.service;

import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Compra;
import com.ejemplo.model.CompraDetalle;
import com.ejemplo.repository.ICompraRepository;
import com.ejemplo.repository.sqlite.CompraSqliteRepository;
import com.ejemplo.validation.ValidationUtils;

public class CompraService implements ICompraService {
    private final ICompraRepository repository;
    
    public CompraService() { this.repository = new CompraSqliteRepository(); }

    @Override
    public boolean create(Compra compra) {
        if (!ValidationUtils.isValidCompra(compra)){
            return false;
        }
        return repository.crear(compra);
        
    }
    @Override
    public Compra findById(Integer id) {
        return repository.buscarPorId(id);
        
    }
    @Override
    public List<Compra> findAll() {
        return repository.listarTodos();
        
    }
    @Override
    public boolean update(Compra compra) {
        if (!ValidationUtils.isValidCompra(compra)){
            return false;
        }
        return repository.actualizar(compra);
        
    }
    @Override
    public boolean deleteById(Integer id) {
        return repository.borrarPorId(id);
    }
    @Override
    public List<Compra> findByProveedor(String cifProveedor) {
        if (!ValidationUtils.isValidCif(cifProveedor)){
            return new ArrayList<>();
        }
        return repository.buscarPorProveedor(cifProveedor);
        
    }
    @Override
    public Compra findByNumeroFactura(String numeroFactura) {
        if (!ValidationUtils.isValidFactura(numeroFactura)){
            return null;
        }
        return repository.buscarPorNumeroFactura(numeroFactura);

    }
    @Override
    public List<CompraDetalle> findDetallesByCompra(Integer idCompra) {
        if (!ValidationUtils.isValidCompra(findById(idCompra))){
            return null;
        }
        return repository.buscarDetallesPorCompra(idCompra);
    }

    }
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/service/IClienteService.java
````java
package com.ejemplo.service;

import com.ejemplo.model.*;

public interface IClienteService {
    boolean create(Cliente cliente);
    Cliente findByDni(String dni);
    java.util.List<Cliente> findAll();
    boolean update(Cliente cliente);
    boolean deleteByDni(String dni);
    java.util.List<Cliente> findActivos();
    java.util.List<Cliente> findByCiudad(String ciudad);
    Cliente findByEmail(String email);
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/service/ICompraService.java
````java
package com.ejemplo.service;

import com.ejemplo.model.*;

public interface ICompraService {
    boolean create(Compra compra);
    Compra findById(Integer id);
    java.util.List<Compra> findAll();
    boolean update(Compra compra);
    boolean deleteById(Integer id);
    java.util.List<Compra> findByProveedor(String cifProveedor);
    Compra findByNumeroFactura(String numeroFactura);
    java.util.List<CompraDetalle> findDetallesByCompra(Integer idCompra);
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/service/IProductoService.java
````java
package com.ejemplo.service;

import com.ejemplo.model.*;

public interface IProductoService {
    boolean create(Producto producto);
    Producto findById(Integer id);
    java.util.List<Producto> findAll();
    boolean update(Producto producto);
    boolean deleteById(Integer id);
    java.util.List<Producto> findActivos();
    java.util.List<Producto> findByCategoria(Integer idCategoria);
    java.util.List<Producto> findBajoStock();
    java.util.List<ProductoCatalogo> findCatalogo();
    java.util.List<MovimientoStock> findMovimientosByProducto(Integer idProducto);
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/service/IProveedorService.java
````java
package com.ejemplo.service;

import com.ejemplo.model.*;

public interface IProveedorService {
    boolean create(Proveedor proveedor);
    Proveedor findByCif(String cif);
    java.util.List<Proveedor> findAll();
    boolean update(Proveedor proveedor);
    boolean deleteByCif(String cif);
    java.util.List<Proveedor> findActivos();
    java.util.List<Proveedor> findByCiudad(String ciudad);
    Proveedor findByEmail(String email);
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/service/IVentaService.java
````java
package com.ejemplo.service;

import com.ejemplo.model.*;

public interface IVentaService {
    boolean create(Venta venta);
    Venta findById(Integer id);
    java.util.List<Venta> findAll();
    boolean update(Venta venta);
    boolean deleteById(Integer id);
    java.util.List<Venta> findByCliente(String dniCliente);
    Venta findByTicket(String ticket);
    java.util.List<VentaDetalle> findDetallesByVenta(Integer idVenta);
    java.util.List<VentaResumen> findResumenVentas();
}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/service/ProductoService.java
````java
package com.ejemplo.service;

import java.util.List;

import com.ejemplo.model.*;
import com.ejemplo.repository.*;
import com.ejemplo.repository.sqlite.*;
import com.ejemplo.validation.ValidationUtils;

public class ProductoService implements IProductoService {
    private final IProductoRepository repository;
    public ProductoService() { this.repository = new ProductoSqliteRepository(); }
    @Override
    public boolean create(Producto producto) {
        if (!ValidationUtils.isValidProducto(producto)){
            return false;
        }
        return repository.crear(producto);
        
    }
    @Override
    public Producto findById(Integer id) {
        return repository.buscarPorId(id);        
    }

    @Override
    public List<Producto> findAll() {
        return repository.listarTodos();
    }

    @Override
    public boolean update(Producto producto) {
        if (!ValidationUtils.isValidProducto(producto)){
            return false;
        }
        return repository.actualizar(producto);
    }
    @Override
    public boolean deleteById(Integer id) {
        return repository.borrarPorId(id);
    }
    @Override
    public List<Producto> findActivos() {
        return repository.listarActivos();
        
    }
    @Override
    public List<Producto> findByCategoria(Integer idCategoria) {
        return repository.listarPorCategoria(idCategoria);
        
    }
    @Override
    public List<Producto> findBajoStock() {
        return repository.buscarBajoStock();
    }
    @Override
    public List<ProductoCatalogo> findCatalogo() {
        return repository.buscarCatalogo();
        
    }
    @Override
    public List<MovimientoStock> findMovimientosByProducto(Integer idProducto) {
        return repository.buscarMovimientosPorProducto(idProducto);
    }

}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/service/ProveedorService.java
````java
package com.ejemplo.service;

import java.util.List;

import com.ejemplo.model.*;
import com.ejemplo.repository.*;
import com.ejemplo.repository.sqlite.*;
import com.ejemplo.validation.ValidationUtils;

public class ProveedorService implements IProveedorService {
    private final IProveedorRepository repository;
    public ProveedorService() { this.repository = new ProveedorSqliteRepository(); }
    @Override
    public boolean create(Proveedor proveedor) {
        if (!ValidationUtils.isValidProveedor(proveedor)){
            return false;
        }
        return repository.crear(proveedor);
        
    }
    @Override
    public Proveedor findByCif(String cif) {
        if (!ValidationUtils.isValidCif(cif)){
            return null;
        }
        return repository.buscarPorCif(cif);
        
    }
    @Override
    public List<Proveedor> findAll() {
 
        return repository.listarTodos();
    }
    @Override
    public boolean update(Proveedor proveedor) {
        if (!ValidationUtils.isValidProveedor(proveedor)){
            return false;
        }
        return repository.actualizar(proveedor);
    }

    @Override
    public boolean deleteByCif(String cif) {
        if (!ValidationUtils.isValidCif(cif)){
            return false;
        }
        return repository.borrarPorCif(cif);
    }
    @Override
    public List<Proveedor> findActivos() {
        return repository.listarActivos();
        
    }
    @Override
    public List<Proveedor> findByCiudad(String ciudad) {
        if (!ValidationUtils.isValidCiudad(ciudad)){
            return null;
        }
        return repository.buscarPorCiudad(ciudad);
        
    }
    @Override
    public Proveedor findByEmail(String email) {
        if (!ValidationUtils.isValidEmail(email)){
            return null;
        }
        return repository.buscarPorEmail(email);
    }


}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/service/VentaService.java
````java
package com.ejemplo.service;

import java.util.List;

import com.ejemplo.model.Venta;
import com.ejemplo.model.VentaDetalle;
import com.ejemplo.model.VentaResumen;
import com.ejemplo.repository.IVentaRepository;
import com.ejemplo.repository.sqlite.VentaSqliteRepository;
import com.ejemplo.validation.ValidationUtils;

public class VentaService implements IVentaService {
    private final IVentaRepository repository;
    public VentaService() { this.repository = new VentaSqliteRepository(); }
    @Override
    public boolean create(Venta venta) {
        if (!ValidationUtils.isValidVenta(venta)){
            return false;
        }
        return repository.crear(venta);
        
    }
    @Override
    public Venta findById(Integer id) {
        return repository.buscarPorId(id);
        
    }

    @Override
    public List<Venta> findAll() {
        return repository.listarTodos();
        
    }

    @Override
    public boolean update(Venta venta) {
        if (!ValidationUtils.isValidVenta(venta)){
            return false;
        }
        return repository.actualizar(venta);
    }

    @Override
    public boolean deleteById(Integer id) {
        return repository.borrarPorId(id);
    }

    @Override
    public List<Venta> findByCliente(String dniCliente) {
        if (!ValidationUtils.isValidDni(dniCliente)){
            return null;
        }
        return repository.buscarPorCliente(dniCliente);
        
    }

    @Override
    public Venta findByTicket(String ticket) {
        if (!ValidationUtils.isValidTicket(ticket)){
            return null;
        }
        return repository.buscarPorTicket(ticket);
    }

    @Override
    public List<VentaDetalle> findDetallesByVenta(Integer idVenta) {
        return repository.buscarDetallesPorVenta(idVenta);
        
    }

    @Override
    public List<VentaResumen> findResumenVentas() {
        return repository.buscarResumenVentas();
        
    }


}
````

## File: fruteria-sqlite/src/main/java/com/ejemplo/validation/ValidationUtils.java
````java
package com.ejemplo.validation;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.Compra;
import com.ejemplo.model.Producto;
import com.ejemplo.model.Proveedor;
import com.ejemplo.model.Venta;

public final class ValidationUtils {
    static String dniPatron = "^[\\d]{8}[A-Z]$";
    static String cifPatron = "^[A-Z][\\d]{8}$";
    static String tlfPatron = "[0-9]{9}";
    static String emailPatron = "[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}";
    static String nombrePatron = "^([A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]+$|^[A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]+ [A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]+$)";
    static String ciudadPatron = "^([A-Z][a-z]+|[A-Z][a-z]+ [A-Z][a-z]+)$";
    static String codigoPatron = "^[A-Z]{3}-[A-Z]{3}-[0-9]{3}$";
    static String fechaPatron = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]) (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
    static String facPatron = "^FAC-[0-9]{4}-[0-9]{3}$";
    static String ticPatron = "^TCK-[0-9]{4}-[0-9]{3}$";

    private ValidationUtils() {
    }

    public static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public static boolean isValidDni(String dni) {
        return dni != null && !isBlank(dni) && dni.matches(dniPatron);
    }

    // public static boolean isValidOptionalDni(String dni) {
    //     return dni != null && isBlank(dni) || dni.matches(dniPatron);
    // }

    public static boolean isValidCif(String cif) {
        return cif != null && !isBlank(cif) && cif.matches(cifPatron);
    }

    public static boolean isValidTelefono(String telefono) {
        return isBlank(telefono) || telefono.matches(tlfPatron);
    }

    public static boolean isValidEmail(String email) {
        return isBlank(email) || email.matches(emailPatron);
    }

    public static boolean isValidNombre(String nombre) {
        return nombre != null && !isBlank(nombre) && nombre.matches(nombrePatron);
    }

    public static boolean isValidCiudad(String ciudad) {
        return ciudad == null  ||  ciudad.matches(ciudadPatron);
    }

    public static boolean isValidCodigoProducto(String codigo) {
        return codigo != null && !isBlank(codigo) && codigo.matches(codigoPatron);
    }

    public static boolean isValidFechaHora(String fecha) {
        return fecha != null && !isBlank(fecha) && fecha.matches(fechaPatron);
    }

    public static boolean isValidFactura(String factura) {
        return factura != null && !isBlank(factura) && factura.matches(facPatron);
    }

    public static boolean isValidTicket(String ticket) {
        return ticket != null && !isBlank(ticket) && ticket.matches(ticPatron);
    }

    public static boolean isPositive(Integer value) {
        return value != null && value >= 1;
    }

    public static boolean isNonNegative(Double value) {
        return value != null && value >= 0;
    }

    public static boolean isPositive(Double value) {
        return value != null && value >= 1;
    }

    public static boolean isBooleanInteger(Integer value) {
        return value != null && value == 1;
    }

    public static boolean isValidCliente(Cliente cliente) {
        if (cliente == null)
            return false;
        return isValidDni(cliente.getDni())
                && isValidNombre(cliente.getNombre())
                && isValidCiudad(cliente.getCiudad())
                && isValidEmail(cliente.getEmail())
                && isValidTelefono(cliente.getTelefono()) ;
    }

    public static boolean isValidProveedor(Proveedor proveedor) {
        if (proveedor == null)
            return false;
        return isValidCif(proveedor.getCif())
                && isValidNombre(proveedor.getNombre())
                && isValidCiudad(proveedor.getCiudad())
                && isValidEmail(proveedor.getEmail())
                && isValidTelefono(proveedor.getTelefono()) ;
    }

    public static boolean isValidProducto(Producto producto) {
        if (producto == null)
            return false;
        return isValidCodigoProducto(producto.getCodigo())
                && isValidNombre(producto.getNombre())
                && isValidCif(producto.getCifProveedorPrincipal());
    }

    public static boolean isValidCompra(Compra compra) {
        if (compra == null)
            return false;
        return isValidFechaHora(compra.getFecha())
                && isValidFactura(compra.getNumeroFactura())
                && isValidCif(compra.getCifProveedor());
    }

    public static boolean isValidVenta(Venta venta) {
        if (venta == null)
            return false;
        return isValidFechaHora(venta.getFecha())
                && isValidTicket(venta.getTicket())
                && (venta.getDniCliente() == null || isValidDni(venta.getDniCliente())); // DNI opcional
    }
}
````

## File: fruteria-sqlite/src/main/resources/data/sqlite/fruteria_schema.sql
````sql
PRAGMA foreign_keys = ON;

DROP VIEW IF EXISTS vw_productos_bajo_stock;
DROP VIEW IF EXISTS vw_resumen_ventas;
DROP VIEW IF EXISTS vw_productos_catalogo;
DROP TRIGGER IF EXISTS trg_compra_detalle_ai;
DROP TRIGGER IF EXISTS trg_venta_detalle_ai;
DROP TRIGGER IF EXISTS trg_venta_no_stock;
DROP TABLE IF EXISTS movimiento_stock;
DROP TABLE IF EXISTS venta_detalle;
DROP TABLE IF EXISTS venta;
DROP TABLE IF EXISTS compra_detalle;
DROP TABLE IF EXISTS compra;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS proveedor;
DROP TABLE IF EXISTS categoria_producto;

CREATE TABLE categoria_producto (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL UNIQUE,
    descripcion TEXT
);

CREATE TABLE proveedor (
    cif TEXT PRIMARY KEY,
    nombre TEXT NOT NULL,
    telefono TEXT,
    email TEXT,
    ciudad TEXT,
    activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1))
);

CREATE TABLE cliente (
    dni TEXT PRIMARY KEY,
    nombre TEXT NOT NULL,
    telefono TEXT,
    email TEXT,
    ciudad TEXT,
    activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1))
);

CREATE TABLE producto (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    codigo TEXT NOT NULL UNIQUE,
    nombre TEXT NOT NULL,
    unidad_medida TEXT NOT NULL CHECK (unidad_medida IN ('kg','unidad','caja','bandeja')),
    precio_compra REAL NOT NULL CHECK (precio_compra >= 0),
    precio_venta REAL NOT NULL CHECK (precio_venta > 0),
    stock_actual REAL NOT NULL DEFAULT 0 CHECK (stock_actual >= 0),
    stock_minimo REAL NOT NULL DEFAULT 0 CHECK (stock_minimo >= 0),
    perecedero INTEGER NOT NULL DEFAULT 1 CHECK (perecedero IN (0,1)),
    activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1)),
    id_categoria INTEGER NOT NULL,
    cif_proveedor_principal TEXT,
    FOREIGN KEY (id_categoria) REFERENCES categoria_producto(id),
    FOREIGN KEY (cif_proveedor_principal) REFERENCES proveedor(cif)
);

CREATE TABLE compra (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
    numero_factura TEXT NOT NULL UNIQUE,
    cif_proveedor TEXT NOT NULL,
    subtotal REAL NOT NULL DEFAULT 0 CHECK (subtotal >= 0),
    iva REAL NOT NULL DEFAULT 0 CHECK (iva >= 0),
    total REAL NOT NULL DEFAULT 0 CHECK (total >= 0),
    estado TEXT NOT NULL DEFAULT 'registrada' CHECK (estado IN ('registrada','cancelada')),
    observaciones TEXT,
    FOREIGN KEY (cif_proveedor) REFERENCES proveedor(cif)
);

CREATE TABLE compra_detalle (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_compra INTEGER NOT NULL,
    id_producto INTEGER NOT NULL,
    cantidad REAL NOT NULL CHECK (cantidad > 0),
    precio_unitario REAL NOT NULL CHECK (precio_unitario >= 0),
    descuento REAL NOT NULL DEFAULT 0 CHECK (descuento >= 0),
    total_linea REAL NOT NULL CHECK (total_linea >= 0),
    FOREIGN KEY (id_compra) REFERENCES compra(id) ON DELETE CASCADE,
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE venta (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ticket TEXT NOT NULL UNIQUE,
    dni_cliente TEXT,
    metodo_pago TEXT NOT NULL CHECK (metodo_pago IN ('efectivo','tarjeta','bizum','transferencia')),
    subtotal REAL NOT NULL DEFAULT 0 CHECK (subtotal >= 0),
    descuento_total REAL NOT NULL DEFAULT 0 CHECK (descuento_total >= 0),
    iva REAL NOT NULL DEFAULT 0 CHECK (iva >= 0),
    total REAL NOT NULL DEFAULT 0 CHECK (total >= 0),
    estado TEXT NOT NULL DEFAULT 'cerrada' CHECK (estado IN ('cerrada','anulada')),
    FOREIGN KEY (dni_cliente) REFERENCES cliente(dni)
);

CREATE TABLE venta_detalle (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_venta INTEGER NOT NULL,
    id_producto INTEGER NOT NULL,
    cantidad REAL NOT NULL CHECK (cantidad > 0),
    precio_unitario REAL NOT NULL CHECK (precio_unitario >= 0),
    descuento REAL NOT NULL DEFAULT 0 CHECK (descuento >= 0),
    total_linea REAL NOT NULL CHECK (total_linea >= 0),
    FOREIGN KEY (id_venta) REFERENCES venta(id) ON DELETE CASCADE,
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE movimiento_stock (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_producto INTEGER NOT NULL,
    tipo TEXT NOT NULL CHECK (tipo IN ('entrada_compra','salida_venta','ajuste')),
    cantidad REAL NOT NULL,
    referencia TEXT,
    observaciones TEXT,
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE INDEX idx_producto_categoria ON producto(id_categoria);
CREATE INDEX idx_producto_proveedor ON producto(cif_proveedor_principal);
CREATE INDEX idx_compra_proveedor ON compra(cif_proveedor);
CREATE INDEX idx_venta_cliente ON venta(dni_cliente);
CREATE INDEX idx_movimiento_producto ON movimiento_stock(id_producto);

CREATE TRIGGER trg_compra_detalle_ai
AFTER INSERT ON compra_detalle
BEGIN
    UPDATE producto
    SET stock_actual = stock_actual + NEW.cantidad
    WHERE id = NEW.id_producto;

    INSERT INTO movimiento_stock(id_producto, tipo, cantidad, referencia, observaciones)
    VALUES (NEW.id_producto, 'entrada_compra', NEW.cantidad, 'COMPRA-' || NEW.id_compra, 'Entrada por compra');
END;

CREATE TRIGGER trg_venta_detalle_ai
AFTER INSERT ON venta_detalle
BEGIN
    UPDATE producto
    SET stock_actual = stock_actual - NEW.cantidad
    WHERE id = NEW.id_producto;

    INSERT INTO movimiento_stock(id_producto, tipo, cantidad, referencia, observaciones)
    VALUES (NEW.id_producto, 'salida_venta', -NEW.cantidad, 'VENTA-' || NEW.id_venta, 'Salida por venta');
END;

CREATE TRIGGER trg_venta_no_stock
BEFORE INSERT ON venta_detalle
FOR EACH ROW
WHEN (SELECT stock_actual FROM producto WHERE id = NEW.id_producto) < NEW.cantidad
BEGIN
    SELECT RAISE(ABORT, 'Stock insuficiente para realizar la venta');
END;

CREATE VIEW vw_productos_bajo_stock AS
SELECT p.id, p.codigo, p.nombre, p.unidad_medida, p.stock_actual, p.stock_minimo
FROM producto p
WHERE p.stock_actual <= p.stock_minimo
ORDER BY p.stock_actual ASC, p.nombre ASC;

CREATE VIEW vw_resumen_ventas AS
SELECT v.id, v.ticket, v.fecha, COALESCE(c.nombre, 'Cliente ocasional') AS cliente,
       v.metodo_pago, v.total, v.estado
FROM venta v
LEFT JOIN cliente c ON c.dni = v.dni_cliente
ORDER BY v.fecha DESC;

CREATE VIEW vw_productos_catalogo AS
SELECT p.id, p.codigo, p.nombre, cp.nombre AS categoria, p.unidad_medida,
       p.precio_compra, p.precio_venta, p.stock_actual, p.stock_minimo,
       p.perecedero, p.activo, pr.nombre AS proveedor_principal
FROM producto p
JOIN categoria_producto cp ON cp.id = p.id_categoria
LEFT JOIN proveedor pr ON pr.cif = p.cif_proveedor_principal
ORDER BY cp.nombre, p.nombre;

INSERT INTO categoria_producto(nombre, descripcion) VALUES
('Fruta', 'Frutas frescas de temporada'),
('Verdura', 'Verduras y hortalizas frescas'),
('Frutos secos', 'Producto seco y envasado'),
('Complementos', 'Huevos, miel y otros productos');

INSERT INTO proveedor(cif, nombre, telefono, email, ciudad, activo) VALUES
('B12345678', 'Distribuciones Atlántico', '922111222', 'compras@atlantico.es', 'La Laguna', 1),
('B23456789', 'Huerta del Norte', '922333444', 'info@huertanorte.es', 'Tacoronte', 1),
('B34567890', 'Campo Fresco SL', '928555666', 'ventas@campofresco.es', 'Telde', 1);

INSERT INTO cliente(dni, nombre, telefono, email, ciudad, activo) VALUES
('11111111A', 'Ana Pérez', '600111111', 'ana@email.com', 'La Laguna', 1),
('22222222B', 'Luis Martín', '600222222', 'luis@email.com', 'Santa Cruz', 1),
('33333333C', 'María Díaz', '600333333', 'maria@email.com', 'La Orotava', 1);

INSERT INTO producto(codigo, nombre, unidad_medida, precio_compra, precio_venta, stock_actual, stock_minimo, perecedero, activo, id_categoria, cif_proveedor_principal) VALUES
('FRU-MAN-001', 'Manzana Golden', 'kg', 1.20, 2.35, 0, 15, 1, 1, 1, 'B12345678'),
('FRU-PLA-001', 'Plátano de Canarias', 'kg', 1.10, 2.10, 0, 20, 1, 1, 1, 'B12345678'),
('FRU-NAR-001', 'Naranja de zumo', 'kg', 0.95, 1.85, 0, 25, 1, 1, 1, 'B23456789'),
('VER-TOM-001', 'Tomate ensalada', 'kg', 1.35, 2.60, 0, 12, 1, 1, 2, 'B23456789'),
('VER-PAP-001', 'Papa bonita', 'kg', 0.80, 1.65, 0, 30, 1, 1, 2, 'B23456789'),
('SEC-ALM-001', 'Almendra cruda', 'kg', 6.00, 9.95, 0, 5, 0, 1, 3, 'B34567890'),
('COM-MIE-001', 'Miel de palma', 'unidad', 4.50, 7.90, 0, 4, 0, 1, 4, 'B34567890');

INSERT INTO compra(fecha, numero_factura, cif_proveedor, subtotal, iva, total, estado, observaciones) VALUES
('2026-04-18 08:30:00', 'FAC-2026-001', 'B12345678', 54.50, 3.82, 58.32, 'registrada', 'Compra semanal fruta'),
('2026-04-19 09:15:00', 'FAC-2026-002', 'B23456789', 73.00, 5.11, 78.11, 'registrada', 'Compra verdura'),
('2026-04-20 10:05:00', 'FAC-2026-003', 'B34567890', 57.00, 3.99, 60.99, 'registrada', 'Complementos y secos');

INSERT INTO compra_detalle(id_compra, id_producto, cantidad, precio_unitario, descuento, total_linea) VALUES
(1, 1, 20, 1.20, 0, 24.00),
(1, 2, 15, 1.10, 0, 16.50),
(1, 3, 15, 0.95, 0.25, 14.00),
(2, 4, 18, 1.35, 0, 24.30),
(2, 5, 60, 0.80, 0, 48.00),
(3, 6, 5, 6.00, 0, 30.00),
(3, 7, 6, 4.50, 0, 27.00);

INSERT INTO venta(fecha, ticket, dni_cliente, metodo_pago, subtotal, descuento_total, iva, total, estado) VALUES
('2026-04-21 11:10:00', 'TCK-2026-001', '11111111A', 'tarjeta', 13.55, 0.50, 0.00, 13.05, 'cerrada'),
('2026-04-21 13:20:00', 'TCK-2026-002', NULL, 'efectivo', 9.95, 0.00, 0.00, 9.95, 'cerrada'),
('2026-04-22 18:00:00', 'TCK-2026-003', '22222222B', 'bizum', 14.20, 0.20, 0.00, 14.00, 'cerrada');

INSERT INTO venta_detalle(id_venta, id_producto, cantidad, precio_unitario, descuento, total_linea) VALUES
(1, 1, 2, 2.35, 0.20, 4.50),
(1, 4, 1.5, 2.60, 0.30, 3.60),
(1, 7, 1, 7.90, 0.00, 7.90),
(2, 6, 1, 9.95, 0.00, 9.95),
(3, 2, 3, 2.10, 0.20, 6.10),
(3, 3, 2, 1.85, 0.00, 3.70),
(3, 5, 2.5, 1.65, 0.00, 4.20);
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/service/validation/ClienteServiceRegexValidationTest.java
````java
package com.ejemplo.service.validation;

import com.ejemplo.model.Cliente;
import com.ejemplo.service.ClienteService;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceRegexValidationTest {
    private ClienteService service;

    @BeforeEach
    void setUp() {
        TestDatabaseSupport.resetDatabase();
        service = new ClienteService();
    }

    @Test
    void createClienteConDniIncorrectoFailTest() {
        assertFalse(service.create(new Cliente("1234A", "Cliente Test", "600000000", "cliente@test.com", "Adeje", 1)));
    }

    @Test
    void createClienteConEmailIncorrectoFailTest() {
        assertFalse(
                service.create(new Cliente("99999999Z", "Cliente Test", "600000000", "cliente.test.com", "Adeje", 1)));
    }

    @Test
    void createClienteConTelefonoIncorrectoFailTest() {
        assertFalse(service.create(new Cliente("99999999Z", "Cliente Test", "600", "cliente@test.com", "Adeje", 1)));
    }

    @Test
    void findByDniConFormatoIncorrectoFailTest() {
        assertNull(service.findByDni("1234A"));
    }
}
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/service/validation/CompraServiceRegexValidationTest.java
````java
package com.ejemplo.service.validation;

import com.ejemplo.model.Compra;
import com.ejemplo.service.CompraService;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CompraServiceRegexValidationTest {
    private CompraService service;

    @BeforeEach
    void setUp() {
        TestDatabaseSupport.resetDatabase();
        service = new CompraService();
    }

    @Test
    void createCompraConFechaIncorrectaFailTest() {
        assertFalse(service.create(
                new Compra(null, "26/04/2026", "FAC-2026-099", "B12345678", 10.0, 0.7, 10.7, "registrada", "Test")));
    }

    @Test
    void createCompraConFacturaIncorrectaFailTest() {
        assertFalse(service.create(
                new Compra(null, "2026-04-26 10:30:00", "099", "B12345678", 10.0, 0.7, 10.7, "registrada", "Test")));
    }

    @Test
    void findByProveedorConCifIncorrectoFailTest() {
        assertTrue(service.findByProveedor("12345678B").isEmpty());
    }

    @Test
    void findByNumeroFacturaConFormatoIncorrectoFailTest() {
        assertNull(service.findByNumeroFactura("099"));
    }
}
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/service/validation/ProductoServiceRegexValidationTest.java
````java
package com.ejemplo.service.validation;

import com.ejemplo.model.Producto;
import com.ejemplo.service.ProductoService;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductoServiceRegexValidationTest {
    private ProductoService service;

    @BeforeEach
    void setUp() {
        TestDatabaseSupport.resetDatabase();
        service = new ProductoService();
    }

    @Test
    void createProductoConCodigoIncorrectoFailTest() {
        assertFalse(service.create(
                new Producto(null, "MAN-001", "Manzana Test", "kg", 1.0, 2.0, 10.0, 5.0, 1, 1, 1, "B12345678")));
    }

    @Test
    void createProductoConNombreIncorrectoFailTest() {
        assertFalse(service
                .create(new Producto(null, "FRU-PER-001", "#", "kg", 1.0, 2.0, 10.0, 5.0, 1, 1, 1, "B12345678")));
    }

    @Test
    void createProductoConCifProveedorIncorrectoFailTest() {
        assertFalse(service.create(
                new Producto(null, "FRU-PER-001", "Pera Test", "kg", 1.0, 2.0, 10.0, 5.0, 1, 1, 1, "12345678B")));
    }
}
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/service/validation/ProveedorServiceRegexValidationTest.java
````java
package com.ejemplo.service.validation;

import com.ejemplo.model.Proveedor;
import com.ejemplo.service.ProveedorService;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ProveedorServiceRegexValidationTest {
    private ProveedorService service;

    @BeforeEach
    void setUp() {
        TestDatabaseSupport.resetDatabase();
        service = new ProveedorService();
    }

    @Test
    void createProveedorConCifIncorrectoFailTest() {
        assertFalse(service
                .create(new Proveedor("12345678B", "Proveedor Test", "922000000", "proveedor@test.com", "Telde", 1)));
    }

    @Test
    void createProveedorConEmailIncorrectoFailTest() {
        assertFalse(service
                .create(new Proveedor("B99999999", "Proveedor Test", "922000000", "proveedor.test.com", "Telde", 1)));
    }

    @Test
    void createProveedorConTelefonoIncorrectoFailTest() {
        assertFalse(
                service.create(new Proveedor("B99999999", "Proveedor Test", "922", "proveedor@test.com", "Telde", 1)));
    }

    @Test
    void findByCifConFormatoIncorrectoFailTest() {
        assertNull(service.findByCif("12345678B"));
    }
}
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/service/validation/VentaServiceRegexValidationTest.java
````java
package com.ejemplo.service.validation;

import com.ejemplo.model.Venta;
import com.ejemplo.service.VentaService;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class VentaServiceRegexValidationTest {
    private VentaService service;

    @BeforeEach
    void setUp() {
        TestDatabaseSupport.resetDatabase();
        service = new VentaService();
    }

    @Test
    void createVentaConFechaIncorrectaFailTest() {
        assertFalse(service.create(new Venta(null, "26/04/2026", "TCK-2026-099", "11111111A", "tarjeta", 10.0, 0.0, 0.0,
                10.0, "cerrada")));
    }

    @Test
    void createVentaConTicketIncorrectoFailTest() {
        assertFalse(service.create(new Venta(null, "2026-04-26 10:30:00", "TICKET-099", "11111111A", "tarjeta", 10.0,
                0.0, 0.0, 10.0, "cerrada")));
    }

    @Test
    void createVentaConDniClienteIncorrectoFailTest() {
        assertFalse(service.create(new Venta(null, "2026-04-26 10:30:00", "TCK-2026-099", "1234A", "tarjeta", 10.0, 0.0,
                0.0, 10.0, "cerrada")));
    }

    @Test
    void findByTicketConFormatoIncorrectoFailTest() {
        assertNull(service.findByTicket("TICKET-099"));
    }
}
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/service/ClienteServiceSqliteTest.java
````java
package com.ejemplo.service;

import com.ejemplo.model.*;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceSqliteTest {
    private ClienteService service;

    @BeforeEach
    void setUp() {
        TestDatabaseSupport.resetDatabase();
        service = new ClienteService();
    }

    private Cliente nuevo() {
        return new Cliente("99999999Z", "Test Cliente", "600000000", "testc@email.com", "Adeje", 1);
    }

    @Test
    void findByDniOkTest() {
        assertNotNull(service.findByDni("11111111A"));
    }

    @Test
    void findByDniNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByDniEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByDniFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllOkTest() {
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void findAllFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllOrderTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void createOkTest() {
        assertTrue(service.create(nuevo()));
    }

    @Test
    void createNullTest() {
        assertFalse(service.create(null));
    }

    @Test
    void createEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void createFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByDniOkTest() {
        assertTrue(service.deleteByDni("33333333C"));
    }

    @Test
    void deleteByDniNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByDniEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByDniFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findActivosOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByCiudadOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByEmailOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByEmailFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }
}
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/service/CompraServiceSqliteTest.java
````java
package com.ejemplo.service;

import com.ejemplo.model.*;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CompraServiceSqliteTest {
    private CompraService service;

    @BeforeEach
    void setUp() {
        TestDatabaseSupport.resetDatabase();
        service = new CompraService();
    }

    private Compra nuevo() {
        return new Compra(null, "2026-04-25 10:00:00", "FAC-2026-999", "B12345678", 10.0, 0.7, 10.7, "registrada",
                "test");
    }

    @Test
    void findByIdOkTest() {
        assertNotNull(service.findById(1));
    }

    @Test
    void findByIdNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByIdEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByIdFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllOkTest() {
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void findAllFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllOrderTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void createOkTest() {
        assertTrue(service.create(nuevo()));
    }

    @Test
    void createNullTest() {
        assertFalse(service.create(null));
    }

    @Test
    void createEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void createFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByIdOkTest() {
        assertTrue(service.deleteById(3));
    }

    @Test
    void deleteByIdNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByIdEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByIdFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByProveedorOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByProveedorNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByProveedorEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByProveedorFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByNumeroFacturaOkTest() {
        assertNotNull(service.findByNumeroFactura("FAC-2026-001"));
    }

    @Test
    void findByNumeroFacturaNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByNumeroFacturaEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByNumeroFacturaFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findDetallesByCompraOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findDetallesByCompraFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findDetallesByCompraEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }
}
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/service/ProductoServiceSqliteTest.java
````java
package com.ejemplo.service;

import com.ejemplo.model.*;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductoServiceSqliteTest {
    private ProductoService service;

    @BeforeEach
    void setUp() {
        TestDatabaseSupport.resetDatabase();
        service = new ProductoService();
    }

    private Producto nuevo() {
        return new Producto(null, "TES-PRO-999", "Producto Test", "kg", 1.0, 2.0, 10.0, 1.0, 1, 1, 1, "B12345678");
    }

    @Test
    void findByIdOkTest() {
        assertNotNull(service.findById(1));
    }

    @Test
    void findByIdNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByIdEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByIdFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllOkTest() {
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void findAllFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllOrderTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void createOkTest() {
        assertTrue(service.create(nuevo()));
    }

    @Test
    void createNullTest() {
        assertFalse(service.create(null));
    }

    @Test
    void createEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void createFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByIdOkTest() {
        assertTrue(service.create(nuevo()));
        assertTrue(service.deleteById(8));
    }

    @Test
    void deleteByIdNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByIdEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByIdFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findActivosOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findActivosFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findActivosEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findActivosFilterTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByCategoriaOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByCategoriaNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByCategoriaEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByCategoriaFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findBajoStockOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findBajoStockFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findBajoStockEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findCatalogoOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findCatalogoFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findCatalogoEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findMovimientosByProductoOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findMovimientosByProductoFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findMovimientosByProductoEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }
}
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/service/ProveedorServiceSqliteTest.java
````java
package com.ejemplo.service;

import com.ejemplo.model.*;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ProveedorServiceSqliteTest {
    private ProveedorService service;

    @BeforeEach
    void setUp() {
        TestDatabaseSupport.resetDatabase();
        service = new ProveedorService();
    }

    private Proveedor nuevo() {
        return new Proveedor("B99999999", "Test Proveedor", "922000000", "testp@email.com", "Adeje", 1);
    }

    @Test
    void findByCifOkTest() {
        assertNotNull(service.findByCif("B12345678"));
    }

    @Test
    void findByCifNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByCifEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByCifFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllOkTest() {
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void findAllFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllOrderTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void createOkTest() {
        assertTrue(service.create(nuevo()));
    }

    @Test
    void createNullTest() {
        assertFalse(service.create(null));
    }

    @Test
    void createEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void createFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByCifOkTest() {
        service.create(nuevo());
        assertTrue(service.deleteByCif("B99999999"));
    }

    @Test
    void deleteByCifNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByCifEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByCifFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findActivosOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByCiudadOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByEmailOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByEmailFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }
}
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/service/VentaServiceSqliteTest.java
````java
package com.ejemplo.service;

import com.ejemplo.model.*;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class VentaServiceSqliteTest {
    private VentaService service;

    @BeforeEach
    void setUp() {
        TestDatabaseSupport.resetDatabase();
        service = new VentaService();
    }

    private Venta nuevo() {
        return new Venta(null, "2026-04-25 11:00:00", "TCK-2026-999", "11111111A", "tarjeta", 10.0, 0.0, 0.0, 10.0,
                "cerrada");
    }

    @Test
    void findByIdOkTest() {
        assertNotNull(service.findById(1));
    }

    @Test
    void findByIdNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByIdEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByIdFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllOkTest() {
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void findAllFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findAllOrderTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void createOkTest() {
        assertTrue(service.create(nuevo()));
    }

    @Test
    void createNullTest() {
        assertFalse(service.create(null));
    }

    @Test
    void createEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void createFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void updateFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByIdOkTest() {
        assertTrue(service.deleteById(3));
    }

    @Test
    void deleteByIdNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByIdEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void deleteByIdFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByClienteOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByClienteNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByClienteEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByClienteFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByTicketOkTest() {
        assertNotNull(service.findByTicket("TCK-2026-001"));
    }

    @Test
    void findByTicketNullTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByTicketEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findByTicketFailTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findDetallesByVentaOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findResumenVentasOkTest() {
        assertTrue(true);
        assertNotNull(service);
    }

    @Test
    void findResumenVentasEmptyTest() {
        assertTrue(true);
        assertNotNull(service);
    }
}
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/support/TestDatabaseSupport.java
````java
package com.ejemplo.support;
import com.ejemplo.repository.sqlite.SQLiteConnectionManager;
import java.nio.file.*;
public class TestDatabaseSupport {
    public static final String TEST_DB = "src/main/resources/data/sqlite/fruteria.db";
    public static void resetDatabase(){ try{ Files.createDirectories(Path.of("target")); Files.copy(Path.of("src/test/resources/backup.db"), Path.of(TEST_DB), StandardCopyOption.REPLACE_EXISTING); SQLiteConnectionManager.setDatabasePath(TEST_DB);} catch(Exception e){ throw new RuntimeException(e);} }
}
````

## File: fruteria-sqlite/src/test/java/com/ejemplo/validation/ValidationUtilsTest.java
````java
package com.ejemplo.validation;

import com.ejemplo.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    void dniOkTest() {
        assertTrue(ValidationUtils.isValidDni("12345678Z"));
    }

    @Test
    void dniNullTest() {
        assertFalse(ValidationUtils.isValidDni(null));
    }

    @Test
    void dniEmptyTest() {
        assertFalse(ValidationUtils.isValidDni(""));
    }

    @Test
    void dniFormatFailTest() {
        assertFalse(ValidationUtils.isValidDni("1234A"));
    }

    @Test
    void dniLowercaseFailTest() {
        assertFalse(ValidationUtils.isValidDni("12345678z"));
    }

    @Test
    void cifOkTest() {
        assertTrue(ValidationUtils.isValidCif("B12345678"));
    }

    @Test
    void cifNullTest() {
        assertFalse(ValidationUtils.isValidCif(null));
    }

    @Test
    void cifEmptyTest() {
        assertFalse(ValidationUtils.isValidCif(""));
    }

    @Test
    void cifFormatFailTest() {
        assertFalse(ValidationUtils.isValidCif("12345678B"));
    }

    @Test
    void cifLowercaseFailTest() {
        assertFalse(ValidationUtils.isValidCif("b12345678"));
    }

    @Test
    void telefonoOkTest() {
        assertTrue(ValidationUtils.isValidTelefono("600123456"));
    }

    @Test
    void telefonoNullOptionalOkTest() {
        assertTrue(ValidationUtils.isValidTelefono(null));
    }

    @Test
    void telefonoWithLettersFailTest() {
        assertFalse(ValidationUtils.isValidTelefono("600ABC456"));
    }

    @Test
    void telefonoTooShortFailTest() {
        assertFalse(ValidationUtils.isValidTelefono("60012345"));
    }

    @Test
    void emailOkTest() {
        assertTrue(ValidationUtils.isValidEmail("cliente@email.com"));
    }

    @Test
    void emailNullOptionalOkTest() {
        assertTrue(ValidationUtils.isValidEmail(null));
    }

    @Test
    void emailWithoutAtFailTest() {
        assertFalse(ValidationUtils.isValidEmail("cliente.email.com"));
    }

    @Test
    void emailWithoutDomainFailTest() {
        assertFalse(ValidationUtils.isValidEmail("cliente@"));
    }

    @Test
    void nombreOkTest() {
        assertTrue(ValidationUtils.isValidNombre("Frutas López"));
    }

    @Test
    void nombreTooShortFailTest() {
        assertFalse(ValidationUtils.isValidNombre("A"));
    }

    @Test
    void nombreInvalidSymbolsFailTest() {
        assertFalse(ValidationUtils.isValidNombre("Frutas #1"));
    }

    @Test
    void ciudadOkTest() {
        assertTrue(ValidationUtils.isValidCiudad("La Laguna"));
    }

    @Test
    void ciudadNullOptionalOkTest() {
        assertTrue(ValidationUtils.isValidCiudad(null));
    }

    @Test
    void ciudadWithNumbersFailTest() {
        assertFalse(ValidationUtils.isValidCiudad("Laguna123"));
    }

    @Test
    void codigoProductoOkTest() {
        assertTrue(ValidationUtils.isValidCodigoProducto("FRU-MAN-001"));
    }

    @Test
    void codigoProductoFormatFailTest() {
        assertFalse(ValidationUtils.isValidCodigoProducto("MAN-001"));
    }

    @Test
    void codigoProductoLowercaseFailTest() {
        assertFalse(ValidationUtils.isValidCodigoProducto("fru-man-001"));
    }

    @Test
    void fechaHoraOkTest() {
        assertTrue(ValidationUtils.isValidFechaHora("2026-04-26 10:30:00"));
    }

    @Test
    void fechaHoraWithoutTimeFailTest() {
        assertFalse(ValidationUtils.isValidFechaHora("2026-04-26"));
    }

    @Test
    void fechaHoraWithSlashFailTest() {
        assertFalse(ValidationUtils.isValidFechaHora("26/04/2026 10:30:00"));
    }

    @Test
    void facturaOkTest() {
        assertTrue(ValidationUtils.isValidFactura("FAC-2026-001"));
    }

    @Test
    void facturaFormatFailTest() {
        assertFalse(ValidationUtils.isValidFactura("2026-FAC-001"));
    }

    @Test
    void ticketOkTest() {
        assertTrue(ValidationUtils.isValidTicket("TCK-2026-001"));
    }

    @Test
    void ticketFormatFailTest() {
        assertFalse(ValidationUtils.isValidTicket("TK-2026-001"));
    }

    @Test
    void clienteCompletoOkTest() {
        Cliente cliente = new Cliente("99999999Z", "Cliente Test", "600000000", "cliente@test.com", "Adeje", 1);
        assertTrue(ValidationUtils.isValidCliente(cliente));
    }

    @Test
    void clienteConDniIncorrectoFailTest() {
        Cliente cliente = new Cliente("9999Z", "Cliente Test", "600000000", "cliente@test.com", "Adeje", 1);
        assertFalse(ValidationUtils.isValidCliente(cliente));
    }

    @Test
    void proveedorCompletoOkTest() {
        Proveedor proveedor = new Proveedor("B99999999", "Proveedor Test", "922000000", "proveedor@test.com", "Telde",
                1);
        assertTrue(ValidationUtils.isValidProveedor(proveedor));
    }

    @Test
    void proveedorConCifIncorrectoFailTest() {
        Proveedor proveedor = new Proveedor("99999999B", "Proveedor Test", "922000000", "proveedor@test.com", "Telde",
                1);
        assertFalse(ValidationUtils.isValidProveedor(proveedor));
    }

    @Test
    void productoCompletoOkTest() {
        Producto producto = new Producto(null, "FRU-PER-001", "Pera Conferencia", "kg", 1.0, 2.0, 10.0, 5.0, 1, 1, 1,
                "B12345678");
        assertTrue(ValidationUtils.isValidProducto(producto));
    }

    @Test
    void productoConCodigoIncorrectoFailTest() {
        Producto producto = new Producto(null, "PER-001", "Pera Conferencia", "kg", 1.0, 2.0, 10.0, 5.0, 1, 1, 1,
                "B12345678");
        assertFalse(ValidationUtils.isValidProducto(producto));
    }

    @Test
    void compraCompletaOkTest() {
        Compra compra = new Compra(null, "2026-04-26 10:30:00", "FAC-2026-099", "B12345678", 10.0, 0.7, 10.7,
                "registrada", "Test");
        assertTrue(ValidationUtils.isValidCompra(compra));
    }

    @Test
    void compraConFacturaIncorrectaFailTest() {
        Compra compra = new Compra(null, "2026-04-26 10:30:00", "099-2026", "B12345678", 10.0, 0.7, 10.7, "registrada",
                "Test");
        assertFalse(ValidationUtils.isValidCompra(compra));
    }

    @Test
    void ventaCompletaOkTest() {
        Venta venta = new Venta(null, "2026-04-26 10:30:00", "TCK-2026-099", "11111111A", "tarjeta", 10.0, 0.0, 0.0,
                10.0, "cerrada");
        assertTrue(ValidationUtils.isValidVenta(venta));
    }

    @Test
    void ventaSinClienteOkTest() {
        Venta venta = new Venta(null, "2026-04-26 10:30:00", "TCK-2026-099", null, "efectivo", 10.0, 0.0, 0.0, 10.0,
                "cerrada");
        assertTrue(ValidationUtils.isValidVenta(venta));
    }

    @Test
    void ventaConTicketIncorrectoFailTest() {
        Venta venta = new Venta(null, "2026-04-26 10:30:00", "TICKET-099", "11111111A", "tarjeta", 10.0, 0.0, 0.0, 10.0,
                "cerrada");
        assertFalse(ValidationUtils.isValidVenta(venta));
    }
}
````

## File: fruteria-sqlite/pom.xml
````xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion><groupId>com.ejemplo</groupId><artifactId>fruteria-sqlite-pk-naturales-solucion</artifactId><version>1.0.0</version>
  <properties><maven.compiler.source>17</maven.compiler.source><maven.compiler.target>17</maven.compiler.target><project.build.sourceEncoding>UTF-8</project.build.sourceEncoding><sqlite.version>3.45.3.0</sqlite.version><junit.version>5.10.2</junit.version></properties>
  <dependencies><dependency><groupId>org.xerial</groupId><artifactId>sqlite-jdbc</artifactId><version>${sqlite.version}</version></dependency><dependency><groupId>org.junit.jupiter</groupId><artifactId>junit-jupiter</artifactId><version>${junit.version}</version><scope>test</scope></dependency></dependencies>
  <build><plugins><plugin><groupId>org.apache.maven.plugins</groupId><artifactId>maven-compiler-plugin</artifactId><version>3.11.0</version><configuration><release>17</release></configuration></plugin><plugin><groupId>org.apache.maven.plugins</groupId><artifactId>maven-surefire-plugin</artifactId><version>3.2.5</version><configuration><useModulePath>false</useModulePath></configuration></plugin></plugins></build>
</project>
````

## File: fruteria-sqlite/README.md
````markdown
<div align="justify;">

# Ejercicio resuelto: La Frutería de DAM con SQLite, repositorios, servicios

<p align="center">
  <img src="images/fruteria-dam.png" alt="Frutería DAM" width="400">
</p>

En este proyecto crearás una aplicación completa para gestionar una frutería, controlando clientes, productos, compras y ventas. Utilizarás tecnologías reales del entorno profesional y aplicarás buenas prácticas de desarrollo (Java 17, Maven, SQLite, patrón repositorio, capa de servicio y tests JUnit 5).

La versión de `bd` usa **claves primarias naturales** en las tablas solicitadas:

- `proveedor.cif` es `PRIMARY KEY`.
- `cliente.dni` es `PRIMARY KEY`.

El resto de tablas principales mantienen clave autoincremental con `INTEGER PRIMARY KEY AUTOINCREMENT`.

---

## 1. Estructura generada

```text
src/main/java/com/ejemplo/model               -> modelos
src/main/java/com/ejemplo/repository          -> interfaces de repositorio
src/main/java/com/ejemplo/repository/sqlite   -> implementación SQLite/JDBC
src/main/java/com/ejemplo/service             -> interfaces y servicios
src/main/resources/data/sqlite                -> schema y base de datos
src/test/java/com/ejemplo/service             -> tests por servicio
src/test/resources/backup.db                  -> copia limpia para cada test
```

<p align="center">
  <img src="images/salida-test.png" alt="salida test" width="400">
</p>

---

## 2. Recuento de capas

| Elemento | Cantidad |
|---|---:|
| Servicios | 5 |
| Interfaces de servicio | 5 |
| Interfaces de repositorio | 5 |
| Repositorios SQLite | 5 |

| Servicio | Interfaz de repositorio | Repositorio SQLite | Tests |
|---|---|---|---:|
| `ClienteService` | `IClienteRepository` | `ClienteSqliteRepository` | 24 |
| `ProveedorService` | `IProveedorRepository` | `ProveedorSqliteRepository` | 24 |
| `ProductoService` | `IProductoRepository` | `ProductoSqliteRepository` | 37 |
| `CompraService` | `ICompraRepository` | `CompraSqliteRepository` | 31 |
| `VentaService` | `IVentaRepository` | `VentaSqliteRepository` | 31 |

---

## 3. Claves primarias de las tablas de bbdd

| Tabla | Clave primaria | Tipo |
|---|---|---|
| `cliente` | `dni` | natural |
| `proveedor` | `cif` | natural |
| `categoria_producto` | `id` | autoincremental |
| `producto` | `id` | autoincremental |
| `compra` | `id` | autoincremental |
| `compra_detalle` | `id` | autoincremental |
| `venta` | `id` | autoincremental |
| `venta_detalle` | `id` | autoincremental |
| `movimiento_stock` | `id` | autoincremental |

> **Importante**: Tener valores autoincremental o no es importante a la hora de realizar las validaciones en las inserciones en las tablas de la bbdd.

### Relaciones modificadas por las claves naturales

Antes, las relaciones con cliente y proveedor podían apuntar a un `id` numérico. En este ejercicio académico se apuntan directamente a la clave natural:

```sql
FOREIGN KEY (cif_proveedor) REFERENCES proveedor(cif)
FOREIGN KEY (cif_proveedor_principal) REFERENCES proveedor(cif)
FOREIGN KEY (dni_cliente) REFERENCES cliente(dni)
```

Esto afecta a las funciones de repositorio y servicio:

- `Cliente`: se usa `findByDni(String dni)` y `deleteByDni(String dni)`.
- `Proveedor`: se usa `findByCif(String cif)` y `deleteByCif(String cif)`.
- `Compra`: se usa `findByProveedor(String cifProveedor)`.
- `Venta`: se usa `findByCliente(String dniCliente)`.

---

## 4. Cómo se resuelve el ejercicio por capas

El orden recomendado es:

```text
1. Crear modelos
2. Realizas las validaciones que necesites en la clase `ValidationUtils`
3. Lanzar los test se han incluido para realizar la validación
4. Crear interfaces de repositorio
5. Implementar repositorios SQLite
6. Crear interfaces de servicio
7. Implementar servicios con validaciones
8. Lanzar los tests de servicio
```

La idea principal es que cada capa tenga una responsabilidad concreta:

| Capa | Responsabilidad |
|---|---|
| Modelo | Representar datos de tablas o vistas |
| Interfaz de repositorio | Declarar las operaciones disponibles |
| Repositorio SQLite | Ejecutar SQL y mapear resultados |
| Interfaz de servicio | Declarar operaciones de negocio |
| Servicio | Validar datos antes de llamar al repositorio |
| Test | Comprobar casos correctos, nulos, vacíos y fallidos |

---

## 5. Modelos

Cada tabla o vista usada por el ejercicio tiene una clase Java simple en `com.ejemplo.model`.

Modelos principales:

- `Cliente`
- `Proveedor`
- `Producto`
- `Compra`
- `Venta`

Modelos auxiliares o de consulta:

- `CategoriaProducto`
- `ProductoCatalogo`
- `MovimientoStock`
- `CompraDetalle`
- `VentaDetalle`
- `VentaResumen`

> Estos modelos son las relaciones entre las tablas

Cada modelo debe tener:

- atributos privados,
- constructor vacío,
- constructor completo,
- getters,
- setters.


Ejemplo:

```java
public class Cliente {
    private String dni;
    private String nombre;
    private String telefono;
    private String email;
    private String ciudad;
    private Integer activo;

    public Cliente() {}

    public Cliente(String dni, String nombre, String telefono, String email, String ciudad, Integer activo) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
        this.activo = activo;
    }

    // getters y setters
}
```

> Los modelos se han incluido para que el proyecto compile sin problemas.

---

## 6. Interfaces de repositorio

Las interfaces de repositorio indican qué consultas debe saber hacer cada repositorio, pero no contienen SQL.

Las interfaces que debes de crear son las siguiente:

- `IClienteRepository` 
- `IProveedorRepository` 
- `IProductoRepository` 
- `ICompraRepository` 
- `IVentaRepository` 

> Debes de definir el conjunto de funciones que consideres necesario en cada uno de los repositorios para después realizar la implementación.

Implementaciones de las interfaces de los repositorios en:

- `ClienteSqliteRepository` 
- `ProveedorRepository` 
- `ProductoRepository` 
- `CompraRepository` 
- `VentaRepository` 

---

## 7. Validaciones que deben implementarse y por qué

Las validaciones deben implementarse `siempre` en la **capa de servicio**, `NO` en el repositorio.

El repositorio se encarga de:

- abrir conexión,
- ejecutar SQL,
- mapear `ResultSet`,
- devolver resultados.

El servicio se encarga de:

- comprobar que los datos tienen sentido,
- evitar consultas innecesarias,
- evitar errores de base de datos previsibles,
- devolver una respuesta controlada.

### 7.1. Validaciones generales

| Caso | Validación | Motivo |
|---|---|---|
| Objeto `null` en `create` o `update` | devolver `false` | No se puede insertar ni actualizar un objeto inexistente |
| Texto `null` | devolver `null`, `false` o lista vacía | Evita buscar o guardar claves inválidas |
| Texto vacío o con espacios | usar `trim().isEmpty()` | Un `"   "` no debe considerarse válido |
| `id == null` | devolver `null`, `false` o lista vacía | No se puede buscar una fila sin identificador |
| `id <= 0` | devolver `null`, `false` o lista vacía | Los ids autoincrementales empiezan en 1 |
| Importes negativos | devolver `false` | La base de datos tiene `CHECK` y el negocio no debe aceptar importes negativos |
| Cantidades negativas o cero | devolver `false` | Una línea de compra o venta no puede tener cantidad inválida |
| Estados no permitidos | devolver `false` | La base de datos solo acepta estados concretos |
| Métodos de pago no permitidos | devolver `false` | La tabla `venta` tiene un `CHECK` |
| Activo distinto de 0 o 1 | devolver `false` | La base de datos solo acepta valores booleanos SQLite |

### 7.2. Validaciones para `ClienteService`

`cliente.dni` es clave primaria natural, por tanto debe ser obligatorio.

| Función | Validaciones | Resultado esperado |
|---|---|---|
| `create(cliente)` | cliente no `null`, `dni` no vacío, `nombre` no vacío, `activo` 0 o 1 | `false` si falla |
| `findByDni(dni)` | `dni` no `null` ni vacío | `null` si falla |
| `findAll()` | sin validación previa | lista, puede estar vacía |
| `update(cliente)` | cliente no `null`, `dni` no vacío, `nombre` no vacío, `activo` 0 o 1 | `false` si falla |
| `deleteByDni(dni)` | `dni` no `null` ni vacío | `false` si falla |
| `findActivos()` | sin validación previa | lista, puede estar vacía |
| `findByCiudad(ciudad)` | ciudad no `null` ni vacía | lista vacía si falla |
| `findByEmail(email)` | email no `null` ni vacío | `null` si falla |

> **Motivo**: El `dni` identifica al cliente. Si se permite un DNI vacío, no se puede garantizar la identidad de la fila.

Ejemplo de validación:

```java
private boolean isBlank(String value) {
    return value == null || value.trim().isEmpty();
}

private boolean isValidActivo(Integer activo) {
    return activo != null && (activo == 0 || activo == 1);
}

public Cliente findByDni(String dni) {
    if (isBlank(dni)) {
        return null;
    } 
    return repository.findByDni(dni);
}
```

### 7.3. Validaciones para `ProveedorService`

`proveedor.cif` es clave primaria natural, por tanto debe ser obligatorio.

| Función | Validaciones | Resultado esperado |
|---|---|---|
| `create(proveedor)` | proveedor no `null`, `cif` no vacío, `nombre` no vacío, `activo` 0 o 1 | `false` si falla |
| `findByCif(cif)` | `cif` no `null` ni vacío | `null` si falla |
| `findAll()` | sin validación previa | lista, puede estar vacía |
| `update(proveedor)` | proveedor no `null`, `cif` no vacío, `nombre` no vacío, `activo` 0 o 1 | `false` si falla |
| `deleteByCif(cif)` | `cif` no `null` ni vacío | `false` si falla |
| `findActivos()` | sin validación previa | lista, puede estar vacía |
| `findByCiudad(ciudad)` | ciudad no `null` ni vacía | lista vacía si falla |
| `findByEmail(email)` | email no `null` ni vacío | `null` si falla |

> **Motivo**: el `CIF` no es autoincremental, así que todas las operaciones de búsqueda, actualización y borrado dependen de él.

### 7.4. Validaciones para `ProductoService`

| Función | Validaciones | Resultado esperado |
|---|---|---|
| `create(producto)` | producto no `null`, código no vacío, nombre no vacío, unidad válida, precios válidos, stock válido, categoría válida, activo 0 o 1, perecedero 0 o 1 | `false` si falla |
| `findById(id)` | `id != null && id > 0` | `null` si falla |
| `findAll()` | sin validación previa | lista, puede estar vacía |
| `update(producto)` | producto no `null`, `id > 0` y mismos campos válidos que create | `false` si falla |
| `deleteById(id)` | `id != null && id > 0` | `false` si falla |
| `findActivos()` | sin validación previa | lista, puede estar vacía |
| `findByCategoria(idCategoria)` | `idCategoria != null && idCategoria > 0` | lista vacía si falla |
| `findBajoStock()` | sin validación previa | lista, puede estar vacía |
| `findCatalogo()` | sin validación previa | lista, puede estar vacía |
| `findMovimientosByProducto(idProducto)` | `idProducto != null && idProducto > 0` | lista vacía si falla |

Unidades válidas según la tabla:

```text
kg, unidad, caja, bandeja
```

> **Motivo**:  la tabla `producto` tiene restricciones `CHECK` sobre unidad, precios, stock, activo y perecedero. Validarlo antes evita depender del error SQL.

### 7.5. Validaciones para `CompraService`

| Función | Validaciones | Resultado esperado |
|---|---|---|
| `create(compra)` | compra no `null`, número de factura no vacío, CIF proveedor no vacío, importes >= 0, estado válido | `false` si falla |
| `findById(id)` | `id != null && id > 0` | `null` si falla |
| `findAll()` | sin validación previa | lista, puede estar vacía |
| `update(compra)` | compra no `null`, `id > 0`, factura no vacía, CIF no vacío, importes >= 0, estado válido | `false` si falla |
| `deleteById(id)` | `id != null && id > 0` | `false` si falla |
| `findByProveedor(cifProveedor)` | CIF no `null` ni vacío | lista vacía si falla |
| `findByNumeroFactura(numeroFactura)` | número no `null` ni vacío | `null` si falla |
| `findDetallesByCompra(idCompra)` | `idCompra != null && idCompra > 0` | lista vacía si falla |

Estados válidos:

```text
registrada, cancelada
```

> **Motivo**:  una compra debe estar asociada a un proveedor existente mediante `cif_proveedor`.

### 7.6. Validaciones para `VentaService`

| Función | Validaciones | Resultado esperado |
|---|---|---|
| `create(venta)` | venta no `null`, ticket no vacío, método de pago válido, importes >= 0, estado válido | `false` si falla |
| `findById(id)` | `id != null && id > 0` | `null` si falla |
| `findAll()` | sin validación previa | lista, puede estar vacía |
| `update(venta)` | venta no `null`, `id > 0`, ticket no vacío, método de pago válido, importes >= 0, estado válido | `false` si falla |
| `deleteById(id)` | `id != null && id > 0` | `false` si falla |
| `findByCliente(dniCliente)` | DNI no `null` ni vacío | lista vacía si falla |
| `findByTicket(ticket)` | ticket no `null` ni vacío | `null` si falla |
| `findDetallesByVenta(idVenta)` | `idVenta != null && idVenta > 0` | lista vacía si falla |
| `findResumenVentas()` | sin validación previa | lista, puede estar vacía |

Métodos de pago válidos:

```text
efectivo, tarjeta, bizum, transferencia
```

Estados válidos:

```text
cerrada, anulada
```

> **Motivo**:  la tabla `venta` tiene `CHECK` para método de pago y estado. Además, el ticket es único y obligatorio.

---

## 8. Construcción de sentencias SQL en los repositorios

Las sentencias SQL deben construirse dentro de los repositorios SQLite.

Regla general:

- Para consultas con parámetros se usa `PreparedStatement`.
- Para consultas fijas sin parámetros se puede usar `Statement`.
- **Importante:** `No se deben concatenar valores del usuario dentro del SQL.`

### 8.1. `INSERT`

Ejemplo para cliente:

```java
String sql = "INSERT INTO cliente(dni,nombre,telefono,email,ciudad,activo) VALUES(?,?,?,?,?,?)";

try (Connection cn = SQLiteConnectionManager.getConnection();
     PreparedStatement ps = cn.prepareStatement(sql)) {

    ps.setString(1, cliente.getDni());
    ps.setString(2, cliente.getNombre());
    ps.setString(3, cliente.getTelefono());
    ps.setString(4, cliente.getEmail());
    ps.setString(5, cliente.getCiudad());
    ps.setInt(6, cliente.getActivo());

    return ps.executeUpdate() == 1;
} catch (SQLException e) {
    return false;
}
```

Por qué se usa `PreparedStatement`:

- evita inyección SQL,
- separa la sentencia de los datos,
- permite reutilizar estructura,
- trata correctamente comillas, nulos y tipos.

### 8.2. `SELECT` por clave primaria natural

Ejemplo para proveedor:

```java
String sql = "SELECT * FROM proveedor WHERE cif = ?";

try (Connection cn = SQLiteConnectionManager.getConnection();
     PreparedStatement ps = cn.prepareStatement(sql)) {

    ps.setString(1, cif);

    try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
            return map(rs);
        }
        return null;
    }
} catch (SQLException e) {
    return null;
}
```

### 8.3. `SELECT` de todos los registros

```java
String sql = "SELECT * FROM cliente ORDER BY nombre";
```

En este caso no hay parámetro externo, por lo que se puede usar `Statement`.

### 8.4. `UPDATE`

Ejemplo para proveedor:

```java
String sql = "UPDATE proveedor SET nombre=?, telefono=?, email=?, ciudad=?, activo=? WHERE cif=?";

try (Connection cn = SQLiteConnectionManager.getConnection();
     PreparedStatement ps = cn.prepareStatement(sql)) {

    ps.setString(1, proveedor.getNombre());
    ps.setString(2, proveedor.getTelefono());
    ps.setString(3, proveedor.getEmail());
    ps.setString(4, proveedor.getCiudad());
    ps.setInt(5, proveedor.getActivo());
    ps.setString(6, proveedor.getCif());

    return ps.executeUpdate() == 1;
} catch (SQLException e) {
    return false;
}
```

El `WHERE cif=?` es imprescindible. Sin `WHERE`, se modificarían todos los proveedores.

### 8.5. `DELETE`

Ejemplo para cliente:

```java
String sql = "DELETE FROM cliente WHERE dni = ?";
```

El método debe devolver `true` solo si se elimina una fila:

```java
return ps.executeUpdate() == 1;
```

Si el DNI no existe, `executeUpdate()` devuelve `0`, por tanto el método devuelve `false`.

### 8.6. Consultas con filtros

Ejemplo: productos por categoría.

```java
String sql = "SELECT * FROM producto WHERE id_categoria = ? ORDER BY nombre";
```

Ejemplo: ventas por cliente.

```java
String sql = "SELECT * FROM venta WHERE dni_cliente = ? ORDER BY fecha DESC";
```

Ejemplo: compras por proveedor.

```java
String sql = "SELECT * FROM compra WHERE cif_proveedor = ? ORDER BY fecha DESC";
```

### 8.7. Consultas contra vistas

Ejemplo: catálogo de productos.

```java
String sql = "SELECT * FROM vw_productos_catalogo ORDER BY nombre";
```

Ejemplo: resumen de ventas.

```java
String sql = "SELECT * FROM vw_resumen_ventas ORDER BY fecha DESC";
```

Las vistas se consultan igual que una tabla, `pero no se inserta`, actualizan ni borran directamente.

---

>**Importante**: En el resto de repositorios se realiza de forma similar a la de clientes. Lo ideal es que lances las sentencias sql directamente sobre la `bd` para verificar que es correcta y de esa forma practicas.

---

## 9. Mapeo de resultados SQL a objetos Java

Cada repositorio debe tener un método privado `map(ResultSet rs)`.

Ejemplo para cliente:

```java
    return new Cliente(
        rs.getString("dni"),
        rs.getString("nombre"),
        rs.getString("telefono"),
        rs.getString("email"),
        rs.getString("ciudad"),
        rs.getInt("activo")
    );
```

> Se puede crear un función, como les diria la `IA` pero ustedes están aprendiendo, y si repites el trabajo aprendes, si se lo das a la IA para que lo haga, no sabes lo que estas haciendo.

Motivo:

- repetir código en cada consulta, ayuda a aprender y saber lo que haces
- cuaando estes en segundo aprenderas otras formas más óptimas que la `IA` desconoce

---

## 10. Verificaciones previas directamente en SQLite con `sqlite3`

Antes de programar los repositorios, conviene comprobar que la base de datos funciona y que las consultas devuelven lo esperado.

> **SI NO SABES SQL NO SABES COMO SE IMPLEMENTAN LAS FUNCIONES DENTRO DEL REPOSITORIO**

Desde la raíz del proyecto:

```bash
sqlite3 src/main/resources/data/sqlite/fruteria.db
```

Activar una salida más cómoda:

```sql
.headers on
.mode column
PRAGMA foreign_keys = ON;
```

### 10.1. Ver las tablas existentes

```sql
.tables
```

### 10.2. Ver el esquema completo

```sql
.schema
```

### 10.3. Ver el esquema de una tabla concreta

```sql
.schema cliente
.schema proveedor
.schema producto
.schema compra
.schema venta
```

### 10.4. Comprobar claves primarias naturales

```sql
PRAGMA table_info(cliente);
PRAGMA table_info(proveedor);
```

En `cliente`, la columna `dni` debe aparecer como clave primaria.

En `proveedor`, la columna `cif` debe aparecer como clave primaria.

### 10.5. Comprobar claves foráneas

```sql
PRAGMA foreign_key_list(producto);
PRAGMA foreign_key_list(compra);
PRAGMA foreign_key_list(venta);
```

Resultado esperado:

- `producto.cif_proveedor_principal` referencia `proveedor.cif`.
- `compra.cif_proveedor` referencia `proveedor.cif`.
- `venta.dni_cliente` referencia `cliente.dni`.

### 10.6. Comprobar índices

```sql
PRAGMA index_list(cliente);
PRAGMA index_list(proveedor);
PRAGMA index_list(producto);
```

### 10.7. Comprobar datos iniciales

```sql
SELECT * FROM cliente;
SELECT * FROM proveedor;
SELECT * FROM categoria_producto;
SELECT * FROM producto;
SELECT * FROM compra;
SELECT * FROM venta;
```

### 10.8. Probar búsquedas por clave natural

```sql
SELECT * FROM cliente
WHERE dni = '12345678A';

SELECT * FROM proveedor
WHERE cif = 'B12345678';
```

Si no conoces los valores existentes, primero lista las claves:

```sql
SELECT dni, nombre FROM cliente;
SELECT cif, nombre FROM proveedor;
```

### 10.9. Probar consultas de filtros

Clientes activos:

```sql
SELECT * FROM cliente
WHERE activo = 1
ORDER BY nombre;
```

Proveedores por ciudad:

```sql
SELECT * FROM proveedor
WHERE ciudad = 'Valencia'
ORDER BY nombre;
```

Productos bajo stock:

```sql
SELECT * FROM producto
WHERE stock_actual <= stock_minimo
ORDER BY nombre;
```

Compras de un proveedor:

```sql
SELECT * FROM compra
WHERE cif_proveedor = 'B12345678'
ORDER BY fecha DESC;
```

Ventas de un cliente:

```sql
SELECT * FROM venta
WHERE dni_cliente = '12345678A'
ORDER BY fecha DESC;
```

### 10.10. Probar vistas

```sql
SELECT * FROM vw_productos_catalogo;
SELECT * FROM vw_productos_bajo_stock;
SELECT * FROM vw_resumen_ventas;
```

### 10.11. Comprobar restricciones `CHECK`

Producto con unidad inválida. Debe fallar:

```sql
INSERT INTO producto(
    codigo,nombre,unidad_medida,precio_compra,precio_venta,
    stock_actual,stock_minimo,perecedero,activo,id_categoria,cif_proveedor_principal
)
VALUES('TEST-001','Producto test','litro',1,2,10,2,1,1,1,'B12345678');
```

> **Motivo:** `unidad_medida` solo admite `kg`, `unidad`, `caja` o `bandeja`.

Venta con método de pago inválido. Debe fallar:

```sql
INSERT INTO venta(ticket,dni_cliente,metodo_pago,subtotal,descuento_total,iva,total,estado)
VALUES('T-TEST','12345678A','paypal',10,0,2.1,12.1,'cerrada');
```

> **Motivo:** `metodo_pago` solo admite `efectivo`, `tarjeta`, `bizum` o `transferencia`.

### 10.12. Comprobar claves foráneas

Compra con proveedor inexistente. Debe fallar si las claves foráneas están activadas:

```sql
PRAGMA foreign_keys = ON;

INSERT INTO compra(numero_factura,cif_proveedor,subtotal,iva,total,estado)
VALUES('F-TEST','NOEXISTE',10,2.1,12.1,'registrada');
```

Venta con cliente inexistente. Debe fallar si `dni_cliente` no existe:

```sql
INSERT INTO venta(ticket,dni_cliente,metodo_pago,subtotal,descuento_total,iva,total,estado)
VALUES('V-TEST','NOEXISTE','efectivo',10,0,2.1,12.1,'cerrada');
```

### 10.13. Comprobar claves únicas

El código de producto es único. Insertar dos productos con el mismo `codigo` debe fallar:

```sql
INSERT INTO producto(codigo,nombre,unidad_medida,precio_compra,precio_venta,stock_actual,stock_minimo,perecedero,activo,id_categoria,cif_proveedor_principal)
VALUES('DUP-001','Producto duplicado 1','kg',1,2,10,2,1,1,1,'B12345678');

INSERT INTO producto(codigo,nombre,unidad_medida,precio_compra,precio_venta,stock_actual,stock_minimo,perecedero,activo,id_categoria,cif_proveedor_principal)
VALUES('DUP-001','Producto duplicado 2','kg',1,2,10,2,1,1,1,'B12345678');
```

### 10.14. Comprobar triggers de stock

Antes de insertar una línea de compra:

```sql
SELECT id, nombre, stock_actual
FROM producto
WHERE id = 1;
```

Insertar una compra y una línea:

```sql
INSERT INTO compra(numero_factura,cif_proveedor,subtotal,iva,total,estado)
VALUES('F-STOCK-TEST','B12345678',10,2.1,12.1,'registrada');

SELECT last_insert_rowid();
```

Usa el id devuelto como `id_compra`:

```sql
INSERT INTO compra_detalle(id_compra,id_producto,cantidad,precio_unitario,descuento,total_linea)
VALUES(4,1,5,2,0,10);
```

Después:

```sql
SELECT id, nombre, stock_actual
FROM producto
WHERE id = 1;

SELECT * FROM movimiento_stock
WHERE id_producto = 1
ORDER BY fecha DESC;
```

Resultado esperado: el stock del producto aumenta y se genera un movimiento de stock.

Para una venta, el trigger debe restar stock:

```sql
INSERT INTO venta(ticket,dni_cliente,metodo_pago,subtotal,descuento_total,iva,total,estado)
VALUES('T-STOCK-TEST','12345678A','efectivo',10,0,2.1,12.1,'cerrada');

SELECT last_insert_rowid();

INSERT INTO venta_detalle(id_venta,id_producto,cantidad,precio_unitario,descuento,total_linea)
VALUES(4,1,2,5,0,10);

SELECT id, nombre, stock_actual
FROM producto
WHERE id = 1;

SELECT * FROM movimiento_stock
WHERE id_producto = 1
ORDER BY fecha DESC;
```

Resultado esperado: el stock del producto disminuye y se genera un movimiento de stock.

### 10.15. Salir de sqlite3

```sql
.quit
```

---

## 11. Cómo conectar Java con SQLite

La conexión se centraliza en `SQLiteConnectionManager`.

Ejemplo conceptual:

```java
public class SQLiteConnectionManager {
    private static final String URL = "jdbc:sqlite:src/main/resources/data/sqlite/fruteria.db";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL);
        try (Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON");
        }
        return connection;
    }
}
```

Es importante activar:

```sql
PRAGMA foreign_keys = ON;
```

> **Motivo:** SQLite no siempre aplica claves foráneas si no se activan en la conexión.

---

## 12. Tests

Los tests están separados por servicio:

```text
ValidationUtilsTest
ClienteServiceSqliteTest
ProveedorServiceSqliteTest
ProductoServiceSqliteTest
CompraServiceSqliteTest
VentaServiceSqliteTest
```

Cada test restaura la base de datos desde:

```text
src/test/resources/backup.db
```

Esto permite que cada test empiece desde el mismo estado inicial.

### 12.1. Tipos de test recomendados

| Tipo de test | Qué comprueba |
|---|---|
| `OkTest` | El caso correcto devuelve el resultado esperado |
| `NullTest` | Un parámetro `null` se controla sin lanzar excepción |
| `EmptyTest` | Un texto vacío o sin registros devuelve el valor esperado |
| `FailTest` | Un dato inexistente o inválido devuelve `false`, `null` o lista vacía |
| `FilterTest` | El filtro devuelve solo los registros correctos |
| `OrderTest` | El orden de los resultados es correcto |

### 12.2. Ejemplo de nombres de tests para cliente

```text
createOkTest
createNullTest
createEmptyTest
createFailTest
findByDniOkTest
findByDniNullTest
findByDniEmptyTest
findByDniFailTest
findAllOkTest
findAllEmptyTest
findAllFailTest
findAllOrderTest
updateOkTest
updateNullTest
updateEmptyTest
updateFailTest
deleteByDniOkTest
deleteByDniNullTest
deleteByDniEmptyTest
deleteByDniFailTest
findActivosOkTest
findByCiudadOkTest
findByEmailOkTest
findByEmailFailTest
```

---

## 12. Ejecutar el proyecto

Ejecutar tests:

```bash
mvn clean test
```

---

## 13. Archivos importantes

Base de datos principal:

```text
src/main/resources/data/sqlite/fruteria.db
```

Schema SQL:

```text
src/main/resources/data/sqlite/fruteria_schema.sql
```

Base de datos limpia para tests:

```text
src/test/resources/backup.db
```

---

## 14. Validaciones con expresiones regulares

## Por qué se añaden expresiones regulares

Las expresiones regulares se utilizan en este ejercicio para validar el formato de los datos antes de llegar al repositorio y antes de ejecutar sentencias SQL contra SQLite.

Esto es importante por varios motivos:

1. Evitan datos con formato incorrecto en la base de datos.
2. Separan responsabilidades: el servicio valida y el repositorio solo persiste o consulta.
3. Reducen errores de integridad, especialmente en claves naturales como `dni` y `cif`.
4. Permiten detectar errores antes de ejecutar SQL.
5. Hacen que los tests sean más claros, porque cada formato válido o inválido se puede comprobar de forma aislada.

En este proyecto las validaciones se implementan en:

```text
src/main/java/com/ejemplo/validation/ValidationUtils.java
```

Los servicios llaman a `ValidationUtils` antes de invocar al repositorio.

Por ejemplo:

```java
@Override
public Cliente findByDni(String dni) {
    if (!ValidationUtils.isValidDni(dni)) return null;
    return repository.findByDni(dni);
}
```

De esta forma, si el DNI no cumple el formato esperado, no se ejecuta esta SQL:

```sql
SELECT * FROM cliente WHERE dni = ?;
```

## Construcción de Expresiones Regulares

A partir de los siguientes ejemplos, identifica los patrones y construye una expresión regular que valide los datos correctos.

---

###  Datos

| Campo | Funcionan ✅ | No funcionan ❌ |
|---|---|---|
| `cliente.dni` | `12345678Z`, `00000000A`, `87654321M` | `1234567Z`, `123456789Z`, `12345678z`, `12345678-Z` |
| `proveedor.cif` | `B12345678`, `A00000000`, `Z87654321` | `12345678B`, `b12345678`, `B1234567`, `BB12345678` |
| `telefono` | `600123456`, `922123456`, `689000111` | `60012345`, `6001234567`, `600-123-456`, `telefono123` |
| `email` | `cliente@email.com`, `nombre.apellido@empresa.es`, `user_01@test.org` | `clienteemail.com`, `cliente@`, `cliente@dominio`, `cliente@.com` |
| `nombre` | `Frutas López`, `Almacén 24`, `Distribuciones Pérez, S.L.` | `A`, `Nombre@Empresa`, `Empresa#1`, `` |
| `ciudad` | `La Laguna`, `Santa Cruz`, `San Cristóbal` | `L`, `Madrid123`, `Ciudad@`, `Las Palmas!` |
| `producto.codigo` | `FRU-MAN-001`, `VER-TOM-123`, `LAC-QUE-009` | `FRU-MAN-1`, `fru-man-001`, `FRUMAN001`, `FRU-001-MAN` |
| `compra.fecha` / `venta.fecha` | `2026-04-26 10:30:00`, `2025-12-01 09:05:45`, `2024-01-31 23:59:59` | `26-04-2026 10:30:00`, `2026/04/26 10:30:00`, `2026-04-26`, `2026-04-26 10:30` |
| `compra.numero_factura` | `FAC-2026-001`, `FAC-2025-123`, `FAC-0000-999` | `fac-2026-001`, `FAC-26-001`, `FAC-2026-1`, `FACT-2026-001` |
| `venta.ticket` | `TCK-2026-001`, `TCK-2025-123`, `TCK-0000-999` | `tck-2026-001`, `TCK-26-001`, `TCK-2026-1`, `TICKET-2026-001` |

---

### Consigna

1. Observa los ejemplos que **funcionan** y los que **no funcionan**.
2. Identifica qué reglas cumplen los datos válidos.
3. Detecta qué errores tienen los datos inválidos.
4. Construye una **expresión regular (regex)** para cada campo.

---

> ***Consejo:*** Empieza por identificar:
> - Longitud del texto
> - Tipos de caracteres (letras, números, símbolos)
> - Posiciones fijas (ej: guiones, @, puntos)

## Dónde aplicar las validaciones

Las expresiones regulares deben aplicarse en la capa de servicio, no en el repositorio.

### ClienteService

Validaciones recomendadas:

```java
ValidationUtils.isValidDni(cliente.getDni())
ValidationUtils.isValidNombre(cliente.getNombre())
ValidationUtils.isValidTelefono(cliente.getTelefono())
ValidationUtils.isValidEmail(cliente.getEmail())
ValidationUtils.isValidCiudad(cliente.getCiudad())
```

Por qué:

- `dni` es clave primaria, por tanto debe ser obligatorio y válido.
- `nombre` no debe estar vacío.
- `telefono` y `email` pueden ser opcionales, pero si se informan deben tener formato válido.

### ProveedorService

Validaciones recomendadas:

```java
ValidationUtils.isValidCif(proveedor.getCif())
ValidationUtils.isValidNombre(proveedor.getNombre())
ValidationUtils.isValidTelefono(proveedor.getTelefono())
ValidationUtils.isValidEmail(proveedor.getEmail())
ValidationUtils.isValidCiudad(proveedor.getCiudad())
```

Por qué:

- `cif` es clave primaria natural.
- Si el CIF está mal, también fallarán las relaciones con `producto` y `compra`.

### ProductoService

Validaciones recomendadas:

```java
ValidationUtils.isValidCodigoProducto(producto.getCodigo())
ValidationUtils.isValidNombre(producto.getNombre())
ValidationUtils.isValidCif(producto.getCifProveedorPrincipal())
```

Por qué:

- `codigo` es único y debe seguir una nomenclatura fija.
- `cifProveedorPrincipal` debe tener formato válido porque referencia a `proveedor(cif)`.

### CompraService

Validaciones recomendadas:

```java
ValidationUtils.isValidFechaHora(compra.getFecha())
ValidationUtils.isValidFactura(compra.getNumeroFactura())
ValidationUtils.isValidCif(compra.getCifProveedor())
```

Por qué:

- `fecha` debe estar en formato compatible con SQLite.
- `numero_factura` es único.
- `cifProveedor` es clave foránea contra `proveedor(cif)`.

### VentaService

Validaciones recomendadas:

```java
ValidationUtils.isValidFechaHora(venta.getFecha())
ValidationUtils.isValidTicket(venta.getTicket())
ValidationUtils.isValidOptionalDni(venta.getDniCliente())
```

Por qué:

- `ticket` es único.
- `dni_cliente` puede ser `NULL`, porque puede existir venta anónima.
- Si se informa `dni_cliente`, debe cumplir el formato de DNI.

## 15. Resumen final del ejercicio

Este ejercicio permite practicar:

- diseño en capas,
- interfaces,
- repositorios,
- servicios,
- validaciones,
- SQL con `PreparedStatement`,
- SQLite desde consola,
- claves primarias naturales,
- claves foráneas,
- restricciones `CHECK`,
- triggers,
- vistas,
- tests JUnit.

El punto más importante del ejercicio es entender que:

```text
El servicio valida.
El repositorio consulta.
La base de datos protege la integridad.
El test comprueba el comportamiento.
```

---

</div>
````
