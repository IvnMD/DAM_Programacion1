package com.ejemplo.service;

import java.util.List;

import com.ejemplo.model.*;
import com.ejemplo.repository.*;
import com.ejemplo.repository.sqlite.*;
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
        if (ValidationUtils.isValidCif(cifProveedor)){
            return null;
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
