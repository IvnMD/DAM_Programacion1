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
