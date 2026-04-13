package com.docencia.ficheros.repo.interfaces;

import java.util.List;

import com.docencia.ficheros.model.Hotel;

public interface IHotelRepository {

    public List<Hotel> findAll();
    public Hotel findById(int id) ;
}
