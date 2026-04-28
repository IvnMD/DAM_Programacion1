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
