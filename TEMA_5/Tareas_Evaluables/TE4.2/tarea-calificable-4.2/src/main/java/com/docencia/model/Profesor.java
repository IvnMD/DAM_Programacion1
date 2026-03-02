package com.docencia.model;

import java.time.LocalDate;

public class Profesor extends Persona {
    private String departamento;

    public Profesor(int id, String nombre, String documento, String email,
            LocalDate fechaNacimiento, LocalDate fechaRegistro,
            String departamento) {
        super(id, nombre, documento, email, fechaNacimiento,
                fechaRegistro);
        // Razono como debes de inicializar el departamento
    }

    @Override
    public String getTipo() {
        // ¿Qué se debe de devolver aquí?
        return "PROFESOR";
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        // Recuerda que verificaciones se deben de realizar en este set
    }

    @Override
    public String toString() {
        // Debes de retornar el tipo, y el departamento al que pertenece el profesor
        return "";
    }
}