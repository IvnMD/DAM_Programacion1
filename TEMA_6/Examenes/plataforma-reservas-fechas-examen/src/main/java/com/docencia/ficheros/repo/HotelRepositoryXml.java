package com.docencia.ficheros.repo;

import com.docencia.ficheros.model.Hotel;
import com.docencia.ficheros.repo.interfaces.IHotelRepository;
import java.util.List;

public class HotelRepositoryXml implements IHotelRepository {

    private List<Hotel> hoteles;

    public HotelRepositoryXml(String resourcePath) {
    }

    @Override
    public List<Hotel> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Hotel findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    
}
