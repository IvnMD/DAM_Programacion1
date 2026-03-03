package com.docencia.model;

import java.time.LocalDate;
/**
 * @author IvnMD
 * @date 02/03/2026
 * @version 1.0.0
 * 
 * @brief Clase profesor
 */
public class Profesor extends Persona {
    private String departamento;
    /**
     * Constructor del profesor
     * @param id del profesor
     * @param nombre del profesor
     * @param documento del profesor
     * @param email del profesor
     * @param fechaNacimiento del profesor
     * @param fechaRegistro del profesor
     * @param departamento del profesor
     */
    public Profesor(int id, String nombre, String documento, String email,
            LocalDate fechaNacimiento, LocalDate fechaRegistro, String departamento) {
        super(id, nombre, documento, email, fechaNacimiento, fechaRegistro);
        setDepartamento(departamento);

    }

    @Override
    public String getTipo() {
        return "PROFESOR";
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if (departamento == null || departamento.isBlank()) {
            throw new IllegalArgumentException("Departamento invalido");
        }
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return getTipo() + ";" +
                getId() + ";" +
                getNombre() + ";" +
                getDocumento() + ";" +
                getEmail() + ";" +
                getFechaNacimiento() + ";" +
                getFechaRegistro() + ";" +
                getDepartamento();
    }
}
