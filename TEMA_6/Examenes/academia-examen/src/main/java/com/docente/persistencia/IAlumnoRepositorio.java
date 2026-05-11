package com.docente.persistencia;

import java.util.List;

import com.docente.modelo.Alumno;
/**
 * Interfaz del repositorio de alumnos
 */
public interface IAlumnoRepositorio {

    /**
     * Funcion que obtiene todos los alumnos del repositorio
     * @return Lista de alumnos
     * */
    List<Alumno> obtenerAlumnos();
    
    /**
     * Funcion que guarda los alumnos en el repositorio 
     * @param alumnos guardados en la lista
     * @return true/false
     */
    boolean guardarAlumnos(List<Alumno> alumnos);

}
