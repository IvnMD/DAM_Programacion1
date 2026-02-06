package com.docencia.clases.ejercicio5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class TurnoEmpleado {

    private static final String EMP_ID_REGEX = "^EMP-\\d{5}$";
    private static final DateTimeFormatter HM = DateTimeFormatter.ofPattern("HH:mm");

    private final String empleadoId;
    private final LocalDate dia;
    private final LocalTime inicio;
    private final LocalTime fin;

    public TurnoEmpleado(String empleadoId, LocalDate dia, LocalTime inicio, LocalTime fin) {
        this.empleadoId = empleadoId;
        this.dia = dia;
        this.inicio = inicio;
        this.fin = fin;
    }

    public void validate() {
        if (empleadoId == null || dia == null || inicio == null || fin == null) {
            throw new IllegalArgumentException();
        }
        if (!Pattern.matches(EMP_ID_REGEX, empleadoId)) {
            throw new IllegalArgumentException();
        }
        // El turno no puede ser de 0 minutos
        if (inicio.equals(fin)) {
            throw new IllegalArgumentException();
        }
    }

    public String franja() {
        return inicio.format(HM) + "-" + fin.format(HM);
    }

    public LocalDateTime inicioDateTime() {
        return LocalDateTime.of(dia, inicio);
    }

    public LocalDateTime finDateTime() {
        // Si el fin es antes que el inicio, es un turno nocturno que acaba el día
        // siguiente
        if (fin.isBefore(inicio)) {
            return LocalDateTime.of(dia.plusDays(1), fin);
        }
        return LocalDateTime.of(dia, fin);
    }

    public boolean cumpleDescansoMinimoDesde(TurnoEmpleado anterior, int minDescansoHoras) {
        if (anterior == null)
            return true;

        LocalDateTime finAnterior = anterior.finDateTime();
        LocalDateTime inicioActual = this.inicioDateTime();

        // Si el inicio del actual es antes que el fin del anterior, no hay descanso
        // posible
        if (inicioActual.isBefore(finAnterior)) {
            return false;
        }

        long minutosDescanso = Duration.between(finAnterior, inicioActual).toMinutes();
        return minutosDescanso >= (long) minDescansoHoras * 60;
    }

    public String getEmpleadoId() {
        return empleadoId;
    }

    public LocalDate getDia() {
        return dia;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFin() {
        return fin;
    }
}