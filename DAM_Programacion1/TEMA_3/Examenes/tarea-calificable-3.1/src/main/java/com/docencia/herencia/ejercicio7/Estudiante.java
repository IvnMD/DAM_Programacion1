package com.docencia.herencia.ejercicio7;

/**
 * @author IvnMD
 * @date 18/12/25
 * @version 1.0.0
 */

import java.util.Objects;
/**
 * Clase estudiante que hereda de persona
 */
public class Estudiante extends Persona {
    private final String curso;


    /**
     * Constructor vacio/por defecto. Inicializado por ser un atributo final
     */
    public Estudiante() {
        curso = "";
    }

    /**
     * Constructor parametrico
     * @param nombre del estudiante
     * @param curso en el que estudia la persona
     */
    public Estudiante(String nombre, String curso) {
        super(nombre);
        this.curso = curso;
    }

    /**
     * Getters
     */
    public String getCurso() {
        if (curso == null || curso.isBlank()){
            return "";
        }
        return curso;
    }

    @Override
    public String descripcionRol() {

        return "Estudiante "+ getNombre() + " del curso " + getCurso();
    }

    @Override
    public int hashCode() {
        return Objects.hash(curso);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estudiante other = (Estudiante) obj;
        return Objects.equals(curso, other.curso);
    }

    
}
