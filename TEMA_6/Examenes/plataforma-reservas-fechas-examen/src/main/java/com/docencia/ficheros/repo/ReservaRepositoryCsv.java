package com.docencia.ficheros.repo;

import com.docencia.ficheros.model.Reserva;
import com.docencia.ficheros.repo.interfaces.IReservaRepository;
import java.util.List;

public class ReservaRepositoryCsv implements IReservaRepository {

    private List<Reserva> reservas;

    public ReservaRepositoryCsv(String resourcePath) {
    }

    @Override
    public List<Reserva> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Reserva findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
