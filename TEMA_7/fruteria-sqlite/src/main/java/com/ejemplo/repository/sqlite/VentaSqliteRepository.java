package com.ejemplo.repository.sqlite;

import com.ejemplo.model.*;
import com.ejemplo.repository.IVentaRepository;
import java.sql.*;
import java.util.*;

public class VentaSqliteRepository implements IVentaRepository {

    @Override
    public boolean crear(Venta venta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public Venta buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<Venta> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    @Override
    public boolean actualizar(Venta venta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public boolean borrarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarPorId'");
    }

    @Override
    public List<Venta> buscarPorCliente(String dniCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorCliente'");
    }

    @Override
    public Venta buscarPorTicket(String ticket) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorTicket'");
    }

    @Override
    public List<VentaDetalle> buscarDetallesPorVenta(Integer idVenta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarDetallesPorVenta'");
    }

    @Override
    public List<VentaResumen> buscarResumenVentas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarResumenVentas'");
    }

    
}
