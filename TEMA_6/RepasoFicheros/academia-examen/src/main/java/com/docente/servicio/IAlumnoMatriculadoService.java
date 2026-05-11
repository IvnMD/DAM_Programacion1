package com.docente.servicio;

import java.util.List;
import com.docente.modelo.AlumnoMatriculado;

public interface IAlumnoMatriculadoService {
    List<String> read();
    boolean crearAlumnoMatriculado(String identificador, String nombre, int edad, String curso);
    boolean actualizarAlumnoMatriculado(String identificador, String nombre, int edad, String curso);
    boolean deleteAlumnoMatriculado(String identificador);
    AlumnoMatriculado buscarAlumnoMatriculado(String identificador);
    boolean matricularAsignatura(String identificadorAlumno, String codigoAsignatura);
    boolean desmatricularAsignatura(String identificadorAlumno, String codigoAsignatura);
    int getNumeroAsignaturas(String identificadorAlumno);
    boolean estaMatriculadoEn(String identificadorAlumno, String codigoAsignatura);
}
