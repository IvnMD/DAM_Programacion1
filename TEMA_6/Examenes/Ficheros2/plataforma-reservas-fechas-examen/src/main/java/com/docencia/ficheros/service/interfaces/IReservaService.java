package com.docencia.ficheros.service.interfaces;

import java.util.List;

import com.docencia.ficheros.model.Hotel;
import com.docencia.ficheros.model.Reserva;
import com.docencia.ficheros.model.ReservaCompleta;

public interface IReservaService {
    public List<ReservaCompleta> getReservasCompletas();
    public ReservaCompleta getReservaCompletaById(int reservaId);
    public double calcularPrecio(Reserva reserva);
    public double totalGastadoPorCliente(int clienteId);
    public Hotel hotelMasRentable();
    public double totalIngresos();
    public long contarNochesTotales();
    public Reserva reservaMasLarga();
    public long totalReservasPorHotel(int hotelId);
}
