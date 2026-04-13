package com.docencia.ficheros.repo;

import com.docencia.ficheros.model.Cliente;
import com.docencia.ficheros.model.Hotel;
import com.docencia.ficheros.repo.interfaces.IHotelRepository;

import java.util.ArrayList;
import java.util.List;

public class HotelRepositoryXml implements IHotelRepository {

    private List<Hotel> hoteles;

    public HotelRepositoryXml(String resourcePath) {
    }

    @Override
    public List<Hotel> findAll() {
        return new ArrayList<>(hoteles);
    }

    @Override
    public Hotel findById(int id) {
        Hotel hotelBuscar = new Hotel(id);
        int indice = hoteles.indexOf(hotelBuscar);
        if (indice < 0) return null;
        
        return hoteles.get(indice);
    }

    
}
