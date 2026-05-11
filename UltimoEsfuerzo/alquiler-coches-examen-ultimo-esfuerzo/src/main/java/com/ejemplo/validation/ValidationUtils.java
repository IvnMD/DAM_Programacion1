package com.ejemplo.validation;

import java.time.LocalDate;

import com.ejemplo.model.Alquiler;
import com.ejemplo.model.Cliente;
import com.ejemplo.model.Vehiculo;

public final class ValidationUtils {

    public static String dniPatron = "^[0-9]{8}[A-Z]$";
    public static String emailPatron = "^[a-z]+@[a-z]+\\.[a-z]+$";
    public static String telefonoPatron = "^[0-9]{9}$";
    public static String patronTipoVehiculo = "^(ECONOMICO|SUV|PREMIUM)$";
    public static String patronEstadoAlquiler = "^(ACTIVO|CANCELADO|FINALIZADO)$";

    private ValidationUtils() {
    }

    public static boolean isValidDni(String dni) {
        if (!isValidTexto(dni))
            return false;
        return dni.matches(dniPatron);
    }

    public static boolean isValidEmail(String email) {
        if (!isValidTexto(email))
            return false;
        return email.matches(emailPatron);
    }

    public static boolean isValidTelefono(String telefono) {
        if (!isValidTexto(telefono))
            return false;
        return telefono.matches(telefonoPatron);
    }

    public static boolean isValidTexto(String texto) {
        return texto != null && !texto.isBlank();
    }

    public static boolean isValidActivo(int activo) {
        return activo == 0 || activo == 1;
    }

    public static boolean isValidTipoVehiculo(String tipo) {
        if (!isValidTexto(tipo))
            return false;
        return tipo.matches(patronTipoVehiculo);
    }

    public static boolean isValidEstadoAlquiler(String estado) {
        if (!isValidTexto(estado))
            return false;
        return estado.matches(patronEstadoAlquiler);
    }

    public static boolean isValidFutureStart(LocalDate fechaInicio) {
        if (fechaInicio == null)
            return false;
        return !fechaInicio.isBefore(LocalDate.now());
    }

    public static boolean isValidDateRange(LocalDate inicio, LocalDate fin) {
        if (inicio == null || fin == null)
            return false;
        return fin.isAfter(inicio);
    }

    public static boolean isValidCliente(Cliente cliente) {
        if (cliente == null)
            return false;
        return isValidDni(cliente.getDni()) &&
                isValidTexto(cliente.getNombre()) &&
                isValidEmail(cliente.getEmail()) &&
                isValidTelefono(cliente.getTelefono()) &&
                isValidActivo(cliente.getActivo());
    }

    public static boolean isValidVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null)
            return false;
        return isValidTexto(vehiculo.getMarca())
                && isValidTexto(vehiculo.getModelo())
                && isValidTipoVehiculo(vehiculo.getTipo())
                && isValidActivo(vehiculo.getDisponible());
    }

    public static boolean isValidAlquiler(Alquiler alquiler) {
        if (alquiler == null)
            return false;
        return isValidDni(alquiler.getDniCliente())
                && isValidId(alquiler.getIdVehiculo())
                && isValidFutureStart(alquiler.getFechaInicio())
                && isValidDateRange(alquiler.getFechaInicio(), alquiler.getFechaFin())
                && isValidEstadoAlquiler(alquiler.getEstado());
    }

    public static boolean isValidId(Integer id) {
        return id != null && id > 0;
    }
}