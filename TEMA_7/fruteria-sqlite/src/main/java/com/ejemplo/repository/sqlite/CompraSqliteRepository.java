package com.ejemplo.repository.sqlite;

import com.ejemplo.model.*;
import com.ejemplo.repository.ICompraRepository;
import java.sql.*;
import java.util.*;

public class CompraSqliteRepository implements ICompraRepository {


    @Override
    public boolean crear(Compra compra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public Compra buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<Compra> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    @Override
    public boolean actualizar(Compra compra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public boolean borrarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarPorId'");
    }

    @Override
    public List<Compra> buscarPorProveedor(String cifProveedor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorProveedor'");
    }

    @Override
    public Compra buscarPorNumeroFactura(String numeroFactura) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorNumeroFactura'");
    }

    @Override
    public List<CompraDetalle> buscarDetallesPorCompra(Integer idCompra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarDetallesPorCompra'");
    }

    
}
