package com.docencia.ficheros.model;

import java.time.temporal.ChronoUnit;
import java.util.Objects;

import com.docencia.ficheros.util.FechaValidator;

public class Reserva {
    private int id;
    private int clienteId;
    private int hotelId;
    private String fechaInicio;
    private String fechaFin;

    public Reserva() {
    }

    public Reserva(int id, int clienteId, int hotelId, String fechaInicio, String fechaFin) {
        FechaValidator.validarRango(fechaInicio, fechaFin);
        this.id = id;
        this.clienteId = clienteId;
        this.hotelId = hotelId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public long getNoches() {
        return ChronoUnit.DAYS.between(FechaValidator.parse(fechaInicio), FechaValidator.parse(fechaFin));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Reserva reserva))
            return false;
        return id == reserva.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
