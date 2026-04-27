package com.ejemplo.service;

import com.ejemplo.model.Socio;
import com.ejemplo.model.SocioReserva;
import com.ejemplo.repository.ISocioRepository;
import com.ejemplo.repository.sqlite.SocioSqliteRepository;
import com.ejemplo.utils.Validaciones;

import java.util.List;

public class SocioService implements ISocioService {

    private final ISocioRepository repository;

    public SocioService() {
        this.repository = new SocioSqliteRepository();
    }

    @Override
    public boolean create(Socio socio) {
        if (!(Validaciones.validarSocio(socio))){
            return false;
        }
        return repository.create(socio);
    }

    @Override
    public Socio findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Socio> findAll() {
        return repository.findAll();
    }

    // @Override
    // public List<socioMonitor> findAllCM(){
    //     return repository.findAllCM();
    // }

    @Override
    public boolean update(Socio socio) {
        if (!(Validaciones.validarSocio(socio)) || repository.findById(socio.getId()) == null) {
            return false;
        }
        return repository.update(socio);
    }

    @Override
    public boolean deleteById(Integer id) {
        return repository.deleteById(id);
    }

    @Override
    public List<Socio> findActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findActivos'");
    }

    @Override
    public List<Socio> findByPlan(String plan) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPlan'");
    }

    @Override
    public List<SocioReserva> findSociosConReservas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSociosConReservas'");
    }

    
}
