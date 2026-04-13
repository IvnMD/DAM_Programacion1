package com.docencia.ficheros.repo;

import com.docencia.ficheros.model.Hotel;
import com.docencia.ficheros.model.Reserva;
import com.docencia.ficheros.repo.interfaces.IReservaRepository;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepositoryCsv implements IReservaRepository {

    private List<Reserva> reservas;

    public ReservaRepositoryCsv(String resourcePath) {
    }

    @Override
    public List<Reserva> findAll() {
        return new ArrayList<>(reservas);
    }

    @Override
    public Reserva findById(int id) {
        Reserva reservaBuscar = new Reserva(id);
        int indice = reservas.indexOf(reservaBuscar);
        if (indice < 0) return null;
        
        return reservas.get(indice);
    }

}
