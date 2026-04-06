package com.docente.servicio;

import java.util.List;
import com.docente.modelo.AlumnoMatriculado;
/**
 * Interfaz de servicio de los alumnos matriculados
 */
public interface IAlumnoMatriculadoService {
    /**
     * Funcion que lee el archivo CSV de los alumnos matriculados
     * @return Lista de alumnos matriculados
     */
    List<String> read();

    /**
     * Funcion que crea un alumno matriculado y lo añade a la lista
     * @param identificador unico del alumno
     * @param nombre del alumno
     * @param edad del alumno
     * @param curso del alumno
     * @return true/false
     */
    boolean crearAlumnoMatriculado(String identificador, String nombre, int edad, String curso);

    /**
     * Funcion que actualiza la lista de alumnos matriculas
     * @param identificador unico del alumno
     * @param nombre del alumno
     * @param edad del alumno
     * @param curso del alumno
     * @return true/false
     */
    boolean actualizarAlumnoMatriculado(String identificador, String nombre, int edad, String curso);

    /**
     * Funcion que elimina la lista de alumnos matriculas
     * @param identificador unico del alumno
     * @param nombre del alumno
     * @param edad del alumno
     * @param curso del alumno
     * @return true/false
     */
    boolean deleteAlumnoMatriculado(String identificador);
    AlumnoMatriculado buscarAlumnoMatriculado(String identificador);
    boolean matricularAsignatura(String identificadorAlumno, String codigoAsignatura);
    boolean desmatricularAsignatura(String identificadorAlumno, String codigoAsignatura);
    int getNumeroAsignaturas(String identificadorAlumno);
    boolean estaMatriculadoEn(String identificadorAlumno, String codigoAsignatura);
}
