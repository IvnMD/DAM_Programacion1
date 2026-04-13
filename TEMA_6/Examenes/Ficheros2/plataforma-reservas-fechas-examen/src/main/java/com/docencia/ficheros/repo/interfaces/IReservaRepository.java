package com.docencia.ficheros.repo.interfaces;
import java.util.List;

import com.docencia.ficheros.model.Reserva;

public interface IReservaRepository {

    public List<Reserva> findAll();
    public Reserva findById(int id);


   
}
