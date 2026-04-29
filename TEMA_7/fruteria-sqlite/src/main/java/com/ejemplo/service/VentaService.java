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
