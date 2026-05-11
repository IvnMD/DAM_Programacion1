package com.docente.persistencia;

import java.util.List;
import com.docente.modelo.Asignatura;
/**
 * Interfaz de las asignaturas del repositorio
 */
public interface IAsignaturaRepositorio {

    /**
     * Funcion que obtiene todos las asignaturas del repositorio
     * @return Lista de asignaturas
     * */
    List<Asignatura> obtenerAsignaturas();

    /**
     * Funcion que guarda las asignaturas en el repositorio 
     * @param asignaturas guardadss en la lista
     * @return true/false
     */
    boolean guardarAsignaturas(List<Asignatura> asignaturas);
}
