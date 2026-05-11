package com.docente.persistencia;

import java.util.List;
import com.docente.modelo.AlumnoMatriculado;
/**
 * Interfaz del repositorio de los alumnos matriculados
 */
public interface IAlumnoMatriculadoRepositorio {
    /**
     * Funcion que obtiene los alumnos matriculados
     */
    List<AlumnoMatriculado> obtenerAlumnosMatriculados();
    /**
     * Funcion que guarda los alumnos matriculados
     * @param alumnosMatriculados Lista que contiene los alumnos matriculados
     * @return true/false
     */
    boolean guardarAlumnosMatriculados(List<AlumnoMatriculado> alumnosMatriculados);
}
