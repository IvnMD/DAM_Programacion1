package com.ejemplo.validation;

import java.time.LocalDate;

public final class ValidationUtils {
    private ValidationUtils() {}

    static String dniPatron = "^[\\d]{8}[A-Z]$";
    static String patronEmail = "^[a-z]+@[a-z]+.[a-z]{2,}$";
    static LocalDate ahora = LocalDate.now();
    static String telefonoPatron = "^[0-9]{9}$";


    public static boolean isValidDni(String dni) {
        if (dni == null || dni.isBlank()){
            return false;
        }
        return  dni.matches(dniPatron);
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.isBlank()){
            return false;
        }
        return email.matches(patronEmail);
    }

    public static boolean isValidTelefono(String telefono) {
        if (telefono == null || telefono.isBlank()){
            return false;
        }
        return telefono.matches(telefono);
    }

    public static boolean isValidTexto(String texto) {
        if (texto == null || texto.isBlank()){
            return false;
        }
        return true;
    }

    public static boolean isValidActivo(int activo) {
        if (activo < 0 || activo > 1){
        return false;
        }
        return true;
    }

    public static boolean isValidTipoVehiculo(String tipo) {
        if (tipo == null || tipo.isBlank()){  // REVISAR ESTO
            return false;
        }
        return true;
    }

    public static boolean isValidEstadoAlquiler(String estado) {
        if (estado == null || estado.isBlank()){
        return false;
        }
        return true;
    }

    public static boolean isValidFutureStart(LocalDate fechaInicio) {
        if (fechaInicio.isBefore(ahora)){
            return false;
        }
        return true;
    }

    public static boolean isValidDateRange(LocalDate inicio, LocalDate fin) {
        if (fin.isBefore(inicio) || inicio.equals(fin)){
            return false;
        }
        return true;
    }

    // public static boolean isValidCliente(Cliente cliente){
    //     return is
    // }
}
