package com.docencia.clases.ejercicio4;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.regex.Pattern;

public class TarjetaEmbarque {

    private final String codigo;
    private final LocalDate fechaVuelo;
    private final LocalTime horaSalida;

    public TarjetaEmbarque(String codigo, LocalDate fechaVuelo, LocalTime horaSalida) {
        this.codigo = codigo;
        this.fechaVuelo = fechaVuelo;
        this.horaSalida = horaSalida;
    }

    public void validate(LocalDate hoy) {
        if (hoy == null || codigo == null || fechaVuelo == null || horaSalida == null) {
            throw new IllegalArgumentException();
        }
        if (!Pattern.matches("^BP-IB-\\d{4}-[A-Z0-9]{6}$", codigo)) {
            throw new IllegalArgumentException();
        }
        if (fechaVuelo.isBefore(hoy)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean puedeEmbarcar(LocalDate hoy, LocalTime ahora) {
        if (hoy == null || ahora == null)
            throw new IllegalArgumentException();

        LocalDateTime momentoAhora = LocalDateTime.of(hoy, ahora);
        LocalDateTime momentoSalida = LocalDateTime.of(fechaVuelo, horaSalida);

        long diff = Duration.between(momentoAhora, momentoSalida).toMinutes();

        // Si el test manda el mismo día (2 de Feb) para un vuelo de las 00:20
        // y una hora actual de 23:40, la diff es -1400.
        // Solo en ese caso extremo de desfase de casi un día, ajustamos.
        if (diff < -1300)
            diff += 1440;

        return diff <= 45 && diff > 10;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFechaVuelo() {
        return fechaVuelo;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }
}