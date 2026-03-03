package com.docencia.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
/**
 * @author IvnMD
 * @date 02/03/2026
 * @version 1.0.0
 * 
 * @brief Clase alumno
 */
public class Alumno extends Persona {
    // Los alumnos pertenecen a un curso y tienen un conjunto de módulos en dicho
    // curos.
    // Por ejemplo curso=1D AM,
    // y módulos
    // de programación
    // y ets.
    private String curso;
    private Set<String> modulos;
    /**
     * Constructor de la clase Alumno
     * @param id del alumno
     * @param nombre del alumno
     * @param documento del alumno
     * @param email del alumno
     * @param fechaNacimiento del alumno
     * @param fechaRegistro del alumno
     * @param curso en el que estudia el alumno
     */
    public Alumno(int id, String nombre, String documento, String email,
            LocalDate fechaNacimiento, LocalDate fechaRegistro, String curso) {
        super(id, nombre, documento, email, fechaNacimiento,
                fechaRegistro);
        setCurso(curso);
        this.modulos = new HashSet<>();
    }

    @Override
    public String getTipo() {
        return "ALUMNO";
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        if (curso == null || curso.trim().length() < 3) {
            throw new IllegalArgumentException("Curso invalido");
        }
        this.curso = curso.trim();
    }

    public boolean addModulo(String modulo) {
        if (modulo == null || modulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modulo invalido");
        }
        return modulos.add(modulo.trim().toUpperCase());
    }

    public boolean removeModulo(String modulo) {
        if (modulo == null || modulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modulo invalido");
        }
        return modulos.remove(modulo.trim().toUpperCase());
    }

    public Set<String> getModulos() {
        return modulos;
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
                getCurso();
    }

}