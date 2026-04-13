package com.docencia.ficheros.service;

import com.docencia.ficheros.model.ReservaCompleta;
import com.docencia.ficheros.model.Hotel;
import com.docencia.ficheros.model.Reserva;
import com.docencia.ficheros.repo.interfaces.IClienteRepository;
import com.docencia.ficheros.repo.interfaces.IHotelRepository;
import com.docencia.ficheros.repo.interfaces.IReservaRepository;
import com.docencia.ficheros.service.interfaces.IReservaService;
import java.util.List;

public class ReservaService implements IReservaService {

    private final IReservaRepository reservaRepository;
    private final IClienteRepository clienteRepository;
    private final IHotelRepository hotelRepository;

    public ReservaService(IReservaRepository reservaRepository, IClienteRepository clienteRepository, IHotelRepository hotelRepository) {
        this.reservaRepository = reservaRepository;
        this.clienteRepository = clienteRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<ReservaCompleta> getReservasCompletas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReservasCompletas'");
    }

    @Override
    public ReservaCompleta getReservaCompletaById(int reservaId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReservaCompletaById'");
    }

    @Override
    public double calcularPrecio(Reserva reserva) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPrecio'");
    }

    @Override
    public double totalGastadoPorCliente(int clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalGastadoPorCliente'");
    }

    @Override
    public Hotel hotelMasRentable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hotelMasRentable'");
    }

    @Override
    public double totalIngresos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalIngresos'");
    }

    @Override
    public long contarNochesTotales() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contarNochesTotales'");
    }

    @Override
    public Reserva reservaMasLarga() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservaMasLarga'");
    }

    @Override
    public long totalReservasPorHotel(int hotelId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalReservasPorHotel'");
    }

    
}
