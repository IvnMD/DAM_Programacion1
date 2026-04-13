package com.docencia.ficheros.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public final class FechaValidator {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    private FechaValidator() {
    }

    public static boolean isFechaValida(String fecha) {
        if (fecha != null && !fecha.isBlank()) {
        String dia = "(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
         String mes = "(0[1-9]|1[1-2])";
         String anyo = "[\\d]{4}";
         String patron = "^" + anyo + "-" + mes + "-" + dia +"$";
            return Pattern.matches(patron, fecha);
        } else {
            return false;
        }
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
        if (fechaInicio.equals(fechaFin)) {
            return true;
        }

        LocalDate inicio = parse(fechaInicio);
        LocalDate fin = parse(fechaFin);
        if (fin.isBefore(inicio)) {
            return false;
        }
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
