package com.docencia.clases.ejercicio1;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.regex.Pattern;

public class RegistroUsuario {

    private final String email;
    private final String password;
    private final String telefono;
    private final LocalDate fechaNacimiento;
    private final LocalDateTime fechaRegistro;

    public RegistroUsuario(String email, String password, String telefono, LocalDate fechaNacimiento) {
        this(email, password, telefono, fechaNacimiento, Clock.systemDefaultZone());
    }

    public RegistroUsuario(String email, String password, String telefono, LocalDate fechaNacimiento, Clock clock) {
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = LocalDateTime.now(clock);
    }

    public void validate(int edadMinima) {
        if (!isValidEmail(this.email)) throw new IllegalArgumentException();
        if (!isValidPassword(this.password)) throw new IllegalArgumentException();
        if (!isValidTelefono(this.telefono)) throw new IllegalArgumentException();
        if (!isEdadValida(this.fechaNacimiento, edadMinima)) throw new IllegalArgumentException();
    }

    private boolean isValidEmail(String email) {
        if (email == null) return false;
        String regex = "^[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(regex, email);
    }

    private boolean isValidPassword(String password) {
        if (password == null) return false;
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])\\S{8,32}$";
        return Pattern.matches(regex, password);
    }

    private boolean isValidTelefono(String telefono) {
        if (telefono == null) return false;
        // Acepta formato +34 600111222, +34600111222, etc.
        String regex = "^\\+\\d{1,3}[\\s]?\\d{9}$";
        return Pattern.matches(regex, telefono);
    }

    private boolean isEdadValida(LocalDate nacimiento, int min) {
        if (nacimiento == null || nacimiento.isAfter(fechaRegistro.toLocalDate())) {
            return false;
        }
        return Period.between(nacimiento, fechaRegistro.toLocalDate()).getYears() >= min;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getTelefono() { return telefono; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
}