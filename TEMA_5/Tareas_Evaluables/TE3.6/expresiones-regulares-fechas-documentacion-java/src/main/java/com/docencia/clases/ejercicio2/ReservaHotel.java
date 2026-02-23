package com.docencia.clases.ejercicio2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class ReservaHotel {

    private final String codigoReserva;
    private final String dni;
    private final LocalDate checkIn;
    private final LocalDate checkOut;

    public ReservaHotel(String codigoReserva, String dni, LocalDate checkIn, LocalDate checkOut) {
        this.codigoReserva = codigoReserva;
        this.dni = dni;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void validate() {
        if (codigoReserva == null || dni == null || checkIn == null || checkOut == null) {
            throw new IllegalArgumentException();
        }

        if (!Pattern.matches("^RES-[0-9]{4}-[A-Z]{3}$", codigoReserva)) {
            throw new IllegalArgumentException();
        }

        if (!isValidDni(dni)) {
            throw new IllegalArgumentException();
        }

        if (!checkOut.isAfter(checkIn)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidDni(String dni) {
        if (!Pattern.matches("^[0-9]{8}[A-Z]$", dni)) {
            return false;
        }
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letraEsperada = letras.charAt(numero % 23);
        return dni.charAt(8) == letraEsperada;
    }

    public long noches() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public boolean puedeCancelar(LocalDate hoy) {
        if (hoy == null)
            throw new IllegalArgumentException();
        return !hoy.isAfter(checkIn.minusDays(2));
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}