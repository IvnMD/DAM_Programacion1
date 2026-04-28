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
