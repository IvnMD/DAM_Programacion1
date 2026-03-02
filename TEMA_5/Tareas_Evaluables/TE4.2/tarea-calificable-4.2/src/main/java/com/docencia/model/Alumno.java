package com.docencia.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Alumno extends Persona {
    // Los alumnos pertenecen a un curso y tienen un conjunto de módulos en dicho curos.
//     Por ejemplo curso=1D AM,
//     y módulos
//     de programación
//     y ets.
    private String curso;
    private Set<String> modulos;

    public Alumno(int id, String nombre, String documento, String email,
            LocalDate fechaNacimiento, LocalDate fechaRegistro,
            String curso) {
        super(id, nombre, documento, email, fechaNacimiento,
                fechaRegistro);
        // ¿Qué debes de inicializar aquí?
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
            throw new IllegalArgumentException("Curso inválido");
        }
        this.curso = curso.trim();
    }

    public boolean addModulo(String modulo) {
        // Razona como se añade un módulo al conjunto de módulos y si pueden existir
        // módulos duplicados.
        return false;
    }

    public Set<String> getModulos() {
        return modulos;
    }

    @Override
    public String toString() {
        // Completa el toString para que muestre el tipo, el curso y los módulos en los
        // que esta matriculado el alumno.
        return "";
    }
}