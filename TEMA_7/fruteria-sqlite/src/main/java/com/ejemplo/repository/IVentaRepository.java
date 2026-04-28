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
