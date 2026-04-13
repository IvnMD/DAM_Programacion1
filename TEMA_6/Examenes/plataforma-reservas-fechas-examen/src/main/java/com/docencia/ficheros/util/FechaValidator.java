package com.docencia.ficheros.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class FechaValidator {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    private FechaValidator() {
    }

    public static boolean isFechaValida(String fecha) {
        return false;
    }

    public static LocalDate parse(String fecha) {
        if (!isFechaValida(fecha)) {
            throw new IllegalArgumentException("Formato de fecha inválido: " + fecha + ". Se esperaba yyyy-MM-dd");
        }
        return LocalDate.parse(fecha.trim(), FORMATTER);
    }

    public static boolean isRangoValido(String fechaInicio, String fechaFin) {
        if (!isFechaValida(fechaInicio) || !isFechaValida(fechaFin)) {
            return false;
        }
        LocalDate inicio = parse(fechaInicio);
        LocalDate fin = parse(fechaFin);
        return !fin.isBefore(inicio);
    }

    public static void validarRango(String fechaInicio, String fechaFin) {
        if (!isFechaValida(fechaInicio)) {
            throw new IllegalArgumentException("Fecha de inicio inválida: " + fechaInicio);
        }
        if (!isFechaValida(fechaFin)) {
            throw new IllegalArgumentException("Fecha de fin inválida: " + fechaFin);
        }
        if (!isRangoValido(fechaInicio, fechaFin)) {
            throw new IllegalArgumentException("La fecha fin no puede ser anterior a la fecha inicio");
        }
    }
}
